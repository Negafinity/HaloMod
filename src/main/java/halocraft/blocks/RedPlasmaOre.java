package halocraft.blocks;

import halocraft.items.RedPlasmaIngot;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class RedPlasmaOre extends Block
{
	public RedPlasmaOre(Material material)
	{
		super(material);
		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundTypePiston);
		setUnlocalizedName("RedPlasmaOre");
		setCreativeTab(CreativeTabs.tabMaterials);
		setHarvestLevel("pickaxe", 3);
	}

	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return RedPlasmaIngot.instance;
	}
}
