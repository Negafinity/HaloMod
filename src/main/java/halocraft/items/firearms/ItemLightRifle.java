package halocraft.items.firearms;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import halocraft.Main;
import halocraft.entities.EntityBullet;
import halocraft.items.ItemAmmoAssaultRifle;
import halocraft.items.ItemCarbineAmmo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLightRifle extends ItemFirearm
{
	public static String name = "itemLightRifle";
	public static ItemFirearm instance = new ItemLightRifle();
	
	public ItemLightRifle()
	{
		super();

		this.damage = 15;
		this.ammo = Main.ammoAssaultRifle;
		this.clipRounds = 32;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
