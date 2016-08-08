package io.github.hsyyid.halocraft.blocks;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.Random;

public class ForerunnerWallBlock extends Block
{
	public static final ForerunnerWallBlock instance = new ForerunnerWallBlock(Material.IRON);
	public static final String name = "ForerunnerWallBlock";

	public ForerunnerWallBlock(Material material)
	{
		super(material);

		this.setHardness(4.0F);
		this.setSoundType(SoundType.STONE);
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
		this.setCreativeTab(CommonProxy.haloCreativeTab);
		this.setHarvestLevel("pickaxe", 3);
	}

	public Block getItemDropped(int metadata, Random random, int fortune)
	{
		return HaloBlock.instance;
	}
}
