package halocraft.items.firearms;

import halocraft.proxies.CommonProxy;

public class Pistol extends ItemFirearm
{
	public static String name = "Pistol";
	public static ItemFirearm instance = new Pistol();

	public Pistol()
	{
		super();

		this.damage = 4;
		this.ammo = CommonProxy.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
