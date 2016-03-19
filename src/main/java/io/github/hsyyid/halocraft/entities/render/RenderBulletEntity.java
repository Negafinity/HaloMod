package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityBullet;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBulletEntity extends Render<EntityBullet>
{
	private final IBakedModel model = RenderingUtil.loadModel("halocraft:entity/Bullet.obj");
	private static final ResourceLocation bulletTextures = new ResourceLocation("halocraft:textures/entities/BulletRender.png");

	public RenderBulletEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBullet entity)
	{
		return bulletTextures;
	}

	@Override
	public void doRender(EntityBullet entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		{
			this.bindTexture(bulletTextures);
			GlStateManager.translate(posX, posY, posZ);

			GlStateManager.pushMatrix();
			{
				RenderingUtil.renderModel(model, -1);
			}
			GlStateManager.popMatrix();
		}
		GlStateManager.popMatrix();
	}
}
