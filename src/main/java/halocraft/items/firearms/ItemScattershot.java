package halocraft.items.firearms;

import halocraft.entities.EntityOrangePlasma;
import halocraft.proxies.CommonProxy;

public class ItemScattershot extends ItemFirearm
{
	public static String name = "Scattershot";
	public static ItemFirearm instance = new ItemScattershot();

	public ItemScattershot()
	{
		super();

		this.damage = 10;
		this.ammoItem = CommonProxy.ammoPrometheanMagazine;
		this.bulletClass = EntityOrangePlasma.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
