package halocraft.armor;

import halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ReconArmor extends ItemArmor
{
	public ReconArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		this.setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		Item item = stack.getItem();

		if (item == CommonProxy.reconHelmet || item == CommonProxy.reconChestplate || item == CommonProxy.reconLeggings || item == CommonProxy.reconBoots)
		{
			return "halocraft:textures/armor/ReconArmor_1.png";
		}
		else if (item == CommonProxy.redReconHelmet || item == CommonProxy.redReconChestplate || item == CommonProxy.redReconLeggings || item == CommonProxy.redReconBoots)
		{
			return "halocraft:textures/armor/RedReconArmor_1.png";
		}
		else if (item == CommonProxy.blueReconHelmet || item == CommonProxy.blueReconChestplate || item == CommonProxy.blueReconLeggings || item == CommonProxy.blueReconBoots)
		{
			return "halocraft:textures/armor/BlueReconArmor_1.png";
		}
		else
		{
			return null;
		}
	}
}
