package halocraft.items.firearms;

import halocraft.entities.EntityRedPlasma;
import halocraft.items.ItemRedPlasmaAmmo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIncinerationCannon extends ItemFirearm
{
	public static String name = "itemIncinerationCannon";
	public static ItemFirearm instance = new ItemIncinerationCannon();

	public ItemIncinerationCannon()
	{
		super();

		this.ammoItem = ItemRedPlasmaAmmo.instance;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.capabilities.isCreativeMode || playerIn.inventory.consumeInventoryItem(this.ammoItem))
		{
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote)
			{
				worldIn.spawnEntityInWorld(new EntityRedPlasma(worldIn, playerIn));
				itemStackIn.damageItem(1, playerIn);
			}
		}

		return itemStackIn;
	}
}
