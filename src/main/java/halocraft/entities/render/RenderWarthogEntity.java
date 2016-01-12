package halocraft.entities.render;

import com.arisux.xlib.api.wavefrontapi.Part;
import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import com.arisux.xlib.api.wavefrontapi.WavefrontModel;
import com.arisux.xlib.client.render.XLibRenderer;
import halocraft.entities.EntityWarthog;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWarthogEntity extends Render<EntityWarthog>
{
	public WavefrontModel model = WavefrontAPI.instance().loadModel(halocraft.HaloCraft.class, "halocraft", "Warthog", "/assets/halocraft/models/entity/Warthog");

	public RenderWarthogEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	public void doRender(EntityWarthog warthogIn, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		double curVelocity = Math.sqrt(warthogIn.motionX * warthogIn.motionX + warthogIn.motionZ * warthogIn.motionZ);
		float tireRotation = curVelocity > 0.1 ? (warthogIn.worldObj.getWorldTime() % 360 * 8) - partialTicks : 0;
		float time = (float) warthogIn.getTimeSinceHit() - partialTicks;
		float damage = warthogIn.getDamageTaken() - partialTicks;
		damage = damage < 0.0F ? 0.0F : damage;

		XLibRenderer.pushMatrix();
		{
			GlStateManager.enableCull();
			XLibRenderer.translate(posX + 0.5, posY + 0.83, posZ);
			
			if (time > 0.0F)
			{
				GlStateManager.rotate(MathHelper.sin(time) * time * damage / 10.0F * (float) warthogIn.getForwardDirection(), 1.0F, 0.0F, 0.0F);
			}

			GlStateManager.rotate(-warthogIn.rotationYaw - 90, 0, 1, 0);

			for (Part p : model.nameToPartHash.values())
			{
				XLibRenderer.pushMatrix();
				{
					if (p == model.getPart("the_node.000_tri_5178_geometry") || p == model.getPart("the_node.001_tri_5178_geometry"))
					{
						XLibRenderer.translate(0, -0.345, -1.27);
						GlStateManager.rotate(tireRotation, 1, 0, 0);
						XLibRenderer.translate(0, 0.345, 1.27);
						p.draw();
					}
					else if (p == model.getPart("the_node.002_tri_5178_geometry") || p == model.getPart("the_node.010_tri_5178_geometry"))
					{
						XLibRenderer.translate(0, -0.33, 1.6);
						GlStateManager.rotate(tireRotation, 1, 0, 0);
						XLibRenderer.translate(0, 0.33, -1.6);
						p.draw();
					}
					else
					{
						p.draw();
					}
				}
				XLibRenderer.popMatrix();
			}
		}
		XLibRenderer.popMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityWarthog entityWarthog)
	{
		return null;
	}
}
