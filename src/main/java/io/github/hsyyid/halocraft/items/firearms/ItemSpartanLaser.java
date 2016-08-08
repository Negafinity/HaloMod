package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityRedPlasma;
import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemSpartanLaser extends ItemFirearm
{
	public static String name = "itemSpartanLaser";
	public static ItemFirearm instance = new ItemSpartanLaser();

	public ItemSpartanLaser()
	{
		super();

		this.ammoItem = CommonProxy.ammoRocket;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if (playerIn.capabilities.isCreativeMode || playerIn.inventory.clearMatchingItems(this.ammoItem, -1, 1, null) == 1)
		{
			worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_SKELETON_SHOOT, SoundCategory.HOSTILE, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote)
			{
				worldIn.spawnEntityInWorld(new EntityRedPlasma(worldIn, playerIn));
				itemStackIn.damageItem(1, playerIn);
			}
		}

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}
}
