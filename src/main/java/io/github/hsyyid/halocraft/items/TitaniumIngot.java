package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class TitaniumIngot extends Item
{
	public static final TitaniumIngot instance = new TitaniumIngot();
	public static final String name = "TitaniumIngot";

	public TitaniumIngot()
	{
		setMaxStackSize(64);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
