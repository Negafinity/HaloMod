package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.item.ItemSword;

public class ItemEnergySword extends ItemSword
{
	// Following is so you can access it in pre-init
	public static final ItemEnergySword instance = new ItemEnergySword();
	public static final String name = "EnergySword";

	public ItemEnergySword()
	{
		super(CommonProxy.haloMaterial);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
