package halocraft.items.firearms;

import halocraft.entities.EntityPurplePlasma;
import halocraft.items.ItemNeedlerAmmo;

public class ItemNeedler extends ItemFirearm
{
	public static String name = "Needler";
	public static ItemFirearm instance = new ItemNeedler();

	public ItemNeedler()
	{
		super();

		this.damage = 6;
		this.ammoItem = ItemNeedlerAmmo.instance;
		this.bulletClass = EntityPurplePlasma.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
