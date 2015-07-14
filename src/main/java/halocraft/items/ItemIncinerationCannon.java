package halocraft.items;

import halocraft.entities.EntityRedPlasma;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIncinerationCannon extends Item {
	//Following is so you can access it in pre-init
	public static final ItemIncinerationCannon instance = new ItemIncinerationCannon();
	public static final String name = "itemIncinerationCannon";
	
	public ItemIncinerationCannon(){
	     super();
	     setCreativeTab(halocraft.Main.haloCreativeTab);
	     setUnlocalizedName("halocraft:" + name.toLowerCase());
	     setMaxDamage(1000);
	     setMaxStackSize(1);
	}
   public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
   {
	   if(playerIn.capabilities.isCreativeMode||playerIn.inventory.consumeInventoryItem(ItemRedPlasmaAmmo.instance)){
           worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
           if (!worldIn.isRemote)
           {
               worldIn.spawnEntityInWorld(new EntityRedPlasma(worldIn, playerIn));
               itemStackIn.damageItem(1, playerIn);
           }
	   }
           return itemStackIn;
    }
}
