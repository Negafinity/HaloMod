package halocraft.armor;

import halocraft.HaloCraft;

import org.lwjgl.opengl.GL11;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class PrometheanArmor extends ItemArmor
{
	public PrometheanArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		return "halocraft:textures/armor/PrometheanArmor" + "_1.png";
	}
}
