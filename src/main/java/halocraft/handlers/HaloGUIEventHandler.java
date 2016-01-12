package halocraft.handlers;

import halocraft.entities.EntityElite;
import halocraft.entities.EntityGrunt;
import halocraft.entities.EntityPromethean;
import halocraft.entities.EntityRedElite;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class HaloGUIEventHandler extends Gui
{
	private Minecraft mc;
	ResourceLocation overlayTop = new ResourceLocation("halocraft:textures/gui/HaloOverlayTop.png");
	ResourceLocation overlayBottom = new ResourceLocation("halocraft:textures/gui/HaloOverlayBottom.png");
	ResourceLocation texture = new ResourceLocation("halocraft:textures/gui/HealthBar.png");
	ResourceLocation brscope = new ResourceLocation("halocraft:textures/gui/BattleRifleScope.png");
	ResourceLocation redSquare = new ResourceLocation("halocraft:textures/gui/RedSquare.png");
	ResourceLocation greenSquare = new ResourceLocation("halocraft:textures/gui/GreenSquare.png");
	ResourceLocation minimap = new ResourceLocation("halocraft:textures/gui/HaloOverlayMinimap.png");

	public HaloGUIEventHandler(Minecraft mc)
	{
		super();
		// We need this to invoke the render engine.
		this.mc = mc;
	}

	/**
	 * Draws textured rectangles of sizes other than 256x256
	 * 
	 * @param x
	 *            The x value of the top-left corner point on the screen where
	 *            drawing to starts
	 * @param y
	 *            The y value of the top-left corner point on the screen where
	 *            drawing to starts
	 * @param u
	 *            The u (x) value of top-left corner point of the texture to
	 *            start drawing from
	 * @param v
	 *            The v (y) value of top-left corner point of the texture to
	 *            start drawing from
	 * @param w
	 *            The width of the rectangle to draw on screen
	 * @param h
	 *            The height of the rectangle to draw on screen
	 * @param textureWidth
	 *            The width of the whole texture
	 * @param textureHeight
	 *            The height of the whole texture
	 */
	protected void drawQuad(int x, int y, int w, int h, float minU, float minV, float maxU, float maxV)
	{
		WorldRenderer tessellator = Tessellator.getInstance().getWorldRenderer();
		tessellator.begin(7, DefaultVertexFormats.POSITION_TEX); // StartDrawingQuads
		tessellator.pos(x + 0, y + h, (double) zLevel).tex(minU, maxV).endVertex();
		tessellator.pos(x + w, y + h, (double) zLevel).tex(maxU, maxV).endVertex();
		tessellator.pos(x + w, y + 0, (double) zLevel).tex(maxU, minV).endVertex();
		tessellator.pos(x + 0, y + 0, (double) zLevel).tex(minU, minV).endVertex();
		Tessellator.getInstance().draw();
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderGameOverlay(RenderGameOverlayEvent event)
	{
		ItemStack helmet = mc.thePlayer.inventory.armorItemInSlot(3);
		if (helmet != null)
		{
			if (helmet.getItem() == halocraft.HaloCraft.spartanHelmet || helmet.getItem() == halocraft.HaloCraft.spartanLockeHelmet || helmet.getItem() == halocraft.HaloCraft.greenSpartanHelmet || helmet.getItem() == halocraft.HaloCraft.blueSpartanHelmet || helmet.getItem() == halocraft.HaloCraft.redSpartanHelmet)
			{
				if (event.isCancelable() && event.type == ElementType.HEALTH)
				{
					event.setCanceled(true);
				}
			}
		}
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}
		// Render Scope (If Z is pressed)
		if (halocraft.handlers.KeyInputHandler.keyPressed == true)
		{
			ScaledResolution scaled = new ScaledResolution(mc);
			int xPos = (scaled.getScaledWidth() - 420) / 2;
			int yPos = (scaled.getScaledHeight() - 250) / 2;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			this.mc.renderEngine.bindTexture(brscope);
			this.drawQuad(0, 0, scaled.getScaledWidth(), scaled.getScaledHeight(), 0F, 0F, 1F, 1F);
		}
		// Checking for Spartan Helmet
		helmet = mc.thePlayer.inventory.armorItemInSlot(3);
		if (helmet != null)
		{
			if (helmet.getItem() == halocraft.HaloCraft.spartanHelmet || helmet.getItem() == halocraft.HaloCraft.spartanLockeHelmet || helmet.getItem() == halocraft.HaloCraft.greenSpartanHelmet || helmet.getItem() == halocraft.HaloCraft.blueSpartanHelmet || helmet.getItem() == halocraft.HaloCraft.redSpartanHelmet)
			{
				// Rendering Top of Halo HUD
				ScaledResolution scaled = new ScaledResolution(mc);
				int xPos = (scaled.getScaledWidth() - 420) / 2;
				int yPos = 0;
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glDisable(GL11.GL_LIGHTING);
				this.mc.renderEngine.bindTexture(overlayTop);
				this.drawQuad(0, 0, scaled.getScaledWidth(), 57, 0F, 0F, 1F, 1F);

				// Drawing Halo-Style Health Bar
				int xPosHealth = xPos + 169;
				int yPosHealth = yPos + 14;
				this.mc.getTextureManager().bindTexture(texture);

				// Add this block of code before you draw the section of your
				// texture containing transparency
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(false);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

				// Here we draw the background bar which contains a transparent
				// section; note the new size
				drawTexturedModalRect(xPosHealth, yPosHealth, 0, 0, 86, 13);

				// Drawing Actual Health
				int manabarwidth = (int) (((float) mc.thePlayer.getHealth() / mc.thePlayer.getMaxHealth()) * 90);
				drawTexturedModalRect(xPosHealth + 1, yPosHealth + 1, 0, 13, manabarwidth, 11);
				yPos = scaled.getScaledHeight() - 85;

				// Draw Bottom of Halo HUD
				this.mc.renderEngine.bindTexture(overlayBottom);
				this.drawQuad(0, scaled.getScaledHeight() - 85, scaled.getScaledWidth(), 85, 0F, 0F, 1F, 1F);

				// Drawing Minimap
				int minimapX = (int) (scaled.getScaledWidth() / 6.2F);
				int minimapY = yPos + 16 + 25;

				// Drawing Beautiful Red Dots
				boolean noEntitiesFound = false;

				List<Entity> entities = new ArrayList<Entity>();
				try
				{
					entities = mc.thePlayer.worldObj.getEntitiesWithinAABBExcludingEntity(mc.thePlayer, mc.thePlayer.getEntityBoundingBox().expand(30, 5, 30));
				}
				catch (NullPointerException e)
				{
					noEntitiesFound = true;
				}

				if (!noEntitiesFound)
				{
					// Draw Map
					for (Entity entityIn : entities)
					{
						int x = (int) (entityIn.posX - mc.thePlayer.posX);

						int y = (int) (entityIn.posZ - mc.thePlayer.posZ);

						if (Math.pow(x, 2) + Math.pow(y, 2) < Math.pow(23, 2))
						{
							if (!(entityIn instanceof EntityMob) && !(entityIn instanceof EntityRedElite) && !(entityIn instanceof EntityPromethean) && !(entityIn instanceof EntityElite) && !(entityIn instanceof EntityGrunt) && entityIn instanceof EntityLivingBase && !(entityIn instanceof EntityArmorStand) && !(entityIn instanceof EntitySlime))
							{
								this.mc.renderEngine.bindTexture(greenSquare);
								this.drawQuad(minimapX + x, minimapY + y, 3, 3, 0F, 0F, 1F, 1F);
							}
							else if (entityIn instanceof EntityLivingBase && !(entityIn instanceof EntityArmorStand))
							{
								this.mc.renderEngine.bindTexture(redSquare);
								this.drawQuad(minimapX + x, minimapY + y, 3, 3, 0F, 0F, 1F, 1F);
							}
						}
					}
				}

				this.mc.renderEngine.bindTexture(minimap);
				GL11.glPushMatrix();
				GL11.glTranslatef(minimapX, minimapY, 0);
				GL11.glPushMatrix();
				GL11.glRotatef(mc.thePlayer.rotationYawHead + 180, 0F, 0F, 1F);
				this.drawQuad(-25, -25, 50, 50, 0F, 0F, 1F, 1F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();

				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(true);
			}
		}
	}
}
