package halocraft.entities.render;

import halocraft.entities.EntityMongoose;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Function;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMongooseEntity extends Render
{
    private static final ModelResourceLocation mongooseModel = new ModelResourceLocation("halocraft:entity/Mongoose.obj");
    IModel model = null;
    public RenderMongooseEntity(RenderManager renderManager)
    {
        super(renderManager);
        this.shadowSize = 0.5F;
    }
    Function<ResourceLocation, TextureAtlasSprite> textureGetter = new Function<ResourceLocation, TextureAtlasSprite>()
            {
                public TextureAtlasSprite apply(ResourceLocation location)
                {
                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
                }
            };

    public void doRender(EntityMongoose par1EntityMongoose, double posX, double posY, double posZ, float yaw, float partialTicks) throws IOException
    {
    	IModel mongoose = ModelLoaderRegistry.getModel(mongooseModel);
    	IBakedModel bakedMongoose = mongoose.bake((TRSRTransformation.identity()),  Attributes.DEFAULT_BAKED_FORMAT, textureGetter);
    	World world = par1EntityMongoose.getWorldObj();
    	BlockPos blockpos = new BlockPos(par1EntityMongoose);
    	Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY + 0.52F, (float)posZ);

        float f2 = (float)par1EntityMongoose.getTimeSinceHit() - partialTicks;
        float f3 = par1EntityMongoose.getDamageTaken() - partialTicks;

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        if (f2 > 0.0F)
        {
            GlStateManager.rotate(MathHelper.sin(f2) * f2 * f3 / 10.0F * (float)par1EntityMongoose.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }
        
        float f4 = 0.75F;
        GlStateManager.scale(f4, f4, f4);
        GlStateManager.scale(1.0F / f4, 1.0F / f4, 1.0F / f4);
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        
        if(par1EntityMongoose.riddenByEntity != null && par1EntityMongoose.riddenByEntity instanceof EntityPlayer)
		{
			EntityPlayer playerIn = (EntityPlayer) par1EntityMongoose.riddenByEntity;
			GlStateManager.rotate(playerIn.rotationYawHead, 0F, 1F, 0F);
		}
        
        worldrenderer.startDrawingQuads();
        GlStateManager.rotate(180f, 0f, 0f, 1f);
        //Get Quads
        List<BakedQuad> generalQuads = bakedMongoose.getGeneralQuads();
		for (BakedQuad q : generalQuads) {
			int[] vd = q.getVertexData();
			worldrenderer.setVertexFormat(Attributes.DEFAULT_BAKED_FORMAT);
			worldrenderer.addVertexData(vd);
		}
		for (EnumFacing face : EnumFacing.values()) {
            List<BakedQuad> faceQuads = 
           		 bakedMongoose.getFaceQuads(face);
            for (BakedQuad q : faceQuads) {
                    int[] vd = q.getVertexData();
                    worldrenderer.setVertexFormat(Attributes.DEFAULT_BAKED_FORMAT);
                   worldrenderer.addVertexData(vd);
           }
		 }
		tessellator.draw();
        GlStateManager.popMatrix();
        super.doRender(par1EntityMongoose, posX, posY, posZ, yaw, partialTicks);
    }

    protected ResourceLocation getEntityTexture(EntityMongoose entity)
    {
        return null;
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return null;
    }

    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks)
    {
        try {
			this.doRender((EntityMongoose)entity, x, y, z, yaw, partialTicks);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}