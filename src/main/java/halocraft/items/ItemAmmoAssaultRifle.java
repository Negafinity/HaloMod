package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemAmmoAssaultRifle extends Item
{
	public ItemAmmoAssaultRifle()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("ammoAssaultRifle");
		setMaxStackSize(1);
		setMaxDamage(32);
	}
}
