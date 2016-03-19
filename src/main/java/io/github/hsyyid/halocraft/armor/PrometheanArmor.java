package io.github.hsyyid.halocraft.armor;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class PrometheanArmor extends ItemArmor
{
	public PrometheanArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn)
	{
		super(material, renderIndex, equipmentSlotIn);
		setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot equipmentSlotIn, String layer)
	{
		return "halocraft:textures/armor/PrometheanArmor_1.png";
	}
}
