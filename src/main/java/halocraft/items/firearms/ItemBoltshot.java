package halocraft.items.firearms;

import halocraft.entities.EntityOrangePlasma;
import halocraft.proxies.CommonProxy;

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
