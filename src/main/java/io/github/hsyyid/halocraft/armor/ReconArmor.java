package io.github.hsyyid.halocraft.armor;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ReconArmor extends ItemArmor
{
	public ReconArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn)
	{
		super(material, renderIndex, equipmentSlotIn);

		this.setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot equipmentSlotIn, String layer)
	{
		if (stack.getDisplayName().toLowerCase().contains("blue"))
		{
			return "halocraft:textures/armor/BlueReconArmor_1.png";
		}
		else if (stack.getDisplayName().toLowerCase().contains("red"))
		{
			return "halocraft:textures/armor/RedReconArmor_1.png";
		}
		else
		{
			return "halocraft:textures/armor/ReconArmor_1.png";
		}
	}
}
