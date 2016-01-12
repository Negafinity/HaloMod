package halocraft.entities.render;

import com.arisux.xlib.api.wavefrontapi.Part;
import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import com.arisux.xlib.api.wavefrontapi.WavefrontModel;
import com.arisux.xlib.client.render.XLibRenderer;
import halocraft.entities.EntityPlasmaRocket;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlasmaRocketEntity extends Render<EntityPlasmaRocket>
{
	public WavefrontModel model = WavefrontAPI.instance().loadModel(halocraft.HaloCraft.class, "halocraft", "Rod-Plasma", "/assets/halocraft/models/entity/Rod-Plasma");

	public RenderPlasmaRocketEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	public void doRender(EntityPlasmaRocket plasmaRocket, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		XLibRenderer.pushMatrix();
		{
			XLibRenderer.translate(posX, posY, posZ);
			for (Part p : model.nameToPartHash.values())
			{
				p.draw();
			}
		}
		XLibRenderer.popMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPlasmaRocket plasmaRocket)
	{
		return null;
	}
}
