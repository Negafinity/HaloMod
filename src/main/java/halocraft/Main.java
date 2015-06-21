package halocraft;

import halocraft.armor.ActiveCamoArmor;
import halocraft.armor.CovenantArmor;
import halocraft.armor.HaloArmor;
import halocraft.blocks.HaloBlock;
import halocraft.blocks.HaloOre;
import halocraft.entities.EntityBullet;
import halocraft.entities.EntityElite;
import halocraft.entities.EntityFragGrenade;
import halocraft.entities.EntityGreenPlasma;
import halocraft.entities.EntityGrunt;
import halocraft.entities.EntityMongoose;
import halocraft.entities.EntityRedPlasma;
import halocraft.entities.EntityRocket;
import halocraft.entities.EntityScorpion;
import halocraft.items.CovenantPiece;
import halocraft.items.FragGrenade;
import halocraft.items.HaloIngot;
import halocraft.items.ItemAmmoAssaultRifle;
import halocraft.items.ItemAmmoPlasma;
import halocraft.items.ItemAssaultRifle;
import halocraft.items.ItemBattleRifle;
import halocraft.items.ItemCarbineRifle;
import halocraft.items.ItemEnergySword;
import halocraft.items.ItemHealthPack;
import halocraft.items.ItemIncinerationCannon;
import halocraft.items.ItemMongoose;
import halocraft.items.ItemRocket;
import halocraft.items.ItemScorpion;
import halocraft.items.Pistol;
import halocraft.items.RocketLauncher;
import halocraft.items.TankHarvester;
import halocraft.packets.FireMessage;
import halocraft.packets.FireMessageHandler;
import halocraft.packets.HalocraftPacketHandler;
import halocraft.proxies.ClientProxy;
import halocraft.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid="halocraft", version="1.2")
public class Main{
	
