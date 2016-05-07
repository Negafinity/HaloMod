package io.github.hsyyid.halocraft.proxies;

import io.github.hsyyid.halocraft.KeyBindings;
import io.github.hsyyid.halocraft.blocks.ForerunnerFloorBlock;
import io.github.hsyyid.halocraft.blocks.ForerunnerWallBlock;
import io.github.hsyyid.halocraft.blocks.HaloBlock;
import io.github.hsyyid.halocraft.blocks.RoofBlock;
import io.github.hsyyid.halocraft.blocks.SteelBlock;
import io.github.hsyyid.halocraft.blocks.TitaniumBlock;
import io.github.hsyyid.halocraft.entities.EntityBlueElite;
import io.github.hsyyid.halocraft.entities.EntityBullet;
import io.github.hsyyid.halocraft.entities.EntityElite;
import io.github.hsyyid.halocraft.entities.EntityFragGrenade;
import io.github.hsyyid.halocraft.entities.EntityGreenPlasma;
import io.github.hsyyid.halocraft.entities.EntityGrunt;
import io.github.hsyyid.halocraft.entities.EntityMarine;
import io.github.hsyyid.halocraft.entities.EntityOrangePlasma;
import io.github.hsyyid.halocraft.entities.EntityPlasmaRocket;
import io.github.hsyyid.halocraft.entities.EntityPromethean;
import io.github.hsyyid.halocraft.entities.EntityPulseGrenade;
import io.github.hsyyid.halocraft.entities.EntityPurplePlasma;
import io.github.hsyyid.halocraft.entities.EntityRedElite;
import io.github.hsyyid.halocraft.entities.EntityRedPlasma;
import io.github.hsyyid.halocraft.entities.EntityRocket;
import io.github.hsyyid.halocraft.entities.render.RenderBlueEliteEntity;
import io.github.hsyyid.halocraft.entities.render.RenderBulletEntity;
import io.github.hsyyid.halocraft.entities.render.RenderEliteEntity;
import io.github.hsyyid.halocraft.entities.render.RenderGreenPlasmaEntity;
import io.github.hsyyid.halocraft.entities.render.RenderGruntEntity;
import io.github.hsyyid.halocraft.entities.render.RenderMarineEntity;
import io.github.hsyyid.halocraft.entities.render.RenderOrangePlasmaEntity;
import io.github.hsyyid.halocraft.entities.render.RenderPlasmaRocketEntity;
import io.github.hsyyid.halocraft.entities.render.RenderPrometheanEntity;
import io.github.hsyyid.halocraft.entities.render.RenderPurplePlasmaEntity;
import io.github.hsyyid.halocraft.entities.render.RenderRedEliteEntity;
import io.github.hsyyid.halocraft.entities.render.RenderRedPlasmaEntity;
import io.github.hsyyid.halocraft.entities.render.RenderRocketEntity;
import io.github.hsyyid.halocraft.entities.vehicles.EntityGhost;
import io.github.hsyyid.halocraft.entities.vehicles.EntityMongoose;
import io.github.hsyyid.halocraft.entities.vehicles.EntityScorpion;
import io.github.hsyyid.halocraft.entities.vehicles.EntityWarthog;
import io.github.hsyyid.halocraft.entities.vehicles.EntityWarthogTurret;
import io.github.hsyyid.halocraft.entities.vehicles.render.RenderGhostEntity;
import io.github.hsyyid.halocraft.entities.vehicles.render.RenderMongooseEntity;
import io.github.hsyyid.halocraft.entities.vehicles.render.RenderScorpionEntity;
import io.github.hsyyid.halocraft.entities.vehicles.render.RenderWarthogEntity;
import io.github.hsyyid.halocraft.entities.vehicles.render.RenderWarthogTurretEntity;
import io.github.hsyyid.halocraft.handlers.HaloGUIEventHandler;
import io.github.hsyyid.halocraft.handlers.KeyInputHandler;
import io.github.hsyyid.halocraft.handlers.ModelBakeEventHandler;
import io.github.hsyyid.halocraft.handlers.PlayerTickHandler;
import io.github.hsyyid.halocraft.handlers.VehicleEventHandler;
import io.github.hsyyid.halocraft.items.FragGrenade;
import io.github.hsyyid.halocraft.items.GreenPlasmaIngot;
import io.github.hsyyid.halocraft.items.ItemCarbineAmmo;
import io.github.hsyyid.halocraft.items.ItemEnergySword;
import io.github.hsyyid.halocraft.items.ItemForerunnerShard;
import io.github.hsyyid.halocraft.items.ItemHealthPack;
import io.github.hsyyid.halocraft.items.ItemNeedlerAmmo;
import io.github.hsyyid.halocraft.items.ItemRedPlasmaAmmo;
import io.github.hsyyid.halocraft.items.PrometheanSword;
import io.github.hsyyid.halocraft.items.PulseGrenade;
import io.github.hsyyid.halocraft.items.PurplePlasmaIngot;
import io.github.hsyyid.halocraft.items.RedPlasmaIngot;
import io.github.hsyyid.halocraft.items.SteelIngot;
import io.github.hsyyid.halocraft.items.TitaniumIngot;
import io.github.hsyyid.halocraft.items.firearms.ItemAssaultRifle;
import io.github.hsyyid.halocraft.items.firearms.ItemBattleRifle;
import io.github.hsyyid.halocraft.items.firearms.ItemBoltshot;
import io.github.hsyyid.halocraft.items.firearms.ItemCarbineRifle;
import io.github.hsyyid.halocraft.items.firearms.ItemFuelRodCannon;
import io.github.hsyyid.halocraft.items.firearms.ItemIncinerationCannon;
import io.github.hsyyid.halocraft.items.firearms.ItemLightRifle;
import io.github.hsyyid.halocraft.items.firearms.ItemNeedler;
import io.github.hsyyid.halocraft.items.firearms.ItemRocketLauncher;
import io.github.hsyyid.halocraft.items.firearms.ItemScattershot;
import io.github.hsyyid.halocraft.items.firearms.ItemShotgun;
import io.github.hsyyid.halocraft.items.firearms.ItemSniperRifle;
import io.github.hsyyid.halocraft.items.firearms.ItemSpartanLaser;
import io.github.hsyyid.halocraft.items.firearms.ItemSuppressor;
import io.github.hsyyid.halocraft.items.firearms.Pistol;
import io.github.hsyyid.halocraft.items.firearms.PlasmaRifle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerItemRenderers()
	{
		ModelResourceLocation res = new ModelResourceLocation("halocraft:TankHarvester", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.tankHarvester, 0, res);
		ModelResourceLocation res2 = new ModelResourceLocation("halocraft:SpartaniumIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.spartaniumIngot, 0, res2);
		ModelResourceLocation res3 = new ModelResourceLocation("halocraft:SpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.spartanChestplate, 0, res3);
		ModelResourceLocation res4 = new ModelResourceLocation("halocraft:SpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.spartanHelmet, 0, res4);
		ModelResourceLocation res5 = new ModelResourceLocation("halocraft:SpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.spartanLeggings, 0, res5);
		ModelResourceLocation res6 = new ModelResourceLocation("halocraft:SpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.spartanBoots, 0, res6);
		ModelResourceLocation res7 = new ModelResourceLocation("halocraft:ammoRocket", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.ammoRocket, 0, res7);
		ModelResourceLocation res9 = new ModelResourceLocation("halocraft:ammoAssaultRifle", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.ammoAssaultRifle, 0, res9);

		// Rendering Promethean Armor
		ModelResourceLocation resource1 = new ModelResourceLocation("halocraft:prometheanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.prometheanHelmet, 0, resource1);
		ModelResourceLocation resource2 = new ModelResourceLocation("halocraft:PrometheanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.prometheanChestplate, 0, resource2);
		ModelResourceLocation resource3 = new ModelResourceLocation("halocraft:PrometheanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.prometheanLeggings, 0, resource3);
		ModelResourceLocation resource4 = new ModelResourceLocation("halocraft:PrometheanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.prometheanBoots, 0, resource4);

		// Rendering Spartan Locke Armor
		ModelResourceLocation lockeResource1 = new ModelResourceLocation("halocraft:SpartanLockeHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.spartanLockeHelmet, 0, lockeResource1);
		ModelResourceLocation lockeResource2 = new ModelResourceLocation("halocraft:SpartanLockeChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.spartanLockeChestplate, 0, lockeResource2);
		ModelResourceLocation lockeResource3 = new ModelResourceLocation("halocraft:SpartanLockeLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.spartanLockeLeggings, 0, lockeResource3);
		ModelResourceLocation lockeResource4 = new ModelResourceLocation("halocraft:SpartanLockeBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.spartanLockeBoots, 0, lockeResource4);

		// Rendering Grenadier Armor
		ModelResourceLocation greenGrenadierReso1 = new ModelResourceLocation("halocraft:GreenGrenadierHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.greenGrenadierHelmet, 0, greenGrenadierReso1);
		ModelResourceLocation greenGrenadierReso2 = new ModelResourceLocation("halocraft:GreenGrenadierChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.greenGrenadierChestplate, 0, greenGrenadierReso2);
		ModelResourceLocation greenGrenadierReso3 = new ModelResourceLocation("halocraft:GreenGrenadierLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.greenGrenadierLeggings, 0, greenGrenadierReso3);
		ModelResourceLocation greenGrenadierReso4 = new ModelResourceLocation("halocraft:GreenGrenadierBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.greenGrenadierBoots, 0, greenGrenadierReso4);

		ModelResourceLocation orangeGrenadierReso1 = new ModelResourceLocation("halocraft:OrangeGrenadierHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.orangeGrenadierHelmet, 0, orangeGrenadierReso1);
		ModelResourceLocation orangeGrenadierReso2 = new ModelResourceLocation("halocraft:OrangeGrenadierChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.orangeGrenadierChestplate, 0, orangeGrenadierReso2);
		ModelResourceLocation orangeGrenadierReso3 = new ModelResourceLocation("halocraft:OrangeGrenadierLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.orangeGrenadierLeggings, 0, orangeGrenadierReso3);
		ModelResourceLocation orangeGrenadierReso4 = new ModelResourceLocation("halocraft:OrangeGrenadierBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.orangeGrenadierBoots, 0, orangeGrenadierReso4);

		// Rendering Recon Armor
		ModelResourceLocation reconReso1 = new ModelResourceLocation("halocraft:ReconHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.reconHelmet, 0, reconReso1);
		ModelResourceLocation reconReso2 = new ModelResourceLocation("halocraft:ReconChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.reconChestplate, 0, reconReso2);
		ModelResourceLocation reconReso3 = new ModelResourceLocation("halocraft:ReconLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.reconLeggings, 0, reconReso3);
		ModelResourceLocation reconReso4 = new ModelResourceLocation("halocraft:ReconBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.reconBoots, 0, reconReso4);

		ModelResourceLocation redReconReso1 = new ModelResourceLocation("halocraft:RedReconHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redReconHelmet, 0, redReconReso1);
		ModelResourceLocation redReconReso2 = new ModelResourceLocation("halocraft:RedReconChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redReconChestplate, 0, redReconReso2);
		ModelResourceLocation redReconReso3 = new ModelResourceLocation("halocraft:RedReconLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redReconLeggings, 0, redReconReso3);
		ModelResourceLocation redReconReso4 = new ModelResourceLocation("halocraft:RedReconBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redReconBoots, 0, redReconReso4);

		ModelResourceLocation blueReconReso1 = new ModelResourceLocation("halocraft:BlueReconHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueReconHelmet, 0, blueReconReso1);
		ModelResourceLocation blueReconReso2 = new ModelResourceLocation("halocraft:BlueReconChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueReconChestplate, 0, blueReconReso2);
		ModelResourceLocation blueReconReso3 = new ModelResourceLocation("halocraft:BlueReconLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueReconLeggings, 0, blueReconReso3);
		ModelResourceLocation blueReconReso4 = new ModelResourceLocation("halocraft:BlueReconBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueReconBoots, 0, blueReconReso4);

		// Rendering Marine Armor
		ModelResourceLocation reso1 = new ModelResourceLocation("halocraft:MarineHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.marineHelmet, 0, reso1);
		ModelResourceLocation reso2 = new ModelResourceLocation("halocraft:MarineChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.marineChestplate, 0, reso2);
		ModelResourceLocation reso3 = new ModelResourceLocation("halocraft:MarineLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.marineLeggings, 0, reso3);
		ModelResourceLocation reso4 = new ModelResourceLocation("halocraft:MarineBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.marineBoots, 0, reso4);

		ModelResourceLocation reso5 = new ModelResourceLocation("halocraft:RedMarineHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redMarineHelmet, 0, reso5);
		ModelResourceLocation reso6 = new ModelResourceLocation("halocraft:RedMarineChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redMarineChestplate, 0, reso6);
		ModelResourceLocation reso7 = new ModelResourceLocation("halocraft:RedMarineLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redMarineLeggings, 0, reso7);
		ModelResourceLocation reso8 = new ModelResourceLocation("halocraft:RedMarineBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redMarineBoots, 0, reso8);

		ModelResourceLocation reso9 = new ModelResourceLocation("halocraft:BlueMarineHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueMarineHelmet, 0, reso9);
		ModelResourceLocation reso10 = new ModelResourceLocation("halocraft:BlueMarineChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueMarineChestplate, 0, reso10);
		ModelResourceLocation reso11 = new ModelResourceLocation("halocraft:BlueMarineLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueMarineLeggings, 0, reso11);
		ModelResourceLocation reso12 = new ModelResourceLocation("halocraft:BlueMarineBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueMarineBoots, 0, reso12);

		// Registering Red Spartan Armor
		ModelResourceLocation res13 = new ModelResourceLocation("halocraft:RedSpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redSpartanChestplate, 0, res13);
		ModelResourceLocation res14 = new ModelResourceLocation("halocraft:RedSpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redSpartanHelmet, 0, res14);
		ModelResourceLocation res15 = new ModelResourceLocation("halocraft:RedSpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redSpartanLeggings, 0, res15);
		ModelResourceLocation res16 = new ModelResourceLocation("halocraft:RedSpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.redSpartanBoots, 0, res16);

		// Rendering Green Spartan Armor
		ModelResourceLocation res17 = new ModelResourceLocation("halocraft:GreenSpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.greenSpartanChestplate, 0, res17);
		ModelResourceLocation res18 = new ModelResourceLocation("halocraft:GreenSpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.greenSpartanHelmet, 0, res18);
		ModelResourceLocation res19 = new ModelResourceLocation("halocraft:GreenSpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.greenSpartanLeggings, 0, res19);
		ModelResourceLocation res20 = new ModelResourceLocation("halocraft:GreenSpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.greenSpartanBoots, 0, res20);

		// Rendering Blue Spartan Armor
		ModelResourceLocation res21 = new ModelResourceLocation("halocraft:BlueSpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueSpartanChestplate, 0, res21);
		ModelResourceLocation res22 = new ModelResourceLocation("halocraft:BlueSpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueSpartanHelmet, 0, res22);
		ModelResourceLocation res23 = new ModelResourceLocation("halocraft:BlueSpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueSpartanLeggings, 0, res23);
		ModelResourceLocation res24 = new ModelResourceLocation("halocraft:BlueSpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.blueSpartanBoots, 0, res24);
		ModelResourceLocation res25 = new ModelResourceLocation("halocraft:covenantPiece", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.covenantPiece, 0, res25);

		// Rendering Default Covenant Armor
		ModelResourceLocation res26 = new ModelResourceLocation("halocraft:CovenantChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.covenantChestplate, 0, res26);
		ModelResourceLocation res27 = new ModelResourceLocation("halocraft:CovenantHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.covenantHelmet, 0, res27);
		ModelResourceLocation res28 = new ModelResourceLocation("halocraft:CovenantLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.covenantLeggings, 0, res28);
		ModelResourceLocation res29 = new ModelResourceLocation("halocraft:CovenantBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.covenantBoots, 0, res29);

		// Rendering ActiveCamo Armor
		ModelResourceLocation res30 = new ModelResourceLocation("halocraft:ActiveCamoChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.activeCamoChestplate, 0, res30);

		// Rendering Plasma Ammo
		ModelResourceLocation res32 = new ModelResourceLocation("halocraft:ammoPlasma", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.ammoPlasma, 0, res32);

		ModelResourceLocation res35 = new ModelResourceLocation("halocraft:RedPlasmaIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(RedPlasmaIngot.instance, 0, res35);

		ModelResourceLocation res37 = new ModelResourceLocation("halocraft:GreenPlasmaIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(GreenPlasmaIngot.instance, 0, res37);

		ModelResourceLocation res38 = new ModelResourceLocation("halocraft:ammoPlasmaRocket", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.ammoPlasmaRocket, 0, res38);

		ModelResourceLocation res39 = new ModelResourceLocation("halocraft:PurplePlasmaIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(PurplePlasmaIngot.instance, 0, res39);

		ModelResourceLocation res40 = new ModelResourceLocation("halocraft:itemWheel", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.itemWheel, 0, res40);

		ModelResourceLocation res41 = new ModelResourceLocation("halocraft:itemOil", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.itemOil, 0, res41);

		ModelResourceLocation res42 = new ModelResourceLocation("halocraft:itemRubber", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.itemRubber, 0, res42);

		ModelResourceLocation res43 = new ModelResourceLocation("halocraft:" + ItemForerunnerShard.name, "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ItemForerunnerShard.instance, 0, res43);

		ModelResourceLocation res44 = new ModelResourceLocation("halocraft:ammoPrometheanMagazine", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.ammoPrometheanMagazine, 0, res44);

		ModelResourceLocation steelIngotRes = new ModelResourceLocation("halocraft:SteelIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SteelIngot.instance, 0, steelIngotRes);

		ModelResourceLocation titaniumIngotRes = new ModelResourceLocation("halocraft:TitaniumIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TitaniumIngot.instance, 0, titaniumIngotRes);

		ModelResourceLocation jetPackRes = new ModelResourceLocation("halocraft:Jetpack", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.jetpack, 0, jetPackRes);

		ModelResourceLocation antiChipRes = new ModelResourceLocation("halocraft:itemAntiChip", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.itemAntiChip, 0, antiChipRes);

		ModelResourceLocation fusionCoilRes = new ModelResourceLocation("halocraft:itemFusionCoil", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CommonProxy.itemFusionCoil, 0, fusionCoilRes);

		// Weapons
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ItemBattleRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemBattleRifle.name, "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ItemBoltshot.instance, 0, new ModelResourceLocation("halocraft:" + ItemBoltshot.name, "inventory"));
	}

	@Override
	public void registerEntityRenderers()
	{
		// TODO: Fix deprecated shizzles
		RenderingRegistry.registerEntityRenderingHandler(EntityPulseGrenade.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), PulseGrenade.instance, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityFragGrenade.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), FragGrenade.instance, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(EntityMongoose.class, RenderMongooseEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, RenderGhostEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityWarthog.class, RenderWarthogEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityWarthogTurret.class, RenderWarthogTurretEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, RenderScorpionEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, RenderBulletEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, RenderRocketEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityPlasmaRocket.class, RenderPlasmaRocketEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRedPlasma.class, RenderRedPlasmaEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenPlasma.class, RenderGreenPlasmaEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityPurplePlasma.class, RenderPurplePlasmaEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityOrangePlasma.class, RenderOrangePlasmaEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityElite.class, RenderEliteEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRedElite.class, RenderRedEliteEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueElite.class, RenderBlueEliteEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityPromethean.class, RenderPrometheanEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityMarine.class, RenderMarineEntity::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGrunt.class, RenderGruntEntity::new);
	}

	@Override
	public void registerBlockRenderers()
	{
		// Rendering Blocks
		Item itemHaloBlock = Item.itemRegistry.getObject(new ResourceLocation("halocraft", HaloBlock.name));
		Item itemHaloOre = Item.itemRegistry.getObject(new ResourceLocation("halocraft", "HaloOre"));
		Item itemForerunnerOre = Item.itemRegistry.getObject(new ResourceLocation("halocraft", "ForerunnerOre"));
		Item itemRedPlasmaOre = Item.itemRegistry.getObject(new ResourceLocation("halocraft", "RedPlasmaOre"));
		Item itemGreenPlasmaOre = Item.itemRegistry.getObject(new ResourceLocation("halocraft", "GreenPlasmaOre"));
		Item itemPurplePlasmaOre = Item.itemRegistry.getObject(new ResourceLocation("halocraft", "PurplePlasmaOre"));
		Item itemPurplePlasmaBlock = Item.itemRegistry.getObject(new ResourceLocation("halocraft", "PurplePlasmaBlock"));
		Item itemRedPlasmaBlock = Item.itemRegistry.getObject(new ResourceLocation("halocraft", "RedPlasmaBlock"));
		Item itemRoofBlock = Item.itemRegistry.getObject(new ResourceLocation("halocraft", RoofBlock.name));
		Item itemWallBlock = Item.itemRegistry.getObject(new ResourceLocation("halocraft", ForerunnerWallBlock.name));
		Item itemFloorBlock = Item.itemRegistry.getObject(new ResourceLocation("halocraft", ForerunnerFloorBlock.name));
		Item itemTitaniumBlock = Item.itemRegistry.getObject(new ResourceLocation("halocraft", TitaniumBlock.name));
		Item itemSteelBlock = Item.itemRegistry.getObject(new ResourceLocation("halocraft", SteelBlock.name));

		ModelResourceLocation forerunnerOreBlockResourceLocation = new ModelResourceLocation("halocraft:ForerunnerOre", "inventory");
		ModelResourceLocation roofBlockResourceLocation = new ModelResourceLocation("halocraft:RoofBlock", "inventory");
		ModelResourceLocation wallBlockResourceLocation = new ModelResourceLocation("halocraft:ForerunnerWallBlock", "inventory");
		ModelResourceLocation floorBlockResourceLocation = new ModelResourceLocation("halocraft:ForerunnerFloorBlock", "inventory");
		ModelResourceLocation haloBlockResourceLocation = new ModelResourceLocation("halocraft:HaloBlock", "inventory");
		ModelResourceLocation purplePlasmaBlockResourceLocation = new ModelResourceLocation("halocraft:PurplePlasmaBlock", "inventory");
		ModelResourceLocation haloOreResourceLocation = new ModelResourceLocation("halocraft:HaloOre", "inventory");
		ModelResourceLocation redPlasmaOreModelResourceLocation = new ModelResourceLocation("halocraft:RedPlasmaOre", "inventory");
		ModelResourceLocation greenPlasmaOreModelResourceLocation = new ModelResourceLocation("halocraft:GreenPlasmaOre", "inventory");
		ModelResourceLocation purplePlasmaOreModelResourceLocation = new ModelResourceLocation("halocraft:PurplePlasmaOre", "inventory");
		ModelResourceLocation redPlasmaBlockModelResourceLocation = new ModelResourceLocation("halocraft:RedPlasmaBlock", "inventory");
		ModelResourceLocation titaniumBlockModelResourceLocation = new ModelResourceLocation("halocraft:TitaniumBlock", "inventory");
		ModelResourceLocation steelBlockModelResourceLocation = new ModelResourceLocation("halocraft:SteelBlock", "inventory");

		final int DEFAULT_ITEM_SUBTYPE = 0;

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemHaloOre, DEFAULT_ITEM_SUBTYPE, haloOreResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemHaloBlock, DEFAULT_ITEM_SUBTYPE, haloBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemRedPlasmaOre, DEFAULT_ITEM_SUBTYPE, redPlasmaOreModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemGreenPlasmaOre, DEFAULT_ITEM_SUBTYPE, greenPlasmaOreModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemPurplePlasmaOre, DEFAULT_ITEM_SUBTYPE, purplePlasmaOreModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemPurplePlasmaBlock, DEFAULT_ITEM_SUBTYPE, purplePlasmaBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemRedPlasmaBlock, DEFAULT_ITEM_SUBTYPE, redPlasmaBlockModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemRoofBlock, DEFAULT_ITEM_SUBTYPE, roofBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemWallBlock, DEFAULT_ITEM_SUBTYPE, wallBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemFloorBlock, DEFAULT_ITEM_SUBTYPE, floorBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemForerunnerOre, DEFAULT_ITEM_SUBTYPE, forerunnerOreBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemTitaniumBlock, DEFAULT_ITEM_SUBTYPE, titaniumBlockModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemSteelBlock, DEFAULT_ITEM_SUBTYPE, steelBlockModelResourceLocation);
	}

	public void registerCustomModelResources()
	{
		OBJLoader.INSTANCE.addDomain("halocraft");

		ModelLoader.setCustomModelResourceLocation(PulseGrenade.instance, 0, new ModelResourceLocation("halocraft:" + PulseGrenade.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemRocketLauncher.instance, 0, new ModelResourceLocation("halocraft:" + ItemRocketLauncher.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemEnergySword.instance, 0, new ModelResourceLocation("halocraft:" + ItemEnergySword.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(PrometheanSword.instance, 0, new ModelResourceLocation("halocraft:" + PrometheanSword.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Pistol.instance, 0, new ModelResourceLocation("halocraft:" + Pistol.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemAssaultRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemAssaultRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(FragGrenade.instance, 0, new ModelResourceLocation("halocraft:" + FragGrenade.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(PlasmaRifle.instance, 0, new ModelResourceLocation("halocraft:" + PlasmaRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemCarbineRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemCarbineRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemSniperRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemSniperRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemLightRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemLightRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemCarbineAmmo.instance, 0, new ModelResourceLocation("halocraft:" + ItemCarbineAmmo.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemFuelRodCannon.instance, 0, new ModelResourceLocation("halocraft:" + ItemFuelRodCannon.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemIncinerationCannon.instance, 0, new ModelResourceLocation("halocraft:" + ItemIncinerationCannon.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemHealthPack.instance, 0, new ModelResourceLocation("halocraft:" + ItemHealthPack.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemNeedlerAmmo.instance, 0, new ModelResourceLocation("halocraft:" + ItemNeedlerAmmo.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemNeedler.instance, 0, new ModelResourceLocation("halocraft:" + ItemNeedler.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(CommonProxy.itemGhost, 0, new ModelResourceLocation("halocraft:itemGhost", "inventory"));
		ModelLoader.setCustomModelResourceLocation(CommonProxy.itemMongoose, 0, new ModelResourceLocation("halocraft:itemMongoose", "inventory"));
		ModelLoader.setCustomModelResourceLocation(CommonProxy.itemScorpion, 0, new ModelResourceLocation("halocraft:itemScorpion", "inventory"));
		ModelLoader.setCustomModelResourceLocation(CommonProxy.itemWarthog, 0, new ModelResourceLocation("halocraft:itemWarthog", "inventory"));
		ModelLoader.setCustomModelResourceLocation(CommonProxy.itemWarthogTurret, 0, new ModelResourceLocation("halocraft:itemWarthogTurret", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemRedPlasmaAmmo.instance, 0, new ModelResourceLocation("halocraft:" + ItemRedPlasmaAmmo.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemScattershot.instance, 0, new ModelResourceLocation("halocraft:" + ItemScattershot.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemSuppressor.instance, 0, new ModelResourceLocation("halocraft:" + ItemSuppressor.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemSpartanLaser.instance, 0, new ModelResourceLocation("halocraft:" + ItemSpartanLaser.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemShotgun.instance, 0, new ModelResourceLocation("halocraft:" + ItemShotgun.name, "inventory"));
	}

	public void registerHandlers()
	{
		KeyBindings.init();
		MinecraftForge.EVENT_BUS.register(new HaloGUIEventHandler(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new VehicleEventHandler());
		MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerTickHandler());
		MinecraftForge.EVENT_BUS.register(new ModelBakeEventHandler());
	}
}
