package io.github.hsyyid.halocraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable
{
	public int damage = 6;

	public EntityBullet(World par1World)
	{
		super(par1World);
	}

	public EntityBullet(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
	}

	public EntityBullet(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

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
