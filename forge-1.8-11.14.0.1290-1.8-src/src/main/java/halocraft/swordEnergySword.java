package halocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class swordEnergySword extends ItemSword{
	public swordEnergySword(ToolMaterial material) {
		super(material);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("energySword");
	}
}