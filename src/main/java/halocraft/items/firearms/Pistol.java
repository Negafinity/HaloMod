package halocraft.items.firearms;

import halocraft.Main;
import halocraft.entities.EntityBullet;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Pistol extends ItemFirearm
{
	public static String name = "Pistol";
	public static ItemFirearm instance = new Pistol();
	
	public Pistol()
	{
		super();

		this.damage = 4;
		this.ammo = Main.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
