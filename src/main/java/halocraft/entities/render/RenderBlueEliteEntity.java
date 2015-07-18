package halocraft.entities.render;

import halocraft.entities.EntityBlueElite;
import halocraft.entities.EntityElite;
import halocraft.entities.EntityRedElite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBlueEliteEntity extends RenderLiving
{
	private static final ResourceLocation mobTextures = new ResourceLocation("halocraft:textures/entities/BlueEliteRender.png");
	public RenderBlueEliteEntity(RenderManager renderManager, ModelBase par1Model, float par2) {
		super(renderManager, par1Model, par2);
		this.addLayer(new LayerHeldItem(this));
	}
	protected ResourceLocation getEntityTexture(EntityBlueElite entity){
		return mobTextures;
	}
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityBlueElite)entity);	
	}
}
