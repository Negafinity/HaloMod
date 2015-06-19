package halocraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAssaultRifle extends Item{
	//Following is so you can access it in pre-init
	public static final ItemAssaultRifle instance = new ItemAssaultRifle();
    public static final String name = "itemAssaultRifle";
    
    public ItemAssaultRifle(){
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn){
	    if(playerIn.capabilities.isCreativeMode||playerIn.inventory.consumeInventoryItem(halocraft.Main.ammoAssaultRifle)){
	         worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        if (!worldIn.isRemote)
	         {
	             worldIn.spawnEntityInWorld(new EntityBullet(worldIn, playerIn));
	         }
	         return itemStackIn;
	   }
	   return itemStackIn;
	}
}
