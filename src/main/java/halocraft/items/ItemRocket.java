package halocraft.items;

import net.minecraft.item.Item;

public class ItemRocket extends Item
{
	public ItemRocket()
	{
		setMaxStackSize(32);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("ammoRocket");
	}
}
