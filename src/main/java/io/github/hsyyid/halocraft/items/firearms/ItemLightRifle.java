package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityOrangePlasma;
import io.github.hsyyid.halocraft.proxies.CommonProxy;

public class ItemLightRifle extends ItemFirearm
{
	public static String name = "itemLightRifle";
	public static ItemFirearm instance = new ItemLightRifle();

	public ItemLightRifle()
	{
		super();

		this.damage = 15;
		this.ammoItem = CommonProxy.ammoPrometheanMagazine;
		this.clipRounds = 32;
		this.bulletClass = EntityOrangePlasma.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
