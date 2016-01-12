package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemRubber extends Item
{
	public ItemRubber()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("itemRubber");
		setMaxStackSize(64);
	}
}
