package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityBullet;
import io.github.hsyyid.halocraft.proxies.CommonProxy;

public class ItemSMG extends ItemFirearm
{
	public static String name = "itemSMG";
	public static ItemFirearm instance = new ItemSMG();

	public ItemSMG()
	{
		super();

		this.damage = 5;
		this.ammoItem = CommonProxy.ammoAssaultRifle;
		this.bulletClass = EntityBullet.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
