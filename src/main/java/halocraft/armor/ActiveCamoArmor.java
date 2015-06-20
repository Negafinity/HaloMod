package halocraft.armor;

import halocraft.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ActiveCamoArmor extends ItemArmor{
	
	public ActiveCamoArmor(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		setCreativeTab(CreativeTabs.tabCombat);
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		 player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 500, 4));
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){
		if(stack.getItem().equals(halocraft.Main.ActiveCamoChestplate)){
			return "halocraft:textures/armor/ActiveCamoArmor_layer_1.png";
		}
		else return null;
	}
}
