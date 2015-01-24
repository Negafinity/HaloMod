package halocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ammoAssaultRifle extends Item {
	public ammoAssaultRifle(){
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("ammoAssaultRifle");
		setMaxStackSize(32);
	}
}
