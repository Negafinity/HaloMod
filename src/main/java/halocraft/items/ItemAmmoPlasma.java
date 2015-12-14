package halocraft.items;

import net.minecraft.item.Item;

public class ItemAmmoPlasma extends Item
{
	public ItemAmmoPlasma()
	{
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("ammoPlasma");
		setMaxStackSize(1);
		setMaxDamage(32);
	}
}
