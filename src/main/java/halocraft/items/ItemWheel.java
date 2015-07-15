package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemWheel extends Item {
	public ItemWheel(){
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("itemWheel");
		setMaxStackSize(32);
	}
}
