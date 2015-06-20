package halocraft.items;

import halocraft.Main;
import halocraft.entities.EntityGreenPlasma;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCarbineRifle extends Item {
	public ItemCarbineRifle(){
	setCreativeTab(CreativeTabs.tabCombat);
	setMaxStackSize(1);
	setUnlocalizedName("CarbineRifle");
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
