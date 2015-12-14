package halocraft.items;

import net.minecraft.item.Item;

public class RedPlasmaIngot extends Item
{
	public static final RedPlasmaIngot instance = new RedPlasmaIngot();
	public static final String name = "RedPlasmaIngot";

	public RedPlasmaIngot()
	{
		setMaxStackSize(16);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
