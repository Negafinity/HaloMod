package com.arisux.xlib.client.render;

import net.minecraft.util.ResourceLocation;

public class Texture
{
    private ResourceLocation resourceLocation;
    private UV uv;

    public Texture(ResourceLocation resourceLocation, UV uv)
    {
        this.resourceLocation = resourceLocation;
        this.uv = uv;
    }

    public ResourceLocation getResourceLocation()
    {
        return resourceLocation;
    }

    public void setResourceLocation(ResourceLocation resourceLocation)
    {
        this.resourceLocation = resourceLocation;
    }

    public UV getUV()
    {
        return uv;
    }

    public void setUV(UV uv)
    {
        this.uv = uv;
    }

    public void setUV(float u, float v)
    {
        this.setUV(0F, u, 0F, v);
    }

    public void setUV(float minU, float minV, float maxU, float maxV)
    {
        this.uv.setMinU(minU).setMinV(minV).setMaxU(maxU).setMaxV(maxV);
    }
}
