package halocraft;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

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
		    for (int i = 0; i < 8; i++)
		    {
		        int randPosX = chunkX + rand.nextInt(16);
		        int randPosY = rand.nextInt(16);
		        int randPosZ = chunkZ + rand.nextInt(16);
		        BlockPos pos = new BlockPos(randPosX, randPosY, randPosZ);
		        (new WorldGenMinable(HaloCraft.haloOre.getDefaultState(), 10)).generate(world, rand, pos);
		    }
		    
		    for (int k = 0; k < 5; k++)
		    {
		        int randX = chunkX + rand.nextInt(16);
		        int randY = rand.nextInt(10);
		        int randZ = chunkZ + rand.nextInt(16);
		        BlockPos pos = new BlockPos(randX, randY, randZ);
		        (new WorldGenMinable(HaloCraft.redPlasmaOre.getDefaultState(), 3)).generate(world, rand, pos);
		    }
		    
		    for (int t = 0; t < 15; t++)
		    {
		        int randXPos = chunkX + rand.nextInt(16);
		        int randYPos = rand.nextInt(45);
		        int randZPos = chunkZ + rand.nextInt(16);
		        BlockPos pos = new BlockPos(randXPos, randYPos, randZPos);
		        (new WorldGenMinable(HaloCraft.greenPlasmaOre.getDefaultState(), 8)).generate(world, rand, pos);
		    }
		    
		    for (int t = 0; t < 10; t++)
		    {
		        int randXP = chunkX + rand.nextInt(16);
		        int randYP = rand.nextInt(25);
		        int randZP = chunkZ + rand.nextInt(16);
		        BlockPos pos = new BlockPos(randXP, randYP, randZP);
		        (new WorldGenMinable(HaloCraft.purplePlasmaOre.getDefaultState(), 4)).generate(world, rand, pos);
		    }
		    
		    for (int t = 0; t < 10; t++)
		    {
		        int randXP = chunkX + rand.nextInt(16);
		        int randYP = rand.nextInt(20);
		        int randZP = chunkZ + rand.nextInt(16);
		        BlockPos pos = new BlockPos(randXP, randYP, randZP);
		        (new WorldGenMinable(HaloCraft.forerunnerOre.getDefaultState(), 5)).generate(world, rand, pos);
		    }
		}
}
