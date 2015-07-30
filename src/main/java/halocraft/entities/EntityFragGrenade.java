package halocraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFragGrenade extends EntityThrowable
{

	public EntityFragGrenade(World worldIn)
	{
		super(worldIn);
	}

	public EntityFragGrenade(World worldIn, EntityLivingBase entityIn)
	{
		super(worldIn, entityIn);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjpos)
	{
		if (!this.worldObj.isRemote)
		{
			this.setDead();
			if (!this.worldObj.isRemote)
			{
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2.0F, true);
				this.setDead();
			}
		}

	}
}
