package halocraft.armor;

import halocraft.HaloCraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class GrenadierArmor extends ItemArmor
{
	public GrenadierArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		this.setCreativeTab(HaloCraft.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		Item item = stack.getItem();

		if (item == HaloCraft.greenGrenadierHelmet || item == HaloCraft.greenGrenadierChestplate
			|| item == HaloCraft.greenGrenadierLeggings || item == HaloCraft.greenGrenadierBoots)
		{
			return "halocraft:textures/armor/GreenGrenadierArmor_1.png";
		}
		else if(item == HaloCraft.orangeGrenadierHelmet || item == HaloCraft.orangeGrenadierChestplate
			|| item == HaloCraft.orangeGrenadierLeggings || item == HaloCraft.orangeGrenadierBoots)
		{
			return "halocraft:textures/armor/OrangeGrenadierArmor_1.png";
		}
		else
		{
			return null;
		}
	}
}