	@SidedProxy(clientSide="halocraft.proxies.ClientProxy", serverSide="halocraft.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	public static String MODID = "halocraft";
	public static String VERSION = "1.3";
	//World Generation
	public static HaloGenerationClass HaloOreGen;
	//Armor Material
	public static ArmorMaterial HaloArmor;
	public static ArmorMaterial CovenantArmor;
	public static ArmorMaterial ActiveCamoArmor;
	//Blocks
	public final static Block HaloOre = new HaloOre(Material.rock);
	public static Block HaloBlock = new HaloBlock(Material.iron);
	//Armor
	public static int helmetID = 0;
	public static int chestplateID = 0;
	public static int leggingID = 0;
	public static int bootID = 0;
	public static Item SpartanHelmet;
	public static Item SpartanChestplate;
	public static Item SpartanLeggings;
	public static Item SpartanBoots;
	public static Item RedSpartanHelmet;
	public static Item RedSpartanChestplate;
	public static Item RedSpartanLeggings;
	public static Item RedSpartanBoots;
	public static Item GreenSpartanHelmet;
	public static Item GreenSpartanChestplate;
	public static Item GreenSpartanLeggings;
	public static Item GreenSpartanBoots;
	public static Item BlueSpartanHelmet;
	public static Item BlueSpartanChestplate;
	public static Item BlueSpartanLeggings;
	public static Item BlueSpartanBoots;
	public static Item CovenantHelmet;
	public static Item CovenantChestplate;
	public static Item CovenantLeggings;
	public static Item CovenantBoots;
	public static Item covenantPiece;
	public static Item ActiveCamoChestplate;
	//Items
	public static Item HaloIngot = new HaloIngot();
	public static Item ammoRocket;
	public static Item ammoAssaultRifle;
	public static Item ammoPlasma;
	public static Item itemBattleRifle;
	public static Item itemMongoose;
	public static Item itemHealthPack;
	public static Item itemCarbineRifle;
	public static Item itemIncinerationCannon;
	public static Item itemScorpion;
	public static Item tankHarvester;
	//Tool Materials
	public static ToolMaterial HaloMaterial;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		System.out.println("Mod Pre-Init");
		itemCarbineRifle = new ItemCarbineRifle();
		itemScorpion = new ItemScorpion();
		//Initalize Tank Harvester
		tankHarvester = new TankHarvester();
		//Initialize Plasma
		ammoPlasma = new ItemAmmoPlasma();
		//Initalizing Cannon
		itemIncinerationCannon = new ItemIncinerationCannon();
		HaloMaterial = EnumHelper.addToolMaterial("HaloMaterial", 3, 1750, 9.0F, 6.0F, 10);
		HaloArmor = EnumHelper.addArmorMaterial("HaloArmor", "halocraft:textures/models/armor/HaloArmor", 100, new int[]{6, 6, 10, 8}, 30);
		CovenantArmor = EnumHelper.addArmorMaterial("CovenantArmor", "halocraft:textures/models/armor/CovenantArmor", 85, new int[]{4, 4, 10, 8}, 30);
		ActiveCamoArmor = EnumHelper.addArmorMaterial("ActiveCamoArmor", "halocraft:textures/models/armor/ActiveCamoArmor", 100, new int[]{6, 6, 10, 8}, 30);
		itemHealthPack = new ItemHealthPack();
		HaloOreGen = new HaloGenerationClass();
		//HaloBlock = new HaloBlock(Material.iron);
		covenantPiece = new CovenantPiece();
		ammoRocket = new ItemRocket();
		ammoAssaultRifle = new ItemAmmoAssaultRifle();
		itemBattleRifle = new ItemBattleRifle();
		itemMongoose = new ItemMongoose();
		halocraft.Main.BlueSpartanHelmet = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("BlueSpartanHelmet");
		halocraft.Main.BlueSpartanChestplate = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("BlueSpartanChestplate");
		halocraft.Main.BlueSpartanLeggings = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("BlueSpartanLeggings");
		halocraft.Main.BlueSpartanBoots = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.bootID, 3).setUnlocalizedName("BlueSpartanBoots");
		halocraft.Main.GreenSpartanHelmet = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("GreenSpartanHelmet");
		halocraft.Main.GreenSpartanChestplate = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("GreenSpartanChestplate");
		halocraft.Main.GreenSpartanLeggings = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("GreenSpartanLeggings");
		halocraft.Main.GreenSpartanBoots = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.bootID, 3).setUnlocalizedName("GreenSpartanBoots");
		halocraft.Main.RedSpartanHelmet = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("RedSpartanHelmet");
		halocraft.Main.RedSpartanChestplate = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("RedSpartanChestplate");
		halocraft.Main.RedSpartanLeggings = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("RedSpartanLeggings");
		halocraft.Main.RedSpartanBoots = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.bootID, 3).setUnlocalizedName("RedSpartanBoots");
		halocraft.Main.SpartanHelmet = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("SpartanHelmet");
		halocraft.Main.SpartanChestplate = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("SpartanChestplate");
		halocraft.Main.SpartanLeggings = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("SpartanLeggings");
		halocraft.Main.SpartanBoots = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.bootID, 3).setUnlocalizedName("SpartanBoots");
		halocraft.Main.CovenantHelmet = new CovenantArmor(halocraft.Main.CovenantArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("CovenantHelmet");
		halocraft.Main.CovenantChestplate = new CovenantArmor(halocraft.Main.CovenantArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("CovenantChestplate");
		halocraft.Main.CovenantLeggings = new CovenantArmor(halocraft.Main.CovenantArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("CovenantLeggings");
		halocraft.Main.CovenantBoots = new CovenantArmor(halocraft.Main.CovenantArmor, halocraft.Main.bootID, 3).setUnlocalizedName("CovenantBoots");
		halocraft.Main.ActiveCamoChestplate = new ActiveCamoArmor(halocraft.Main.ActiveCamoArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("ActiveCamoChestplate");
		GameRegistry.registerItem(ItemEnergySword.instance, ItemEnergySword.name);
		int randomID3 = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", randomID3, this, 250, 50, true);
		int randomID4 = EntityRegistry.findGlobalUniqueEntityId() + 1;
		EntityRegistry.registerModEntity(EntityMongoose.class, "Mongoose", randomID4, this, 250, 50, true);
		int randomID9 = EntityRegistry.findGlobalUniqueEntityId() + 5;
		EntityRegistry.registerModEntity(EntityScorpion.class, "Socrpion", randomID9, this, 250, 50, true);
		int randomID2 = EntityRegistry.findGlobalUniqueEntityId() + 2;
		EntityRegistry.registerModEntity(EntityRocket.class, "Rocket", randomID2, this, 250, 50, true);
		int randomID7 = EntityRegistry.findGlobalUniqueEntityId() + 3;
		EntityRegistry.registerModEntity(EntityRedPlasma.class, "RedPlasma", randomID7, this, 250, 50, true);
		int randomID8 = EntityRegistry.findGlobalUniqueEntityId() + 4;
		EntityRegistry.registerModEntity(EntityGreenPlasma.class, "GreenPlasma", randomID8, this, 250, 50, true);
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		System.out.println("Random ID 1: " + randomID);
		EntityRegistry.registerGlobalEntityID(EntityElite.class, "Elite", randomID, 230, 78);
		EntityRegistry.addSpawn(EntityElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, 
				BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, 
				BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, 
				BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, 
				BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, 
				BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);
		int randomID5 = EntityRegistry.findGlobalUniqueEntityId();
		System.out.println("Random ID 5: " + randomID5);
		EntityRegistry.registerGlobalEntityID(EntityGrunt.class, "Grunt", randomID5, 78, 230);
		EntityRegistry.addSpawn(EntityGrunt.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, 
				BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, 
				BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, 
				BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, 
				BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, 
				BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);
		//EntityRegistry.registerModEntity(EntityElite.class,"Elite", randomID, this, 250, 50, true);
		int randomID6 = EntityRegistry.findGlobalUniqueEntityId();
		System.out.println("Random ID 6" + randomID6);
		EntityRegistry.registerModEntity(EntityFragGrenade.class, "fragGrenade", randomID6 + 1, this, 128, 1, true);
		GameRegistry.registerBlock(HaloOre, "HaloOre");
		GameRegistry.registerBlock(HaloBlock, "HaloBlock");
		GameRegistry.registerItem(itemMongoose, "itemMongoose");
		GameRegistry.registerItem(covenantPiece, "covenantPiece");
		GameRegistry.registerItem(FragGrenade.instance, FragGrenade.name);
		GameRegistry.registerItem(HaloIngot, "HaloIngot");
		GameRegistry.registerItem(RocketLauncher.instance, RocketLauncher.name);
		GameRegistry.registerItem(ammoRocket, "ammoRocket");
		GameRegistry.registerItem(ammoAssaultRifle, "ammoAssaultRifle");
		GameRegistry.registerItem(ItemAssaultRifle.instance, ItemAssaultRifle.name);
		GameRegistry.registerItem(itemBattleRifle, "itemBattleRifle");
		GameRegistry.registerItem(itemHealthPack, "HealthPack");
		GameRegistry.registerItem(itemScorpion, "itemScorpion");
		GameRegistry.registerItem(itemIncinerationCannon, "incinerationCannon");
		GameRegistry.registerItem(ammoPlasma, "ammoPlasma");
		GameRegistry.registerItem(Pistol.instance, Pistol.name);
		GameRegistry.registerItem(tankHarvester, "TankHarvester");
		GameRegistry.registerItem(itemCarbineRifle, "itemCarbineRifle");
		GameRegistry.registerItem(halocraft.Main.SpartanHelmet, "SpartanHelmet");
		GameRegistry.registerItem(halocraft.Main.SpartanChestplate, "SpartanChestplate");
		GameRegistry.registerItem(halocraft.Main.SpartanLeggings, "SpartanLeggings");
		GameRegistry.registerItem(halocraft.Main.SpartanBoots, "SpartanBoots");
		GameRegistry.registerItem(halocraft.Main.RedSpartanHelmet, "RedSpartanHelmet");
		GameRegistry.registerItem(halocraft.Main.RedSpartanChestplate, "RedSpartanChestplate");
		GameRegistry.registerItem(halocraft.Main.RedSpartanLeggings, "RedSpartanLeggings");
		GameRegistry.registerItem(halocraft.Main.RedSpartanBoots, "RedSpartanBoots");
		GameRegistry.registerItem(halocraft.Main.GreenSpartanHelmet, "GreenSpartanHelmet");
		GameRegistry.registerItem(halocraft.Main.GreenSpartanChestplate, "GreenSpartanChestplate");
		GameRegistry.registerItem(halocraft.Main.GreenSpartanLeggings, "GreenSpartanLeggings");
		GameRegistry.registerItem(halocraft.Main.GreenSpartanBoots, "GreenSpartanBoots");
		GameRegistry.registerItem(halocraft.Main.BlueSpartanHelmet, "BlueSpartanHelmet");
		GameRegistry.registerItem(halocraft.Main.BlueSpartanChestplate, "BlueSpartanChestplate");
		GameRegistry.registerItem(halocraft.Main.BlueSpartanLeggings, "BlueSpartanLeggings");
		GameRegistry.registerItem(halocraft.Main.BlueSpartanBoots, "BlueSpartanBoots");
		GameRegistry.registerItem(halocraft.Main.CovenantHelmet, "CovenantHelmet");
		GameRegistry.registerItem(halocraft.Main.CovenantChestplate, "CovenantChestplate");
		GameRegistry.registerItem(halocraft.Main.CovenantLeggings, "CovenantLeggings");
		GameRegistry.registerItem(halocraft.Main.CovenantBoots, "CovenantBoots");
		GameRegistry.registerItem(halocraft.Main.ActiveCamoChestplate, "ActiveCamoChestplate");
		//Block Recipes
		GameRegistry.addRecipe(new ItemStack(HaloBlock, 1), new Object[]{"XXX","XXX","XXX", 'X', HaloIngot});
		//Gun Recipes
		ItemStack gunpowderStack = new ItemStack(Items.gunpowder);
		ItemStack glassStack = new ItemStack(Blocks.glass);
		GameRegistry.addRecipe(new ItemStack(itemBattleRifle, 1), new Object[]{"ZX ","XXY", " XA", 'X', HaloIngot, 'Y', gunpowderStack, 'Z', glassStack, 'A', HaloBlock});
		GameRegistry.addRecipe(new ItemStack(ItemAssaultRifle.instance, 1), new Object[]{"XXY", " ZZ", "  Z", 'X', HaloIngot, 'Y', gunpowderStack, 'Z', HaloBlock});
		//Recipes
		ItemStack woolStack = new ItemStack(Blocks.wool);
		ItemStack goldenAppleStack = new ItemStack(Items.golden_apple);
		GameRegistry.addRecipe(new ItemStack(itemHealthPack, 1), new Object[]{"YYY","YXY", "YYY", 'X', goldenAppleStack, 'Y', woolStack});
		GameRegistry.addRecipe(new ItemStack(SpartanHelmet, 1), new Object[]{"XXX","X X", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(SpartanChestplate, 1), new Object[]{"X X","XXX", "XXX", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(SpartanLeggings, 1), new Object[]{"XXX","X X","X X", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(SpartanBoots, 1), new Object[]{"X X","X X", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(CovenantHelmet, 1), new Object[]{"XXX","X X", 'X', covenantPiece});
		GameRegistry.addRecipe(new ItemStack(CovenantChestplate, 1), new Object[]{"X X","XXX", "XXX", 'X', covenantPiece});
		GameRegistry.addRecipe(new ItemStack(CovenantLeggings, 1), new Object[]{"XXX","X X","X X", 'X', covenantPiece});
		GameRegistry.addRecipe(new ItemStack(CovenantBoots, 1), new Object[]{"X X","X X", 'X', covenantPiece});
		GameRegistry.addRecipe(new ItemStack(ammoRocket, 5), new Object[]{" X "," X ", " Y ", 'X', HaloIngot, 'Y', gunpowderStack});
		ItemStack coalStack = new ItemStack(Items.coal);
		GameRegistry.addRecipe(new ItemStack(itemMongoose, 1), new Object[]{"XXX","X X", "Y Y", 'X', HaloIngot, 'Y', coalStack});
		//Health Pack Crafting Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(itemHealthPack, 1), new ItemStack(Items.nether_wart, 1), new ItemStack(Items.speckled_melon, 1), new ItemStack(Blocks.wool, 1));
		//Active Camo Armor	
		GameRegistry.addShapelessRecipe(new ItemStack(ActiveCamoChestplate, 1), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.fermented_spider_eye, 1), new ItemStack(Items.nether_wart, 1), SpartanChestplate);
		//Red Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanHelmet, 1), new ItemStack(Items.dye, 1, 1), SpartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanChestplate, 1), new ItemStack(Items.dye, 1, 1), SpartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanLeggings, 1), new ItemStack(Items.dye, 1, 1), SpartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanBoots, 1), new ItemStack(Items.dye, 1, 1), SpartanBoots);
		//Green Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanHelmet, 1), new ItemStack(Items.dye, 1, 10), SpartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanChestplate, 1), new ItemStack(Items.dye, 1, 10), SpartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanLeggings, 1), new ItemStack(Items.dye, 1, 10), SpartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanBoots, 1), new ItemStack(Items.dye, 1, 10), SpartanBoots);
		//Blue Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanHelmet, 1), new ItemStack(Items.dye, 1, 6), SpartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanChestplate, 1), new ItemStack(Items.dye, 1, 6), SpartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanLeggings, 1), new ItemStack(Items.dye, 1, 6), SpartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanBoots, 1), new ItemStack(Items.dye, 1, 6), SpartanBoots);
		ItemStack stickStack = new ItemStack(Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemEnergySword.instance, 1), new Object[]{" X "," X ", " Y ", 'X', HaloIngot, 'Y', stickStack});
		ItemStack gunStack = new ItemStack(Items.gunpowder);
		GameRegistry.addRecipe(new ItemStack(RocketLauncher.instance, 1), new Object[]{"XZZ", "XYZ", "ZYX", 'X', HaloIngot, 'Y', gunStack, 'Z', HaloBlock});
		ItemStack ironStack = new ItemStack(Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemAssaultRifle.instance, 1), new Object[]{"ZXX", " ZX", " YZ", 'X', HaloIngot, 'Y', gunStack, 'Z', ironStack});
		ItemStack goldStack = new ItemStack(Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(ammoAssaultRifle, 15), new Object[]{" X ", " X ", "XYX", 'X', goldStack, 'Y', gunStack});
		GameRegistry.addRecipe(new ItemStack(itemCarbineRifle, 1), new Object[]{"XXY", " YX", " XX", 'X', covenantPiece, 'Y', gunStack});
		GameRegistry.addSmelting(HaloOre, new ItemStack(HaloIngot, 1), 0.1f);
		GameRegistry.addShapelessRecipe(new ItemStack(covenantPiece, 1), new ItemStack(Items.blaze_rod, 1), new ItemStack(Items.coal, 1));
		//Frag Grenade Crafting
		ItemStack tntStack = new ItemStack(Blocks.tnt);
		GameRegistry.addRecipe(new ItemStack(FragGrenade.instance, 1), new Object[]{" X ", "XYX", "XXX", 'X', ironStack, 'Y', tntStack});
		//World Gen
		GameRegistry.registerWorldGenerator(HaloOreGen, 1);
		
		if (event.getSide() == Side.CLIENT)
			proxy.preInit();
	}
	@EventHandler
	public void Init(FMLInitializationEvent event){
		System.out.println("Mod Init");
		//MinecraftForge.EVENT_BUS.register(new HaloEventHandler(Minecraft.getMinecraft()));
		//CProxy.addArmour(null);
		
		//Register Key
		proxy.registerKey();
		//Event Bus
		//MinecraftForge.EVENT_BUS.register(new HaloEventHandler(Minecraft.getMinecraft()));
		
		//GUI Overlay
		//CProxy.registerEventHandler();
		
		//Rendering
		proxy.registerRenders();
		
		//Register Packet
		HalocraftPacketHandler.INSTANCE.registerMessage(FireMessageHandler.class, FireMessage.class, 0, Side.SERVER);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		System.out.println("HaloCraft PostInit");
		System.out.println("HaloCraft 2.0 Initialized!");
	}
}

