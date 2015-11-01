package halocraft.items;

import halocraft.HaloCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemHealthPack extends Item {
	//Following is so you can access it in pre-init
	public static final ItemHealthPack instance = new ItemHealthPack();
	public static final String name = "HealthPack";
	    
	public ItemHealthPack(){
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		playerIn.addPotionEffect(new PotionEffect(Potion.heal.id, 500, 4));
		playerIn.inventory.consumeInventoryItem(ItemHealthPack.instance);
		return itemStackIn;
    }
}
