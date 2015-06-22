package halocraft.items;

import halocraft.Main;
import halocraft.entities.EntityBullet;
import halocraft.entities.EntityGreenPlasma;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PlasmaRifle extends Item{
	//Following is so you can access it in pre-init
	public static final PlasmaRifle instance = new PlasmaRifle();
    public static final String name = "PlasmaRifle";
    
    public PlasmaRifle(){
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn){
	    if(playerIn.capabilities.isCreativeMode||playerIn.inventory.consumeInventoryItem(halocraft.Main.ammoPlasma)){
	         worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        if (!worldIn.isRemote)
	         {
	             worldIn.spawnEntityInWorld(new EntityGreenPlasma(worldIn, playerIn));
	         }
	         return itemStackIn;
	   }
	   return itemStackIn;
	}
}
