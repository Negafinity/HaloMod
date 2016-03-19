package io.github.hsyyid.halocraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class ForerunnerOre extends Block
{
	public ForerunnerOre(Material material)
	{
		super(material);
		
		this.setHardness(4.0F);
		this.setStepSound(SoundType.STONE);
		this.setUnlocalizedName("ForerunnerOre");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setHarvestLevel("pickaxe", 3);
	}

	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return null;
	}
}
