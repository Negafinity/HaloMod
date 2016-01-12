package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemAmmoPlasmaRocket extends Item
{
	public ItemAmmoPlasmaRocket()
	{
		setMaxStackSize(32);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("ammoPlasmaRocket");
	}
}
