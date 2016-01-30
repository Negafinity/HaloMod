package halocraft.items;

import halocraft.proxies.CommonProxy;
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
