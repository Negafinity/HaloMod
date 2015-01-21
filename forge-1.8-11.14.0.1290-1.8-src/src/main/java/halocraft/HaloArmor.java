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
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
        if(armor.getItem() == halocraft.Main.SpartanHelmet) {
                return "halocraft:textures/armor/SpartanHelmet";
        }
        else if(armor.getItem() == halocraft.Main.SpartanChestplate) {
                return "halocraft:textures/armor/SpartanChestplate.png";
        }
        else if(armor.getItem() == halocraft.Main.SpartanLeggings){
                return "halocraft:textures/armor/SpartanLeggings";
        }
        else{
                return "halocraft:textures/armor/SpartanBoots";
        }
    }
}
