package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemAmmoPrometheanMagazine extends Item
{
	public ItemAmmoPrometheanMagazine()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("ammoPrometheanMagazine");
		setMaxStackSize(64);
		setMaxDamage(32);
	}
}
