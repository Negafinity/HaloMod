package io.github.hsyyid.halocraft.util;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class TAS extends TextureAtlasSprite
{
	public TAS(String spriteName)
	{
		super(spriteName);
	}

	@Override
	public float getInterpolatedU(double u)
	{
		return (float) u / 16;
	}

	@Override
	public float getInterpolatedV(double v)
	{
		return (float) v / 16;
	}
}
