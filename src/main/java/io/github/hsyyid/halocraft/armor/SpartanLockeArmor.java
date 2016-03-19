package io.github.hsyyid.halocraft.armor;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SpartanLockeArmor extends ItemArmor
{
	public SpartanLockeArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn)
	{
		super(material, renderIndex, equipmentSlotIn);

		this.setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot equipmentSlotIn, String layer)
	{
		return "halocraft:textures/armor/SpartanLockeArmor_1.png";
	}
}
