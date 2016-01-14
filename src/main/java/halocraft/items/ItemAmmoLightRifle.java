package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemAmmoLightRifle extends Item
{
	public ItemAmmoLightRifle()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("ammoLightRifle");
		setMaxStackSize(1);
		setMaxDamage(32);
	}
}
