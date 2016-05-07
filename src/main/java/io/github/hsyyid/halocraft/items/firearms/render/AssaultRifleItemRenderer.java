package io.github.hsyyid.halocraft.items.firearms.render;

import io.github.hsyyid.halocraft.util.ItemRenderer;
import io.github.hsyyid.halocraft.util.RenderingUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.util.ResourceLocation;

public class AssaultRifleItemRenderer extends ItemRenderer
{
	private final IBakedModel model = RenderingUtil.loadModel("halocraft:item/AssaultRifle.obj");

	public AssaultRifleItemRenderer()
	{
		super(new ResourceLocation(""));
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
			GlStateManager.translate(-0.15, 0.3, 0.15);
			GlStateManager.rotate(180f, 0, 1, 0);
			RenderingUtil.renderModel(model, -1);
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderInInventory()
	{
		GlStateManager.scale(1.1, 1.1, 1.1);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(0.1, 0, 0);
			GlStateManager.rotate(-90f, 0, 1, 0);
			GlStateManager.rotate(-45f, 1, 0, 0);
			RenderingUtil.renderModel(model, -1);
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void renderOnGround()
	{
		GlStateManager.scale(0.75, 0.75, 0.75);

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
