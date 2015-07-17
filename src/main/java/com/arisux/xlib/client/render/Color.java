package com.arisux.xlib.client.render;

import java.nio.ByteBuffer;

public class Color
{
	public float r, g, b, a;

	public Color(float r, float g, float b, float a)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
    public void writeRGBA(ByteBuffer buf)
    {
        buf.put((byte) this.r);
        buf.put((byte) this.g);
        buf.put((byte) this.b);
        buf.put((byte) this.a);
    }

    public void writeRGB(ByteBuffer buf)
    {
        buf.put((byte) this.r);
        buf.put((byte) this.g);
        buf.put((byte) this.b);
    }
}