package halocraft;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMongooseEntity extends Render
{
	protected RenderMongooseEntity(RenderManager renderManager, ModelBase par1Model) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}

	public ModelBase model;

	public void doRenderCar(EntityMongoose car, double x, double y, double z, float rotationYaw, float par1)
	{
		if (!car.isDead)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x, (float)y + 1.1F, (float)z);
			GL11.glRotatef(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
			float timeSinceHit = (float)car.getTimeSinceHit() - par1;
			float damageTaken = car.getDamageTaken() - par1;

			if (damageTaken < 0.0F)
			{
				damageTaken = 0.0F;
			}

			if (timeSinceHit > 0.0F)
			{
				GL11.glRotatef(MathHelper.sin(timeSinceHit) * timeSinceHit * damageTaken / 10.0F * (float)car.getForwardDirection(), 0.0F, 0.0F, 1.0F);
			}

			float f4 = 0.75F;
			GL11.glScalef(f4, f4, f4);
			GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
			this.bindEntityTexture(car);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);
			this.model.render(car, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float par1) 
	{
		doRenderCar((EntityMongoose) entity, x, y, z, rotationYaw, par1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return getCarTexture((EntityMongoose) entity);
	}

	public ResourceLocation getCarTexture(EntityMongoose car)
	{
		switch (car.carColour) 
		{
		case 0:
			return new ResourceLocation("halocraft", "textures/entities/White Car.png");

		case 1:
			return new ResourceLocation("halocraft", "textures/entities/Red Car.png");

		case 2:
			return new ResourceLocation("halocraft", "textures/entities/Blue Car.png");

		case 3:
			return new ResourceLocation("halocraft", "textures/entities/Yellow Car.png");

		case 4:
			return new ResourceLocation("halocraft", "textures/entities/Green Car.png");

		case 5:
			return new ResourceLocation("halocraft", "textures/entities/Orange Car.png");

		case 10:
			return new ResourceLocation("javalcars", "textures/entities/Rainbow Car.png");

		default:
			return new ResourceLocation("javalcars", "textures/entities/White Car.png");
		}
	}
}