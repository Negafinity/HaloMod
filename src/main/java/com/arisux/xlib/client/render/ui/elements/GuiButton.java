package com.arisux.xlib.client.render.ui.elements;

import com.arisux.xlib.client.render.XLibRenderer;
import com.arisux.xlib.client.render.ui.XLibUIRenderer;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;

public class GuiButton extends GuiElement
{
    public GuiButton(ArrayList<GuiElement> elements)
    {
        super(elements);
    }

    @Override
    public void onRender()
    {
        super.onRender();

        if (this.isTextured())
        {
            XLibRenderer.bindResource(this.getTexture().getResourceLocation());
            XLibRenderer.drawQuad(this.getX(), this.getY(), this.getX() + this.getW(), this.getY() + this.getH(), 0, this.getTexture().getUV().getMinU(), this.getTexture().getUV().getMinV(), this.getTexture().getUV().getMaxU(), this.getTexture().getUV().getMaxV());
        }

        XLibRenderer.drawQuadColored(this.getX(), this.getY(), this.getX() + this.getW(), this.getY() + this.getH(), this.isPressed() ? this.getColorActive() : (this.isHovered() ? this.getColorHover() : this.getColor()));
        XLibUIRenderer.drawStringCentered(this.getText(), this.getX() + (this.getW() / 2), this.getY() + (this.getH() / 2) - XLibUIRenderer.FONT_HEIGHT / 2, this.getColorForeground(), false);
    }

    @Override
    public void onTick()
    {
        this.setHovered(this.isMouseInElement(XLibUIRenderer.getScaledMousePosition()));
        this.setPressed(Mouse.getEventButton() == 0 && Mouse.getEventButtonState() && this.isHovered());

        if (this.isPressed())
        {
            this.action.onAction();
        }
    }
}
