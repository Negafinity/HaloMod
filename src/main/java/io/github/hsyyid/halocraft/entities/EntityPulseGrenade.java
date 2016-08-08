package io.github.hsyyid.halocraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityPulseGrenade extends EntityThrowable
{
	public EntityPulseGrenade(World worldIn)
	{
		super(worldIn);
	}

	public EntityPulseGrenade(World worldIn, EntityLivingBase entityIn)
	{
		super(worldIn, entityIn);
	}

	@Override
	protected void onImpact(RayTraceResult rayTraceResult)
	{
		if (!this.worldObj.isRemote && rayTraceResult != null)
		{
			this.setDead();

			if (rayTraceResult.entityHit != null)
			{
				rayTraceResult.entityHit.setFire(10);
			}

			BlockPos hit = rayTraceResult.getBlockPos();

			if (hit != null)
			{
				BlockPos fire = new BlockPos(hit.getX(), hit.getY() + 1, hit.getZ());
				BlockPos fire2 = new BlockPos(hit.getX() + 1, hit.getY() + 1, hit.getZ());
				BlockPos fire3 = new BlockPos(hit.getX(), hit.getY() + 1, hit.getZ() + 1);

				this.worldObj.setBlockToAir(fire);
				this.worldObj.setBlockState(fire, Blocks.FIRE.getDefaultState());
				this.worldObj.setBlockState(fire2, Blocks.FIRE.getDefaultState());
				this.worldObj.setBlockState(fire3, Blocks.FIRE.getDefaultState());
				this.setDead();
			}
		}
	}
}
