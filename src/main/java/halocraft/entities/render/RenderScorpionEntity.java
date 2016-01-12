package halocraft.entities.render;

import com.arisux.xlib.api.wavefrontapi.Part;
import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import com.arisux.xlib.api.wavefrontapi.WavefrontModel;
import com.arisux.xlib.client.render.XLibRenderer;
import halocraft.entities.EntityScorpion;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderScorpionEntity extends Render<EntityScorpion>
{
	public WavefrontModel model = WavefrontAPI.instance().loadModel(halocraft.HaloCraft.class, "halocraft", "Scorpion", "/assets/halocraft/models/entity/Scorpion");

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
		XLibRenderer.pushMatrix();
		{
			XLibRenderer.translate(posX + 2.5, posY, posZ - 2.75);

			XLibRenderer.translate(-2.5, 0, 2);
			GlStateManager.rotate(-(entity.rotationYaw - 90), 0, 1, 0);
			XLibRenderer.translate(2.5, 0, -5);

			for (Part p : model.nameToPartHash.values())
			{
				XLibRenderer.pushMatrix();
				{
					if (p == model.getPart("the_node.025_tri_714_geometry") && entity.riddenByEntity != null && entity.riddenByEntity instanceof EntityPlayer)
					{
						EntityPlayer rider = (EntityPlayer) entity.riddenByEntity;
						XLibRenderer.translate(-2.75, 0, 6.15);
						GlStateManager.rotate(-90, 0F, 1F, 0F);
						GlStateManager.rotate(entity.rotationYaw - 108, 0, 1, 0);
						GlStateManager.rotate(-rider.rotationYawHead - 72, 0F, 1F, 0F);
						XLibRenderer.translate(2.75, 0, -6.15);
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
}
