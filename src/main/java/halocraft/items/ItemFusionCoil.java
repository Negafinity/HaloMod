package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class ItemFusionCoil extends Item
{
	public ItemFusionCoil()
	{
		this.setCreativeTab(CommonProxy.haloCreativeTab);
		this.setUnlocalizedName("itemFusionCoil");
		this.setMaxStackSize(64);
	}
}
