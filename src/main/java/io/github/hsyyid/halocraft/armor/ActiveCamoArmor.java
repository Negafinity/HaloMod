package io.github.hsyyid.halocraft.armor;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.world.World;

public class ActiveCamoArmor extends ItemArmor
{
	public ActiveCamoArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn)
	{
		super(material, renderIndex, equipmentSlotIn);

		this.setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor)
	{
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(PotionType.getID(PotionTypes.invisibility)), 500, 4));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		return "halocraft:textures/armor/ActiveCamoArmor_layer_1.png";
	}
}
