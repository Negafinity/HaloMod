package io.github.hsyyid.halocraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityOrangePlasma extends EntityBullet
{
	public EntityOrangePlasma(World par1World)
	{
		super(par1World);
	}

	public EntityOrangePlasma(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
	}

	public EntityOrangePlasma(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}
}
