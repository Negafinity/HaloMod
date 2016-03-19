package io.github.hsyyid.halocraft.entities.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.pipeline.LightUtil;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenderingUtil
{
	public static Map<String, IBakedModel> loadedModels = new HashMap<>();

	public static void renderModel(IBakedModel model, int color)
	{
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer worldrenderer = tessellator.getBuffer();

		List<BakedQuad> quads = model.getQuads(null, null, 1);
		// RenderingUtil.renderQuads(worldrenderer, quads, color);//TODO will prob explode
		for (BakedQuad quad : quads)
		{
			worldrenderer.begin(GL11.GL_QUADS, quad.getFormat());
			LightUtil.renderQuadColor(worldrenderer, quad, color);
			tessellator.draw();
		}

		// tessellator.draw();
	}

	public static void renderQuads(VertexBuffer renderer, List<BakedQuad> quads, int color)
	{
		for (BakedQuad bakedquad : quads)
			LightUtil.renderQuadColor(renderer, bakedquad, color);
	}

	public static IBakedModel loadModel(String resourceName)
	{
		return loadModel(resourceName, Attributes.DEFAULT_BAKED_FORMAT);
	}

	public static IBakedModel loadModel(String resourceName, VertexFormat fmt)
	{
		IBakedModel model = loadedModels.get(resourceName);
		if (model != null)
			return model;

		try
		{
			TextureMap textures = Minecraft.getMinecraft().getTextureMapBlocks();
			IModel mod = ModelLoaderRegistry.getModel(new ResourceLocation(resourceName));
			model = mod.bake(mod.getDefaultState(), fmt, (location) -> textures.getAtlasSprite(location.toString()));
			loadedModels.put(resourceName, model);
			return model;
		}
		catch (Exception e)
		{
			throw new ReportedException(new CrashReport("Error loading custom model " + resourceName, e));
		}
	}
}
