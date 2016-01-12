package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class GreenPlasmaIngot extends Item
{
	public static final GreenPlasmaIngot instance = new GreenPlasmaIngot();
	public static final String name = "GreenPlasmaIngot";

	public GreenPlasmaIngot()
	{
		setMaxStackSize(16);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
