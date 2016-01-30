package halocraft.items.firearms;

import halocraft.entities.EntityOrangePlasma;
import halocraft.proxies.CommonProxy;

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
