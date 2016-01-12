package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemOil extends Item
{
	public ItemOil()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("itemOil");
		setMaxStackSize(64);
	}
}
