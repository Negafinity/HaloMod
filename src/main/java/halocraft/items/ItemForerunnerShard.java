package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemForerunnerShard extends Item
{
	public static final ItemForerunnerShard instance = new ItemForerunnerShard();
	public static final String name = "ItemForerunnerShard";

	public ItemForerunnerShard()
	{
		setMaxStackSize(16);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
