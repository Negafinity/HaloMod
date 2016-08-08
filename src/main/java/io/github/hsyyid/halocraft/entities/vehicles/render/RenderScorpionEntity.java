package io.github.hsyyid.halocraft.entities.vehicles.render;

import com.arisux.airix.api.wavefrontapi.Part;

import io.github.hsyyid.halocraft.entities.vehicles.EntityScorpion;
import io.github.hsyyid.halocraft.util.Models;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderScorpionEntity extends Render<EntityScorpion>
{
	public RenderScorpionEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityScorpion entityWarthog)
	{
		return null;
	}

	@Override
	public void doRender(EntityScorpion entity, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(posX + 2.5, posY, posZ - 2.75);

			for (Part p : Models.SCORPION.nameToPartHash.values())
			{
				GlStateManager.pushMatrix();
				{
					if (p == Models.SCORPION.getPart("the_node.025_tri_714_geometry") && entity.getControllingPassenger() != null && entity.getControllingPassenger() instanceof EntityPlayer)
					{
						EntityPlayer rider = (EntityPlayer) entity.getControllingPassenger();

						GlStateManager.translate(-2.5, 0, 2.5);
						GlStateManager.rotate(-(rider.rotationYawHead - 180), 0F, 1F, 0F);
						GlStateManager.translate(2.5, 0, -2.5);
						p.draw();
					}
					else
					{
						p.draw();
					}
				}
				GlStateManager.popMatrix();
			}
		}
		GlStateManager.popMatrix();
	}
}
