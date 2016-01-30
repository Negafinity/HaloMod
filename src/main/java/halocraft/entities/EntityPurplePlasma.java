package halocraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPurplePlasma extends EntityBullet
{
	public EntityGrunt shotByGrunt;
	public Entity shootingEntity;

	public EntityPurplePlasma(World par1World)
	{
		super(par1World);
	}

	public EntityPurplePlasma(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
	}

	public EntityPurplePlasma(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectpos)
	{
		if (!this.worldObj.isRemote)
		{
			if (movingobjectpos.entityHit != null)
			{
				if (this.shotByGrunt != null && this.shotByGrunt == movingobjectpos.entityHit)
					;
				else if (this.shootingEntity != null && this.shootingEntity == movingobjectpos.entityHit)
					;
				else
				{
					movingobjectpos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
				}

				this.setDead();
			}
		}
	}
}
