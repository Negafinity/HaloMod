package halocraft.entities.render;

import halocraft.entities.EntityMarine;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMarineEntity extends RenderLiving
{
	private static final ResourceLocation marineTextures = new ResourceLocation("halocraft:textures/armor/MarineArmor_1.png");

	public RenderMarineEntity(RenderManager renderManager, ModelBase par1Model, float par2)
	{
		super(renderManager, par1Model, par2);
		this.addLayer(new LayerHeldItem(this));
	}

	protected ResourceLocation getEntityTexture(EntityMarine entity)
	{
		return marineTextures;
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityMarine) entity);
	}
}
