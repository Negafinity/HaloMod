package halocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class itemBattleRifle extends Item {
	public itemBattleRifle(){
	setCreativeTab(CreativeTabs.tabCombat);
	setMaxStackSize(1);
	setUnlocalizedName("BattleRifle");
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
