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

public class HaloArmor extends ItemArmor
{
	public static final ResourceLocation texture = new ResourceLocation("halocraft" + ":textures/gui/HealthBar.png");
	
	public HaloArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		setCreativeTab(halocraft.Main.haloCreativeTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if (stack.getItem().equals(halocraft.Main.SpartanHelmet) || stack.getItem().equals(halocraft.Main.Jetpack) || stack.getItem().equals(halocraft.Main.SpartanChestplate) || stack.getItem().equals(halocraft.Main.SpartanBoots))
		{
			return "halocraft:textures/armor/HaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.Main.SpartanLeggings))
		{
			return "halocraft:textures/armor/HaloArmor_layer_2.png";
		}
		if (stack.getItem().equals(halocraft.Main.RedSpartanHelmet) || stack.getItem().equals(halocraft.Main.RedSpartanChestplate) || stack.getItem().equals(halocraft.Main.RedSpartanBoots))
		{
			return "halocraft:textures/armor/RedHaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.Main.RedSpartanLeggings))
		{
			return "halocraft:textures/armor/RedHaloArmor_layer_2.png";
		}
		if (stack.getItem().equals(halocraft.Main.GreenSpartanHelmet) || stack.getItem().equals(halocraft.Main.GreenSpartanChestplate) || stack.getItem().equals(halocraft.Main.GreenSpartanBoots))
		{
			return "halocraft:textures/armor/GreenHaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.Main.GreenSpartanLeggings))
		{
			return "halocraft:textures/armor/GreenHaloArmor_layer_2.png";
		}
		if (stack.getItem().equals(halocraft.Main.BlueSpartanHelmet) || stack.getItem().equals(halocraft.Main.BlueSpartanChestplate) || stack.getItem().equals(halocraft.Main.BlueSpartanBoots))
		{
			return "halocraft:textures/armor/BlueHaloArmor_layer_1.png";
		}

		if (stack.getItem().equals(halocraft.Main.BlueSpartanLeggings))
		{
			return "halocraft:textures/armor/BlueHaloArmor_layer_2.png";
		}
		else
			return null;
	}
}
