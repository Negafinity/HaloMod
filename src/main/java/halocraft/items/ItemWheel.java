package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemWheel extends Item
{
	public ItemWheel()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("itemWheel");
		setMaxStackSize(32);
	}
}
