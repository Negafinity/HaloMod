package halocraft.items.firearms;

import halocraft.entities.EntityBullet;
import halocraft.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class ItemFirearm extends Item
{	
	public Item ammo;
	public int damage;
	public int clipRounds;

	public ItemFirearm()
	{
		this.clipRounds = 32;
		this.setCreativeTab(CommonProxy.haloCreativeTab);
		this.setMaxStackSize(1);
		this.setMaxDamage(1000);
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn))
		{
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!worldIn.isRemote)
			{
				EntityBullet bullet = new EntityBullet(worldIn, playerIn);
				bullet.damage = this.damage;
				worldIn.spawnEntityInWorld(bullet);
				itemStackIn.damageItem(1, playerIn);
			}
			return itemStackIn;
		}
		
		return itemStackIn;
	}

	public boolean canDamageAmmo(World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.inventory.hasItem(this.ammo))
		{
			for (ItemStack itemStack : playerIn.inventory.mainInventory)
			{
				if (itemStack != null && itemStack.getItem() != null && this.ammo.getUnlocalizedName().equals(itemStack.getItem().getUnlocalizedName()))
				{
					if (itemStack.getItemDamage() < this.clipRounds)
					{
						itemStack.attemptDamageItem(1, new Random());
					}
					else
					{
						playerIn.inventory.consumeInventoryItem(itemStack.getItem());
					}

					return true;
				}
			}
		}
		return false;
	}
}
