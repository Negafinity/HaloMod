package halocraft.armor;

import halocraft.proxies.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ActiveCamoArmor extends ItemArmor
{
	public ActiveCamoArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		setCreativeTab(CommonProxy.haloCreativeTab);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor)
	{
		player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 500, 4));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if (stack.getItem().equals(CommonProxy.activeCamoChestplate))
		{
			return "halocraft:textures/armor/ActiveCamoArmor_layer_1.png";
		}

		return null;
	}
}
