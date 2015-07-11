package halocraft.entities.render;

import halocraft.entities.EntityElite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEliteEntity extends RenderLiving{
	private static final ResourceLocation mobTextures = new ResourceLocation("halocraft:textures/entities/EliteRender.png");
	public RenderEliteEntity(RenderManager p_i46153_1_, ModelBase par1Model,
			float par2) {
		super(p_i46153_1_, par1Model, par2);
	}
	protected ResourceLocation getEntityTexture(EntityElite entity){
		return mobTextures;
	}
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityElite)entity);	

	}
}
