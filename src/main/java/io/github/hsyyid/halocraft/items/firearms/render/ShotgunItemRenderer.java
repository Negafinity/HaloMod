package io.github.hsyyid.halocraft.items.firearms.render;

import com.arisux.airix.api.wavefrontapi.Part;

import io.github.hsyyid.halocraft.util.ItemRenderer;
import io.github.hsyyid.halocraft.util.Models;
import net.minecraft.client.renderer.GlStateManager;

public class ShotgunItemRenderer extends ItemRenderer
{
	public ShotgunItemRenderer()
	{
		super();
	}

	@Override
	public void renderThirdPerson()
	{
		GlStateManager.scale(0.035, 0.035, 0.035);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(0, -1, 5);
			GlStateManager.rotate(90f, 0, 1, 0);

			for (Part p : Models.SHOTGUN.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderFirstPerson()
	{
		GlStateManager.scale(0.025, 0.025, 0.025);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-10, 10, 15);
			GlStateManager.rotate(90f, 0, 1, 0);

			for (Part p : Models.SHOTGUN.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderInInventory()
	{
		GlStateManager.scale(0.055, 0.055, 0.055);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(5, -5, 0);
			GlStateManager.rotate(180f, 0, 1, 0);
			GlStateManager.rotate(45f, 0, 0, 1);
			GlStateManager.rotate(-45f, 1, 0, 0);

			for (Part p : Models.SHOTGUN.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderOnGround()
	{
		GlStateManager.scale(0.025, 0.025, 0.025);

		GlStateManager.pushMatrix();
		{
			for (Part p : Models.SHOTGUN.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderInFrame()
	{
		GlStateManager.scale(0.055, 0.055, 0.055);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-10, -5, 0);

			for (Part p : Models.SHOTGUN.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}
}
