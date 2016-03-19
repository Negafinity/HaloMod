package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityBullet;
import io.github.hsyyid.halocraft.proxies.CommonProxy;

public class ItemAssaultRifle extends ItemFirearm
{
	public static String name = "itemAssaultRifle";
	public static ItemFirearm instance = new ItemAssaultRifle();

	public ItemAssaultRifle()
	{
		super();

		this.damage = 6;
		this.ammoItem = CommonProxy.ammoAssaultRifle;
		this.bulletClass = EntityBullet.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
