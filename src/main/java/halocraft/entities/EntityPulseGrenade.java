package halocraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
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
	protected void onImpact(MovingObjectPosition movingobjpos)
	{
		if (!this.worldObj.isRemote && movingobjpos != null)
		{
			this.setDead();
			if (movingobjpos.entityHit != null)
			{
				movingobjpos.entityHit.setFire(10);
			}
			BlockPos hit = movingobjpos.getBlockPos();
			if (hit != null)
			{
				BlockPos fire = new BlockPos(hit.getX(), hit.getY() + 1, hit.getZ());
				BlockPos fire2 = new BlockPos(hit.getX() + 1, hit.getY() + 1, hit.getZ());
				BlockPos fire3 = new BlockPos(hit.getX(), hit.getY() + 1, hit.getZ() + 1);

				this.worldObj.setBlockToAir(fire);
				this.worldObj.setBlockState(fire, Blocks.fire.getDefaultState());
				this.worldObj.setBlockState(fire2, Blocks.fire.getDefaultState());
				this.worldObj.setBlockState(fire3, Blocks.fire.getDefaultState());
				this.setDead();
			}
		}

	}
}
