package io.github.hsyyid.halocraft.handlers;

import io.github.hsyyid.halocraft.items.firearms.ItemAssaultRifle;
import io.github.hsyyid.halocraft.items.firearms.ItemBattleRifle;
import io.github.hsyyid.halocraft.items.firearms.ItemBoltshot;
import io.github.hsyyid.halocraft.items.firearms.ItemShotgun;
import io.github.hsyyid.halocraft.items.firearms.render.AssaultRifleItemRenderer;
import io.github.hsyyid.halocraft.items.firearms.render.BattleRifleItemRenderer;
import io.github.hsyyid.halocraft.items.firearms.render.BoltshotItemRenderer;
import io.github.hsyyid.halocraft.items.firearms.render.ShotgunItemRenderer;
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
		event.getModelRegistry().putObject(new ModelResourceLocation("halocraft:" + ItemBoltshot.name, "inventory"), new BoltshotItemRenderer());
		event.getModelRegistry().putObject(new ModelResourceLocation("halocraft:" + ItemAssaultRifle.name, "inventory"), new AssaultRifleItemRenderer());
		event.getModelRegistry().putObject(new ModelResourceLocation("halocraft:" + ItemShotgun.name, "inventory"), new ShotgunItemRenderer());
	}
}
