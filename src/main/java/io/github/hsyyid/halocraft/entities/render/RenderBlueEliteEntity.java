package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityBlueElite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderBlueEliteEntity extends RenderLiving<EntityBlueElite>
{
	private final ResourceLocation textures = new ResourceLocation("halocraft:textures/entities/BlueEliteRender.png");

	public RenderBlueEliteEntity(RenderManager renderManager, ModelBase par1Model, float par2)
	{
		super(renderManager, par1Model, par2);

		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBlueElite entity)
	{
		return textures;
	}
}
