package com.arisux.xlib.client.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class Model extends ModelBase
{
    public static final float DEFAULT_BOX_TRANSLATION = 0.0625F;

    /**
     * Set the width and height of this ModelBaseExtension's texture.
     *
     * @param textureWidth - The texture width in pixels
     * @param textureHeight - The texture height in pixels
     */
    public void setTextureDimensions(int textureWidth, int textureHeight)
    {
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
    }

    /**
     * Set the rotation angles of the specified ModelRenderer instance.
     */
    public void setRotation(ModelRenderer model, float rotateAngleX, float rotateAngleY, float rotateAngleZ)
    {
        model.rotateAngleX = rotateAngleX;
        model.rotateAngleY = rotateAngleY;
        model.rotateAngleZ = rotateAngleZ;
    }

    /**
     * A standard rendering argument. Does not call any super class methods.
     * @param boxTranslation - Box translation offset.
     */
    public void render(float boxTranslation)
    {
        super.render(null, 0F, 0F, 0F, 0F, 0F, boxTranslation);
    }

    /**
     * A standard rendering argument. Does not call any super class methods.
     */
    public void render()
    {
        this.render(DEFAULT_BOX_TRANSLATION);
    }

    /**
     * The standard render method from ModelBase with correct parameter mappings. Calls the superclass method.
     *
     * @param entity - The Entity instance being rendered.
     * @param swingProgress - The arm swing progress of the Entity being rendered.
     * @param swingProgressPrev - The previous tick's arm swing progress of the Entity being rendered.
     * @param idleProgress - The idle arm swing progress of the Entity being rendered.
     * @param headYaw - The head rotation yaw of the Entity being rendered.
     * @param headPitch - The head rotation pitch of the Entity being rendered.
     * @param boxTranslation - The box translation offset. Default value is 0.0625F
     */
    @Override
    public void render(Entity entity, float swingProgress, float swingProgressPrev, float idleProgress, float headYaw, float headPitch, float boxTranslation)
    {
        super.render(entity, swingProgress, swingProgressPrev, idleProgress, headYaw, headPitch, boxTranslation);
    }

    /**
     * The standard setRotationAngles method from ModelBase with correct parameter mappings. Calls the superclass method.
     *
     * @param swingProgress - The arm swing progress of the Entity being rendered.
     * @param swingProgressPrev - The previous tick's arm swing progress of the Entity being rendered.
     * @param idleProgress - The idle arm swing progress of the Entity being rendered.
     * @param headYaw - The head rotation yaw of the Entity being rendered.
     * @param headPitch - The head rotation pitch of the Entity being rendered.
     * @param boxTranslation - The box translation offset. Default value is 0.0625F
     * @param entity - The Entity instance being rendered.
     */
    @Override
    public void setRotationAngles(float swingProgress, float swingProgressPrev, float idleProgress, float headYaw, float headPitch, float boxTranslation, Entity entity)
    {
        super.setRotationAngles(swingProgress, swingProgressPrev, idleProgress, headYaw, headPitch, boxTranslation, entity);
    }
}