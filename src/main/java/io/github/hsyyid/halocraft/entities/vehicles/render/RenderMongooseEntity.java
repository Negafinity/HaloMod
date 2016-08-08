package io.github.hsyyid.halocraft.entities.vehicles.render;

import com.arisux.airix.api.wavefrontapi.Part;

import io.github.hsyyid.halocraft.entities.vehicles.EntityMongoose;
import io.github.hsyyid.halocraft.util.Models;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMongooseEntity extends Render<EntityMongoose>
{
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
			double curVelocity = Math.sqrt(entity.motionX * entity.motionX + entity.motionZ * entity.motionZ);
			float tireRotation = curVelocity > 0.1 ? -(entity.worldObj.getWorldTime() % 360 * 8) - partialTicks : 0;

			if (entity.getControllingPassenger() != null && entity.getControllingPassenger() instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) entity.getControllingPassenger();
				GlStateManager.rotate(-(player.rotationYawHead + 90), 0, 1, 0);
			}

			for (Part p : Models.MONGOOSE.nameToPartHash.values())
			{
				GlStateManager.pushMatrix();
				{
					if (p == Models.MONGOOSE.getPart("the_node.014_tri_564_geometry") || p == Models.MONGOOSE.getPart("the_node.013_tri_540_geometry"))
					{
						GlStateManager.pushMatrix();
						{
							GlStateManager.translate(-1.4, 0.48, 0);
							GlStateManager.rotate(tireRotation, 0, 0, 1);
							GlStateManager.translate(1.4, -0.48, 0);
							p.draw();
						}
						GlStateManager.popMatrix();
					}
					else if (p == Models.MONGOOSE.getPart("the_node.015_tri_540_geometry.001") || p == Models.MONGOOSE.getPart("the_node.016_tri_540_geometry.002"))
					{
						GlStateManager.pushMatrix();
						{
							GlStateManager.translate(0.65, 0.45, 0);
							GlStateManager.rotate(tireRotation, 0, 0, 1);
							GlStateManager.translate(-0.65, -0.45, 0);
							p.draw();
						}
						GlStateManager.popMatrix();
					}
					else
					{
						p.draw();
					}
				}
				GlStateManager.popMatrix();
			}
		}
		GlStateManager.popMatrix();
	}
}
