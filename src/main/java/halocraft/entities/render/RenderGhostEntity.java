package halocraft.entities.render;

import halocraft.entities.EntityMongoose;
import halocraft.entities.EntityWarthog;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.arisux.xlib.api.wavefrontapi.Part;
import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import com.arisux.xlib.api.wavefrontapi.WavefrontModel;
import com.arisux.xlib.client.render.XLibRenderer;

@SideOnly(Side.CLIENT)
public class RenderGhostEntity extends Render
{
	public WavefrontModel model = WavefrontAPI.instance().loadModel(halocraft.Main.class, "halocraft", "Ghost", "/assets/halocraft/models/entity/Ghost");

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
			XLibRenderer.translate(posX, posY, posZ);
			
			GlStateManager.rotate(-(entity.rotationYaw - 180), 0, 1, 0);

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
}