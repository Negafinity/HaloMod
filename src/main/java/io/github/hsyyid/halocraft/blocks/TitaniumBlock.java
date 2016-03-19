package io.github.hsyyid.halocraft.blocks;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.Random;

public class TitaniumBlock extends Block
{
	public static final TitaniumBlock instance = new TitaniumBlock(Material.iron);
	public static final String name = "TitaniumBlock";

	public TitaniumBlock(Material material)
	{
		super(material);

		this.setHardness(4.0F);
		this.setStepSound(SoundType.STONE);
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
		this.setCreativeTab(CommonProxy.haloCreativeTab);
		this.setHarvestLevel("pickaxe", 3);
	}

	public Block getItemDropped(int metadata, Random random, int fortune)
	{
		return TitaniumBlock.instance;
	}
}
