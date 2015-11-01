package halocraft.items.firearms;

import halocraft.HaloCraft;
import halocraft.entities.EntityBullet;
import halocraft.entities.EntityOrangePlasma;
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
		this.ammo = HaloCraft.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn))
		{
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityOrangePlasma bullet = new EntityOrangePlasma(worldIn, playerIn);
				bullet.damage = this.damage;
				worldIn.spawnEntityInWorld(bullet);
				itemStackIn.damageItem(1, playerIn);
			}
		}
		
		return itemStackIn;
	}
}
