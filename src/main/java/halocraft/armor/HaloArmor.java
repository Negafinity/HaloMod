package halocraft.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class HaloArmor extends ItemArmor
{
	public HaloArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if (stack.getItem().equals(halocraft.HaloCraft.spartanHelmet) || stack.getItem().equals(halocraft.HaloCraft.jetpack) || stack.getItem().equals(halocraft.HaloCraft.spartanChestplate) || stack.getItem().equals(halocraft.HaloCraft.spartanBoots))
		{
			return "halocraft:textures/armor/HaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.HaloCraft.spartanLeggings))
		{
			return "halocraft:textures/armor/HaloArmor_layer_2.png";
		}
		if (stack.getItem().equals(halocraft.HaloCraft.redSpartanHelmet) || stack.getItem().equals(halocraft.HaloCraft.redSpartanChestplate) || stack.getItem().equals(halocraft.HaloCraft.redSpartanBoots))
		{
			return "halocraft:textures/armor/RedHaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.HaloCraft.redSpartanLeggings))
		{
			return "halocraft:textures/armor/RedHaloArmor_layer_2.png";
		}
		if (stack.getItem().equals(halocraft.HaloCraft.greenSpartanHelmet) || stack.getItem().equals(halocraft.HaloCraft.greenSpartanChestplate) || stack.getItem().equals(halocraft.HaloCraft.greenSpartanBoots))
		{
			return "halocraft:textures/armor/GreenHaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.HaloCraft.greenSpartanLeggings))
		{
			return "halocraft:textures/armor/GreenHaloArmor_layer_2.png";
		}
		if (stack.getItem().equals(halocraft.HaloCraft.blueSpartanHelmet) || stack.getItem().equals(halocraft.HaloCraft.blueSpartanChestplate) || stack.getItem().equals(halocraft.HaloCraft.blueSpartanBoots))
		{
			return "halocraft:textures/armor/BlueHaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.HaloCraft.blueSpartanLeggings))
		{
			return "halocraft:textures/armor/BlueHaloArmor_layer_2.png";
		}

		return null;
	}
}
