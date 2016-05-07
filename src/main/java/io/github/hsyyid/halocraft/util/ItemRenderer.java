package io.github.hsyyid.halocraft.util;

import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IPerspectiveAwareModel;

public abstract class ItemRenderer implements IPerspectiveAwareModel
{
	public enum ItemRenderType
	{
		ENTITY, EQUIPPED, EQUIPPED_FIRST_PERSON, INVENTORY, FIRST_PERSON_MAP
	}

	protected static final float DEFAULT_BOX_TRANSLATION = 0.625F;
	private final Pair<? extends IBakedModel, Matrix4f> selfPair;
	protected Minecraft mc = Minecraft.getMinecraft();
	protected ResourceLocation resource;

	public ItemRenderer(ResourceLocation resource)
	{
		this.selfPair = Pair.of(this, null);
		this.resource = resource;
	}

	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType)
	{
		switch (cameraTransformType)
		{
			case THIRD_PERSON_RIGHT_HAND: {
				GlStateManager.pushMatrix();
				GlStateManager.disableLighting();
				this.renderThirdPerson();
				GlStateManager.popMatrix();
				break;
			}
			case FIXED: {
				GlStateManager.pushMatrix();
				GlStateManager.disableLighting();
				this.renderInFrame();
				GlStateManager.popMatrix();
				break;
			}
			case GUI: {
				GlStateManager.pushMatrix();
				GlStateManager.disableLighting();
				this.renderInInventory();
				GlStateManager.popMatrix();
				break;
			}
			case GROUND: {
				GlStateManager.pushMatrix();
				GlStateManager.disableLighting();
				this.renderOnGround();
				GlStateManager.popMatrix();
				break;
			}
			case FIRST_PERSON_RIGHT_HAND: {
				GlStateManager.pushMatrix();
				GlStateManager.disableLighting();
				this.renderFirstPerson();
				GlStateManager.popMatrix();
				break;
			}
		}

		return selfPair;
	}

	public abstract void renderThirdPerson();

	public abstract void renderFirstPerson();

	public abstract void renderInInventory();

	public abstract void renderInFrame();

	public abstract void renderOnGround();

	public ResourceLocation getResourceLocation()
	{
		return resource;
	}

	public void setResourceLocation(ResourceLocation resource)
	{
		this.resource = resource;
	}

	@Override
	public boolean isAmbientOcclusion()
	{
		return true;
	}

	@Override
	public boolean isGui3d()
	{
		return true;
	}

	@Override
	public boolean isBuiltInRenderer()
	{
		return false;
	}

	@Override
	public TextureAtlasSprite getParticleTexture()
	{
		return null;
	}

	@Override
	public ItemCameraTransforms getItemCameraTransforms()
	{
		return ItemCameraTransforms.DEFAULT;
	}

	public void bindTexture()
	{
		this.mc.renderEngine.bindTexture(this.resource);
	}

	public boolean firstPersonRenderCheck(Object o)
	{
		return o == mc.getRenderViewEntity() && mc.gameSettings.thirdPersonView == 0 && (!(mc.currentScreen instanceof GuiInventory) && !(mc.currentScreen instanceof GuiContainerCreative));
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand)
	{
		return Lists.newArrayList();
	}
	
	@Override
	public ItemOverrideList getOverrides()
	{
		return new ItemOverrideList(Lists.newArrayList());
	}
}
