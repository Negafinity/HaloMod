package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemAmmoPrometheanMagazine extends Item
{
	public ItemAmmoPrometheanMagazine()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("ammoPrometheanMagazine");
		setMaxStackSize(1);
		setMaxDamage(32);
	}
}
