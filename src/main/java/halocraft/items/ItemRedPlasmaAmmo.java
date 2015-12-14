package halocraft.items;

import net.minecraft.item.Item;

public class ItemRedPlasmaAmmo extends Item
{
	// Following is so you can access it in pre-init
	public static final ItemRedPlasmaAmmo instance = new ItemRedPlasmaAmmo();
	public static final String name = "itemRedPlasmaAmmo";

	public ItemRedPlasmaAmmo()
	{
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(32);
	}
}
