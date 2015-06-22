package halocraft.render;

import java.io.IOException;
import java.util.List;

import halocraft.entities.EntityBullet;
import halocraft.models.ModelBullet;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Function;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.client.model.b3d.B3DLoader;

public class RenderBulletEntity extends Render{
	private static final ResourceLocation bulletTextures = new ResourceLocation("halocraft:textures/entities/BulletRender.png");
	private static final ModelResourceLocation bulletModelFile = new ModelResourceLocation("halocraft:models/entity/Bullet.b3d");
	 Function<ResourceLocation, TextureAtlasSprite> textureGetter = new Function<ResourceLocation, TextureAtlasSprite>()
	            {
	                public TextureAtlasSprite apply(ResourceLocation location)
	                {
	                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
	                }
	            };
	public RenderBulletEntity(RenderManager rendermanager) {
		super(rendermanager);
		shadowSize = 0.5F;
		// TODO Auto-generated constructor stub
	}
	protected ResourceLocation getEntityTexture(Entity entity){
		return bulletTextures;
	}
	public void render(EntityBullet bullet, double d, double d1, double d2, float f, float f1)
	{
		Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		if(bullet.ticksExisted < 1)
			return;
		bindEntityTexture(bullet);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90F -bullet.prevRotationPitch - (bullet.rotationPitch - bullet.prevRotationPitch) * f1, 1.0F, 0.0F, 0.0F);
		IModel bulletModel = null;
		try {
			bulletModel = B3DLoader.instance.loadModel(bulletModelFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	IBakedModel bakedBullet = bulletModel.bake((TRSRTransformation.identity()),  Attributes.DEFAULT_BAKED_FORMAT, textureGetter);
    	worldrenderer.startDrawingQuads();
        GlStateManager.rotate(-90f, 0f, 0f, 1f);
        //Get Quads
        List<BakedQuad> generalQuads = bakedBullet.getGeneralQuads();
		for (BakedQuad q : generalQuads) {
			int[] vd = q.getVertexData();
			worldrenderer.setVertexFormat(Attributes.DEFAULT_BAKED_FORMAT);
			worldrenderer.addVertexData(vd);
		}
		for (EnumFacing face : EnumFacing.values()) {
            List<BakedQuad> faceQuads = 
           		 bakedBullet.getFaceQuads(face);
            for (BakedQuad q : faceQuads) {
                    int[] vd = q.getVertexData();
                    worldrenderer.setVertexFormat(Attributes.DEFAULT_BAKED_FORMAT);
                   worldrenderer.addVertexData(vd);
           }
		 }
		tessellator.draw();
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		render((EntityBullet) entity, d, d1, d2, f, f1);
	}
	
}
