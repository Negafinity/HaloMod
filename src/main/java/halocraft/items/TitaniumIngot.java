package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class TitaniumIngot extends Item
{
	public static final TitaniumIngot instance = new TitaniumIngot();
	public static final String name = "TitaniumIngot";

	public TitaniumIngot()
	{
		setMaxStackSize(16);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
