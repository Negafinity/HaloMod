package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityBullet;
import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.lang.reflect.Constructor;

public class ItemFirearm extends Item
{
	public Item ammoItem;
	public int damage;
	public int clipRounds;
	public int remainingBullets = 0;
	public Class<? extends EntityBullet> bulletClass;

	public ItemFirearm()
	{
		this.clipRounds = 32;
		this.setCreativeTab(CommonProxy.haloCreativeTab);
		this.setMaxStackSize(1);
		this.setMaxDamage(1000);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if (playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn))
		{
			worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.entity_skeleton_shoot, SoundCategory.HOSTILE, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote)
			{
				try
				{
					Constructor<? extends EntityBullet> bulletConstructor = bulletClass.getConstructor(new Class[] { World.class, EntityLivingBase.class });
					EntityBullet bullet = bulletConstructor.newInstance(new Object[] { worldIn, (EntityLivingBase) playerIn });
					bullet.damage = this.damage;
					worldIn.spawnEntityInWorld(bullet);
					itemStackIn.damageItem(1, playerIn);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}

	public boolean canDamageAmmo(World worldIn, EntityPlayer playerIn)
	{
		if (!worldIn.isRemote)
		{
			if (playerIn.inventory.hasItemStack(new ItemStack(this.ammoItem)))
			{
				for (ItemStack itemStack : playerIn.inventory.mainInventory)
				{
					if (itemStack != null && itemStack.getItem() != null && this.ammoItem.getUnlocalizedName().equals(itemStack.getItem().getUnlocalizedName()))
					{
						if (this.remainingBullets > 0)
						{
							this.remainingBullets--;
						}
						else
						{
							playerIn.inventory.clearMatchingItems(this.ammoItem, -1, 1, null);
							this.remainingBullets = this.clipRounds;
						}

						return true;
					}
				}
			}
		}

		return false;
	}
}
