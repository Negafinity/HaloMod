package halocraft.handlers;

import halocraft.Main;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HaloEventHandler
{
	@SubscribeEvent
	public void onClientTick(TickEvent.PlayerTickEvent event)
	{
		if (event.player.inventory.armorInventory[2] != null && event.player.inventory.armorInventory[2].getItem().equals(halocraft.Main.Jetpack))
		{
			event.player.capabilities.allowFlying = true;
			if (event.player.capabilities.isFlying)
			{
				event.player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, event.player.posX, event.player.posY, event.player.posZ, 0, -0.05, 0, 0);
			}
		}
		else if ((event.player.inventory.armorInventory[2] == null && !(event.player.capabilities.isCreativeMode)) || (event.player.inventory.armorInventory[2] != null && !(event.player.capabilities.isCreativeMode)))
		{
			event.player.capabilities.allowFlying = false;
		}
	}
}
