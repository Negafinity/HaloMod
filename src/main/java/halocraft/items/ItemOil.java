package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemOil extends Item {
	public ItemOil(){
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("itemOil");
		setMaxStackSize(64);
	}
}
