package halocraft;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class HaloGenerationClass implements IWorldGenerator{
		@Override
		public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
		{
		    switch(world.provider.getDimensionId())
		    {
		    case 0:
		    generateSurface(world, random, chunkX*16, chunkZ*16);
		    break;
		    }
		}

		public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
		{
		    for (int i = 0; i < 5; i++)
		    {
		        int randPosX = chunkX + rand.nextInt(16);
		        int randPosY = rand.nextInt(16);
		        int randPosZ = chunkZ + rand.nextInt(16);
		        BlockPos pos = new BlockPos(randPosX, randPosY, randPosZ);
		        (new WorldGenMinable(Main.HaloOre.getDefaultState(), 10)).generate(world, rand, pos);
		    }
		}
}
