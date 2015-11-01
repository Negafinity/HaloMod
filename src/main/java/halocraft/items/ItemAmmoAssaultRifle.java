package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemAmmoAssaultRifle extends Item
{
	public ItemAmmoAssaultRifle()
	{
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("ammoAssaultRifle");
		setMaxStackSize(1);
		setMaxDamage(32);
	}
}
