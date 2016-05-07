package io.github.hsyyid.halocraft.items.firearms.render;

import io.github.hsyyid.halocraft.util.ItemRenderer;
import io.github.hsyyid.halocraft.util.RenderingUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.util.ResourceLocation;

public class BoltshotItemRenderer extends ItemRenderer
{
	private final IBakedModel model = RenderingUtil.loadModel("halocraft:item/Boltshot.obj");

	public BoltshotItemRenderer()
	{
		super(new ResourceLocation(""));
	}

	@Override
	public void renderThirdPerson()
	{
		GlStateManager.scale(0.6, 0.6, 0.6);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(0.1, -0.5, -0.25);
			GlStateManager.rotate(180f, 0, 1, 0);
			RenderingUtil.renderModel(model, -1);
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
			RenderingUtil.renderModel(model, -1);
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
