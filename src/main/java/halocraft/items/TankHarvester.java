package halocraft.items;

import halocraft.Main;
import halocraft.entities.EntityGreenPlasma;
import halocraft.entities.EntityScorpion;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TankHarvester extends Item {
	public TankHarvester(){
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(1);
		setUnlocalizedName("TankHarvester");
	}
	 public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	 {
		 if(entity instanceof EntityScorpion){
			 entity.dropItem(halocraft.Main.itemScorpion, 1);
			 entity.setDead();
		 }
		 else{
			 player.addChatMessage(new ChatComponentText("[HaloCraft 2.0] This is not a Scorpion!"));
		 }
	     return false;
	 }
}
