package halocraft.items;

import halocraft.Main;
import halocraft.entities.EntityBullet;
import halocraft.entities.EntityPurplePlasma;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNeedler extends Item
{
	//Following is so you can access it in pre-init
	public static final ItemNeedler instance = new ItemNeedler();
	public static final String name = "Needler";

	public ItemNeedler(){
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
		setMaxDamage(1000);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if(playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn))
		{
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!worldIn.isRemote)
			{
				EntityPurplePlasma purplePlasma = new EntityPurplePlasma(worldIn, playerIn);
				purplePlasma.damage = 6;
				worldIn.spawnEntityInWorld(purplePlasma);
				itemStackIn.damageItem(1, playerIn);
			}
			return itemStackIn;
		}
		return itemStackIn;
	}

	public boolean canDamageAmmo(World worldIn, EntityPlayer playerIn)
	{
		if(playerIn.inventory.hasItem(ItemNeedlerAmmo.instance))
		{
			for(ItemStack itemStack : playerIn.inventory.mainInventory)
			{
				if(itemStack != null && itemStack.getItem() != null && itemStack.getItem() instanceof ItemNeedlerAmmo)
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
