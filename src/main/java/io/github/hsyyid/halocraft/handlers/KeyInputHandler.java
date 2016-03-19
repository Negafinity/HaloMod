package io.github.hsyyid.halocraft.handlers;

import com.mojang.realmsclient.gui.ChatFormatting;
import io.github.hsyyid.halocraft.KeyBindings;
import io.github.hsyyid.halocraft.entities.EntityGhost;
import io.github.hsyyid.halocraft.entities.EntityScorpion;
import io.github.hsyyid.halocraft.items.firearms.ItemBattleRifle;
import io.github.hsyyid.halocraft.items.firearms.ItemSniperRifle;
import io.github.hsyyid.halocraft.packets.FireMessage;
import io.github.hsyyid.halocraft.packets.HalocraftPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler
{
	private Minecraft mc = Minecraft.getMinecraft();
	World worldIn = mc.theWorld;
	EntityPlayer playerIn = mc.thePlayer;
	public static boolean keyPressed = false;
	public static int fire = 0;

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		if (KeyBindings.scope.isPressed())
		{
			if (mc.thePlayer.getHeldItemMainhand() != null)
			{
				if (mc.thePlayer.getHeldItemMainhand().getItem() == ItemBattleRifle.instance || mc.thePlayer.getHeldItemMainhand().getItem() == ItemSniperRifle.instance)
				{
					keyPressed = true;

				}
				else
				{
					mc.thePlayer.addChatMessage(new TextComponentString(ChatFormatting.BLUE + "[HaloCraft 2.0]" + ChatFormatting.RED + " This is not a weapon or does not have a scope."));
				}
			}
			else
			{
				mc.thePlayer.addChatMessage(new TextComponentString(ChatFormatting.BLUE + "[HaloCraft 2.0]" + ChatFormatting.RED + " You're not holding anything!"));
			}
		}
		else if (KeyBindings.fire.isPressed())
		{
			if (mc.thePlayer.isRiding())
			{
				Entity ridingEntity = mc.thePlayer.getRidingEntity();

				if (ridingEntity instanceof EntityScorpion)
				{
					fire = 1;
					HalocraftPacketHandler.INSTANCE.sendToServer(new FireMessage(fire));
				}
				else if (ridingEntity instanceof EntityGhost)
				{
					fire = 2;
					HalocraftPacketHandler.INSTANCE.sendToServer(new FireMessage(fire));
				}
				else
				{
					mc.thePlayer.addChatMessage(new TextComponentString(ChatFormatting.BLUE + "[HaloCraft 2.0]" + ChatFormatting.RED + " This is not a Scorpion!"));
				}
			}
			else
			{
				fire = 3;
				HalocraftPacketHandler.INSTANCE.sendToServer(new FireMessage(fire));
			}

		}
		else
		{
			keyPressed = false;
		}
	}

}
