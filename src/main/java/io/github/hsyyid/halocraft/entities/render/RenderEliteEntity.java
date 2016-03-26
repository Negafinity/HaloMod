package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityElite;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderEliteEntity extends RenderLiving<EntityElite>
{
	private static final ResourceLocation mobTextures = new ResourceLocation("halocraft:textures/entities/EliteRender.png");

	public RenderEliteEntity(RenderManager renderManager)
	{
		super(renderManager, new ModelBiped(), 0);
		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityElite entity)
	{
		return mobTextures;
	}
}
