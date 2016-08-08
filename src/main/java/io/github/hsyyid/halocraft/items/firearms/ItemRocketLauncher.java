package io.github.hsyyid.halocraft.items.firearms;

import io.github.hsyyid.halocraft.entities.EntityRocket;
import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemRocketLauncher extends ItemFirearm
{
	public static final ItemRocketLauncher instance = new ItemRocketLauncher();
	public static final String name = "itemRocketLauncher";

	public ItemRocketLauncher()
	{
		super();

		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
		this.ammoItem = CommonProxy.ammoRocket;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if (playerIn.capabilities.isCreativeMode || playerIn.inventory.clearMatchingItems(this.ammoItem, -1, 1, null) == 1)
		{
			worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_SKELETON_SHOOT, SoundCategory.HOSTILE, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote)
			{
				worldIn.spawnEntityInWorld(new EntityRocket(worldIn, playerIn));
				itemStackIn.damageItem(1, playerIn);
			}

			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
		}

		return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
	}
}
