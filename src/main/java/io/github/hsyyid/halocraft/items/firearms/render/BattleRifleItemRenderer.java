package io.github.hsyyid.halocraft.items.firearms.render;

import io.github.hsyyid.halocraft.util.ItemRenderer;
import io.github.hsyyid.halocraft.util.RenderingUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.util.ResourceLocation;

public class BattleRifleItemRenderer extends ItemRenderer
{
	private final IBakedModel model = RenderingUtil.loadModel("halocraft:item/BattleRifle.obj");

	public BattleRifleItemRenderer()
	{
		super(new ResourceLocation(""));
	}

	@Override
	public ItemOverrideList getOverrides()
	{
		return model.getOverrides();
	}

	@Override
	public void renderThirdPerson()
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.rotate(180f, 0, 1, 0);
			RenderingUtil.renderModel(model, -1);
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
			RenderingUtil.renderModel(model, -1);
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
			RenderingUtil.renderModel(model, -1);
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderOnGround()
	{
		GlStateManager.scale(0.5, 0.5, 0.5);

		GlStateManager.pushMatrix();
		{
			RenderingUtil.renderModel(model, -1);
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderInFrame()
	{
		this.renderInInventory();
	}
}
