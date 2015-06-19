package halocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class ItemRocket extends Item{
	public ItemRocket() {
        setMaxStackSize(32);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("ammoRocket");
	}
}
