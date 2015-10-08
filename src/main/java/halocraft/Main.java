package halocraft;

import halocraft.armor.ActiveCamoArmor;
import halocraft.armor.CovenantArmor;
import halocraft.armor.HaloArmor;
import halocraft.blocks.ForerunnerFloorBlock;
import halocraft.blocks.ForerunnerOre;
import halocraft.blocks.ForerunnerWallBlock;
import halocraft.blocks.HaloBlock;
import halocraft.blocks.HaloOre;
import halocraft.blocks.PurplePlasmaBlock;
import halocraft.blocks.RedPlasmaBlock;
import halocraft.blocks.RoofBlock;
import halocraft.creativetabs.HaloCreativeTab;
import halocraft.entities.EntityBlueElite;
import halocraft.entities.EntityBullet;
import halocraft.entities.EntityElite;
import halocraft.entities.EntityFragGrenade;
import halocraft.entities.EntityGhost;
import halocraft.entities.EntityGreenPlasma;
import halocraft.entities.EntityGrunt;
import halocraft.entities.EntityMarine;
import halocraft.entities.EntityMongoose;
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
import halocraft.items.CovenantPiece;
import halocraft.items.FragGrenade;
import halocraft.items.GreenPlasmaIngot;
import halocraft.items.ItemAmmoAssaultRifle;
import halocraft.items.ItemAmmoPlasma;
import halocraft.items.ItemAmmoPlasmaRocket;
import halocraft.items.ItemCarbineAmmo;
import halocraft.items.ItemEnergySword;
import halocraft.items.ItemForerunnerShard;
import halocraft.items.ItemGhost;
import halocraft.items.ItemHealthPack;
import halocraft.items.ItemMongoose;
import halocraft.items.ItemNeedlerAmmo;
import halocraft.items.ItemOil;
import halocraft.items.ItemRedPlasmaAmmo;
import halocraft.items.ItemRocket;
import halocraft.items.ItemRocketLauncher;
import halocraft.items.ItemRubber;
import halocraft.items.ItemScorpion;
import halocraft.items.ItemWarthog;
import halocraft.items.ItemWarthogTurret;
import halocraft.items.ItemWheel;
import halocraft.items.PlasmaRifle;
import halocraft.items.PrometheanSword;
import halocraft.items.PulseGrenade;
import halocraft.items.PurplePlasmaIngot;
import halocraft.items.RedPlasmaIngot;
import halocraft.items.SpartaniumIngot;
import halocraft.items.TankHarvester;
import halocraft.items.firearms.ItemAssaultRifle;
import halocraft.items.firearms.ItemBattleRifle;
import halocraft.items.firearms.ItemBoltshot;
import halocraft.items.firearms.ItemCarbineRifle;
import halocraft.items.firearms.ItemFuelRodCannon;
import halocraft.items.firearms.ItemIncinerationCannon;
import halocraft.items.firearms.ItemLightRifle;
import halocraft.items.firearms.ItemNeedler;
import halocraft.items.firearms.ItemScattershot;
import halocraft.items.firearms.ItemSniperRifle;
import halocraft.items.firearms.Pistol;
import halocraft.packets.FireMessage;
import halocraft.packets.FireMessageHandler;
import halocraft.packets.HalocraftPacketHandler;
import halocraft.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = "halocraft", version = "1.5")
public class Main
{
	public int counter = 0;

	@SidedProxy(clientSide = "halocraft.proxies.ClientProxy", serverSide = "halocraft.proxies.CommonProxy")
	public static CommonProxy proxy;

