package halocraft.proxies;

import halocraft.ActiveCamoArmor;
import halocraft.CovenantArmor;
import halocraft.EntityBullet;
import halocraft.EntityElite;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.client.model.b3d.B3DModel;
import halocraft.CustomModelBlock;
import halocraft.EntityFragGrenade;
import halocraft.EntityGreenPlasma;
import halocraft.EntityGrunt;
import halocraft.EntityMongoose;
import halocraft.EntityRedPlasma;
import halocraft.EntityRocket;
import halocraft.HaloArmor;
import halocraft.HaloEventHandler;
import halocraft.HaloIngot;
import halocraft.KeyBindings;
import halocraft.KeyInputHandler;
import halocraft.RenderBulletEntity;
import halocraft.RenderEliteEntity;
import halocraft.RenderGreenPlasmaEntity;
import halocraft.RenderGruntEntity;
import halocraft.RenderMongooseEntity;
import halocraft.RenderRedPlasmaEntity;
import halocraft.RenderRocketEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders(){
		B3DLoader.instance.addDomain("halocraft");
		Item item = Item.getItemFromBlock(CustomModelBlock.instance);
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation("halocraft:" + CustomModelBlock.name, "inventory"));
		ModelResourceLocation res = new ModelResourceLocation("halocraft:energySword", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.swordEnergySword, 0, res);
		ModelResourceLocation res2 = new ModelResourceLocation("halocraft:HaloIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.HaloIngot, 0, res2);
		ModelResourceLocation res3 = new ModelResourceLocation("halocraft:SpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.SpartanChestplate, 0, res3);
		ModelResourceLocation res4 = new ModelResourceLocation("halocraft:SpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.SpartanHelmet, 0, res4);
		ModelResourceLocation res5 = new ModelResourceLocation("halocraft:SpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.SpartanLeggings, 0, res5);
		ModelResourceLocation res6 = new ModelResourceLocation("halocraft:SpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.SpartanBoots, 0, res6);
		ModelResourceLocation res7 = new ModelResourceLocation("halocraft:ammoRocket", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.ammoRocket, 0, res7);
		ModelResourceLocation res8 = new ModelResourceLocation("halocraft:rocketLauncher", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.rocketLauncher, 0, res8);
		ModelResourceLocation res9 = new ModelResourceLocation("halocraft:ammoAssaultRifle", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.ammoAssaultRifle, 0, res9);
		//ModelResourceLocation res10 = new ModelResourceLocation("halocraft:itemAssaultRifle", "inventory");
		//ModelLoader.setCustomModelResourceLocation(halocraft.Main.itemAssaultRifle, 0, res10);
		ModelResourceLocation res11 = new ModelResourceLocation("halocraft:itemBattleRifle", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.itemBattleRifle, 0, res11);
		ModelResourceLocation res12 = new ModelResourceLocation("halocraft:itemMongoose", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.itemMongoose, 0, res12);
		//Registering Red Spartan Armor
		ModelResourceLocation res13 = new ModelResourceLocation("halocraft:RedSpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.RedSpartanChestplate, 0, res13);
		ModelResourceLocation res14 = new ModelResourceLocation("halocraft:RedSpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.RedSpartanHelmet, 0, res14);
		ModelResourceLocation res15 = new ModelResourceLocation("halocraft:RedSpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.RedSpartanLeggings, 0, res15);
		ModelResourceLocation res16 = new ModelResourceLocation("halocraft:RedSpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.RedSpartanBoots, 0, res16);
		//Rendering Green Spartan Armor
		ModelResourceLocation res17 = new ModelResourceLocation("halocraft:GreenSpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.GreenSpartanChestplate, 0, res17);
		ModelResourceLocation res18 = new ModelResourceLocation("halocraft:GreenSpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.GreenSpartanHelmet, 0, res18);
		ModelResourceLocation res19 = new ModelResourceLocation("halocraft:GreenSpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.GreenSpartanLeggings, 0, res19);
		ModelResourceLocation res20 = new ModelResourceLocation("halocraft:GreenSpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.GreenSpartanBoots, 0, res20);
		//Rendering Blue Spartan Armor
		ModelResourceLocation res21 = new ModelResourceLocation("halocraft:BlueSpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.BlueSpartanChestplate, 0, res21);
		ModelResourceLocation res22 = new ModelResourceLocation("halocraft:BlueSpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.BlueSpartanHelmet, 0, res22);
		ModelResourceLocation res23 = new ModelResourceLocation("halocraft:BlueSpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.BlueSpartanLeggings, 0, res23);
		ModelResourceLocation res24 = new ModelResourceLocation("halocraft:BlueSpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.BlueSpartanBoots, 0, res24);
		ModelResourceLocation res25 = new ModelResourceLocation("halocraft:covenantPiece", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.covenantPiece, 0, res25);
		//Rendering Default Covenant Armor
		ModelResourceLocation res26 = new ModelResourceLocation("halocraft:CovenantChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.CovenantChestplate, 0, res26);
		ModelResourceLocation res27 = new ModelResourceLocation("halocraft:CovenantHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.CovenantHelmet, 0, res27);
		ModelResourceLocation res28 = new ModelResourceLocation("halocraft:CovenantLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.CovenantLeggings, 0, res28);
		ModelResourceLocation res29 = new ModelResourceLocation("halocraft:CovenantBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.CovenantBoots, 0, res29);
		//Rendering ActiveCamo Armor
		ModelResourceLocation res30 = new ModelResourceLocation("halocraft:ActiveCamoChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.ActiveCamoChestplate, 0, res30);
		//Rendering Incineration Cannon
		ModelResourceLocation res31 = new ModelResourceLocation("halocraft:incinerationCannon", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.itemIncinerationCannon, 0, res31);
		//Rendering Plasma Ammo
		ModelResourceLocation res32 = new ModelResourceLocation("halocraft:ammoPlasma", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.ammoPlasma, 0, res32);
		//Rendering Carbine Rifle
		ModelResourceLocation res33 = new ModelResourceLocation("halocraft:itemCarbineRifle", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.itemCarbineRifle, 0, res33);
		//Rendering Health Pack
		ModelResourceLocation res34 = new ModelResourceLocation("halocraft:HealthPack", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.itemHealthPack, 0, res34);
		//Rendering Grenades
		ModelResourceLocation res35 = new ModelResourceLocation("halocraft:fragGrenade", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(halocraft.Main.fragGrenade, 0, res35);
		//Rendering Blocks
		Item itemBlockSimple = GameRegistry.findItem("halocraft", "HaloBlock");
		Item itemBlockSimple2 = GameRegistry.findItem("halocraft", "HaloOre");
		ModelResourceLocation haloBlockResourceLocation = new ModelResourceLocation("halocraft:HaloBlock", "inventory");
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("halocraft:HaloOre", "inventory");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple2, 0, itemModelResourceLocation);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, DEFAULT_ITEM_SUBTYPE, haloBlockResourceLocation);
		//Rendering Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityFragGrenade.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), halocraft.Main.fragGrenade, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMongoose.class, new RenderMongooseEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBulletEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, new RenderRocketEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedPlasma.class, new RenderRedPlasmaEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenPlasma.class, new RenderGreenPlasmaEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityElite.class, new RenderEliteEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrunt.class, new RenderGruntEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));	
	}
	public void addStuff(){
		//ModelBakery.addVariantName(halocraft.Main.itemAssaultRifle, "halocraft:assaultrifle.b3d");
	}
	public void registerKey(){
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		KeyBindings.init();
		MinecraftForge.EVENT_BUS.register(new HaloEventHandler(Minecraft.getMinecraft()));
	}
}
