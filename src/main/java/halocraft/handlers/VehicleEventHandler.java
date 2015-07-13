package halocraft.handlers;

import halocraft.entities.EntityScorpion;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VehicleEventHandler {

	Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onRenderPlayerEvent(RenderPlayerEvent.Pre event)
	{
		if(mc.thePlayer.isRiding() && mc.thePlayer.ridingEntity instanceof EntityScorpion)
		{
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent.Pre event)
	{
		if(mc.thePlayer.isRiding() && mc.thePlayer.ridingEntity instanceof EntityScorpion)
		{
			if(event.type == event.type.HOTBAR)
			{
				event.setCanceled(true);
			}
		}
	}
}
