package io.github.hsyyid.halocraft.handlers;

import io.github.hsyyid.halocraft.entities.vehicles.EntityScorpion;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VehicleEventHandler
{
	@SubscribeEvent
	public void onRenderPlayerEvent(RenderPlayerEvent.Pre event)
	{
		if (event.getEntityPlayer().isRiding() && event.getEntityPlayer().getRidingEntity() instanceof EntityScorpion)
		{
			event.setCanceled(true);
		}
	}
}
