package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class ItemAmmoPlasmaRocket extends Item{
	public ItemAmmoPlasmaRocket() {
        setMaxStackSize(32);
        setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("ammoPlasmaRocket");
	}
}
