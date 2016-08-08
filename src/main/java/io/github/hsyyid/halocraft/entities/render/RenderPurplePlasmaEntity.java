package io.github.hsyyid.halocraft.entities.render;

import com.arisux.airix.api.wavefrontapi.Part;

import io.github.hsyyid.halocraft.entities.EntityPurplePlasma;
import io.github.hsyyid.halocraft.util.Models;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPurplePlasmaEntity extends Render<EntityPurplePlasma>
{
	private static final ResourceLocation plasmaTextures = new ResourceLocation("halocraft:textures/entities/PurplePlasmaRender.png");

	public RenderPurplePlasmaEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPurplePlasma entity)
	{
		return plasmaTextures;
	}

	@Override
	public void doRender(EntityPurplePlasma entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		{
			this.bindTexture(plasmaTextures);
			GlStateManager.translate(posX, posY, posZ);

			GlStateManager.pushMatrix();
			{
				for (Part p : Models.PURPLE_PLASMA.nameToPartHash.values())
				{
					p.draw();
				}
			}
			GlStateManager.popMatrix();
		}
		GlStateManager.popMatrix();
	}
}
