package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityPlasmaRocket;
import io.github.hsyyid.halocraft.items.FuelRodCannonTask;
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

public class ItemFuelRodCannon extends ItemFirearm
{
	private Timer timer = new Timer();
	public boolean canShoot = true;

	public static String name = "itemFuelRodCannon";
	public static ItemFirearm instance = new ItemFuelRodCannon();

	public ItemFuelRodCannon()
	{
		super();

		this.ammoItem = CommonProxy.ammoPlasmaRocket;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if (canShoot)
		{
			if (playerIn.capabilities.isCreativeMode || playerIn.inventory.clearMatchingItems(this.ammoItem, -1, 1, null) == 1)
			{
				worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.entity_skeleton_shoot, SoundCategory.HOSTILE, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

				if (!worldIn.isRemote)
				{
					worldIn.spawnEntityInWorld(new EntityPlasmaRocket(worldIn, playerIn));
					itemStackIn.damageItem(1, playerIn);
					canShoot = false;
					timer.schedule(new FuelRodCannonTask(this), 3000);
				}
			}

			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
		}

		return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
	}
}
