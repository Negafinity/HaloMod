package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemOil extends Item
{
	public ItemOil()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("itemOil");
		setMaxStackSize(64);
	}
}
