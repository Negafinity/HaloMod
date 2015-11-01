package halocraft.entities.render;

import halocraft.entities.EntityPurplePlasma;
import halocraft.items.firearms.ItemNeedler;
import halocraft.models.ModelBullet;

import org.lwjgl.opengl.GL11;

import com.arisux.xlib.api.wavefrontapi.Part;
import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import com.arisux.xlib.api.wavefrontapi.WavefrontModel;
import com.arisux.xlib.client.render.XLibRenderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPurplePlasmaEntity extends Render		
{
	public WavefrontModel needleModel = WavefrontAPI.instance().loadModel(halocraft.HaloCraft.class, "halocraft", "Needle", "/assets/halocraft/models/entity/Needle");
	private static final ResourceLocation plasmaTextures = new ResourceLocation("halocraft:textures/entities/PurplePlasmaRender.png");
	public RenderPurplePlasmaEntity(RenderManager rendermanager)
	{
		super(rendermanager);
		shadowSize = 0.5F;
	}
	protected ResourceLocation getEntityTexture(Entity entity){
		return plasmaTextures;
	}
	public void render(EntityPurplePlasma plasma, double posX, double posY, double posZ, float f, float f1)
	{
		//		if(plasma.damage == 6)
		//		{
		//			XLibRenderer.pushMatrix();
		//			{
		//				XLibRenderer.translate(posX, posY, posZ);
		//				for(Part p: needleModel.nameToPartHash.values())
		//				{
		//					p.draw();
		//				}
		//			}
		//			XLibRenderer.popMatrix();
		//		}
		//		else
		//		{
		bindEntityTexture(plasma);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) posX, (float) posY, (float) posZ);
		GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90F -plasma.prevRotationPitch - (plasma.rotationPitch - plasma.prevRotationPitch) * f1, 1.0F, 0.0F, 0.0F);
		ModelBase model = new ModelBullet();
		if(model != null)
			model.render(plasma, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		//		}
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		render((EntityPurplePlasma) entity, d, d1, d2, f, f1);
	}

}
