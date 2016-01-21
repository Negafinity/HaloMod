package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemAntiChip extends Item
{
	public ItemAntiChip()
	{
		this.setCreativeTab(CommonProxy.haloCreativeTab);
		this.setUnlocalizedName("itemAntiChip");
		this.setMaxStackSize(64);
	}
}
