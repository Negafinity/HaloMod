package com.arisux.xlib.client.render;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_CLAMP;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_ONE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_S;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_T;
import static org.lwjgl.opengl.GL11.GL_ZERO;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glCopyTexSubImage2D;
import static org.lwjgl.opengl.GL11.glDepthMask;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glGetBoolean;
import static org.lwjgl.opengl.GL11.glTexParameteri;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import com.arisux.xlib.XLib;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;

public class XLibRenderer
{
    public static ArrayList<Framebuffer> frameBuffers = new ArrayList<Framebuffer>();

    public static Tessellator tessellator()
    {
        return Tessellator.getInstance();
    }

    public static TextureManager textureManager()
    {
        return XLib.game().getTextureManager();
    }

    public static WorldRenderer worldRenderer()
    {
        return tessellator().getWorldRenderer();
    }

    public static void translate(float x, float y, float z)
    {
        GlStateManager.translate(x, y, z);
    }

    public static void translate(double x, double y, double z)
    {
        translate((float) x, (float) y, (float) z);
    }

    public static void pushMatrix()
    {
        GlStateManager.pushMatrix();
    }

    public static void popMatrix()
    {
        GlStateManager.popMatrix();
    }

    public static void scale(int x, int y, int z)
    {
        GlStateManager.scale(x, y, z);
    }

    public static void copyDownsizedRender(TextureManager manager, ResourceLocation renderTo, int x, int y, int w, int h, int index)
    {
        ITextureObject textureObject = manager.getTexture(renderTo);
        if (textureObject != null)
        {
            glBindTexture(GL_TEXTURE_2D, textureObject.getGlTextureId());
            glCopyTexSubImage2D(GL_TEXTURE_2D, 0, index, index, x, y, w, h);
        }
    }

    public static Framebuffer bufferAdd(int width, int height, boolean useDepth)
    {
        Framebuffer render = new Framebuffer(width, height, useDepth);
        frameBuffers.add(render);
        return render;
    }

    public static void bufferClear(Framebuffer buffer)
    {
        glEnable(GL_DEPTH_TEST);
        if (buffer.framebufferObject >= 0)
        {
            buffer.deleteFramebuffer();
        }
        frameBuffers.remove(buffer);
    }

    /**
     * Disable lightmapping, enable GL_BLEND, and reset the colors to default values.
     */
    public static void lightmapDisable()
    {
        char c0 = 61680;
        glEnable(GL_BLEND);
        glBlendFunc(GL_ONE, GL_ONE);
        glDepthMask(true);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) c0 % 65536 / 1.0F, (float) c0 / 65536 / 1.0F);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Enable lightmapping, disable GL_BLEND, and reset the colors to default values.
     */
    public static void lightmapEnable()
    {
        char c0 = 61680;
        glDisable(GL_BLEND);
        glDepthMask(true);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) c0 % 65536 / 1.0F, (float) c0 / 65536 / 1.0F);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Disable light
     */
    public static void lightDisable()
    {
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        if (glGetBoolean(GL_TEXTURE_2D))
        {
            glDisable(GL_TEXTURE_2D);
        }
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
        glDisable(GL_LIGHTING);
    }

    /**
     * Enable light
     */
    public static void lightEnable()
    {
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        if (glGetBoolean(GL_TEXTURE_2D))
        {
            glEnable(GL_TEXTURE_2D);
        }
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
        glEnable(GL_LIGHTING);
    }

    /**
     * Reset GL_BLEND
     */
    public static void blendClear()
    {
        OpenGlHelper.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, GL_ONE, GL_ZERO);
    }

    /**
     * Combonation of GL functions used to smooth out the rough edges of a 2D texture.
     */
    public static void antiAlias2D()
    {
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
    }

    /**
     * @param resource - The ResourceLocation of which to get the GL texture ID from.
     * @return Returns the GL texture ID of the specified ResourceLocation
     */
    public static int getTexID(ResourceLocation resource)
    {
        Object object = XLib.game().getTextureManager().getTexture(resource);
        object = object == null ? new SimpleTexture(resource) : object;
        return ((ITextureObject) object).getGlTextureId();
    }

    /**
     * @param color - 4 segment hexadecimal color value
     */
    public static void colorHex4(int color)
    {
        float a = (color >> 24 & 255) / 255.0F;
        float r = (color >> 16 & 255) / 255.0F;
        float g = (color >> 8 & 255) / 255.0F;
        float b = (color & 255) / 255.0F;
        glColor4f(r, g, b, a);
    }

    /**
     * @param color - 3 segment hexadecimal color value
     */
    public static void colorHex3(int color)
    {
        float r = (color >> 16 & 255) / 255.0F;
        float g = (color >> 8 & 255) / 255.0F;
        float b = (color & 255) / 255.0F;
        glColor3f(r, g, b);
    }

    /**
     * TODO: Test method. Possibly broken due to byte conversion.
     * Converts 4 RGBA values into a single hexadecimal color value.
     *
     * @param a - Alpha value ranged from 0-255
     * @param r - Red value ranged from 0-255
     * @param g - Green value ranged from 0-255
     * @param b - Blue value ranged from 0-255
     * @return Hexadecimal created from the provided RGBA values.
     */
    public static int createHexColor(int a, int r, int g, int b)
    {
        Color color = new Color(a, r, g, b);
        ByteBuffer buf = ByteBuffer.allocate(4);

        color.writeRGBA(buf);
        buf.rewind();

        return buf.getInt();
    }

    public static void bindResource(ResourceLocation resource)
    {
        textureManager().bindTexture(resource);
    }

    public ITextureObject getTextureObject(ResourceLocation resource)
    {
        return textureManager().getTexture(resource);
    }

    public static void drawQuadColored(int x, int y, int w, int h, int color)
    {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        colorHex4(color);
        drawQuad(x, y, w, h);
        colorHex4(0xFFFFFFFF);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawQuadRelative(int x, int y, int w, int h)
    {
        drawQuadRelative(x, y, x + w, y + h, 0);
    }

    public static void drawQuadRelative(int x, int y, int w, int h, int z)
    {
        drawQuad(x, y, x + w, y + h, z, 0, 1, 0, 1);
    }

    public static void drawQuad(int x1, int y1, int x2, int y2)
    {
        drawQuad(x1, y1, x2, y2, 0);
    }

    public static void drawQuad(int x1, int y1, int x2, int y2, int z)
    {
        drawQuad(x1, y1, x2, y2, z, 0, 1, 0, 1);
    }

    public static void drawQuad(int x1, int y1, int x2, int y2, int z, float minU, float maxU, float minV, float maxV)
    {
        worldRenderer().startDrawingQuads();
        worldRenderer().addVertexWithUV(x1, y2, z, minU, maxV);
        worldRenderer().addVertexWithUV(x2, y2, z, maxU, maxV);
        worldRenderer().addVertexWithUV(x2, y1, z, maxU, minV);
        worldRenderer().addVertexWithUV(x1, y1, z, minU, minV);
        tessellator().draw();
    }

	public static void bindTexture(ResourceLocation resource)
	{
		XLib.game().renderEngine.bindTexture(resource);
	}
}
