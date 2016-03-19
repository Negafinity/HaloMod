package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityRocket;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRocketEntity extends Render<EntityRocket>
{
	private final IBakedModel model = RenderingUtil.loadModel("halocraft:entity/Rocket.obj");
	private static final ResourceLocation rocketTextures = new ResourceLocation("halocraft:textures/entities/RocketRender.png");

	public RenderRocketEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityRocket entity)
	{
		return rocketTextures;
	}

	@Override
	public void doRender(EntityRocket entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		{
			this.bindTexture(rocketTextures);
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
