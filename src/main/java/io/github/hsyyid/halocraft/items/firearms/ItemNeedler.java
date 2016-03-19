package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityPurplePlasma;
import io.github.hsyyid.halocraft.items.ItemNeedlerAmmo;

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
