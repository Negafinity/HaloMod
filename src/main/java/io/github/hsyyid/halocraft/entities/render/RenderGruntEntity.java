package io.github.hsyyid.halocraft.entities.render;

import io.github.hsyyid.halocraft.entities.EntityGrunt;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderGruntEntity extends RenderLiving<EntityGrunt>
{
	private static final ResourceLocation gruntTextures = new ResourceLocation("halocraft:textures/entities/GruntRender.png");

	public RenderGruntEntity(RenderManager renderManager, ModelBase par1Model, float par2)
	{
		super(renderManager, par1Model, par2);
		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGrunt entity)
	{
		return gruntTextures;
	}
}
