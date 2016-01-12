package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemRocket extends Item
{
	public ItemRocket()
	{
		setMaxStackSize(32);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("ammoRocket");
	}
}
