package io.github.hsyyid.halocraft.entities.vehicles.render;

import io.github.hsyyid.halocraft.entities.render.RenderingUtil;
import io.github.hsyyid.halocraft.entities.vehicles.EntityScorpion;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderScorpionEntity extends Render<EntityScorpion>
{
	private final IBakedModel model = RenderingUtil.loadModel("halocraft:entity/Scorpion.obj");

	public RenderScorpionEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityScorpion entityWarthog)
	{
		return null;
	}

	@Override
	public void doRender(EntityScorpion entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(posX - 2.5, posY, posZ + 3);

			if (entity.isBeingRidden() && entity.getControllingPassenger() instanceof EntityPlayer)
			{
				EntityPlayer entityPlayer = (EntityPlayer) entity.getControllingPassenger();
				GlStateManager.rotate(-(entityPlayer.rotationYawHead + 180), 0, 1, 0);
			}

			GlStateManager.pushMatrix();
			{
				RenderingUtil.renderModel(model, -1);
			}
			GlStateManager.popMatrix();
		}
		GlStateManager.popMatrix();
	}
}
