package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class GreenPlasmaIngot extends Item
{
	public static final GreenPlasmaIngot instance = new GreenPlasmaIngot();
	public static final String name = "GreenPlasmaIngot";

	public GreenPlasmaIngot()
	{
		setMaxStackSize(64);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
