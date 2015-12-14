package halocraft.items.firearms;

import halocraft.HaloCraft;

public class ItemBattleRifle extends ItemFirearm
{
	public static String name = "itemBattleRifle";
	public static ItemFirearm instance = new ItemBattleRifle();

	public ItemBattleRifle()
	{
		super();

		this.damage = 8;
		this.ammo = HaloCraft.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
