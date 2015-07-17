package com.arisux.xlib.client.render.ui;

import com.arisux.xlib.XLibForgeModule;
import com.arisux.xlib.client.render.ui.elements.GuiElement;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;

public class GlobalRenderer
{
    private ArrayList<GuiElement> elements;

    public GlobalRenderer()
    {
        this.elements = new ArrayList<GuiElement>();
    }

    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        for (GuiElement element : elements)
        {
            element.onTick();
        }
    }

    public void onRenderTick(TickEvent.RenderTickEvent event)
    {
        for (GuiElement element : elements)
        {
            element.onRender();
        }
    }

    public static final GlobalRenderer instance()
    {
        return XLibForgeModule.globalRenderer();
    }

    public ArrayList<GuiElement> getElements()
    {
        return this.elements;
    }
}
