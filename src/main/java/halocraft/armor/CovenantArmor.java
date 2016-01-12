package halocraft.armor;

import halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CovenantArmor extends ItemArmor
{
	public CovenantArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if (stack.getItem().equals(CommonProxy.covenantHelmet) || stack.getItem().equals(CommonProxy.covenantChestplate) || stack.getItem().equals(CommonProxy.covenantBoots))
		{
			return "halocraft:textures/armor/CovenantArmor_layer_1.png";
		}

		if (stack.getItem().equals(CommonProxy.covenantLeggings))
		{
			return "halocraft:textures/armor/CovenantArmor_layer_2.png";
		}

		return null;
	}
}
