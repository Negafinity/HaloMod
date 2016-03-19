package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class SpartaniumIngot extends Item
{
	public SpartaniumIngot()
	{
		setMaxStackSize(64);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("SpartaniumIngot");
	}
}
