package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityMarine;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderMarineEntity extends RenderLiving<EntityMarine>
{
	private final ResourceLocation textures = new ResourceLocation("halocraft:textures/entities/MarineRender.png");

	public RenderMarineEntity(RenderManager renderManager)
	{
		super(renderManager, new ModelBiped(), 0);
		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMarine entity)
	{
		return textures;
	}
}
