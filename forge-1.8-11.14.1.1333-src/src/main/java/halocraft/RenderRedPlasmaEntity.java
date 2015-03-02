package halocraft;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderRedPlasmaEntity extends Render {
	private static final ResourceLocation plasmaTextures = new ResourceLocation("halocraft:textures/entities/RedPlasmaRender.png");
	public RenderRedPlasmaEntity(RenderManager rendermanager) {
		super(rendermanager);
		shadowSize = 0.5F;
		// TODO Auto-generated constructor stub
	}
	protected ResourceLocation getEntityTexture(Entity entity){
		return plasmaTextures;
	}
	public void render(EntityRedPlasma plasma, double d, double d1, double d2, float f, float f1)
	{
		if(plasma.ticksExisted < 1)
			return;
		bindEntityTexture(plasma);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90F -plasma.prevRotationPitch - (plasma.rotationPitch - plasma.prevRotationPitch) * f1, 1.0F, 0.0F, 0.0F);
		ModelBase model = new ModelRocket();
		if(model != null)
			model.render(plasma, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		render((EntityRedPlasma) entity, d, d1, d2, f, f1);
	}
	
}
