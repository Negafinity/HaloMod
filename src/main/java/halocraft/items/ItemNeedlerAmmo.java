package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemNeedlerAmmo extends Item
{
	public static final ItemNeedlerAmmo instance = new ItemNeedlerAmmo();
	public static final String name = "ItemNeedlerAmmo";

	public ItemNeedlerAmmo()
	{
		setMaxStackSize(64);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setMaxDamage(32);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