	public static String MODID = "halocraft";
	public static String VERSION = "1.5";
	// World Generation
	public static HaloGenerationClass HaloOreGen;
	// Armor Material
	public static ArmorMaterial HaloArmor;
	public static ArmorMaterial CovenantArmor;
	public static ArmorMaterial ActiveCamoArmor;
	// Blocks
	public final static Block HaloOre = new HaloOre(Material.iron);
	public final static Block ForerunnerOre = new ForerunnerOre(Material.iron);
	public final static Block RedPlasmaOre = new halocraft.blocks.RedPlasmaOre(Material.iron);
	public final static Block GreenPlasmaOre = new halocraft.blocks.GreenPlasmaOre(Material.iron);
	public final static Block PurplePlasmaOre = new halocraft.blocks.PurplePlasmaOre(Material.iron);
	// Armor
	public static int helmetID = 0;
	public static int chestplateID = 0;
	public static int leggingID = 0;
	public static int bootID = 0;
	public static Item SpartanHelmet;
	public static Item SpartanChestplate;
	public static Item SpartanLeggings;
	public static Item SpartanBoots;
	public static Item prometheanHelmet;
	public static Item PrometheanChestplate;
	public static Item PrometheanLeggings;
	public static Item PrometheanBoots;
	public static Item MarineHelmet;
	public static Item MarineChestplate;
	public static Item MarineLeggings;
	public static Item MarineBoots;
	public static Item BlueMarineHelmet;
	public static Item BlueMarineChestplate;
	public static Item BlueMarineLeggings;
	public static Item BlueMarineBoots;
	public static Item RedMarineHelmet;
	public static Item RedMarineChestplate;
	public static Item RedMarineLeggings;
	public static Item RedMarineBoots;
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
	public static Item Jetpack;
	// Creative Tabs
	public static CreativeTabs haloCreativeTab;
	// Items
	public static Item spartaniumIngot;
	public static Item ammoRocket;
	public static Item ammoAssaultRifle;
	public static Item ammoPlasma;
	public static Item itemWheel;
	public static Item itemOil;
	public static Item ammoPlasmaRocket;
	public static Item tankHarvester;
	public static Item itemRubber;
	// Tool Materials
	public static ToolMaterial HaloMaterial;
	public static ToolMaterial PrometheanMaterial;

	public static ArmorMaterial PrometheanArmor;
	public static ArmorMaterial MarineArmor;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLLog.getLogger().info("[HaloCraft 2.0]: Starting to load...");
		
		haloCreativeTab = new HaloCreativeTab(CreativeTabs.getNextID(), "haloCreativeTab");
		spartaniumIngot = new SpartaniumIngot();
		itemOil = new ItemOil();
		itemWheel = new ItemWheel();
		itemRubber = new ItemRubber();
		ammoPlasmaRocket = new ItemAmmoPlasmaRocket();
		// Initalize Tank Harvester
		tankHarvester = new TankHarvester();
		// Initialize Plasma
		ammoPlasma = new ItemAmmoPlasma();
		HaloMaterial = EnumHelper.addToolMaterial("HaloMaterial", 3, 1750, 9.0F, 6.0F, 10);
		PrometheanMaterial = EnumHelper.addToolMaterial("PrometheanMaterial", 3, 1750, 9.0F, 8.0F, 10);
		PrometheanArmor = EnumHelper.addArmorMaterial("PrometheanArmor", "halocraft:textures/models/armor/PrometheanArmor", 100, new int[] { 6, 9, 7, 5 }, 30);
		HaloArmor = EnumHelper.addArmorMaterial("HaloArmor", "halocraft:textures/models/armor/HaloArmor", 75, new int[] { 5, 7, 7, 5 }, 30);
		CovenantArmor = EnumHelper.addArmorMaterial("CovenantArmor", "halocraft:textures/models/armor/CovenantArmor", 50, new int[] { 5, 6, 6, 5 }, 30);
		MarineArmor = EnumHelper.addArmorMaterial("MarineArmor", "halocraft:textures/models/armor/MarineArmor", 50, new int[] { 5, 6, 6, 5 }, 30);
		ActiveCamoArmor = EnumHelper.addArmorMaterial("ActiveCamoArmor", "halocraft:textures/models/armor/ActiveCamoArmor", 100, new int[] { 6, 6, 10, 8 }, 30);
		HaloOreGen = new HaloGenerationClass();
		// HaloBlock = new HaloBlock(Material.iron);
		covenantPiece = new CovenantPiece();
		ammoRocket = new ItemRocket();
		ammoAssaultRifle = new ItemAmmoAssaultRifle();

