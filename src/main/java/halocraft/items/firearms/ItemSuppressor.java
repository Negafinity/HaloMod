package halocraft.items.firearms;

import halocraft.Main;

public class ItemSuppressor extends ItemFirearm
{
	public static String name = "itemSuppressor";
	public static ItemFirearm instance = new ItemSuppressor();
	
	public ItemSuppressor()
	{
		super();

		this.damage = 7;
		this.ammo = Main.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
