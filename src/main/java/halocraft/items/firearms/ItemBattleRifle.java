package halocraft.items.firearms;

import halocraft.proxies.CommonProxy;

public class ItemBattleRifle extends ItemFirearm
{
	public static String name = "itemBattleRifle";
	public static ItemFirearm instance = new ItemBattleRifle();

	public ItemBattleRifle()
	{
		super();

		this.damage = 8;
		this.ammo = CommonProxy.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