		// Promethean Armor
		prometheanHelmet = new halocraft.armor.PrometheanArmor(PrometheanArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("prometheanHelmet");
		PrometheanChestplate = new halocraft.armor.PrometheanArmor(PrometheanArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("PrometheanChestplate");
		PrometheanLeggings = new halocraft.armor.PrometheanArmor(PrometheanArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("PrometheanLeggings");
		PrometheanBoots = new halocraft.armor.PrometheanArmor(PrometheanArmor, halocraft.Main.bootID, 3).setUnlocalizedName("PrometheanBoots");

		// Marine Armor
		MarineHelmet = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("MarineHelmet");
		MarineChestplate = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("MarineChestplate");
		MarineLeggings = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("MarineLeggings");
		MarineBoots = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.bootID, 3).setUnlocalizedName("MarineBoots");

		RedMarineHelmet = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("RedMarineHelmet");
		RedMarineChestplate = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("RedMarineChestplate");
		RedMarineLeggings = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("RedMarineLeggings");
		RedMarineBoots = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.bootID, 3).setUnlocalizedName("RedMarineBoots");

		BlueMarineHelmet = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("BlueMarineHelmet");
		BlueMarineChestplate = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("BlueMarineChestplate");
		BlueMarineLeggings = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("BlueMarineLeggings");
		BlueMarineBoots = new halocraft.armor.MarineArmor(MarineArmor, halocraft.Main.bootID, 3).setUnlocalizedName("BlueMarineBoots");

		Jetpack = new HaloArmor(HaloArmor, chestplateID, 1).setUnlocalizedName("Jetpack");

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

		// Register Entities
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityMongoose.class, "Mongoose", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityScorpion.class, "Socrpion", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityPlasmaRocket.class, "PlasmaRocket", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityGhost.class, "Ghost", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityPurplePlasma.class, "PurplePlasma", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityWarthogTurret.class, "WarthogTurret", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityRocket.class, "Rocket", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityRedPlasma.class, "RedPlasma", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityGreenPlasma.class, "GreenPlasma", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityWarthog.class, "Warthog", getRandomID(), this, 250, 50, true);
		EntityRegistry.registerModEntity(EntityFragGrenade.class, "fragGrenade", getRandomID(), this, 128, 1, true);
		EntityRegistry.registerModEntity(EntityPulseGrenade.class, "pulseGrenade", getRandomID(), this, 250, 50, true);

