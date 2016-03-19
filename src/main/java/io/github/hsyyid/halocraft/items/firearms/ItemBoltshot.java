package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityOrangePlasma;
import io.github.hsyyid.halocraft.proxies.CommonProxy;

public class ItemBoltshot extends ItemFirearm
{
	public static String name = "itemBoltshot";
	public static ItemFirearm instance = new ItemBoltshot();

	public ItemBoltshot()
	{
		super();

		this.damage = 7;
		this.ammoItem = CommonProxy.ammoPrometheanMagazine;
		this.bulletClass = EntityOrangePlasma.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
