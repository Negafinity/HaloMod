package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HaloIngot extends Item {
	public HaloIngot() {
		setMaxStackSize(16);
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("HaloIngot");
	}
}
