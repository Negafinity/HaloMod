package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityRedPlasma;
import io.github.hsyyid.halocraft.items.ItemRedPlasmaAmmo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
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
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if (playerIn.capabilities.isCreativeMode || playerIn.inventory.clearMatchingItems(this.ammoItem, -1, 1, null) == 1)
		{
			worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.entity_skeleton_shoot, SoundCategory.HOSTILE, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote)
			{
				worldIn.spawnEntityInWorld(new EntityRedPlasma(worldIn, playerIn));
				itemStackIn.damageItem(1, playerIn);
			}
		}

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}
}
