package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemCarbineAmmo extends Item
{
	public static final ItemCarbineAmmo instance = new ItemCarbineAmmo();
	public static final String name = "ItemCarbineAmmo";

	public ItemCarbineAmmo()
	{
		setMaxStackSize(1);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setMaxDamage(32);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
