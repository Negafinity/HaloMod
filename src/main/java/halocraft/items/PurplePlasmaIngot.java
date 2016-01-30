package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class PurplePlasmaIngot extends Item
{
	public static final PurplePlasmaIngot instance = new PurplePlasmaIngot();
	public static final String name = "PurplePlasmaIngot";

	public PurplePlasmaIngot()
	{
		setMaxStackSize(64);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
