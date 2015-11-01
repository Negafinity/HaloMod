package halocraft.entities;

import java.util.concurrent.TimeUnit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGreenPlasma extends EntityThrowable
{
	public int damage = 6;

	public EntityGreenPlasma(World par1World)
	{
		super(par1World);
	}

	public EntityGreenPlasma(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
	}

	public EntityGreenPlasma(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

	protected void onImpact(MovingObjectPosition movingobjectpos)
	{
		if (movingobjectpos.entityHit != null)
		{
			movingobjectpos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
			
			if (movingobjectpos.entityHit instanceof EntityScorpion)
			{
				BlockPos pos = movingobjectpos.entityHit.getPosition();
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				
				if (movingobjectpos.entityHit.riddenByEntity != null && !movingobjectpos.entityHit.riddenByEntity.isDead)
				{
					if (movingobjectpos.entityHit.riddenByEntity instanceof EntityPlayer)
					{
						Entity entity = movingobjectpos.entityHit.riddenByEntity;
						String modName = EnumChatFormatting.BLUE + "[HaloCraft 2.0]";
						if (this.getThrower() instanceof EntityPlayer)
						{
							EntityPlayer player = (EntityPlayer) this.getThrower();
							entity.addChatMessage(new ChatComponentText(modName + EnumChatFormatting.WHITE + " Your Scorpion has been disabled for 5 seconds by a Plasma Rifle shot by " + EnumChatFormatting.RED + player.getName() + EnumChatFormatting.WHITE + "!"));
						}
						else
						{
							entity.addChatMessage(new ChatComponentText(modName + EnumChatFormatting.WHITE + " Your Scorpion has been disabled for 5 seconds by a Plasma Rifle!"));
						}
					}
				}
				
				for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(5); stop > System.nanoTime();)
				{
					movingobjectpos.entityHit.setPosition(x, y, z);
				}
				
			}
			else if (movingobjectpos.entityHit instanceof EntityMongoose)
			{
				BlockPos pos = movingobjectpos.entityHit.getPosition();
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				
				if (movingobjectpos.entityHit.riddenByEntity != null && !movingobjectpos.entityHit.riddenByEntity.isDead)
				{
					if (movingobjectpos.entityHit.riddenByEntity instanceof EntityPlayer)
					{
						Entity entity = movingobjectpos.entityHit.riddenByEntity;
						String modName = EnumChatFormatting.BLUE + "[HaloCraft 2.0]";
						
						if (this.getThrower() instanceof EntityPlayer)
						{
							EntityPlayer player = (EntityPlayer) this.getThrower();
							entity.addChatMessage(new ChatComponentText(modName + EnumChatFormatting.WHITE + " Your Mongoose has been disabled for 5 seconds by a Plasma Rifle shot by " + EnumChatFormatting.RED + player.getName() + EnumChatFormatting.WHITE + "!"));
						}
						else
						{
							entity.addChatMessage(new ChatComponentText(modName + EnumChatFormatting.WHITE + " Your Mongoose has been disabled for 5 seconds by a Plasma Rifle!"));
						}
					}
				}
				for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(5); stop > System.nanoTime();)
				{
					movingobjectpos.entityHit.setPosition(x, y, z);
				}
			}
		}
		
		if (!this.worldObj.isRemote)
		{
			this.setDead();
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
