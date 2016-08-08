package io.github.hsyyid.halocraft.entities.vehicles.render;

import com.arisux.airix.api.wavefrontapi.Part;

import io.github.hsyyid.halocraft.entities.vehicles.EntityGhost;
import io.github.hsyyid.halocraft.util.Models;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGhostEntity extends Render<EntityGhost>
{
	public RenderGhostEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGhost entityWarthog)
	{
		return null;
	}

	@Override
	public void doRender(EntityGhost entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(posX, posY + 0.35, posZ);
			GlStateManager.rotate(-(entity.rotationYaw + 90), 0, 1, 0);

			GlStateManager.pushMatrix();
			{
				for (Part p : Models.GHOST.nameToPartHash.values())
				{
					p.draw();
				}
			}
			GlStateManager.popMatrix();
		}
		GlStateManager.popMatrix();
	}
}
