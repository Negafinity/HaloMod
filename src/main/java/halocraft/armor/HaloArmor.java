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
		if (stack.getItem().equals(halocraft.HaloCraft.SpartanHelmet) || stack.getItem().equals(halocraft.HaloCraft.Jetpack) || stack.getItem().equals(halocraft.HaloCraft.SpartanChestplate) || stack.getItem().equals(halocraft.HaloCraft.SpartanBoots))
		{
			return "halocraft:textures/armor/HaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.HaloCraft.SpartanLeggings))
		{
			return "halocraft:textures/armor/HaloArmor_layer_2.png";
		}
		if (stack.getItem().equals(halocraft.HaloCraft.RedSpartanHelmet) || stack.getItem().equals(halocraft.HaloCraft.RedSpartanChestplate) || stack.getItem().equals(halocraft.HaloCraft.RedSpartanBoots))
		{
			return "halocraft:textures/armor/RedHaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.HaloCraft.RedSpartanLeggings))
		{
			return "halocraft:textures/armor/RedHaloArmor_layer_2.png";
		}
		if (stack.getItem().equals(halocraft.HaloCraft.GreenSpartanHelmet) || stack.getItem().equals(halocraft.HaloCraft.GreenSpartanChestplate) || stack.getItem().equals(halocraft.HaloCraft.GreenSpartanBoots))
		{
			return "halocraft:textures/armor/GreenHaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.HaloCraft.GreenSpartanLeggings))
		{
			return "halocraft:textures/armor/GreenHaloArmor_layer_2.png";
		}
		if (stack.getItem().equals(halocraft.HaloCraft.BlueSpartanHelmet) || stack.getItem().equals(halocraft.HaloCraft.BlueSpartanChestplate) || stack.getItem().equals(halocraft.HaloCraft.BlueSpartanBoots))
		{
			return "halocraft:textures/armor/BlueHaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.HaloCraft.BlueSpartanLeggings))
		{
			return "halocraft:textures/armor/BlueHaloArmor_layer_2.png";
		}

		return null;
	}
}
