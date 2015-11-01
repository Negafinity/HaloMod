package halocraft.items.firearms;

import halocraft.HaloCraft;
import halocraft.entities.EntityBullet;
import halocraft.items.ItemAmmoAssaultRifle;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ItemAssaultRifle extends ItemFirearm
{
	public static String name = "itemAssaultRifle";
	public static ItemFirearm instance = new ItemAssaultRifle();
	
	public ItemAssaultRifle()
	{
		super();

		this.damage = 6;
		this.ammo = HaloCraft.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
