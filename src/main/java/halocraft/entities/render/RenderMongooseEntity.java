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
public class RenderMongooseEntity extends Render
{
	public WavefrontModel model = WavefrontAPI.instance().loadModel(halocraft.Main.class, "halocraft", "Mongoose", "/assets/halocraft/models/entity/Mongoose");

	public RenderMongooseEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}
	public void doRender(EntityMongoose mongooseIn, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		XLibRenderer.pushMatrix();
		XLibRenderer.translate(posX, posY + 0.52, posZ);
		
		if(mongooseIn.riddenByEntity != null && mongooseIn.riddenByEntity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) mongooseIn.riddenByEntity;
			GlStateManager.rotate(-(player.rotationYawHead), 0, 1, 0);
		}
		
		for(Part p : model.nameToPartHash.values())
		{
			p.draw();
		}
		
		XLibRenderer.popMatrix();
		super.doRender(mongooseIn, posX, posY, posZ, yaw, partialTicks);
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
		this.doRender((EntityMongoose)entity, x, y, z, yaw, partialTicks);
	}
}