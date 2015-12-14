package halocraft.items.firearms;

import halocraft.entities.EntityGreenPlasma;
import halocraft.items.ItemCarbineAmmo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class ItemCarbineRifle extends ItemFirearm
{
	public static String name = "itemCarbineRifle";
	public static ItemFirearm instance = new ItemCarbineRifle();

	public ItemCarbineRifle()
	{
		super();

		this.damage = 8;
		this.ammo = ItemCarbineAmmo.instance;
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
				EntityGreenPlasma greenPlasma = new EntityGreenPlasma(worldIn, playerIn);
				greenPlasma.damage = this.damage;
				worldIn.spawnEntityInWorld(greenPlasma);
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
				if (itemStack != null && itemStack.getItem() != null && itemStack.getItem() instanceof ItemCarbineAmmo)
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
