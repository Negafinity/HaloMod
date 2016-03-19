package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityPurplePlasma;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPurplePlasmaEntity extends Render<EntityPurplePlasma>
{
	private final IBakedModel model = RenderingUtil.loadModel("halocraft:entity/Needle.obj");
	private static final ResourceLocation plasmaTextures = new ResourceLocation("halocraft:textures/entities/PurplePlasmaRender.png");

	public RenderPurplePlasmaEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPurplePlasma entity)
	{
		return plasmaTextures;
	}

	@Override
	public void doRender(EntityPurplePlasma entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		{
			this.bindTexture(plasmaTextures);
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
