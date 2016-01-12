package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class SpartaniumIngot extends Item
{
	public SpartaniumIngot()
	{
		setMaxStackSize(16);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("SpartaniumIngot");
	}
}
