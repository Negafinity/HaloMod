package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.entities.EntityPulseGrenade;
import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class PulseGrenade extends Item
{
	public static final PulseGrenade instance = new PulseGrenade();
	public static final String name = "PulseGrenade";

	public PulseGrenade()
	{
		setUnlocalizedName("pulseGrenade");
		setCreativeTab(CommonProxy.haloCreativeTab);
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (!playerIn.capabilities.isCreativeMode)
		{
			--itemStackIn.stackSize;
		}

		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 0.7F, 0.8F);

		if (!worldIn.isRemote)
		{
			worldIn.spawnEntityInWorld(new EntityPulseGrenade(worldIn, playerIn));
		}

		return itemStackIn;
	}
}
