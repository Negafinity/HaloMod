package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemAmmoPlasmaRocket extends Item
{
	public ItemAmmoPlasmaRocket()
	{
		setMaxStackSize(32);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("ammoPlasmaRocket");
	}
}
