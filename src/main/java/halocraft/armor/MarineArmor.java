package halocraft.armor;

import halocraft.Main;

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

public class MarineArmor extends ItemArmor
{
	public MarineArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		setCreativeTab(halocraft.Main.haloCreativeTab);
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if(stack.getDisplayName().toLowerCase().contains("blue"))
		{
			return "halocraft:textures/armor/BlueMarineArmor" + "_1.png";
		}
		else if(stack.getDisplayName().toLowerCase().contains("red"))
		{
			return "halocraft:textures/armor/RedMarineArmor" + "_1.png";
		}
		else
		{
			return "halocraft:textures/armor/MarineArmor" + "_1.png";
		}
	}
}
