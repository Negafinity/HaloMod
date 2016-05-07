package io.github.hsyyid.halocraft.entities.vehicles.render;

import io.github.hsyyid.halocraft.entities.vehicles.EntityMongoose;
import io.github.hsyyid.halocraft.util.RenderingUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMongooseEntity extends Render<EntityMongoose>
{
	private final IBakedModel model = RenderingUtil.loadModel("halocraft:entity/Mongoose.obj");

	public RenderMongooseEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMongoose entityWarthog)
	{
		return null;
	}

	@Override
	public void doRender(EntityMongoose entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(posX, posY, posZ);

			if (entity.isBeingRidden() && entity.getControllingPassenger() instanceof EntityPlayer)
			{
				EntityPlayer entityPlayer = (EntityPlayer) entity.getControllingPassenger();
				GlStateManager.rotate(-(entityPlayer.rotationYawHead + 90), 0, 1, 0);
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
