package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityPromethean;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderPrometheanEntity extends RenderLiving<EntityPromethean>
{
	private static final ResourceLocation mobTextures = new ResourceLocation("halocraft:textures/entities/PrometheanRender.png");

	public RenderPrometheanEntity(RenderManager renderManager, ModelBase par1Model, float par2)
	{
		super(renderManager, par1Model, par2);
		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPromethean entity)
	{
		return mobTextures;
	}
}
