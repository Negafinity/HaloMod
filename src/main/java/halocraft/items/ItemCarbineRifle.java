package halocraft.items;

import java.util.Random;

import halocraft.Main;
import halocraft.entities.EntityGreenPlasma;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCarbineRifle extends Item {
	public static final ItemCarbineRifle instance = new ItemCarbineRifle();
	public static final String name = "itemCarbineRifle";

	public ItemCarbineRifle()
	{
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setMaxStackSize(1);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxDamage(1000);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if(playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn))
		{
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!worldIn.isRemote)
			{
				EntityGreenPlasma greenPlasma = new EntityGreenPlasma(worldIn, playerIn);
				greenPlasma.damage = 8;
				worldIn.spawnEntityInWorld(greenPlasma);
				itemStackIn.damageItem(1, playerIn);
			}
			return itemStackIn;
		}
		return itemStackIn;
	}
	
	public boolean canDamageAmmo(World worldIn, EntityPlayer playerIn)
	{
		if(playerIn.inventory.hasItem(ItemCarbineAmmo.instance))
		{
			for(ItemStack itemStack : playerIn.inventory.mainInventory)
			{
				if(itemStack != null && itemStack.getItem() != null && itemStack.getItem() instanceof ItemCarbineAmmo)
				{
					if(itemStack.getItemDamage() < 32)
					{
						itemStack.attemptDamageItem(1, new Random());
					}
					else
					{
						playerIn.inventory.consumeInventoryItem(itemStack.getItem());
					}
					return true;
				}
			}
		}
		return false;
	}
}
