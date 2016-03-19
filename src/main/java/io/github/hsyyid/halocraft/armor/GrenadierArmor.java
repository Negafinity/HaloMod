package io.github.hsyyid.halocraft.armor;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class GrenadierArmor extends ItemArmor
{
	public GrenadierArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn)
	{
		super(material, renderIndex, equipmentSlotIn);

		this.setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot equipmentSlotIn, String layer)
	{
		if (stack.getItem() == CommonProxy.greenGrenadierHelmet || stack.getItem() == CommonProxy.greenGrenadierChestplate || stack.getItem() == CommonProxy.greenGrenadierLeggings || stack.getItem() == CommonProxy.greenGrenadierBoots)
		{
			return "halocraft:textures/armor/GreenGrenadierArmor_1.png";
		}
		else
		{
			return "halocraft:textures/armor/OrangeGrenadierArmor_1.png";
		}
	}
}
