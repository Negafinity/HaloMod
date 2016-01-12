package halocraft.entities.render;

import halocraft.entities.EntityRedElite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderRedEliteEntity extends RenderLiving<EntityRedElite>
{
	private static final ResourceLocation mobTextures = new ResourceLocation("halocraft:textures/entities/RedEliteRender.png");

	public RenderRedEliteEntity(RenderManager renderManager, ModelBase par1Model, float par2)
	{
		super(renderManager, par1Model, par2);
		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityRedElite entity)
	{
		return mobTextures;
	}
}
