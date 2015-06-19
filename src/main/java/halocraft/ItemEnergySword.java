package halocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemEnergySword extends ItemSword{
	public ItemEnergySword(ToolMaterial material) {
		super(material);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("energySword");
	}
}