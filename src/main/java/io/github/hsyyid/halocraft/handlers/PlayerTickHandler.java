package io.github.hsyyid.halocraft.handlers;

import io.github.hsyyid.halocraft.proxies.CommonProxy;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerTickHandler
{
	@SubscribeEvent
	public void onClientTick(TickEvent.PlayerTickEvent event)
	{
		if (event.player.inventory.armorInventory[2] != null && event.player.inventory.armorInventory[2].getItem().equals(CommonProxy.jetpack))
		{
			event.player.capabilities.allowFlying = true;
			event.player.sendPlayerAbilities();

			if (event.player.capabilities.isFlying)
			{
				event.player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, event.player.posX, event.player.posY, event.player.posZ, 0, -0.05, 0, 0);
			}
		}
		else if (!(event.player.capabilities.isCreativeMode))
		{
			event.player.capabilities.allowFlying = false;
			event.player.sendPlayerAbilities();
		}
	}
}
