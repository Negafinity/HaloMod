package io.github.hsyyid.halocraft.blocks;

import io.github.hsyyid.halocraft.items.PurplePlasmaIngot;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class PurplePlasmaOre extends Block
{
	public PurplePlasmaOre(Material material)
	{
		super(material);

		this.setHardness(4.0F);
		this.setSoundType(SoundType.STONE);
		this.setUnlocalizedName("PurplePlasmaOre");
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.setHarvestLevel("pickaxe", 3);
	}

	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return PurplePlasmaIngot.instance;
	}
}
