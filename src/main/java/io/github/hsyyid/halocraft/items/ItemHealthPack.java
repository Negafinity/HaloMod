package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.world.World;

public class ItemHealthPack extends Item
{
	public static final ItemHealthPack instance = new ItemHealthPack();
	public static final String name = "HealthPack";

	public ItemHealthPack()
	{
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(PotionType.getID(PotionTypes.healing)), 500, 4));
		playerIn.inventory.clearMatchingItems(ItemHealthPack.instance, -1, 1, null);
		return itemStackIn;
	}
}
