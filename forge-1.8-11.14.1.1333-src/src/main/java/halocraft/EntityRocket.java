package halocraft;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityRocket extends EntityThrowable{
    public EntityRocket(World par1World)
    {
        super(par1World);
    }
    public EntityRocket(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityRocket(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    float explosionRadius = 3.0F;
    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);
        this.setDead();
    }
}