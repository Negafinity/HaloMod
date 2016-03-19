package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityOrangePlasma;
import io.github.hsyyid.halocraft.models.ModelBullet;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderOrangePlasmaEntity extends Render<EntityOrangePlasma>
{
	private static final ResourceLocation textures = new ResourceLocation("halocraft:textures/entities/OrangePlasmaRender.png");

	public RenderOrangePlasmaEntity(RenderManager rendermanager)
	{
		super(rendermanager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityOrangePlasma entity)
	{
		return textures;
	}

	@Override
	public void doRender(EntityOrangePlasma entity, double d, double d1, double d2, float f, float f1)
	{
		if (entity.ticksExisted < 1)
			return;

		this.bindEntityTexture(entity);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90F - entity.prevRotationPitch - (entity.rotationPitch - entity.prevRotationPitch) * f1, 1.0F, 0.0F, 0.0F);
		ModelBase model = new ModelBullet();

		if (model != null)
			model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		GL11.glPopMatrix();
	}

}
