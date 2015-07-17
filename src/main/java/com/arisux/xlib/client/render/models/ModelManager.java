package com.arisux.xlib.client.render.models;

import net.minecraft.client.model.ModelBase;

public class ModelManager
{
    /**
     * Constructs a standard ModelBase instance from the specified class.
     *
     * @param modelClass - A class extending ModelBase which will be instantaniated.
     * @return Instance of the class specified in the modelClass parameter.
     */
    public static ModelBase createModelBase(Class<? extends ModelBase> modelClass)
    {
        try
        {
            return (modelClass.getConstructor()).newInstance(new Object[] {});
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Constructs a ModelBaseExtension instance from the specified class.
     *
     * @param modelClass - A class extending ModelBaseExtension which will be instantaniated.
     * @return Instance of the class specified in the modelClass parameter.
     */
    public static Model createModelBaseExtended(Class<? extends Model> modelClass)
    {
        try
        {
            return (modelClass.getConstructor()).newInstance(new Object[] {});
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
