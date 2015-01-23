package halocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class HaloArmor extends ItemArmor {

	public HaloArmor(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		setCreativeTab(CreativeTabs.tabCombat);
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){
		if(stack.getItem().equals(halocraft.Main.SpartanHelmet)|| stack.getItem().equals(halocraft.Main.SpartanChestplate)|| stack.getItem().equals(halocraft.Main.SpartanBoots)){
			return "halocraft:textures/armor/haloarmor_layer_1.png";
		}
		
		if(stack.getItem().equals(halocraft.Main.SpartanLeggings)){
			return "halocraft:textures/armor/haloarmor_layer_2.png";
		}
		
		else return null;
	}
}
