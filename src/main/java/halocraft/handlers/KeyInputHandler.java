package halocraft.handlers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import halocraft.KeyBindings;
import halocraft.Main;
import halocraft.entities.EntityMongoose;
import halocraft.entities.EntityRocket;
import halocraft.entities.EntityScorpion;
import halocraft.items.ItemBattleRifle;
import halocraft.packets.FireMessage;
import halocraft.packets.HalocraftPacketHandler;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler{
	private Minecraft mc = Minecraft.getMinecraft();
	World worldIn = mc.theWorld;
	EntityPlayer playerIn = mc.thePlayer;
	public static boolean keyPressed = false;
	public static int fire = 0;
	
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyBindings.scope.isPressed()){
        	if(mc.thePlayer.getHeldItem() != null){
        		if(mc.thePlayer.getHeldItem().getItem() == ItemBattleRifle.instance){
        			keyPressed = true;

            	}
            	else{
            		mc.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HaloCraft 2.0]" + EnumChatFormatting.RED + " This is not a weapon or does not have a scope."));
            	}
        	}
        	else{
        		mc.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HaloCraft 2.0]" + EnumChatFormatting.RED + " You're not holding anything!"));
        	}
        }
        else if(KeyBindings.fire.isPressed()){
        	if(mc.thePlayer.isRiding()){
        		Entity ridingEntity = mc.thePlayer.ridingEntity;
        		if(ridingEntity instanceof EntityScorpion){
        			fire = 1;
        			HalocraftPacketHandler.INSTANCE.sendToServer(new FireMessage(fire));
        		}
        		else{
        			mc.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HaloCraft 2.0]" + EnumChatFormatting.RED + " This is not a Scorpion!"));
        		}
        	}
        	else{
        		mc.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HaloCraft 2.0]" + EnumChatFormatting.RED + " You're not riding anything!"));
        	}
        	
        }
        else{
        	keyPressed = false;
        }
    }

}
