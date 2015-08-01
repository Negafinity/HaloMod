package halocraft.handlers;

import halocraft.entities.EntityScorpion;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VehicleEventHandler {

	Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onRenderPlayerEvent(RenderPlayerEvent.Pre event)
	{
		if(event.entityPlayer.isRiding() && event.entityPlayer.ridingEntity instanceof EntityScorpion)
		{
			event.setCanceled(true);
		}
	}
}
