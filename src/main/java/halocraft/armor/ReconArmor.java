package halocraft.armor;

import halocraft.HaloCraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ReconArmor extends ItemArmor
{
	public ReconArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		this.setCreativeTab(HaloCraft.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		Item item = stack.getItem();

		if (item == HaloCraft.reconHelmet || item == HaloCraft.reconChestplate
			|| item == HaloCraft.reconLeggings || item == HaloCraft.reconBoots)
		{
			return "halocraft:textures/armor/ReconArmor_1.png";
		}
		else if(item == HaloCraft.redReconHelmet || item == HaloCraft.redReconChestplate
			|| item == HaloCraft.redReconLeggings || item == HaloCraft.redReconBoots)
		{
			return "halocraft:textures/armor/RedReconArmor_1.png";
		}
		else if(item == HaloCraft.blueReconHelmet || item == HaloCraft.blueReconChestplate
			|| item == HaloCraft.blueReconLeggings || item == HaloCraft.blueReconBoots)
		{
			return "halocraft:textures/armor/BlueReconArmor_1.png";
		}
		else
		{
			return null;
		}
	}
}
