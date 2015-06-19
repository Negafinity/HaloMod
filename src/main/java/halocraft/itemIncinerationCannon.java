package halocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIncinerationCannon extends Item {
	public ItemIncinerationCannon(){
	     super();
	     setCreativeTab(CreativeTabs.tabCombat);
	     setUnlocalizedName("incinerationCannon");
	     setMaxStackSize(1);
	}
   public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
   {
           worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
           if (!worldIn.isRemote)
           {
               worldIn.spawnEntityInWorld(new EntityRedPlasma(worldIn, playerIn));
           }
           return itemStackIn;
    }
}
