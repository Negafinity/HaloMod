package io.github.hsyyid.halocraft.handlers;

import io.github.hsyyid.halocraft.items.firearms.ItemBattleRifle;
import io.github.hsyyid.halocraft.items.firearms.render.BattleRifleItemRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelBakeEventHandler
{
	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event)
	{
		// Firearms
		event.getModelRegistry().putObject(new ModelResourceLocation("halocraft:" + ItemBattleRifle.name, "inventory"), new BattleRifleItemRenderer());
	}
}
