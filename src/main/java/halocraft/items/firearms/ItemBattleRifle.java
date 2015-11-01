package halocraft.items.firearms;

import java.util.Random;

import halocraft.HaloCraft;
import halocraft.entities.EntityBullet;
import halocraft.items.ItemAmmoAssaultRifle;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
