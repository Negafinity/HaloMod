package io.github.hsyyid.halocraft.items.firearms.render;

import com.arisux.airix.api.wavefrontapi.Part;

import io.github.hsyyid.halocraft.util.ItemRenderer;
import io.github.hsyyid.halocraft.util.Models;
import net.minecraft.client.renderer.GlStateManager;

public class BattleRifleItemRenderer extends ItemRenderer
{
	public BattleRifleItemRenderer()
	{
		super();
	}

	@Override
	public void renderThirdPerson()
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.rotate(180f, 0, 1, 0);

			for (Part p : Models.BATTLE_RIFLE.nameToPartHash.values())
			{
				p.draw();
			}
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderFirstPerson()
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(0, 0.15, 0.25);
			GlStateManager.rotate(180f, 0, 1, 0);

			for (Part p : Models.BATTLE_RIFLE.nameToPartHash.values())
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
			GlStateManager.translate(0.15, -0.2, 0);
			GlStateManager.rotate(-90f, 0, 1, 0);
			GlStateManager.rotate(-45f, 1, 0, 0);

			for (Part p : Models.BATTLE_RIFLE.nameToPartHash.values())
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
			for (Part p : Models.BATTLE_RIFLE.nameToPartHash.values())
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
