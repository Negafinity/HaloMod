package halocraft.blocks;

import halocraft.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.Random;

public class SteelBlock extends Block
{
	public static final SteelBlock instance = new SteelBlock(Material.iron);
	public static final String name = "SteelBlock";

	public SteelBlock(Material material)
	{
		super(material);
		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundTypePiston); // sounds got renamed, look in Block class for what blocks have what sounds
		setUnlocalizedName("halocraft:" + name.toLowerCase()); // changed in 1.7
		setCreativeTab(CommonProxy.haloCreativeTab);
		setHarvestLevel("pickaxe", 3);
	}

	public Block getItemDropped(int metadata, Random random, int fortune)
	{
		return SteelBlock.instance;
	}
}
