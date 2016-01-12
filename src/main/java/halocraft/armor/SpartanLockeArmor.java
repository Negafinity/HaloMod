package halocraft.armor;

import halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SpartanLockeArmor extends ItemArmor
{
	public SpartanLockeArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		return "halocraft:textures/armor/SpartanLockeArmor_1.png";
	}
}
