package com.arisux.xlib.client.render.ui.elements;

import com.arisux.xlib.client.render.ui.GlobalRenderer;
import com.arisux.xlib.client.render.ui.elements.actions.IElementAction;
import com.arisux.xlib.client.render.Texture;
import net.minecraft.util.Vec3;

import java.util.ArrayList;

public abstract class GuiElement
{
    private int x;
    private int y;
    private int w;
    private int h;
    private int color;
    private int colorHover;
    private int colorDisabled;
    private int colorForeground;
    private int colorActive;
    private boolean isHovered;
    private boolean isPressed;
    private String text;
    protected IElementAction action;
    private Texture texture;

    public GuiElement()
    {
        this.init();
        GlobalRenderer.instance().getElements().add(this);
    }

    public GuiElement(ArrayList<GuiElement> elements)
    {
        elements.add(this);
        this.init();
    }

    public void init()
    {
        ;
    }

    public void onTick()
    {
        ;
    }

    public void onRender()
    {
        ;
    }

    public int getX()
    {
        return x;
    }

    public GuiElement setX(int x)
    {
        this.x = x;
        return this;
    }

    public int getY()
    {
        return y;
    }

    public GuiElement setY(int y)
    {
        this.y = y;
        return this;
    }

    public int getW()
    {
        return w;
    }

    public GuiElement setWidth(int w)
    {
        this.w = w;
        return this;
    }

    public int getH()
    {
        return h;
    }

    public GuiElement setHeight(int h)
    {
        this.h = h;
        return this;
    }

    public GuiElement setSize(int w, int h)
    {
        this.w = w;
        this.h = h;
        return this;
    }

    public GuiElement setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
        return this;
    }

    public GuiElement setColor(int color)
    {
        this.color = color;
        return this;
    }

    public GuiElement setColorActive(int colorActive)
    {
        this.colorActive = colorActive;
        return this;
    }

    public GuiElement setColorDisabled(int colorDisabled)
    {
        this.colorDisabled = colorDisabled;
        return this;
    }

    public GuiElement setColorHover(int colorHover)
    {
        this.colorHover = colorHover;
        return this;
    }

    public int getColor()
    {
        return color;
    }

    public int getColorActive()
    {
        return colorActive;
    }

    public int getColorDisabled()
    {
        return colorDisabled;
    }

    public int getColorHover()
    {
        return colorHover;
    }

    public GuiElement setAction(IElementAction action)
    {
        this.action = action;
        return this;
    }

    public boolean isMouseInElement(Vec3 mouse)
    {
        return mouse.xCoord > this.x && mouse.xCoord < this.x + this.w && mouse.yCoord > this.y && mouse.yCoord < this.y + this.h;
    }

    public boolean isHovered()
    {
        return isHovered;
    }

    public void setHovered(boolean isHovered)
    {
        this.isHovered = isHovered;
    }

    public boolean isPressed()
    {
        return isPressed;
    }

    public void setPressed(boolean isPressed)
    {
        this.isPressed = isPressed;
    }

    public String getText()
    {
        return text;
    }

    public GuiElement setText(String text)
    {
        this.text = text;
        return this;
    }

    public int getColorForeground()
    {
        return colorForeground;
    }

    public GuiElement setColorForeground(int colorForeground)
    {
        this.colorForeground = colorForeground;
        return this;
    }

    public boolean isTextured()
    {
        return this.getTexture() != null;
    }

    public GuiElement setTexture(Texture texture)
    {
        this.texture = texture;
        return this;
    }

    public Texture getTexture()
    {
        return texture;
    }
}