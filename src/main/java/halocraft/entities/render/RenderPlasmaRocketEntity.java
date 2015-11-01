package halocraft.entities.render;

import halocraft.entities.EntityPlasmaRocket;
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
public class RenderPlasmaRocketEntity extends Render
{
	public WavefrontModel model = WavefrontAPI.instance().loadModel(halocraft.HaloCraft.class, "halocraft", "Rod-Plasma", "/assets/halocraft/models/entity/Rod-Plasma");

	public RenderPlasmaRocketEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}
	public void doRender(EntityPlasmaRocket plasmaRocket, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		XLibRenderer.pushMatrix();
		{
			XLibRenderer.translate(posX, posY, posZ);
			for(Part p: model.nameToPartHash.values())
			{
				p.draw();
			}
		}
		XLibRenderer.popMatrix();
	}


	protected ResourceLocation getEntityTexture(EntityPlasmaRocket plasmaRocket)
	{
		return null;
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}

	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks)
	{
		this.doRender((EntityPlasmaRocket)entity, x, y, z, yaw, partialTicks);
	}
}