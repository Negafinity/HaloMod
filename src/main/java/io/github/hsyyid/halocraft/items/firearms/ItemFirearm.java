package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityBullet;
import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import java.lang.reflect.Constructor;

public class ItemFirearm extends Item
{
	public Item ammoItem;
	public int damage;
	public int clipRounds;
	public Class<? extends EntityBullet> bulletClass;

	public ItemFirearm()
	{
		this.clipRounds = 32;
		this.bulletClass = EntityBullet.class;
		this.setCreativeTab(CommonProxy.haloCreativeTab);
		this.setMaxStackSize(1);
		this.setMaxDamage(1000);
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt)
	{
		if (nbt == null)
		{
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("bullets", 0);
			stack.setTagCompound(tag);
		}

		return super.initCapabilities(stack, nbt);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if (playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn, stack))
		{
			worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.entity_skeleton_shoot, SoundCategory.HOSTILE, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote)
			{
				try
				{
					Constructor<? extends EntityBullet> bulletConstructor = bulletClass.getConstructor(World.class, EntityLivingBase.class);
					EntityBullet bullet = bulletConstructor.newInstance(worldIn, playerIn);
					bullet.damage = this.damage;
					worldIn.spawnEntityInWorld(bullet);
					stack.damageItem(1, playerIn);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}

	public boolean canDamageAmmo(World worldIn, EntityPlayer playerIn, ItemStack stack)
	{
		if (!worldIn.isRemote)
		{
			if (playerIn.inventory.hasItemStack(new ItemStack(this.ammoItem)))
			{
				for (ItemStack itemStack : playerIn.inventory.mainInventory)
				{
					if (itemStack != null && itemStack.getItem() != null && this.ammoItem.getUnlocalizedName().equals(itemStack.getItem().getUnlocalizedName()))
					{
						if (this.getRemainingBullets(stack) > 0)
						{
							this.setRemainingBullets(stack, this.getRemainingBullets(stack) - 1);
						}
						else
						{
							playerIn.inventory.clearMatchingItems(this.ammoItem, -1, 1, null);
							this.setRemainingBullets(stack, this.clipRounds);
						}

						return true;
					}
				}
			}
		}

		return false;
	}

	public int getRemainingBullets(ItemStack stack)
	{
		return stack.getTagCompound().getInteger("bullets");
	}

	public void setRemainingBullets(ItemStack stack, int shots)
	{
		stack.getTagCompound().setInteger("bullets", shots);
	}
}
