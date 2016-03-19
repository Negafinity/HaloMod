package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityBullet;
import io.github.hsyyid.halocraft.proxies.CommonProxy;

public class PlasmaRifle extends ItemFirearm
{
	public static final PlasmaRifle instance = new PlasmaRifle();
	public static final String name = "PlasmaRifle";

	public PlasmaRifle()
	{
		super();
		
		this.damage = 6;
		this.ammoItem = CommonProxy.ammoAssaultRifle;
		this.bulletClass = EntityBullet.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
