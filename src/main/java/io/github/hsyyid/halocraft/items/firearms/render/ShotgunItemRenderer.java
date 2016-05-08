package io.github.hsyyid.halocraft.items.firearms.render;

import io.github.hsyyid.halocraft.util.ItemRenderer;
import io.github.hsyyid.halocraft.util.RenderingUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.util.ResourceLocation;

public class ShotgunItemRenderer extends ItemRenderer
{
	private final IBakedModel model = RenderingUtil.loadModelWithTexture("halocraft:item/shotgun.obj");

	public ShotgunItemRenderer()
	{
		super(new ResourceLocation("halocraft:textures/items/shotgun.png"));
	}

	@Override
	public void renderThirdPerson()
	{
		this.bindTexture();
		GlStateManager.scale(0.035, 0.035, 0.035);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(0, -1, 5);
			GlStateManager.rotate(90f, 0, 1, 0);
			RenderingUtil.renderModel(model, -1);
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderFirstPerson()
	{
		this.bindTexture();
		GlStateManager.scale(0.025, 0.025, 0.025);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-10, 10, 15);
			GlStateManager.rotate(90f, 0, 1, 0);
			RenderingUtil.renderModel(model, -1);
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderInInventory()
	{
		this.bindTexture();
		GlStateManager.scale(0.055, 0.055, 0.055);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(5, -5, 0);
			GlStateManager.rotate(180f, 0, 1, 0);
			GlStateManager.rotate(45f, 0, 0, 1);
			GlStateManager.rotate(-45f, 1, 0, 0);
			RenderingUtil.renderModel(model, -1);
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderOnGround()
	{
		this.bindTexture();
		GlStateManager.scale(0.025, 0.025, 0.025);

		GlStateManager.pushMatrix();
		{
			RenderingUtil.renderModel(model, -1);
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderInFrame()
	{
		this.bindTexture();
		GlStateManager.scale(0.055, 0.055, 0.055);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-10, -5, 0);
			RenderingUtil.renderModel(model, -1);
		}
		GlStateManager.popMatrix();
	}
}
