package com.arisux.xlib.api.wavefrontapi;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.arisux.xlib.client.render.Color;
import com.arisux.xlib.client.render.XLibRenderer;

import net.minecraft.util.ResourceLocation;

public class FaceGroup
{
	public String mtlName;
	public ResourceLocation resource;
	public ArrayList<Face> faces = new ArrayList<Face>();
	public boolean listReady = false;
	public int glList;
	public Color color;

	public void bindTexture()
	{
		if (resource != null)
		{
			XLibRenderer.bindTexture(resource);
		}
	}

	public void draw()
	{
		if (resource != null)
		{
			bindTexture();
			drawNoBind();
		}
		else
		{
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			drawNoBind();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
	}

	public void drawNoBind()
	{
		if (listReady == false)
		{
			listReady = true;
			glList = GL11.glGenLists(1);

			GL11.glNewList(glList, GL11.GL_COMPILE);
			this.drawVertex();
			GL11.glEndList();
		}

		GL11.glCallList(glList);
	}

	private void drawVertex()
	{
		int mode = 0;

		for (Face f : faces)
		{
			if (f.vertexNbr != mode)
			{
				if (mode != 0)
				{
					GL11.glEnd();
				}
				
				switch (f.vertexNbr)
				{
					case 3:
						GL11.glBegin(GL11.GL_TRIANGLES);
						break;
					case 4:
						GL11.glBegin(GL11.GL_QUADS);
						break;
					case 6:
						GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
						break;
					case 8:
						GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
						break;
				}

				mode = f.vertexNbr;
			}

			GL11.glColor3f(this.color.r, this.color.g, this.color.b);
			GL11.glNormal3f(f.normal.x, f.normal.y, f.normal.z);

			for (int idx = 0; idx < mode; idx++)
			{
				if (f.uv[idx] != null)
				{
					GL11.glTexCoord2f(f.uv[idx].getMaxU(), f.uv[idx].maxV);
				}
				
				GL11.glVertex3f(f.vertex[idx].x, f.vertex[idx].y, f.vertex[idx].z);
			}
		}

		if (mode != 0)
		{
			GL11.glEnd();
		}
	}
}
