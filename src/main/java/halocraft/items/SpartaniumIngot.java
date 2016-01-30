package halocraft.items;

import halocraft.proxies.CommonProxy;
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
