package halocraft.entities.render;

import halocraft.entities.EntityGreenPlasma;
import halocraft.models.ModelBullet;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGreenPlasmaEntity extends Render<EntityGreenPlasma>
{
	private static final ResourceLocation plasmaTextures = new ResourceLocation("halocraft:textures/entities/GreenPlasmaRender.png");

	public RenderGreenPlasmaEntity(RenderManager rendermanager)
	{
		super(rendermanager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGreenPlasma entity)
	{
		return plasmaTextures;
	}

	@Override
	public void doRender(EntityGreenPlasma plasma, double d, double d1, double d2, float f, float f1)
	{
		if (plasma.ticksExisted < 1)
			return;
		this.bindEntityTexture(plasma);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90F - plasma.prevRotationPitch - (plasma.rotationPitch - plasma.prevRotationPitch) * f1, 1.0F, 0.0F, 0.0F);
		ModelBase model = new ModelBullet();
		if (model != null)
			model.render(plasma, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
