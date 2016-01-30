package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemMagazine extends Item
{
	public ItemMagazine()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("ammoAssaultRifle");
		setMaxStackSize(64);
		setMaxDamage(32);
	}
}
