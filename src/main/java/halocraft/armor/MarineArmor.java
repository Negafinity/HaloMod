package halocraft.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MarineArmor extends ItemArmor
{
	public MarineArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if (stack.getDisplayName().toLowerCase().contains("blue"))
		{
			return "halocraft:textures/armor/BlueMarineArmor" + "_1.png";
		}
		else if (stack.getDisplayName().toLowerCase().contains("red"))
		{
			return "halocraft:textures/armor/RedMarineArmor" + "_1.png";
		}
		else
		{
			return "halocraft:textures/armor/MarineArmor" + "_1.png";
		}
	}
}
