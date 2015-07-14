package halocraft.items;

import halocraft.entities.EntityFragGrenade;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FragGrenade extends Item{
	public static final FragGrenade instance = new FragGrenade();
    public static final String name = "FragGrenade";
    
	public FragGrenade(){
		setUnlocalizedName("fragGrenade");
		setCreativeTab(halocraft.Main.haloCreativeTab);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn){
		if(!playerIn.capabilities.isCreativeMode){
		--itemStackIn.stackSize;
		}
		worldIn.playSoundAtEntity(playerIn, "random.fizz", 0.7F, 0.8F);
		
		if(!worldIn.isRemote){
			worldIn.spawnEntityInWorld(new EntityFragGrenade(worldIn, playerIn));
		}
		return itemStackIn;
	}
}