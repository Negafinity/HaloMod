package halocraft.items.firearms;

import halocraft.entities.EntityGreenPlasma;
import halocraft.items.ItemCarbineAmmo;

public class ItemCarbineRifle extends ItemFirearm
{
	public static String name = "itemCarbineRifle";
	public static ItemFirearm instance = new ItemCarbineRifle();

	public ItemCarbineRifle()
	{
		super();

		this.damage = 8;
		this.ammoItem = ItemCarbineAmmo.instance;
		this.bulletClass = EntityGreenPlasma.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
