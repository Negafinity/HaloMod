package com.arisux.xlib.client.render;

public class UV
{
	public float minU;
	public float maxU;
	public float minV;
	public float maxV;

	public UV(float minU, float minV, float maxU, float maxV)
	{
		this.minU = minU;
		this.minV = minV;
		this.maxU = maxU;
		this.maxV = maxV;
	}

	public UV(float u, float v)
	{
		this(0F, u, 0F, v);
	}
	
	public float getMinU()
	{
		return minU;
	}
	
	public float getMaxU()
	{
		return this.maxU;
	}
	
	public float getU()
	{
		return this.maxU;
	}
	
	public float getMinV()
	{
		return minV;
	}
	
	public float getMaxV()
	{
		return this.maxV;
	}
	
	public float getV()
	{
		return this.maxV;
	}
	
	public UV setMinU(float minU)
	{
		this.minU = minU;
		return this;
	}
	
	public UV setMaxU(float maxU)
	{
		this.maxU = maxU;
		return this;
	}
	
	public UV setMinV(float minV)
	{
		this.minV = minV;
		return this;
	}
	
	public UV setMaxV(float maxV)
	{
		this.maxV = maxV;
		return this;
	}
}