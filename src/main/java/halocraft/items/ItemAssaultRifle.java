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
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
		setMaxDamage(1000);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn){
		if (!worldIn.isRemote)
        {
			if(playerIn.capabilities.isCreativeMode|| damageAmmo(playerIn.inventory, playerIn, worldIn)){
				worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				worldIn.spawnEntityInWorld(new EntityBullet(worldIn, playerIn));
				itemStackIn.damageItem(1, playerIn);
			}
	         return itemStackIn;
	   }
	   return itemStackIn;
	}
	public boolean damageAmmo(InventoryPlayer p, EntityPlayer playerIn, World worldIn)
	{
		if (!worldIn.isRemote)
        {
			if(p.hasItem(halocraft.Main.ammoAssaultRifle))
			{
				for(int i = 0; i <= p.getSizeInventory(); i++)
				{
					ItemStack found = p.getStackInSlot(i);
					if(found.getItem() instanceof ItemAmmoAssaultRifle && found.getItem().getDamage(found) > 0)
					{
						found.damageItem(1, playerIn);
						return true;
					}
				}
			}
        }
		return false;
	}
}
