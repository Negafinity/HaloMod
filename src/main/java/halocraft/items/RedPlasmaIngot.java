package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class RedPlasmaIngot extends Item
{
	public static final RedPlasmaIngot instance = new RedPlasmaIngot();
	public static final String name = "RedPlasmaIngot";

	public RedPlasmaIngot()
	{
		setMaxStackSize(64);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
