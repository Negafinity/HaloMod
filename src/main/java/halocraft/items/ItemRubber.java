package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRubber extends Item {
	public ItemRubber(){
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("itemRubber");
		setMaxStackSize(64);
	}
}
