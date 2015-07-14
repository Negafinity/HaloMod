package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRedPlasmaAmmo extends Item {
	public ItemRedPlasmaAmmo(){
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("itemRedPlasmaAmmo");
		setMaxStackSize(32);
	}
}