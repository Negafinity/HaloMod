package halocraft.handlers;

import halocraft.Main;
import halocraft.entities.EntityBlueElite;
import halocraft.entities.EntityElite;
import halocraft.entities.EntityGrunt;
import halocraft.entities.EntityRedElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

public class HaloGUIEventHandler extends Gui{
	private Minecraft mc;
	ResourceLocation overlayTop = new ResourceLocation("halocraft:textures/gui/HaloOverlayTop.png");
	ResourceLocation overlayBottom = new ResourceLocation("halocraft:textures/gui/HaloOverlayBottom.png");
	ResourceLocation texture = new ResourceLocation("halocraft:textures/gui/HealthBar.png");
	ResourceLocation brscope = new ResourceLocation("halocraft:textures/gui/BattleRifleScope.png");
	ResourceLocation redSquare = new ResourceLocation("halocraft:textures/gui/RedSquare.png");
	ResourceLocation greenSquare = new ResourceLocation("halocraft:textures/gui/GreenSquare.png");
	ResourceLocation minimap = new ResourceLocation("halocraft:textures/gui/HaloOverlayMinimap.png");
	public HaloGUIEventHandler(Minecraft mc){
		super();
		// We need this to invoke the render engine.
		this.mc = mc;
	}

	/**
	 * Draws textured rectangles of sizes other than 256x256
	 * @param x The x value of the top-left corner point on the screen where drawing to starts 
	 * @param y The y value of the top-left corner point on the screen where drawing to starts
	 * @param u The u (x) value of top-left corner point of the texture to start drawing from
	 * @param v The v (y) value of top-left corner point of the texture to start drawing from
	 * @param width The width of the rectangle to draw on screen
	 * @param height The height of the rectangle to draw on screen
	 * @param textureWidth The width of the whole texture
	 * @param textureHeight The height of the whole texture
	 */
	protected void drawNonStandardTexturedRect(int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight)
	{
		double f = 1F / (double)textureWidth;
		double f1 = 1F / (double)textureHeight;
		WorldRenderer tessellator = Tessellator.getInstance().getWorldRenderer();
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x, y + height, 0, u * f, (v + height) * f1);
		tessellator.addVertexWithUV(x + width, y + height, 0, (u + width) * f, (v + height) * f1);
		tessellator.addVertexWithUV(x + width, y, 0, (u + width) * f, v * f1);
		tessellator.addVertexWithUV(x, y, 0, u * f, v * f1);
		Tessellator.getInstance().draw();
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderGameOverlay(RenderGameOverlayEvent event)
	{
		ItemStack helmet = mc.thePlayer.inventory.armorItemInSlot(3);
		if(helmet != null){
			if(helmet.getItem() == halocraft.Main.SpartanHelmet || helmet.getItem() == halocraft.Main.GreenSpartanHelmet || helmet.getItem() == halocraft.Main.BlueSpartanHelmet || helmet.getItem() == halocraft.Main.RedSpartanHelmet){
				if(event.isCancelable() && event.type == ElementType.HEALTH){
					event.setCanceled(true);
				}
			}
		}
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE){
			return;
		}
		//Render Scope (If Z is pressed)
		if(halocraft.handlers.KeyInputHandler.keyPressed == true){
			ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
			int xPos = (scaled.getScaledWidth() - 420) / 2;
			int yPos = (scaled.getScaledHeight() - 250) / 2;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			this.mc.renderEngine.bindTexture(brscope);
			this.drawNonStandardTexturedRect(xPos, yPos, 0, 0, 420, 250, 420, 250);
		}
		//Checking for Spartan Helmet
		helmet = mc.thePlayer.inventory.armorItemInSlot(3);
		if(helmet != null){
			if(helmet.getItem() == halocraft.Main.SpartanHelmet || helmet.getItem() == halocraft.Main.GreenSpartanHelmet || helmet.getItem() == halocraft.Main.BlueSpartanHelmet || helmet.getItem() == halocraft.Main.RedSpartanHelmet)
			{
				//Rendering Top of Halo HUD
				ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
				int xPos = (scaled.getScaledWidth() - 420) / 2;
				int yPos = 0;
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glDisable(GL11.GL_LIGHTING);
				this.mc.renderEngine.bindTexture(overlayTop);
				this.drawNonStandardTexturedRect(xPos, yPos, 0, 0, 420, 57, 420, 57);
				//Drawing Halo-Style Health Bar
				int xPosHealth = xPos + 169;
				int yPosHealth = yPos + 14;
				this.mc.getTextureManager().bindTexture(texture);	    		
				// Add this block of code before you draw the section of your texture containing transparency
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(false);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				// Here we draw the background bar which contains a transparent section; note the new size
				drawTexturedModalRect(xPosHealth, yPosHealth, 0, 0, 86, 13);
				//Drawing Actual Health
				int manabarwidth = (int)(((float) mc.thePlayer.getHealth() / mc.thePlayer.getMaxHealth()) * 90);
				drawTexturedModalRect(xPosHealth + 1, yPosHealth + 1, 0, 13, manabarwidth, 11);
				yPos = scaled.getScaledHeight() - 85;
				//Draw Bottom of Halo HUD
				this.mc.renderEngine.bindTexture(overlayBottom);
				this.drawNonStandardTexturedRect(xPos, yPos, 0, 0, 420, 85, 420, 85);


				//Drawing Minimap
				this.mc.renderEngine.bindTexture(minimap);
				GL11.glPushMatrix();
				GL11.glTranslatef(xPos + 41 + 25, yPos + 16 + 25, 0);
				GL11.glPushMatrix();
				GL11.glRotatef(mc.thePlayer.rotationYawHead + 180, 0F, 0F, 1F);
				this.drawNonStandardTexturedRect(-25, -25, 0, 0, 50, 50, 50, 50);
				GL11.glPopMatrix();
				GL11.glPopMatrix();


				//Drawing Beautiful Red Dots
				boolean noEntitiesFound = false;

				List<Entity> entities = new ArrayList<Entity>();
				try
				{
					entities = mc.thePlayer.worldObj.getEntitiesWithinAABBExcludingEntity(mc.thePlayer, mc.thePlayer.getEntityBoundingBox().expand(30, 5, 30));
				}
				catch(NullPointerException e)
				{
					noEntitiesFound = true;
				}

				if(!noEntitiesFound)
				{
					//Draw Map
					for(Entity entityIn : entities)
					{
						int x = (int) (entityIn.posX - mc.thePlayer.posX);
						
						int y = (int) (entityIn.posZ - mc.thePlayer.posZ);
						
						double approxMinimapArea = Math.PI * Math.pow(25, 2);
						if(Math.pow(x, 2) + Math.pow(y, 2) < Math.pow(25, 2))
						{
							if(!(entityIn instanceof EntityMob) && !(entityIn instanceof EntityRedElite) && !(entityIn instanceof EntityBlueElite) && !(entityIn instanceof EntityElite) && !(entityIn instanceof EntityGrunt) && entityIn instanceof EntityLivingBase && !(entityIn instanceof EntitySlime))
							{
								this.mc.renderEngine.bindTexture(greenSquare);
								this.drawNonStandardTexturedRect(xPos + 41 + 23 + x, yPos + 16 + 25 + y, 0, 0, 3, 3, 5, 5);
							}
							else if(entityIn instanceof EntityLivingBase)
							{
								this.mc.renderEngine.bindTexture(redSquare);
								this.drawNonStandardTexturedRect(xPos + 41 + 23 + x, yPos + 16 + 25 + y, 0, 0, 3, 3, 5, 5);
							}
						}
					}
				}
				
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(true);
			}
		}
	}
}

