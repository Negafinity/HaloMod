package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityPromethean;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderPrometheanEntity extends RenderLiving<EntityPromethean>
{
	private final ResourceLocation textures = new ResourceLocation("halocraft:textures/entities/PrometheanRender.png");

	public RenderPrometheanEntity(RenderManager renderManager)
	{
		super(renderManager, new ModelBiped(), 0);
		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPromethean entity)
	{
		return textures;
	}
}
