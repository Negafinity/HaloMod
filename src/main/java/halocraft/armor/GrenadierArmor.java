package halocraft.armor;

import halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class GrenadierArmor extends ItemArmor
{
	public GrenadierArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		this.setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		Item item = stack.getItem();

		if (item == CommonProxy.greenGrenadierHelmet || item == CommonProxy.greenGrenadierChestplate
			|| item == CommonProxy.greenGrenadierLeggings || item == CommonProxy.greenGrenadierBoots)
		{
			return "halocraft:textures/armor/GreenGrenadierArmor_1.png";
		}
		else if(item == CommonProxy.orangeGrenadierHelmet || item == CommonProxy.orangeGrenadierChestplate
			|| item == CommonProxy.orangeGrenadierLeggings || item == CommonProxy.orangeGrenadierBoots)
		{
			return "halocraft:textures/armor/OrangeGrenadierArmor_1.png";
		}
		else
		{
			return null;
		}
	}
}
