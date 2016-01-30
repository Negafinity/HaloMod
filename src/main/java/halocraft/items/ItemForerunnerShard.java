package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemForerunnerShard extends Item
{
	public static final ItemForerunnerShard instance = new ItemForerunnerShard();
	public static final String name = "ItemForerunnerShard";

	public ItemForerunnerShard()
	{
		setMaxStackSize(64);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
