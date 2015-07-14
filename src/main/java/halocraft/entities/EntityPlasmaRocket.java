package halocraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPlasmaRocket extends EntityThrowable{
    public EntityPlasmaRocket(World par1World)
    {
        super(par1World);
    }
    public EntityPlasmaRocket(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityPlasmaRocket(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    float explosionRadius = 3.0F;
    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);
        this.setDead();
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
		if(this.motionX < 0.001 && this.motionY < 0.001 && this.motionZ < 0.001)
		{
			this.setDead();
		}
    }
}