package halocraft.entities.render;

import com.arisux.xlib.api.wavefrontapi.Part;
import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import com.arisux.xlib.api.wavefrontapi.WavefrontModel;
import com.arisux.xlib.client.render.XLibRenderer;
import halocraft.entities.EntityWarthog;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGhostEntity extends Render
{
	public WavefrontModel model = WavefrontAPI.instance().loadModel(halocraft.HaloCraft.class, "halocraft", "Ghost", "/assets/halocraft/models/entity/Ghost");

	public RenderGhostEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	protected ResourceLocation getEntityTexture(EntityWarthog entityWarthog)
	{
		return null;
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}

	public void doRender(Entity entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		XLibRenderer.pushMatrix();
		{
			XLibRenderer.translate(posX + 1.75f, posY, posZ + 0.25f);

			XLibRenderer.pushMatrix();
			{
				XLibRenderer.translate(-1.8, 0, -0.25);
				// GlStateManager.rotate((entity.worldObj.getWorldTime() % 360 * 8), 0, 1, 0);
				GlStateManager.rotate(-(entity.rotationYaw - 180), 0, 1, 0);
				XLibRenderer.translate(1.8, 0, 0.25);

				for (Part p : model.nameToPartHash.values())
				{
					XLibRenderer.pushMatrix();
					{
						p.draw();
					}
					XLibRenderer.popMatrix();
				}
			}
			XLibRenderer.popMatrix();
		}
		XLibRenderer.popMatrix();
	}
}
