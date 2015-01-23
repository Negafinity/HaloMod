package halocraft;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class HaloGenerationClass implements IWorldGenerator{

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        int numPerChunk = 4;

        for (int curSpawn = 0; curSpawn < numPerChunk; curSpawn++)
        {
            if (random.nextInt(15) != 0)
            {
                continue;
            }

            int xOffset = random.nextInt(15);
            int zOffset = random.nextInt(15);

            BlockPos topBlock = world.getTopSolidOrLiquidBlock(new BlockPos(chunkX * 16 + xOffset, 0, chunkZ * 16 + zOffset));

            if (world.getBlockState(topBlock) == Blocks.air.getDefaultState() &&
                    world.getBlockState(topBlock.down()) == Blocks.grass.getDefaultState())
            {
                world.setBlockState(topBlock, Main.HaloOre.getDefaultState());
            }
        }

    }

}
