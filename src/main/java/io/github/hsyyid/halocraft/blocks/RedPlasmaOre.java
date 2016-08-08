package io.github.hsyyid.halocraft.blocks;

import io.github.hsyyid.halocraft.items.RedPlasmaIngot;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class RedPlasmaOre extends Block
{
	public RedPlasmaOre(Material material)
	{
		super(material);

		this.setHardness(4.0F);
		this.setSoundType(SoundType.STONE);
		this.setUnlocalizedName("RedPlasmaOre");
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.setHarvestLevel("pickaxe", 3);
	}

	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return RedPlasmaIngot.instance;
	}
}
