package halocraft.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CovenantArmor extends ItemArmor
{
	public CovenantArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if (stack.getItem().equals(halocraft.HaloCraft.CovenantHelmet) || stack.getItem().equals(halocraft.HaloCraft.CovenantChestplate) || stack.getItem().equals(halocraft.HaloCraft.CovenantBoots))
		{
			return "halocraft:textures/armor/CovenantArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.HaloCraft.CovenantLeggings))
		{
			return "halocraft:textures/armor/CovenantArmor_layer_2.png";
		}

		return null;
	}
}
