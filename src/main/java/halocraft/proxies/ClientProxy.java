package halocraft.proxies;

import halocraft.KeyBindings;
import halocraft.api.OBJLoader;
import halocraft.blocks.ForerunnerFloorBlock;
import halocraft.blocks.ForerunnerWallBlock;
import halocraft.blocks.HaloBlock;
import halocraft.blocks.RoofBlock;
import halocraft.entities.EntityBlueElite;
import halocraft.entities.EntityBullet;
import halocraft.entities.EntityElite;
import halocraft.entities.EntityFragGrenade;
import halocraft.entities.EntityGhost;
import halocraft.entities.EntityGreenPlasma;
import halocraft.entities.EntityGrunt;
import halocraft.entities.EntityMarine;
import halocraft.entities.EntityMongoose;
import halocraft.entities.EntityOrangePlasma;
import halocraft.entities.EntityPlasmaRocket;
import halocraft.entities.EntityPromethean;
import halocraft.entities.EntityPulseGrenade;
import halocraft.entities.EntityPurplePlasma;
import halocraft.entities.EntityRedElite;
import halocraft.entities.EntityRedPlasma;
import halocraft.entities.EntityRocket;
import halocraft.entities.EntityScorpion;
import halocraft.entities.EntityWarthog;
import halocraft.entities.EntityWarthogTurret;
import halocraft.entities.render.RenderBlueEliteEntity;
import halocraft.entities.render.RenderBulletEntity;
import halocraft.entities.render.RenderEliteEntity;
import halocraft.entities.render.RenderGhostEntity;
import halocraft.entities.render.RenderGreenPlasmaEntity;
import halocraft.entities.render.RenderGruntEntity;
import halocraft.entities.render.RenderMarineEntity;
import halocraft.entities.render.RenderMongooseEntity;
import halocraft.entities.render.RenderOrangePlasmaEntity;
import halocraft.entities.render.RenderPlasmaRocketEntity;
import halocraft.entities.render.RenderPrometheanEntity;
import halocraft.entities.render.RenderPurplePlasmaEntity;
import halocraft.entities.render.RenderRedEliteEntity;
import halocraft.entities.render.RenderRedPlasmaEntity;
import halocraft.entities.render.RenderRocketEntity;
import halocraft.entities.render.RenderScorpionEntity;
import halocraft.entities.render.RenderWarthogEntity;
import halocraft.entities.render.RenderWarthogTurretEntity;
import halocraft.handlers.HaloEventHandler;
import halocraft.handlers.HaloGUIEventHandler;
import halocraft.handlers.KeyInputHandler;
import halocraft.handlers.VehicleEventHandler;
import halocraft.items.FragGrenade;
import halocraft.items.GreenPlasmaIngot;
import halocraft.items.ItemCarbineAmmo;
import halocraft.items.ItemEnergySword;
import halocraft.items.ItemForerunnerShard;
import halocraft.items.ItemGhost;
import halocraft.items.ItemHealthPack;
import halocraft.items.ItemMongoose;
import halocraft.items.ItemNeedlerAmmo;
import halocraft.items.ItemRedPlasmaAmmo;
import halocraft.items.ItemScorpion;
import halocraft.items.ItemWarthog;
import halocraft.items.ItemWarthogTurret;
import halocraft.items.PrometheanSword;
import halocraft.items.PulseGrenade;
import halocraft.items.PurplePlasmaIngot;
import halocraft.items.RedPlasmaIngot;
import halocraft.items.firearms.ItemAssaultRifle;
import halocraft.items.firearms.ItemBattleRifle;
import halocraft.items.firearms.ItemBoltshot;
import halocraft.items.firearms.ItemCarbineRifle;
import halocraft.items.firearms.ItemFuelRodCannon;
import halocraft.items.firearms.ItemIncinerationCannon;
import halocraft.items.firearms.ItemLightRifle;
import halocraft.items.firearms.ItemNeedler;
import halocraft.items.firearms.ItemRocketLauncher;
import halocraft.items.firearms.ItemScattershot;
import halocraft.items.firearms.ItemSniperRifle;
import halocraft.items.firearms.ItemSuppressor;
import halocraft.items.firearms.Pistol;
import halocraft.items.firearms.PlasmaRifle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenders()
	{
		ModelResourceLocation res = new ModelResourceLocation("halocraft:TankHarvester", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.tankHarvester, 0, res);
		ModelResourceLocation res2 = new ModelResourceLocation("halocraft:SpartaniumIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.spartaniumIngot, 0, res2);
		ModelResourceLocation res3 = new ModelResourceLocation("halocraft:SpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.spartanChestplate, 0, res3);
		ModelResourceLocation res4 = new ModelResourceLocation("halocraft:SpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.spartanHelmet, 0, res4);
		ModelResourceLocation res5 = new ModelResourceLocation("halocraft:SpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.spartanLeggings, 0, res5);
		ModelResourceLocation res6 = new ModelResourceLocation("halocraft:SpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.spartanBoots, 0, res6);
		ModelResourceLocation res7 = new ModelResourceLocation("halocraft:ammoRocket", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.ammoRocket, 0, res7);
		ModelResourceLocation res9 = new ModelResourceLocation("halocraft:ammoAssaultRifle", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.ammoAssaultRifle, 0, res9);

		// Rendering Promethean Armor
		ModelResourceLocation resource1 = new ModelResourceLocation("halocraft:prometheanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.prometheanHelmet, 0, resource1);
		ModelResourceLocation resource2 = new ModelResourceLocation("halocraft:PrometheanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.prometheanChestplate, 0, resource2);
		ModelResourceLocation resource3 = new ModelResourceLocation("halocraft:PrometheanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.prometheanLeggings, 0, resource3);
		ModelResourceLocation resource4 = new ModelResourceLocation("halocraft:PrometheanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.prometheanBoots, 0, resource4);

		// Rendering Spartan Locke Armor
		ModelResourceLocation lockeResource1 = new ModelResourceLocation("halocraft:SpartanLockeHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.spartanLockeHelmet, 0, lockeResource1);
		ModelResourceLocation lockeResource2 = new ModelResourceLocation("halocraft:SpartanLockeChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.spartanLockeChestplate, 0, lockeResource2);
		ModelResourceLocation lockeResource3 = new ModelResourceLocation("halocraft:SpartanLockeLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.spartanLockeLeggings, 0, lockeResource3);
		ModelResourceLocation lockeResource4 = new ModelResourceLocation("halocraft:SpartanLockeBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.spartanLockeBoots, 0, lockeResource4);

		//Rendering Grenadier Armor
		ModelResourceLocation greenGrenadierReso1 = new ModelResourceLocation("halocraft:GreenGrenadierHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.greenGrenadierHelmet, 0, greenGrenadierReso1);
		ModelResourceLocation greenGrenadierReso2 = new ModelResourceLocation("halocraft:GreenGrenadierChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.greenGrenadierChestplate, 0, greenGrenadierReso2);
		ModelResourceLocation greenGrenadierReso3 = new ModelResourceLocation("halocraft:GreenGrenadierLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.greenGrenadierLeggings, 0, greenGrenadierReso3);
		ModelResourceLocation greenGrenadierReso4 = new ModelResourceLocation("halocraft:GreenGrenadierBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.greenGrenadierBoots, 0, greenGrenadierReso4);
		
		ModelResourceLocation orangeGrenadierReso1 = new ModelResourceLocation("halocraft:OrangeGrenadierHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.orangeGrenadierHelmet, 0, orangeGrenadierReso1);
		ModelResourceLocation orangeGrenadierReso2 = new ModelResourceLocation("halocraft:OrangeGrenadierChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.orangeGrenadierChestplate, 0, orangeGrenadierReso2);
		ModelResourceLocation orangeGrenadierReso3 = new ModelResourceLocation("halocraft:OrangeGrenadierLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.orangeGrenadierLeggings, 0, orangeGrenadierReso3);
		ModelResourceLocation orangeGrenadierReso4 = new ModelResourceLocation("halocraft:OrangeGrenadierBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.orangeGrenadierBoots, 0, orangeGrenadierReso4);
		
		// Rendering Recon Armor
		ModelResourceLocation reconReso1 = new ModelResourceLocation("halocraft:ReconHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.reconHelmet, 0, reconReso1);
		ModelResourceLocation reconReso2 = new ModelResourceLocation("halocraft:ReconChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.reconChestplate, 0, reconReso2);
		ModelResourceLocation reconReso3 = new ModelResourceLocation("halocraft:ReconLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.reconLeggings, 0, reconReso3);
		ModelResourceLocation reconReso4 = new ModelResourceLocation("halocraft:ReconBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.reconBoots, 0, reconReso4);
		
		ModelResourceLocation redReconReso1 = new ModelResourceLocation("halocraft:RedReconHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redReconHelmet, 0, redReconReso1);
		ModelResourceLocation redReconReso2 = new ModelResourceLocation("halocraft:RedReconChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redReconChestplate, 0, redReconReso2);
		ModelResourceLocation redReconReso3 = new ModelResourceLocation("halocraft:RedReconLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redReconLeggings, 0, redReconReso3);
		ModelResourceLocation redReconReso4 = new ModelResourceLocation("halocraft:RedReconBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redReconBoots, 0, redReconReso4);
		
		ModelResourceLocation blueReconReso1 = new ModelResourceLocation("halocraft:BlueReconHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueReconHelmet, 0, blueReconReso1);
		ModelResourceLocation blueReconReso2 = new ModelResourceLocation("halocraft:BlueReconChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueReconChestplate, 0, blueReconReso2);
		ModelResourceLocation blueReconReso3 = new ModelResourceLocation("halocraft:BlueReconLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueReconLeggings, 0, blueReconReso3);
		ModelResourceLocation blueReconReso4 = new ModelResourceLocation("halocraft:BlueReconBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueReconBoots, 0, blueReconReso4);

		// Rendering Marine Armor
		ModelResourceLocation reso1 = new ModelResourceLocation("halocraft:MarineHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.marineHelmet, 0, reso1);
		ModelResourceLocation reso2 = new ModelResourceLocation("halocraft:MarineChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.marineChestplate, 0, reso2);
		ModelResourceLocation reso3 = new ModelResourceLocation("halocraft:MarineLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.marineLeggings, 0, reso3);
		ModelResourceLocation reso4 = new ModelResourceLocation("halocraft:MarineBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.marineBoots, 0, reso4);

		ModelResourceLocation reso5 = new ModelResourceLocation("halocraft:RedMarineHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redMarineHelmet, 0, reso5);
		ModelResourceLocation reso6 = new ModelResourceLocation("halocraft:RedMarineChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redMarineChestplate, 0, reso6);
		ModelResourceLocation reso7 = new ModelResourceLocation("halocraft:RedMarineLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redMarineLeggings, 0, reso7);
		ModelResourceLocation reso8 = new ModelResourceLocation("halocraft:RedMarineBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redMarineBoots, 0, reso8);

		ModelResourceLocation reso9 = new ModelResourceLocation("halocraft:BlueMarineHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueMarineHelmet, 0, reso9);
		ModelResourceLocation reso10 = new ModelResourceLocation("halocraft:BlueMarineChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueMarineChestplate, 0, reso10);
		ModelResourceLocation reso11 = new ModelResourceLocation("halocraft:BlueMarineLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueMarineLeggings, 0, reso11);
		ModelResourceLocation reso12 = new ModelResourceLocation("halocraft:BlueMarineBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueMarineBoots, 0, reso12);

		// Registering Red Spartan Armor
		ModelResourceLocation res13 = new ModelResourceLocation("halocraft:RedSpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redSpartanChestplate, 0, res13);
		ModelResourceLocation res14 = new ModelResourceLocation("halocraft:RedSpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redSpartanHelmet, 0, res14);
		ModelResourceLocation res15 = new ModelResourceLocation("halocraft:RedSpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redSpartanLeggings, 0, res15);
		ModelResourceLocation res16 = new ModelResourceLocation("halocraft:RedSpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.redSpartanBoots, 0, res16);
		// Rendering Green Spartan Armor
		ModelResourceLocation res17 = new ModelResourceLocation("halocraft:GreenSpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.greenSpartanChestplate, 0, res17);
		ModelResourceLocation res18 = new ModelResourceLocation("halocraft:GreenSpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.greenSpartanHelmet, 0, res18);
		ModelResourceLocation res19 = new ModelResourceLocation("halocraft:GreenSpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.greenSpartanLeggings, 0, res19);
		ModelResourceLocation res20 = new ModelResourceLocation("halocraft:GreenSpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.greenSpartanBoots, 0, res20);
		// Rendering Blue Spartan Armor
		ModelResourceLocation res21 = new ModelResourceLocation("halocraft:BlueSpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueSpartanChestplate, 0, res21);
		ModelResourceLocation res22 = new ModelResourceLocation("halocraft:BlueSpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueSpartanHelmet, 0, res22);
		ModelResourceLocation res23 = new ModelResourceLocation("halocraft:BlueSpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueSpartanLeggings, 0, res23);
		ModelResourceLocation res24 = new ModelResourceLocation("halocraft:BlueSpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.blueSpartanBoots, 0, res24);
		ModelResourceLocation res25 = new ModelResourceLocation("halocraft:covenantPiece", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.covenantPiece, 0, res25);
		// Rendering Default Covenant Armor
		ModelResourceLocation res26 = new ModelResourceLocation("halocraft:CovenantChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.covenantChestplate, 0, res26);
		ModelResourceLocation res27 = new ModelResourceLocation("halocraft:CovenantHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.covenantHelmet, 0, res27);
		ModelResourceLocation res28 = new ModelResourceLocation("halocraft:CovenantLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.covenantLeggings, 0, res28);
		ModelResourceLocation res29 = new ModelResourceLocation("halocraft:CovenantBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.covenantBoots, 0, res29);
		// Rendering ActiveCamo Armor
		ModelResourceLocation res30 = new ModelResourceLocation("halocraft:ActiveCamoChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.activeCamoChestplate, 0, res30);

		// Rendering Plasma Ammo
		ModelResourceLocation res32 = new ModelResourceLocation("halocraft:ammoPlasma", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.ammoPlasma, 0, res32);

		ModelResourceLocation res35 = new ModelResourceLocation("halocraft:RedPlasmaIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(RedPlasmaIngot.instance, 0, res35);

		ModelResourceLocation res37 = new ModelResourceLocation("halocraft:GreenPlasmaIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(GreenPlasmaIngot.instance, 0, res37);

		ModelResourceLocation res38 = new ModelResourceLocation("halocraft:ammoPlasmaRocket", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.ammoPlasmaRocket, 0, res38);

		ModelResourceLocation res39 = new ModelResourceLocation("halocraft:PurplePlasmaIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(PurplePlasmaIngot.instance, 0, res39);

		ModelResourceLocation res40 = new ModelResourceLocation("halocraft:itemWheel", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.itemWheel, 0, res40);

		ModelResourceLocation res41 = new ModelResourceLocation("halocraft:itemOil", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.itemOil, 0, res41);

		ModelResourceLocation res42 = new ModelResourceLocation("halocraft:itemRubber", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.HaloCraft.itemRubber, 0, res42);

		ModelResourceLocation res43 = new ModelResourceLocation("halocraft:" + ItemForerunnerShard.name, "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ItemForerunnerShard.instance, 0, res43);

		// Rendering Blocks
		Item itemBlockSimple = GameRegistry.findItem("halocraft", HaloBlock.name);
		Item itemBlockSimple2 = GameRegistry.findItem("halocraft", "HaloOre");
		Item itemForerunnerOre = GameRegistry.findItem("halocraft", "ForerunnerOre");
		Item itemRedPlasmaOre = GameRegistry.findItem("halocraft", "RedPlasmaOre");
		Item itemGreenPlasmaOre = GameRegistry.findItem("halocraft", "GreenPlasmaOre");
		Item itemPurplePlasmaOre = GameRegistry.findItem("halocraft", "PurplePlasmaOre");
		Item itemPurplePlasmaBlock = GameRegistry.findItem("halocraft", "PurplePlasmaBlock");
		Item itemRedPlasmaBlock = GameRegistry.findItem("halocraft", "RedPlasmaBlock");
		Item itemRoofBlock = GameRegistry.findItem("halocraft", RoofBlock.name);
		Item itemWallBlock = GameRegistry.findItem("halocraft", ForerunnerWallBlock.name);
		Item itemFloorBlock = GameRegistry.findItem("halocraft", ForerunnerFloorBlock.name);

		ModelResourceLocation forerunnerOreBlockResourceLocation = new ModelResourceLocation("halocraft:ForerunnerOre", "inventory");
		ModelResourceLocation roofBlockResourceLocation = new ModelResourceLocation("halocraft:RoofBlock", "inventory");
		ModelResourceLocation wallBlockResourceLocation = new ModelResourceLocation("halocraft:ForerunnerWallBlock", "inventory");
		ModelResourceLocation floorBlockResourceLocation = new ModelResourceLocation("halocraft:ForerunnerFloorBlock", "inventory");
		ModelResourceLocation haloBlockResourceLocation = new ModelResourceLocation("halocraft:HaloBlock", "inventory");
		ModelResourceLocation purplePlasmaBlockResourceLocation = new ModelResourceLocation("halocraft:PurplePlasmaBlock", "inventory");
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("halocraft:HaloOre", "inventory");
		ModelResourceLocation redPlasmaOreModelResourceLocation = new ModelResourceLocation("halocraft:RedPlasmaOre", "inventory");
		ModelResourceLocation greenPlasmaOreModelResourceLocation = new ModelResourceLocation("halocraft:GreenPlasmaOre", "inventory");
		ModelResourceLocation purplePlasmaOreModelResourceLocation = new ModelResourceLocation("halocraft:PurplePlasmaOre", "inventory");
		ModelResourceLocation redPlasmaBlockModelResourceLocation = new ModelResourceLocation("halocraft:RedPlasmaBlock", "inventory");

		final int DEFAULT_ITEM_SUBTYPE = 0;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple2, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, DEFAULT_ITEM_SUBTYPE, haloBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemRedPlasmaOre, DEFAULT_ITEM_SUBTYPE, redPlasmaOreModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemGreenPlasmaOre, DEFAULT_ITEM_SUBTYPE, greenPlasmaOreModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemPurplePlasmaOre, DEFAULT_ITEM_SUBTYPE, purplePlasmaOreModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemPurplePlasmaBlock, DEFAULT_ITEM_SUBTYPE, purplePlasmaBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemRedPlasmaBlock, DEFAULT_ITEM_SUBTYPE, redPlasmaBlockModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemRoofBlock, DEFAULT_ITEM_SUBTYPE, roofBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemWallBlock, DEFAULT_ITEM_SUBTYPE, wallBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemFloorBlock, DEFAULT_ITEM_SUBTYPE, floorBlockResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemForerunnerOre, DEFAULT_ITEM_SUBTYPE, forerunnerOreBlockResourceLocation);

		// Rendering Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityPulseGrenade.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), PulseGrenade.instance, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityFragGrenade.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), FragGrenade.instance, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMongoose.class, new RenderMongooseEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderGhostEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityWarthog.class, new RenderWarthogEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityWarthogTurret.class, new RenderWarthogTurretEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, new RenderScorpionEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBulletEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, new RenderRocketEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityPlasmaRocket.class, new RenderPlasmaRocketEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedPlasma.class, new RenderRedPlasmaEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenPlasma.class, new RenderGreenPlasmaEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityPurplePlasma.class, new RenderPurplePlasmaEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityOrangePlasma.class, new RenderOrangePlasmaEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityElite.class, new RenderEliteEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedElite.class, new RenderRedEliteEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueElite.class, new RenderBlueEliteEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityPromethean.class, new RenderPrometheanEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityMarine.class, new RenderMarineEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrunt.class, new RenderGruntEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));

	}

	public void preInit()
	{
		ModelLoaderRegistry.registerLoader(OBJLoader.instance);
		OBJLoader.instance.addDomain("halocraft");

		ModelLoader.setCustomModelResourceLocation(ItemBoltshot.instance, 0, new ModelResourceLocation("halocraft:" + ItemBoltshot.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(PulseGrenade.instance, 0, new ModelResourceLocation("halocraft:" + PulseGrenade.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemRocketLauncher.instance, 0, new ModelResourceLocation("halocraft:" + ItemRocketLauncher.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemEnergySword.instance, 0, new ModelResourceLocation("halocraft:" + ItemEnergySword.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(PrometheanSword.instance, 0, new ModelResourceLocation("halocraft:" + PrometheanSword.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Pistol.instance, 0, new ModelResourceLocation("halocraft:" + Pistol.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemAssaultRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemAssaultRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(FragGrenade.instance, 0, new ModelResourceLocation("halocraft:" + FragGrenade.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(PlasmaRifle.instance, 0, new ModelResourceLocation("halocraft:" + PlasmaRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemBattleRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemBattleRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemCarbineRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemCarbineRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemSniperRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemSniperRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemLightRifle.instance, 0, new ModelResourceLocation("halocraft:" + ItemLightRifle.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemCarbineAmmo.instance, 0, new ModelResourceLocation("halocraft:" + ItemCarbineAmmo.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemFuelRodCannon.instance, 0, new ModelResourceLocation("halocraft:" + ItemFuelRodCannon.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemIncinerationCannon.instance, 0, new ModelResourceLocation("halocraft:" + ItemIncinerationCannon.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemHealthPack.instance, 0, new ModelResourceLocation("halocraft:" + ItemHealthPack.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemNeedlerAmmo.instance, 0, new ModelResourceLocation("halocraft:" + ItemNeedlerAmmo.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemNeedler.instance, 0, new ModelResourceLocation("halocraft:" + ItemNeedler.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemGhost.instance, 0, new ModelResourceLocation("halocraft:" + ItemGhost.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemMongoose.instance, 0, new ModelResourceLocation("halocraft:" + ItemMongoose.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemScorpion.instance, 0, new ModelResourceLocation("halocraft:" + ItemScorpion.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemWarthog.instance, 0, new ModelResourceLocation("halocraft:" + ItemWarthog.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemWarthogTurret.instance, 0, new ModelResourceLocation("halocraft:" + ItemWarthogTurret.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemRedPlasmaAmmo.instance, 0, new ModelResourceLocation("halocraft:" + ItemRedPlasmaAmmo.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemScattershot.instance, 0, new ModelResourceLocation("halocraft:" + ItemScattershot.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemSuppressor.instance, 0, new ModelResourceLocation("halocraft:" + ItemSuppressor.name, "inventory"));
	}

	public void registerKey()
	{
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		KeyBindings.init();
		MinecraftForge.EVENT_BUS.register(new HaloGUIEventHandler(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new VehicleEventHandler());
		FMLCommonHandler.instance().bus().register(new HaloEventHandler());
	}
}
