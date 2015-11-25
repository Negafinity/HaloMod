package com.arisux.xlib.client.render.ui;

import com.arisux.xlib.XLib;
import com.arisux.xlib.client.render.XLibRenderer;
import com.arisux.xlib.client.render.ui.elements.ITooltipLineHandler;
import com.arisux.xlib.util.XLibMath;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.Vec3;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL12;

import java.awt.*;
import java.util.ArrayList;

public class XLibUIRenderer
{
    public static final int FONT_HEIGHT = 8;
    public static final String TOOLTIP_LINESPACE = "\u00A7h";
    public static final String TOOLTIP_HANDLER = "\u00A7x";
    private static ArrayList<ITooltipLineHandler> tipLineHandlers = new ArrayList<ITooltipLineHandler>();
    public static final UserInterface globalInterface = new UserInterface(){
        ;
    };

    public static FontRenderer fontRenderer() { return XLib.game().fontRendererObj; }

    public static int getRenderWidth(String s)
    {
        return fontRenderer().getStringWidth(s);
    }

    public static void drawString(String s, int x, int y, int color, boolean shadow)
    {
        fontRenderer().drawString(s, x, y, color, shadow);
    }

    public static void drawString(String s, int x, int y, int color)
    {
        drawString(s, x, y, color, true);
    }

    public static void drawString(String s, int x, int y)
    {
        drawString(s, x, y, 0xFFFFFFFF);
    }

    public static void drawStringCentered(String s, int x, int y, int color, boolean shadow)
    {
        drawString(s, x - (getRenderWidth(s) / 2), y, color, shadow);
    }

    public static void drawStringCentered(String s, int x, int y, int color)
    {
        drawStringCentered(s, x, y, color, true);
    }

    public static void drawStringCentered(String s, int x, int y)
    {
        drawStringCentered(s, x, y, 0xFFFFFFFF);
    }

    public static void drawStringRight(String s, int x, int y, int color, boolean shadow)
    {
        drawString(s, x - getRenderWidth(s), y, color, shadow);
    }

    public static void drawStringRight(String s, int x, int y, int color)
    {
        drawStringRight(s, x, y, color, true);
    }

    public static void drawStringRight(String s, int x, int y)
    {
        drawStringRight(s, x, y, 0xFFFFFF);
    }

    public static ScaledResolution getScaledResolution()
    {
        return new ScaledResolution(XLib.game());
    }

    public static Vec3 getScaledMousePosition()
    {
        ScaledResolution scaledResolution = getScaledResolution();
        int scaledMouseX = (Mouse.getX() * scaledResolution.getScaledWidth() / Display.getWidth());
        int scaledMouseY = scaledResolution.getScaledHeight() - (Mouse.getY() * scaledResolution.getScaledHeight() / Display.getHeight());
        return new Vec3(scaledMouseX, scaledMouseY, 0);
    }

    /**
     * @return Returns the current game display width and height as a Dimension
     */
    public static Dimension getDisplayResolution()
    {
        Minecraft mc = Minecraft.getMinecraft();
        return new Dimension(mc.displayWidth, mc.displayHeight);
    }

    /**
     * @return Returns the mouse location in-game.
     */
    public static Point getMouseLocation()
    {
        ScaledResolution size = getScaledResolution();
        Dimension res = getDisplayResolution();
        return new Point(Mouse.getX() * size.getScaledWidth() / res.width, size.getScaledHeight() - Mouse.getY() * size.getScaledHeight() / res.height - 1);
    }

    public static int getTipLineId(ITooltipLineHandler handler)
    {
        tipLineHandlers.add(handler);
        return tipLineHandlers.size() - 1;
    }

    public static ITooltipLineHandler getTipLine(String line)
    {
        return !line.startsWith(TOOLTIP_HANDLER) ? null : tipLineHandlers.get(Integer.parseInt(line.substring(2)));
    }

    /**
     * Draws a multi-line tooltip at the specified cordinates.
     *
     * @param x - x coordinate
     * @param y - y coordinate
     * @param list - List of Strings to show in the tooltip.
     */
    public static void drawMultilineToolTip(int x, int y, ArrayList<String> list)
    {
        if (list.isEmpty())
        {
            return;
        }
        glDisable(GL12.GL_RESCALE_NORMAL);
        glDisable(GL_DEPTH_TEST);
        RenderHelper.disableStandardItemLighting();
        int w = 0;
        int h = -2;

        for (int i = 0; i < list.size(); i++)
        {
            String s = list.get(i);
            ITooltipLineHandler line = getTipLine(s);
            Dimension d = line != null ? line.getSize() : new Dimension(getRenderWidth(s), list.get(i).endsWith(TOOLTIP_LINESPACE) && i + 1 < list.size() ? 12 : 10);
            w = Math.max(w, d.width);
            h += d.height;
        }

        if (x < 8)
        {
            x = 8;
        }
        else if (x > getScaledResolution().getScaledWidth() - w - 8)
        {
            x -= 24 + w;
        }
        y = (int) XLibMath.clip(y, 8, getScaledResolution().getScaledHeight() - 8 - h);

        globalInterface.incZLevel(300);
        drawTooltipBox(x - 4, y - 4, w + 7, h + 7);

        for (String s : list)
        {
            ITooltipLineHandler line = getTipLine(s);
            if (line != null)
            {
                line.draw(x, y);
                y += line.getSize().height;
            }
            else
            {
                drawString(s, x, y, -1);
                y += s.endsWith(TOOLTIP_LINESPACE) ? 12 : 10;
            }
        }

        tipLineHandlers.clear();
        globalInterface.incZLevel(-300);

        glEnable(GL_DEPTH_TEST);
        glEnable(GL12.GL_RESCALE_NORMAL);
    }

    /**
     * Draws a tooltip box at the specified cordinates, with the specified width and height.
     *
     * @param x - x coordinate
     * @param y - y coordinate
     * @param w - Width of the box
     * @param h - Height of the box
     */
    public static void drawTooltipBox(int x, int y, int w, int h)
    {
        int bg = 0xf0100010;
        XLibRenderer.drawQuadColored(x + 1, y, w - 1, 1, bg);
        XLibRenderer.drawQuadColored(x + 1, y + h, w - 1, 1, bg);
        XLibRenderer.drawQuadColored(x + 1, y + 1, w - 1, h - 1, bg);
        XLibRenderer.drawQuadColored(x, y + 1, 1, h - 1, bg);
        XLibRenderer.drawQuadColored(x + w, y + 1, 1, h - 1, bg);
        int grad1 = 0x505000ff;
        int grad2 = 0x5028007F;
        globalInterface.drawGradientRect(x + 1, y + 2, 1, h - 3, grad1, grad2);
        globalInterface.drawGradientRect(x + w - 1, y + 2, 1, h - 3, grad1, grad2);
        globalInterface.drawGradientRect(x + 1, y + 1, w - 1, 1, grad1, grad1);
        globalInterface.drawGradientRect(x + 1, y + h - 1, w - 1, 1, grad2, grad2);
    }
}
