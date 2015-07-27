package halocraft.items;

import halocraft.Main;
import halocraft.entities.EntityBullet;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ItemAssaultRifle extends Item{
	//Following is so you can access it in pre-init
	public static final ItemAssaultRifle instance = new ItemAssaultRifle();
	public static final String name = "itemAssaultRifle";

	public ItemAssaultRifle(){
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
		setMaxDamage(1000);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if(playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn)){
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!worldIn.isRemote)
			{
				worldIn.spawnEntityInWorld(new EntityBullet(worldIn, playerIn));
				itemStackIn.damageItem(1, playerIn);
			}
			return itemStackIn;
		}
		return itemStackIn;
	}
	public boolean canDamageAmmo(World worldIn, EntityPlayer playerIn)
	{
		if(playerIn.inventory.hasItem(halocraft.Main.ammoAssaultRifle))
		{
			for(ItemStack itemStack : playerIn.inventory.mainInventory)
			{
				if(itemStack != null && itemStack.getItem() != null && itemStack.getItem() instanceof ItemAmmoAssaultRifle)
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
