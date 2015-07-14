package halocraft.items;

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
	     if(playerIn.capabilities.isCreativeMode||playerIn.inventory.consumeInventoryItem(ItemCarbineAmmo.instance)){
	         worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	         if (!worldIn.isRemote)
	         {
	             worldIn.spawnEntityInWorld(new EntityGreenPlasma(worldIn, playerIn));
	             itemStackIn.damageItem(1, playerIn);
	         }
	         return itemStackIn;
	   }
	   return itemStackIn;
	}
}
