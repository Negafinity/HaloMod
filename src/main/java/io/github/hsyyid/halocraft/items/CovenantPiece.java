package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.Item;

public class CovenantPiece extends Item
{
	public CovenantPiece()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("CovenantPiece");
		setMaxStackSize(64);
	}
}
