package halocraft.entities.render;

import halocraft.entities.EntityMarine;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderMarineEntity extends RenderLiving<EntityMarine>
{
	private static final ResourceLocation marineTextures = new ResourceLocation("halocraft:textures/entities/MarineRender.png");

	public RenderMarineEntity(RenderManager renderManager, ModelBase par1Model, float par2)
	{
		super(renderManager, par1Model, par2);
		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMarine entity)
	{
		return marineTextures;
	}
}
