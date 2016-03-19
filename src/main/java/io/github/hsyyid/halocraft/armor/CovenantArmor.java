package io.github.hsyyid.halocraft.armor;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CovenantArmor extends ItemArmor
{
	public CovenantArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn)
	{
		super(material, renderIndex, equipmentSlotIn);

		this.setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot equipmentSlotIn, String layer)
	{
		if (equipmentSlotIn != EntityEquipmentSlot.LEGS)
		{
			return "halocraft:textures/armor/CovenantArmor_layer_1.png";
		}
		else
		{
			return "halocraft:textures/armor/CovenantArmor_layer_2.png";
		}
	}
}
