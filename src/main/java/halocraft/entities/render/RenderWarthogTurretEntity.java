package halocraft.entities.render;

import halocraft.entities.EntityWarthog;
import halocraft.entities.EntityWarthogTurret;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.arisux.xlib.api.wavefrontapi.Part;
import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import com.arisux.xlib.api.wavefrontapi.WavefrontModel;
import com.arisux.xlib.client.render.XLibRenderer;

@SideOnly(Side.CLIENT)
public class RenderWarthogTurretEntity extends Render
{
	WavefrontModel warthogTurretModel = WavefrontAPI.instance().loadModel(halocraft.HaloCraft.class, "halocraft", "WarthogTurret", "/assets/halocraft/models/entity/WarthogTurret");
	public RenderWarthogTurretEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}
	public void doRender(EntityWarthogTurret warthogIn, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		double curVelocity = Math.sqrt(warthogIn.motionX * warthogIn.motionX + warthogIn.motionZ * warthogIn.motionZ);
		float tireRotation = curVelocity > 0.1 ? (warthogIn.worldObj.getWorldTime() % 360 * 8) - partialTicks : 0;
		float time = (float)warthogIn.getTimeSinceHit() - partialTicks;
		float damage = warthogIn.getDamageTaken() - partialTicks;
		damage = damage < 0.0F ? 0.0F : damage;

		XLibRenderer.pushMatrix();
		{
			GlStateManager.enableCull();
			XLibRenderer.translate(posX + 0.5, posY + 0.83, posZ);
			if (time > 0.0F)
			{
				GlStateManager.rotate(MathHelper.sin(time) * time * damage / 10.0F * (float)warthogIn.getForwardDirection(), 1.0F, 0.0F, 0.0F);
			}
			
			if(warthogIn.riddenByEntity != null && warthogIn.riddenByEntity instanceof EntityPlayer)
			{
				EntityPlayer rider = (EntityPlayer) warthogIn.riddenByEntity; 
				GlStateManager.rotate(-warthogIn.rotationYaw - 90, 0, 1, 0);
			}

			for (Part part : warthogTurretModel.nameToPartHash.values())
			{
				XLibRenderer.pushMatrix();
				{
					if (part == warthogTurretModel.getPart("the_node.000_tri_5178_geometry") || part == warthogTurretModel.getPart("the_node.001_tri_5178_geometry"))
					{
						XLibRenderer.translate(0, -0.345, -1.27);
						GlStateManager.rotate(tireRotation, 1, 0, 0);
						XLibRenderer.translate(0, 0.345, 1.27);
						part.draw();
					}
					else if(part == warthogTurretModel.getPart("the_node.002_tri_5178_geometry") || part == warthogTurretModel.getPart("the_node.010_tri_5178_geometry"))
					{
						XLibRenderer.translate(0, -0.33, 1.6);
						GlStateManager.rotate(tireRotation, 1, 0, 0);
						XLibRenderer.translate(0, 0.33, -1.6);
						part.draw();
					}
					else if(part == warthogTurretModel.getPart("the_node.169_tri_4674_geometry") && warthogIn.thirdRider != null)
					{
						GlStateManager.rotate(warthogIn.thirdRider.rotationYawHead, 1, 0, 0);
						part.draw();
					}
					else
					{
						part.draw();
					}
				}
				XLibRenderer.popMatrix();
			}
		}
		XLibRenderer.popMatrix();
	}


	protected ResourceLocation getEntityTexture(EntityWarthog entityWarthog)
	{
		return null;
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}

	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks)
	{
		this.doRender((EntityWarthogTurret)entity, x, y, z, yaw, partialTicks);
	}
}