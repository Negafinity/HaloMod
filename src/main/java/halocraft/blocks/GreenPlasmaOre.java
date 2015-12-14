package halocraft.blocks;

import halocraft.items.GreenPlasmaIngot;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class GreenPlasmaOre extends Block
{
	public GreenPlasmaOre(Material material)
	{
		super(material);
		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundTypePiston);
		setUnlocalizedName("GreenPlasmaOre");
		setCreativeTab(CreativeTabs.tabMaterials);
		setHarvestLevel("pickaxe", 3);
	}

	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return GreenPlasmaIngot.instance;
	}
}
