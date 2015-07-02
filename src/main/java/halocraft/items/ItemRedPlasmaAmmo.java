package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRedPlasmaAmmo extends Item {
	public ItemRedPlasmaAmmo(){
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("itemRedPlasmaAmmo");
		setMaxStackSize(32);
	}
}