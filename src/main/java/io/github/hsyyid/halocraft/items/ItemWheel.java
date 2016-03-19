package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemWheel extends Item
{
	public ItemWheel()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("itemWheel");
		setMaxStackSize(32);
	}
}
