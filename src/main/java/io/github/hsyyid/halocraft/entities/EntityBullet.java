package io.github.hsyyid.halocraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable
{
	public int damage = 6;

	public EntityBullet(World worldIn)
	{
		super(worldIn);
	}

	public EntityBullet(World worldIn, EntityLivingBase livingBaseIn)
	{
		super(worldIn, livingBaseIn);
		
		this.setThrowableHeading(livingBaseIn.getLookVec().xCoord, livingBaseIn.getLookVec().yCoord, livingBaseIn.getLookVec().zCoord, 1.5f, 0.0f);
	}

	public EntityBullet(World worldIn, double x, double y, double z)
	{
		super(worldIn, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult rayTraceResult)
	{
		if (!this.worldObj.isRemote)
		{
			if (rayTraceResult.entityHit != null)
			{
				rayTraceResult.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
			}

			this.setDead();
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.motionX < 0.001 && this.motionY < 0.001 && this.motionZ < 0.001)
		{
			this.setDead();
		}
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0F;
	}

}
