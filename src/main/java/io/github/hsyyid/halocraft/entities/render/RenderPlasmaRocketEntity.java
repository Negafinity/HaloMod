package io.github.hsyyid.halocraft.entities.render;

import com.arisux.airix.api.wavefrontapi.Part;

import io.github.hsyyid.halocraft.entities.EntityPlasmaRocket;
import io.github.hsyyid.halocraft.util.Models;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlasmaRocketEntity extends Render<EntityPlasmaRocket>
{
	public RenderPlasmaRocketEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPlasmaRocket entity)
	{
		return null;
	}

	@Override
	public void doRender(EntityPlasmaRocket entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(posX, posY, posZ);

			GlStateManager.pushMatrix();
			{
				for (Part p : Models.PLASMA_ROCKET.nameToPartHash.values())
				{
					p.draw();
				}
			}
			GlStateManager.popMatrix();
		}
		GlStateManager.popMatrix();
	}
}
