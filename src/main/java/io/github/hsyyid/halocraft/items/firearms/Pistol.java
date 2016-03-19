package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityBullet;
import io.github.hsyyid.halocraft.proxies.CommonProxy;

public class Pistol extends ItemFirearm
{
	public static String name = "Pistol";
	public static ItemFirearm instance = new Pistol();

	public Pistol()
	{
		super();

		this.damage = 4;
		this.ammoItem = CommonProxy.ammoAssaultRifle;
		this.bulletClass = EntityBullet.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
