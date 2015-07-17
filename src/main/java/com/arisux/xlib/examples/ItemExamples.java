package com.arisux.xlib.examples;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.lwjgl.util.Color;

public class ItemExamples
{
    public static Item itemTest = new Item().setUnlocalizedName("itemTest");

    public void register()
    {
        GameRegistry.registerItem(itemTest, "itemTest");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemTest, 0, new ModelResourceLocation("examplemod:itemTest", "inventory"));
    }
}
