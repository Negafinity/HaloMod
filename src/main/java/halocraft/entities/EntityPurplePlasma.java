package halocraft.entities;

import halocraft.items.firearms.ItemNeedler;

import java.util.concurrent.TimeUnit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPurplePlasma extends EntityThrowable
{
	public int damage = 6;
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

	protected void onImpact(MovingObjectPosition movingobjectpos)
	{
		if (movingobjectpos.entityHit != null)
		{
			if (this.shotByGrunt != null && this.shotByGrunt == movingobjectpos.entityHit);
			else if (this.shootingEntity != null && this.shootingEntity == movingobjectpos.entityHit);
			else
			{
				if (!(this.worldObj.isRemote))
				{
					movingobjectpos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
					this.setDead();
				}
			}
		}
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0F;
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
}
