package halocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class CovenantArmor extends ItemArmor{

	public CovenantArmor(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		setCreativeTab(CreativeTabs.tabCombat);
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){
		if(stack.getItem().equals(halocraft.Main.CovenantHelmet)|| stack.getItem().equals(halocraft.Main.CovenantChestplate)|| stack.getItem().equals(halocraft.Main.CovenantBoots)){
			return "halocraft:textures/armor/covenantarmor_layer_1.png";
		}
		
		if(stack.getItem().equals(halocraft.Main.CovenantLeggings)){
			return "halocraft:textures/armor/covenantarmor_layer_2.png";
		}
		
		else return null;
	}
}
