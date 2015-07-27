package halocraft.entities.render;

import halocraft.entities.EntityMongoose;
import halocraft.entities.EntityWarthog;
import net.minecraft.client.Minecraft;
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
public class RenderScorpionEntity extends Render
{
	public WavefrontModel model = WavefrontAPI.instance().loadModel(halocraft.Main.class, "halocraft", "Scorpion", "/assets/halocraft/models/entity/Scorpion");

	public RenderScorpionEntity(RenderManager renderManager)
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
			XLibRenderer.translate(posX + 2.5, posY, posZ - 2.75);

			for (Part p : model.nameToPartHash.values())
			{
				XLibRenderer.pushMatrix();
				{
					if (p == model.getPart("the_node.025_tri_714_geometry") && entity.riddenByEntity != null && entity.riddenByEntity instanceof EntityPlayer)
					{
						EntityPlayer rider = (EntityPlayer) entity.riddenByEntity;
						XLibRenderer.translate(-2.75, 0, 6.15);
						GlStateManager.rotate(-rider.rotationYawHead + 180, 0, 1, 0);
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