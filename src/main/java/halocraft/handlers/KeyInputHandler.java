package halocraft.handlers;

import halocraft.KeyBindings;
import halocraft.Main;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler{
	private Minecraft mc = Minecraft.getMinecraft();
	public static boolean keyPressed = false;
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyBindings.scope.isPressed()){
        	if(mc.thePlayer.getHeldItem() != null){
        		if(mc.thePlayer.getHeldItem().getItem() == halocraft.Main.itemBattleRifle){
        			keyPressed = true;

            	}
            	else{
            		mc.thePlayer.addChatMessage(new ChatComponentText("[HaloCraft 2.0] This is not a weapon or does not have a scope."));
            	}
        	}
        	else{
        		mc.thePlayer.addChatMessage(new ChatComponentText("[HaloCraft 2.0] You're not holding anything!"));
        	}
        }
        else{
        	keyPressed = false;
        }
    }

}
