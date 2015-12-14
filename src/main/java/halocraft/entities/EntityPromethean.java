package halocraft.entities;

import halocraft.items.PrometheanSword;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPromethean extends EntityMob
{
	public EntityPromethean(World worldIn)
	{
		super(worldIn);
		this.setSize(0.9F, 1.5F);
		this.setCurrentItemOrArmor(0, new ItemStack(PrometheanSword.instance));
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.6F));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false));
		this.tasks.addTask(3, new EntityAIWander(this, 0.5F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
		this.tasks.addTask(6, new EntityAIMoveTowardsRestriction(this, 1.0D));
	}

	@Override
	public ItemStack getHeldItem()
	{
		return new ItemStack(PrometheanSword.instance, 1);
	}

	@Override
	public void onDeath(DamageSource cause)
	{
		super.onDeath(cause);
		if(!(this.worldObj.isRemote))
		{
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1.0f, true);
		}
	}

	protected boolean isAIEnabled()
	{
		return true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	}
}
