package halocraft.items.firearms;

import halocraft.HaloCraft;
import halocraft.entities.EntityBullet;
import halocraft.items.IntervalTask;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Timer;

public class ItemSniperRifle extends ItemFirearm
{
	private Timer t = new Timer();
	public boolean canShoot = true;

	public static String name = "itemSniperRifle";
	public static ItemFirearm instance = new ItemSniperRifle();

	public ItemSniperRifle()
	{
		super();

		this.damage = 10;
		this.ammo = HaloCraft.ammoAssaultRifle;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (canShoot)
		{
			if (playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn))
			{
				worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				if (!worldIn.isRemote)
				{
					EntityBullet bullet = new EntityBullet(worldIn, playerIn);
					bullet.damage = 10;
					worldIn.spawnEntityInWorld(bullet);
					itemStackIn.damageItem(1, playerIn);
					canShoot = false;
					t.schedule(new IntervalTask(this), 1000);
				}

				return itemStackIn;
			}
		}

		return itemStackIn;
	}
}
