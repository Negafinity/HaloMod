package io.github.hsyyid.halocraft.items.firearms.render;

import com.arisux.airix.api.wavefrontapi.Part;

import io.github.hsyyid.halocraft.util.ItemRenderer;
import io.github.hsyyid.halocraft.util.Models;
import net.minecraft.client.renderer.GlStateManager;

public class BoltshotItemRenderer extends ItemRenderer
{
	public BoltshotItemRenderer()
	{
		super();
	}

	@Override
	public void renderThirdPerson()
	{
		GlStateManager.scale(0.6, 0.6, 0.6);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(0.1, -0.5, -0.25);
			GlStateManager.rotate(180f, 0, 1, 0);

			for (Part p : Models.BOLTSHOT.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderFirstPerson()
	{
		GlStateManager.scale(0.5, 0.5, 0.5);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-0.45, 0.2, 0.5);
			GlStateManager.rotate(180f, 0, 1, 0);

			for (Part p : Models.BOLTSHOT.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderInInventory()
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-0.3, -0.35, 0);
			GlStateManager.rotate(-90f, 0, 1, 0);
			GlStateManager.rotate(-45f, 1, 0, 0);

			for (Part p : Models.BOLTSHOT.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderOnGround()
	{
		GlStateManager.scale(0.5, 0.5, 0.5);

		GlStateManager.pushMatrix();
		{
			for (Part p : Models.BOLTSHOT.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderInFrame()
	{
		this.renderInInventory();
	}
}
