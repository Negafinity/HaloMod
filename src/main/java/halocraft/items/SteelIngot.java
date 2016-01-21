package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class SteelIngot extends Item
{
	public static final SteelIngot instance = new SteelIngot();
	public static final String name = "SteelIngot";

	public SteelIngot()
	{
		setMaxStackSize(16);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
