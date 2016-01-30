package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemAmmoPlasma extends Item
{
	public ItemAmmoPlasma()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("ammoPlasma");
		setMaxStackSize(64);
		setMaxDamage(32);
	}
}
