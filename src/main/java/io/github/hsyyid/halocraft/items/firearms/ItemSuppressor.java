package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityOrangePlasma;
import io.github.hsyyid.halocraft.proxies.CommonProxy;

public class ItemSuppressor extends ItemFirearm
{
	public static String name = "itemSuppressor";
	public static ItemFirearm instance = new ItemSuppressor();
	
	public ItemSuppressor()
	{
		super();

		this.damage = 7;
		this.ammoItem = CommonProxy.ammoPrometheanMagazine;
		this.bulletClass = EntityOrangePlasma.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
