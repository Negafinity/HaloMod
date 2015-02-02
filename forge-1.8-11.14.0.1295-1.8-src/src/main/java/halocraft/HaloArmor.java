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
		if(stack.getItem().equals(halocraft.Main.RedSpartanHelmet)|| stack.getItem().equals(halocraft.Main.RedSpartanChestplate)|| stack.getItem().equals(halocraft.Main.RedSpartanBoots)){
			return "halocraft:textures/armor/redhaloarmor_layer_1.png";
		}
		
		if(stack.getItem().equals(halocraft.Main.RedSpartanLeggings)){
			return "halocraft:textures/armor/redhaloarmor_layer_2.png";
		}
		if(stack.getItem().equals(halocraft.Main.GreenSpartanHelmet)|| stack.getItem().equals(halocraft.Main.GreenSpartanChestplate)|| stack.getItem().equals(halocraft.Main.GreenSpartanBoots)){
			return "halocraft:textures/armor/greenhaloarmor_layer_1.png";
		}
		
		if(stack.getItem().equals(halocraft.Main.GreenSpartanLeggings)){
			return "halocraft:textures/armor/greenhaloarmor_layer_2.png";
		}
		if(stack.getItem().equals(halocraft.Main.BlueSpartanHelmet)|| stack.getItem().equals(halocraft.Main.BlueSpartanChestplate)|| stack.getItem().equals(halocraft.Main.BlueSpartanBoots)){
			return "halocraft:textures/armor/bluehaloarmor_layer_1.png";
		}
		
		if(stack.getItem().equals(halocraft.Main.BlueSpartanLeggings)){
			return "halocraft:textures/armor/bluehaloarmor_layer_2.png";
		}
		else return null;
	}
}
