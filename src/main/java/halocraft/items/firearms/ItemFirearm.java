package halocraft.items.firearms;

import halocraft.entities.EntityBullet;
import halocraft.proxies.CommonProxy;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn))
		{
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

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

			return itemStackIn;
		}

		return itemStackIn;
	}

	public boolean canDamageAmmo(World worldIn, EntityPlayer playerIn)
	{
		if (!worldIn.isRemote)
		{
			if (playerIn.inventory.hasItem(this.ammoItem))
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
							playerIn.inventory.consumeInventoryItem(this.ammoItem);
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
