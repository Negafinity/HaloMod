package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityBullet;
import io.github.hsyyid.halocraft.items.SniperRifleTask;
import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
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
		this.ammoItem = CommonProxy.ammoAssaultRifle;
		this.bulletClass = EntityBullet.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if (canShoot)
		{
			if (playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn, stack))
			{
				worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.entity_skeleton_shoot, SoundCategory.HOSTILE, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

				if (!worldIn.isRemote)
				{
					EntityBullet bullet = new EntityBullet(worldIn, playerIn);
					bullet.damage = 10;
					worldIn.spawnEntityInWorld(bullet);
					stack.damageItem(1, playerIn);
					canShoot = false;
					t.schedule(new SniperRifleTask(this), 1000);
				}
			}

			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
		}

		return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
	}
}
