package halocraft.items.firearms;

import halocraft.entities.EntityPurplePlasma;
import halocraft.items.ItemNeedlerAmmo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class ItemNeedler extends ItemFirearm
{
	public static String name = "Needler";
	public static ItemFirearm instance = new ItemNeedler();

	public ItemNeedler()
	{
		super();

		this.damage = 6;
		this.ammo = ItemNeedlerAmmo.instance;
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
				EntityPurplePlasma purplePlasma = new EntityPurplePlasma(worldIn, playerIn);
				purplePlasma.damage = this.damage;
				worldIn.spawnEntityInWorld(purplePlasma);
				itemStackIn.damageItem(1, playerIn);
			}

			return itemStackIn;
		}

		return itemStackIn;
	}

	@Override
	public boolean canDamageAmmo(World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.inventory.hasItem(this.ammo))
		{
			for (ItemStack itemStack : playerIn.inventory.mainInventory)
			{
				if (itemStack != null && itemStack.getItem() != null && itemStack.getItem() instanceof ItemNeedlerAmmo)
				{
					if (itemStack.getItemDamage() < 32)
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
