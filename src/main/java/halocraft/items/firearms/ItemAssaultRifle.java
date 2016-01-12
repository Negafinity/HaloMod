package halocraft.items.firearms;

import halocraft.proxies.CommonProxy;

public class ItemAssaultRifle extends ItemFirearm
{
	public static String name = "itemAssaultRifle";
	public static ItemFirearm instance = new ItemAssaultRifle();

	public ItemAssaultRifle()
	{
		super();

		this.damage = 6;
		this.ammo = CommonProxy.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
