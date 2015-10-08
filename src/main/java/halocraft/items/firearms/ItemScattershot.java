package halocraft.items.firearms;

import halocraft.Main;
import halocraft.entities.EntityBullet;
import halocraft.items.ItemAmmoAssaultRifle;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemScattershot extends ItemFirearm
{
	public static String name = "Scattershot";
	public static ItemFirearm instance = new ItemScattershot();
	
	public ItemScattershot()
	{
		super();

		this.damage = 10;
		this.ammo = Main.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
