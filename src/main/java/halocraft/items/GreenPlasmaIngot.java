package halocraft.items;

import net.minecraft.item.Item;

public class GreenPlasmaIngot extends Item
{
	public static final GreenPlasmaIngot instance = new GreenPlasmaIngot();
	public static final String name = "GreenPlasmaIngot";

	public GreenPlasmaIngot()
	{
		setMaxStackSize(16);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
