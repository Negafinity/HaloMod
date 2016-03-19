package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemRubber extends Item
{
	public ItemRubber()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("itemRubber");
		setMaxStackSize(64);
	}
}
