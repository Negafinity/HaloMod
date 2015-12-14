package halocraft.items;

import halocraft.entities.EntityPulseGrenade;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PulseGrenade extends Item
{
	public static final PulseGrenade instance = new PulseGrenade();
	public static final String name = "PulseGrenade";

	public PulseGrenade()
	{
		setUnlocalizedName("pulseGrenade");
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (!playerIn.capabilities.isCreativeMode)
		{
			--itemStackIn.stackSize;
		}

		worldIn.playSoundAtEntity(playerIn, "random.fizz", 0.7F, 0.8F);

		if (!worldIn.isRemote)
		{
			worldIn.spawnEntityInWorld(new EntityPulseGrenade(worldIn, playerIn));
		}
		return itemStackIn;
	}
}