		EntityRegistry.registerGlobalEntityID(EntityElite.class, "GoldenElite", EntityRegistry.findGlobalUniqueEntityId(), 0xFFEE00, 0xFFFFFF);
		EntityRegistry.addSpawn(EntityElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerGlobalEntityID(EntityRedElite.class, "RedElite", EntityRegistry.findGlobalUniqueEntityId(), 0xFF0000, 0x000000);
		EntityRegistry.addSpawn(EntityRedElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerGlobalEntityID(EntityBlueElite.class, "BlueElite", EntityRegistry.findGlobalUniqueEntityId(), 0x002FFF, 0xCC00FF);
		EntityRegistry.addSpawn(EntityBlueElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerGlobalEntityID(EntityGrunt.class, "Grunt", EntityRegistry.findGlobalUniqueEntityId(), 0x4F2E00, 0x424242);
		EntityRegistry.addSpawn(EntityGrunt.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerGlobalEntityID(EntityPromethean.class, "Promethean", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFF7700);
		EntityRegistry.addSpawn(EntityPromethean.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerGlobalEntityID(EntityMarine.class, "Marine", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x47BEE6);
		EntityRegistry.addSpawn(EntityMarine.class, 15, 4, 10, EnumCreatureType.CREATURE, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		// Register Items and Blocks
		GameRegistry.registerItem(ItemScattershot.instance, ItemScattershot.name);
		GameRegistry.registerItem(ItemEnergySword.instance, ItemEnergySword.name);
		GameRegistry.registerItem(PrometheanSword.instance, PrometheanSword.name);
		GameRegistry.registerBlock(HaloOre, "HaloOre");
		GameRegistry.registerBlock(RedPlasmaBlock.instance, RedPlasmaBlock.name);
		GameRegistry.registerBlock(PurplePlasmaBlock.instance, PurplePlasmaBlock.name);
		GameRegistry.registerBlock(ForerunnerOre, "ForerunnerOre");
		GameRegistry.registerItem(itemWheel, "itemWheel");
		GameRegistry.registerItem(itemOil, "itemOil");
		GameRegistry.registerBlock(RedPlasmaOre, "RedPlasmaOre");
		GameRegistry.registerBlock(GreenPlasmaOre, "GreenPlasmaOre");
		GameRegistry.registerBlock(PurplePlasmaOre, "PurplePlasmaOre");
		GameRegistry.registerBlock(HaloBlock.instance, HaloBlock.name);
		GameRegistry.registerItem(ItemMongoose.instance, ItemMongoose.name);
		GameRegistry.registerItem(ItemWarthogTurret.instance, ItemWarthogTurret.name);
		GameRegistry.registerItem(covenantPiece, "covenantPiece");
		GameRegistry.registerItem(FragGrenade.instance, FragGrenade.name);
		GameRegistry.registerItem(spartaniumIngot, "SpartaniumIngot");
		GameRegistry.registerItem(ItemRocketLauncher.instance, ItemRocketLauncher.name);
		GameRegistry.registerItem(ammoRocket, "ammoRocket");
		GameRegistry.registerItem(Jetpack, "Jetpack");
		GameRegistry.registerItem(ammoAssaultRifle, "ammoAssaultRifle");
		GameRegistry.registerItem(ItemForerunnerShard.instance, ItemForerunnerShard.name);
		GameRegistry.registerItem(ItemAssaultRifle.instance, ItemAssaultRifle.name);
		GameRegistry.registerItem(ItemBattleRifle.instance, ItemBattleRifle.name);
		GameRegistry.registerItem(ItemHealthPack.instance, ItemHealthPack.name);
		GameRegistry.registerItem(ItemRedPlasmaAmmo.instance, ItemRedPlasmaAmmo.name);
		GameRegistry.registerItem(ItemGhost.instance, ItemGhost.name);
		GameRegistry.registerItem(ammoPlasmaRocket, "ammoPlasmaRocket");
		GameRegistry.registerItem(itemRubber, "itemRubber");
		GameRegistry.registerItem(ItemLightRifle.instance, ItemLightRifle.name);
		GameRegistry.registerItem(ItemScorpion.instance, ItemScorpion.name);
		GameRegistry.registerItem(ItemIncinerationCannon.instance, ItemIncinerationCannon.name);
		GameRegistry.registerItem(ammoPlasma, "ammoPlasma");
		GameRegistry.registerItem(PulseGrenade.instance, PulseGrenade.name);
		GameRegistry.registerItem(Pistol.instance, Pistol.name);
		GameRegistry.registerItem(ItemNeedlerAmmo.instance, ItemNeedlerAmmo.name);
		GameRegistry.registerItem(RedPlasmaIngot.instance, RedPlasmaIngot.name);
		GameRegistry.registerItem(ItemSniperRifle.instance, ItemSniperRifle.name);
		GameRegistry.registerItem(tankHarvester, "TankHarvester");
		GameRegistry.registerItem(ItemCarbineRifle.instance, ItemCarbineRifle.name);
		GameRegistry.registerItem(ItemNeedler.instance, ItemNeedler.name);
		GameRegistry.registerItem(ItemWarthog.instance, ItemWarthog.name);
		GameRegistry.registerItem(GreenPlasmaIngot.instance, GreenPlasmaIngot.name);
		GameRegistry.registerItem(prometheanHelmet, "prometheanHelmet");
		GameRegistry.registerItem(PrometheanChestplate, "PrometheanChestplate");
		GameRegistry.registerItem(PrometheanLeggings, "PrometheanLeggings");
		GameRegistry.registerItem(PrometheanBoots, "PrometheanBoots");
		GameRegistry.registerItem(MarineHelmet, "MarineHelmet");
		GameRegistry.registerItem(MarineChestplate, "MarineChestplate");
		GameRegistry.registerItem(MarineLeggings, "MarineLeggings");
		GameRegistry.registerItem(MarineBoots, "MarineBoots");
		GameRegistry.registerItem(RedMarineHelmet, "RedMarineHelmet");
		GameRegistry.registerItem(RedMarineChestplate, "RedMarineChestplate");
		GameRegistry.registerItem(RedMarineLeggings, "RedMarineLeggings");
		GameRegistry.registerItem(RedMarineBoots, "RedMarineBoots");
		GameRegistry.registerItem(BlueMarineHelmet, "BlueMarineHelmet");
		GameRegistry.registerItem(BlueMarineChestplate, "BlueMarineChestplate");
		GameRegistry.registerItem(BlueMarineLeggings, "BlueMarineLeggings");
		GameRegistry.registerItem(BlueMarineBoots, "BlueMarineBoots");
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
		GameRegistry.registerItem(PurplePlasmaIngot.instance, PurplePlasmaIngot.name);
		GameRegistry.registerItem(halocraft.Main.CovenantHelmet, "CovenantHelmet");
		GameRegistry.registerItem(halocraft.Main.CovenantChestplate, "CovenantChestplate");
		GameRegistry.registerItem(halocraft.Main.CovenantLeggings, "CovenantLeggings");
		GameRegistry.registerItem(halocraft.Main.CovenantBoots, "CovenantBoots");
		GameRegistry.registerItem(halocraft.Main.ActiveCamoChestplate, "ActiveCamoChestplate");
		GameRegistry.registerItem(ItemFuelRodCannon.instance, ItemFuelRodCannon.name);
		GameRegistry.registerItem(PlasmaRifle.instance, PlasmaRifle.name);
		GameRegistry.registerItem(ItemCarbineAmmo.instance, ItemCarbineAmmo.name);
		GameRegistry.registerBlock(RoofBlock.instance, RoofBlock.name);
		GameRegistry.registerBlock(ForerunnerWallBlock.instance, ForerunnerWallBlock.name);
		GameRegistry.registerBlock(ForerunnerFloorBlock.instance, ForerunnerFloorBlock.name);
		GameRegistry.registerItem(ItemBoltshot.instance, ItemBoltshot.name);
		// Block Recipes
		GameRegistry.addRecipe(new ItemStack(HaloBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(PurplePlasmaBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', PurplePlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(RedPlasmaBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', RedPlasmaIngot.instance });

		GameRegistry.addRecipe(new ItemStack(itemRubber, 2), new Object[] { "XXX", "XXX", "XXX", 'X', itemOil });

		// Gun Recipes
		ItemStack gunpowderStack = new ItemStack(Items.gunpowder);
		ItemStack glassPaneStack = new ItemStack(Blocks.glass_pane);
		ItemStack redGlassPaneStack = new ItemStack(Blocks.stained_glass_pane, 1, 14);
		GameRegistry.addRecipe(new ItemStack(ItemBattleRifle.instance, 1), new Object[] { "ZA ", "XXY", " AX", 'X', spartaniumIngot, 'Y', gunpowderStack, 'Z', glassPaneStack, 'A', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ItemLightRifle.instance, 1), new Object[] { "ZX ", "YXX", " XX", 'X', RedPlasmaIngot.instance, 'Y', ItemRedPlasmaAmmo.instance, 'Z', redGlassPaneStack });
		GameRegistry.addRecipe(new ItemStack(Pistol.instance, 1), new Object[] { "   ", " XY", "  Z", 'X', spartaniumIngot, 'Y', gunpowderStack, 'Z', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ItemSniperRifle.instance, 1), new Object[] { "XYX", "ZYY", " IY", 'X', glassPaneStack, 'Y', spartaniumIngot, 'Z', gunpowderStack, 'I', new ItemStack(Items.iron_ingot) });
		// Recipes
		ItemStack woolStack = new ItemStack(Blocks.wool);
		ItemStack goldenAppleStack = new ItemStack(Items.golden_apple);
		GameRegistry.addRecipe(new ItemStack(ItemWarthogTurret.instance, 1), new Object[] { "  Z", "XXX", "YXY", 'X', HaloBlock.instance, 'Y', itemWheel, 'Z', ItemAssaultRifle.instance });
		GameRegistry.addRecipe(new ItemStack(ItemWarthog.instance, 1), new Object[] { "   ", "XXX", "YXY", 'X', HaloBlock.instance, 'Y', itemWheel });
		GameRegistry.addRecipe(new ItemStack(ItemScorpion.instance, 1), new Object[] { "YXX", "XXX", "XXX", 'X', HaloBlock.instance, 'Y', ItemRocketLauncher.instance });
		GameRegistry.addRecipe(new ItemStack(ItemGhost.instance, 1), new Object[] { "   ", "XY ", "YYY", 'X', PlasmaRifle.instance, 'Y', PurplePlasmaBlock.instance });
		GameRegistry.addRecipe(new ItemStack(ItemIncinerationCannon.instance, 1), new Object[] { "  X", "YYX", " ZY", 'X', ItemRedPlasmaAmmo.instance, 'Y', RedPlasmaBlock.instance, 'Z', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(tankHarvester, 1), new Object[] { "XXX", "XYX", "XXX", 'X', spartaniumIngot, 'Y', ItemScorpion.instance });

		// Pulse Grenade
		GameRegistry.addRecipe(new ItemStack(PulseGrenade.instance, 1), new Object[] { " X ", "XYX", " X ", 'X', RedPlasmaIngot.instance, 'Y', Blocks.tnt });

		// Spartan Armor
		GameRegistry.addRecipe(new ItemStack(SpartanHelmet, 1), new Object[] { "XXX", "X X", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(SpartanChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(SpartanLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(SpartanBoots, 1), new Object[] { "X X", "X X", 'X', spartaniumIngot });

		// Promethean Armor
		GameRegistry.addRecipe(new ItemStack(prometheanHelmet, 1), new Object[] { "XXX", "X X", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(PrometheanChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(PrometheanLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(PrometheanBoots, 1), new Object[] { "X X", "X X", 'X', RedPlasmaIngot.instance });

		// Marine Armor
		GameRegistry.addRecipe(new ItemStack(MarineHelmet, 1), new Object[] { "XXX", "Y Y", 'X', spartaniumIngot, 'Y', Items.leather });
		GameRegistry.addRecipe(new ItemStack(MarineChestplate, 1), new Object[] { "Y Y", "XXX", "XXX", 'X', spartaniumIngot, 'Y', Items.leather });
		GameRegistry.addRecipe(new ItemStack(MarineLeggings, 1), new Object[] { "YYY", "X X", "X X", 'X', spartaniumIngot, 'Y', Items.leather });
		GameRegistry.addRecipe(new ItemStack(MarineBoots, 1), new Object[] { "Y Y", "X X", 'X', spartaniumIngot, 'Y', Items.leather });

		GameRegistry.addRecipe(new ItemStack(CovenantHelmet, 1), new Object[] { "XXX", "X X", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(CovenantChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(CovenantLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(CovenantBoots, 1), new Object[] { "X X", "X X", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(ammoRocket, 5), new Object[] { " X ", " X ", " YZ", 'X', spartaniumIngot, 'Y', gunpowderStack, 'Z', new ItemStack(Items.string) });
		GameRegistry.addRecipe(new ItemStack(ammoPlasmaRocket, 5), new Object[] { " X ", " X ", " YZ", 'X', GreenPlasmaIngot.instance, 'Y', gunpowderStack, 'Z', new ItemStack(Items.string) });
		GameRegistry.addRecipe(new ItemStack(ItemRedPlasmaAmmo.instance, 1), new Object[] { " X ", " X ", " YZ", 'X', RedPlasmaIngot.instance, 'Y', gunpowderStack, 'Z', new ItemStack(Items.string) });
		ItemStack coalStack = new ItemStack(Items.coal);
		GameRegistry.addRecipe(new ItemStack(ItemMongoose.instance, 1), new Object[] { "X  ", "YYY", "ZYZ", 'X', spartaniumIngot, 'Y', HaloBlock.instance, 'Z', itemWheel });

		// Health Pack Crafting Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHealthPack.instance, 1), new ItemStack(Items.nether_wart, 1), new ItemStack(Items.speckled_melon, 1), new ItemStack(Blocks.wool, 1));

		// Active Camo Armor
		GameRegistry.addShapelessRecipe(new ItemStack(ActiveCamoChestplate, 1), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.fermented_spider_eye, 1), new ItemStack(Items.nether_wart, 1), SpartanChestplate);

		// Forerunner Blocks
		GameRegistry.addRecipe(new ItemStack(ForerunnerFloorBlock.instance, 1), new Object[] { "XX ", "XX ", 'X', new ItemStack(ItemForerunnerShard.instance) });
		GameRegistry.addRecipe(new ItemStack(ForerunnerWallBlock.instance, 1), new Object[] { "XX ", "XX ", 'X', new ItemStack(ForerunnerFloorBlock.instance) });
		GameRegistry.addRecipe(new ItemStack(RoofBlock.instance, 1), new Object[] { "XX ", "XX ", 'X', new ItemStack(ForerunnerWallBlock.instance) });

		// Red Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanHelmet, 1), new ItemStack(Items.dye, 1, 1), SpartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanChestplate, 1), new ItemStack(Items.dye, 1, 1), SpartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanLeggings, 1), new ItemStack(Items.dye, 1, 1), SpartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanBoots, 1), new ItemStack(Items.dye, 1, 1), SpartanBoots);

		// Red Marine Armor
		GameRegistry.addShapelessRecipe(new ItemStack(RedMarineHelmet, 1), new ItemStack(Items.dye, 1, 1), MarineHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(RedMarineChestplate, 1), new ItemStack(Items.dye, 1, 1), MarineChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(RedMarineLeggings, 1), new ItemStack(Items.dye, 1, 1), MarineLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(RedMarineBoots, 1), new ItemStack(Items.dye, 1, 1), MarineBoots);

		// Blue Marine Armor
		GameRegistry.addShapelessRecipe(new ItemStack(BlueMarineHelmet, 1), new ItemStack(Items.dye, 1, 6), MarineHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueMarineChestplate, 1), new ItemStack(Items.dye, 1, 6), MarineChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueMarineLeggings, 1), new ItemStack(Items.dye, 1, 6), MarineLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueMarineBoots, 1), new ItemStack(Items.dye, 1, 6), MarineBoots);

		// Green Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanHelmet, 1), new ItemStack(Items.dye, 1, 10), SpartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanChestplate, 1), new ItemStack(Items.dye, 1, 10), SpartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanLeggings, 1), new ItemStack(Items.dye, 1, 10), SpartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanBoots, 1), new ItemStack(Items.dye, 1, 10), SpartanBoots);

		// Blue Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanHelmet, 1), new ItemStack(Items.dye, 1, 6), SpartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanChestplate, 1), new ItemStack(Items.dye, 1, 6), SpartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanLeggings, 1), new ItemStack(Items.dye, 1, 6), SpartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanBoots, 1), new ItemStack(Items.dye, 1, 6), SpartanBoots);

		GameRegistry.addRecipe(new ItemStack(itemWheel, 1), new Object[] { "XXX", "XYX", "XXX", 'X', itemRubber, 'Y', Items.iron_ingot });
		ItemStack stickStack = new ItemStack(Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemEnergySword.instance, 1), new Object[] { " X ", " X ", " Y ", 'X', PurplePlasmaIngot.instance, 'Y', stickStack });
		GameRegistry.addRecipe(new ItemStack(PrometheanSword.instance, 1), new Object[] { " X ", " X ", " Y ", 'X', RedPlasmaIngot.instance, 'Y', stickStack });
		ItemStack gunStack = new ItemStack(Items.gunpowder);
		GameRegistry.addRecipe(new ItemStack(ItemRocketLauncher.instance, 1), new Object[] { " XX", "YYY", " IZ", 'X', ammoRocket, 'Y', spartaniumIngot, 'Z', HaloBlock.instance, 'I', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ItemFuelRodCannon.instance, 1), new Object[] { "XXZ", "XYZ", " XX", 'X', GreenPlasmaIngot.instance, 'Y', covenantPiece, 'Z', ammoPlasmaRocket });
		ItemStack ironStack = new ItemStack(Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemAssaultRifle.instance, 1), new Object[] { "   ", "XXY", " ZX", 'X', spartaniumIngot, 'Y', gunStack, 'Z', ironStack });
		ItemStack goldStack = new ItemStack(Items.gold_ingot);
		ItemStack greenIngotStack = new ItemStack(GreenPlasmaIngot.instance);
		GameRegistry.addRecipe(new ItemStack(ammoAssaultRifle, 15), new Object[] { " X ", " X ", "XYX", 'X', goldStack, 'Y', gunStack });
		GameRegistry.addRecipe(new ItemStack(ItemCarbineAmmo.instance, 15), new Object[] { " X ", " X ", "XYX", 'X', greenIngotStack, 'Y', gunStack });
		GameRegistry.addRecipe(new ItemStack(ItemNeedlerAmmo.instance, 15), new Object[] { " X ", " X ", "XYX", 'X', new ItemStack(PurplePlasmaIngot.instance), 'Y', gunStack });
		GameRegistry.addRecipe(new ItemStack(ItemCarbineRifle.instance, 1), new Object[] { "XZ ", "PGG", " CG", 'X', covenantPiece, 'C', new ItemStack(ItemCarbineAmmo.instance), 'Z', new ItemStack(RedPlasmaIngot.instance), 'P', new ItemStack(PurplePlasmaIngot.instance), 'G', new ItemStack(GreenPlasmaIngot.instance) });
		GameRegistry.addRecipe(new ItemStack(ItemNeedler.instance, 1), new Object[] { "XXX", "YYY", "  Y", 'X', ItemNeedlerAmmo.instance, 'Y', PurplePlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(PlasmaRifle.instance, 1), new Object[] { "YY ", " XY", "YY ", 'X', ammoPlasma, 'Y', RedPlasmaIngot.instance });
		GameRegistry.addSmelting(HaloOre, new ItemStack(spartaniumIngot, 1), 0.1f);
		GameRegistry.addSmelting(new ItemStack(Blocks.dirt), new ItemStack(itemOil, 1), 0.1f);
		GameRegistry.addSmelting(RedPlasmaOre, new ItemStack(RedPlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addSmelting(PurplePlasmaOre, new ItemStack(PurplePlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addSmelting(ForerunnerOre, new ItemStack(ItemForerunnerShard.instance, 1), 0.1f);
		GameRegistry.addSmelting(GreenPlasmaIngot.instance, new ItemStack(ammoPlasma, 1), 0.1f);
		GameRegistry.addSmelting(GreenPlasmaOre, new ItemStack(GreenPlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addShapelessRecipe(new ItemStack(covenantPiece, 1), new ItemStack(Items.blaze_rod, 1), new ItemStack(Items.coal, 1));
		// Frag Grenade Crafting
		ItemStack tntStack = new ItemStack(Blocks.tnt);
		GameRegistry.addRecipe(new ItemStack(FragGrenade.instance, 1), new Object[] { " X ", "XYX", "XXX", 'X', ironStack, 'Y', tntStack });

		// World Gen Registration
		GameRegistry.registerWorldGenerator(HaloOreGen, 1);

		if (event.getSide() == Side.CLIENT)
			proxy.preInit();
	}

	public int getRandomID()
	{
		counter++;
		return counter + EntityRegistry.findGlobalUniqueEntityId();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		// Register Key Handler(s)
		proxy.registerKey();

		// Register Rendering Classes
		proxy.registerRenders();

		// Register Packet Handler
		HalocraftPacketHandler.INSTANCE.registerMessage(FireMessageHandler.class, FireMessage.class, 0, Side.SERVER);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		FMLLog.getLogger().info("[HaloCraft 2.0]: Loaded Successfully!");
		FMLLog.getLogger().info("[HaloCraft 2.0]: This mod was created by NEGAFINITY, if you have issues please post them on GitHub!");
	}
}
