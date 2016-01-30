package halocraft.proxies;

import halocraft.HaloCraft;
import halocraft.HaloGenerationClass;
import halocraft.armor.ActiveCamoArmor;
import halocraft.armor.CovenantArmor;
import halocraft.armor.GrenadierArmor;
import halocraft.armor.HaloArmor;
import halocraft.armor.MarineArmor;
import halocraft.armor.PrometheanArmor;
import halocraft.armor.ReconArmor;
import halocraft.armor.SpartanLockeArmor;
import halocraft.blocks.ForerunnerFloorBlock;
import halocraft.blocks.ForerunnerOre;
import halocraft.blocks.ForerunnerWallBlock;
import halocraft.blocks.HaloBlock;
import halocraft.blocks.HaloOre;
import halocraft.blocks.PurplePlasmaBlock;
import halocraft.blocks.RedPlasmaBlock;
import halocraft.blocks.RoofBlock;
import halocraft.blocks.SteelBlock;
import halocraft.blocks.TitaniumBlock;
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
import halocraft.items.CovenantPiece;
import halocraft.items.FragGrenade;
import halocraft.items.GreenPlasmaIngot;
import halocraft.items.ItemMagazine;
import halocraft.items.ItemAmmoPlasma;
import halocraft.items.ItemAmmoPlasmaRocket;
import halocraft.items.ItemAmmoPrometheanMagazine;
import halocraft.items.ItemAntiChip;
import halocraft.items.ItemCarbineAmmo;
import halocraft.items.ItemEnergySword;
import halocraft.items.ItemForerunnerShard;
import halocraft.items.ItemFusionCoil;
import halocraft.items.ItemGhost;
import halocraft.items.ItemHealthPack;
import halocraft.items.ItemMongoose;
import halocraft.items.ItemNeedlerAmmo;
import halocraft.items.ItemOil;
import halocraft.items.ItemRedPlasmaAmmo;
import halocraft.items.ItemRocket;
import halocraft.items.ItemRubber;
import halocraft.items.ItemScorpion;
import halocraft.items.ItemWarthog;
import halocraft.items.ItemWarthogTurret;
import halocraft.items.ItemWheel;
import halocraft.items.PrometheanSword;
import halocraft.items.PulseGrenade;
import halocraft.items.PurplePlasmaIngot;
import halocraft.items.RedPlasmaIngot;
import halocraft.items.SpartaniumIngot;
import halocraft.items.SteelIngot;
import halocraft.items.TankHarvester;
import halocraft.items.TitaniumIngot;
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
import halocraft.packets.FireMessage;
import halocraft.packets.FireMessageHandler;
import halocraft.packets.HalocraftPacketHandler;
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
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy
{
	public int counter = 0;

	// World Generation
	public static HaloGenerationClass haloOreGen;

	// Armor
	public static final int HELMET_ID = 0;
	public static final int CHESTPLATE_ID = 0;
	public static final int LEGGING_ID = 0;
	public static final int BOOT_ID = 0;

	// Items
	public static Item spartaniumIngot;
	public static Item ammoRocket;
	public static Item ammoAssaultRifle;
	public static Item ammoPrometheanMagazine;
	public static Item ammoPlasma;
	public static Item itemWheel;
	public static Item itemOil;
	public static Item itemAntiChip;
	public static Item itemFusionCoil;
	public static Item ammoPlasmaRocket;
	public static Item tankHarvester;
	public static Item itemRubber;

	public static Item spartanHelmet;
	public static Item spartanChestplate;
	public static Item spartanLeggings;
	public static Item spartanBoots;

	public static Item prometheanHelmet;
	public static Item prometheanChestplate;
	public static Item prometheanLeggings;
	public static Item prometheanBoots;

	public static Item spartanLockeHelmet;
	public static Item spartanLockeChestplate;
	public static Item spartanLockeLeggings;
	public static Item spartanLockeBoots;

	public static Item greenGrenadierHelmet;
	public static Item greenGrenadierChestplate;
	public static Item greenGrenadierLeggings;
	public static Item greenGrenadierBoots;

	public static Item orangeGrenadierHelmet;
	public static Item orangeGrenadierChestplate;
	public static Item orangeGrenadierLeggings;
	public static Item orangeGrenadierBoots;

	public static Item reconHelmet;
	public static Item reconChestplate;
	public static Item reconLeggings;
	public static Item reconBoots;

	public static Item blueReconHelmet;
	public static Item blueReconChestplate;
	public static Item blueReconLeggings;
	public static Item blueReconBoots;

	public static Item redReconHelmet;
	public static Item redReconChestplate;
	public static Item redReconLeggings;
	public static Item redReconBoots;

	public static Item marineHelmet;
	public static Item marineChestplate;
	public static Item marineLeggings;
	public static Item marineBoots;

	public static Item blueMarineHelmet;
	public static Item blueMarineChestplate;
	public static Item blueMarineLeggings;
	public static Item blueMarineBoots;

	public static Item redMarineHelmet;
	public static Item redMarineChestplate;
	public static Item redMarineLeggings;
	public static Item redMarineBoots;

	public static Item redSpartanHelmet;
	public static Item redSpartanChestplate;
	public static Item redSpartanLeggings;
	public static Item redSpartanBoots;

	public static Item greenSpartanHelmet;
	public static Item greenSpartanChestplate;
	public static Item greenSpartanLeggings;
	public static Item greenSpartanBoots;

	public static Item blueSpartanHelmet;
	public static Item blueSpartanChestplate;
	public static Item blueSpartanLeggings;
	public static Item blueSpartanBoots;

	public static Item covenantHelmet;
	public static Item covenantChestplate;
	public static Item covenantLeggings;
	public static Item covenantBoots;
	public static Item covenantPiece;

	public static Item activeCamoChestplate;

	public static Item jetpack;

	// Blocks
	public final static Block haloOre = new HaloOre(Material.iron);
	public final static Block forerunnerOre = new ForerunnerOre(Material.iron);
	public final static Block redPlasmaOre = new halocraft.blocks.RedPlasmaOre(Material.iron);
	public final static Block greenPlasmaOre = new halocraft.blocks.GreenPlasmaOre(Material.iron);
	public final static Block purplePlasmaOre = new halocraft.blocks.PurplePlasmaOre(Material.iron);

	// Creative Tabs
	public static CreativeTabs haloCreativeTab;

	// Tool Materials
	public static ToolMaterial haloMaterial;
	public static ToolMaterial prometheanMaterial;

	// Armor Material
	public static ArmorMaterial haloArmor;
	public static ArmorMaterial spartanLockeArmor;
	public static ArmorMaterial covenantArmor;
	public static ArmorMaterial activeCamoArmor;
	public static ArmorMaterial prometheanArmor;
	public static ArmorMaterial marineArmor;

	public void initializeCreativeTabs()
	{
		haloCreativeTab = new HaloCreativeTab(CreativeTabs.getNextID(), "haloCreativeTab");
	}

	public void initializeMaterials()
	{
		haloMaterial = EnumHelper.addToolMaterial("HaloMaterial", 3, 1750, 9.0F, 6.0F, 10);
		prometheanMaterial = EnumHelper.addToolMaterial("PrometheanMaterial", 3, 1750, 9.0F, 8.0F, 10);
		haloArmor = EnumHelper.addArmorMaterial("HaloArmor", "halocraft:textures/models/armor/HaloArmor", 75, new int[] { 5, 7, 7, 5 }, 30);
		spartanLockeArmor = EnumHelper.addArmorMaterial("HaloArmor", "halocraft:textures/models/armor/SpartanLockeArmor", 75, new int[] { 6, 7, 6, 6 }, 30);
		prometheanArmor = EnumHelper.addArmorMaterial("PrometheanArmor", "halocraft:textures/models/armor/PrometheanArmor", 100, new int[] { 6, 9, 7, 5 }, 30);
		covenantArmor = EnumHelper.addArmorMaterial("CovenantArmor", "halocraft:textures/models/armor/CovenantArmor", 50, new int[] { 5, 6, 6, 5 }, 30);
		marineArmor = EnumHelper.addArmorMaterial("MarineArmor", "halocraft:textures/models/armor/MarineArmor", 50, new int[] { 5, 6, 6, 5 }, 30);
		activeCamoArmor = EnumHelper.addArmorMaterial("ActiveCamoArmor", "halocraft:textures/models/armor/ActiveCamoArmor", 100, new int[] { 6, 6, 10, 8 }, 30);
	}

	public void initializeItems()
	{
		spartaniumIngot = new SpartaniumIngot();
		itemOil = new ItemOil();
		itemAntiChip = new ItemAntiChip();
		itemFusionCoil = new ItemFusionCoil();
		itemWheel = new ItemWheel();
		itemRubber = new ItemRubber();
		ammoPlasmaRocket = new ItemAmmoPlasmaRocket();
		tankHarvester = new TankHarvester();
		ammoPlasma = new ItemAmmoPlasma();
		ammoPrometheanMagazine = new ItemAmmoPrometheanMagazine();
		covenantPiece = new CovenantPiece();
		ammoRocket = new ItemRocket();
		ammoAssaultRifle = new ItemMagazine();

		// Promethean Armor
		prometheanHelmet = new PrometheanArmor(prometheanArmor, HELMET_ID, 0).setUnlocalizedName("prometheanHelmet");
		prometheanChestplate = new PrometheanArmor(prometheanArmor, CHESTPLATE_ID, 1).setUnlocalizedName("PrometheanChestplate");
		prometheanLeggings = new PrometheanArmor(prometheanArmor, LEGGING_ID, 2).setUnlocalizedName("PrometheanLeggings");
		prometheanBoots = new PrometheanArmor(prometheanArmor, BOOT_ID, 3).setUnlocalizedName("PrometheanBoots");

		// Spartan Locke Armor
		spartanLockeHelmet = new SpartanLockeArmor(spartanLockeArmor, HELMET_ID, 0).setUnlocalizedName("SpartanLockeHelmet");
		spartanLockeChestplate = new SpartanLockeArmor(spartanLockeArmor, CHESTPLATE_ID, 1).setUnlocalizedName("SpartanLockeChestplate");
		spartanLockeLeggings = new SpartanLockeArmor(spartanLockeArmor, LEGGING_ID, 2).setUnlocalizedName("SpartanLockeLeggings");
		spartanLockeBoots = new SpartanLockeArmor(spartanLockeArmor, BOOT_ID, 3).setUnlocalizedName("SpartanLockeBoots");

		// Grenadier Armor
		greenGrenadierHelmet = new GrenadierArmor(marineArmor, HELMET_ID, 0).setUnlocalizedName("GreenGrenadierHelmet");
		greenGrenadierChestplate = new GrenadierArmor(marineArmor, CHESTPLATE_ID, 1).setUnlocalizedName("GreenGrenadierChestplate");
		greenGrenadierLeggings = new GrenadierArmor(marineArmor, LEGGING_ID, 2).setUnlocalizedName("GreenGrenadierLeggings");
		greenGrenadierBoots = new GrenadierArmor(marineArmor, BOOT_ID, 3).setUnlocalizedName("GreenGrenadierBoots");

		orangeGrenadierHelmet = new GrenadierArmor(marineArmor, HELMET_ID, 0).setUnlocalizedName("OrangeGrenadierHelmet");
		orangeGrenadierChestplate = new GrenadierArmor(marineArmor, CHESTPLATE_ID, 1).setUnlocalizedName("OrangeGrenadierChestplate");
		orangeGrenadierLeggings = new GrenadierArmor(marineArmor, LEGGING_ID, 2).setUnlocalizedName("OrangeGrenadierLeggings");
		orangeGrenadierBoots = new GrenadierArmor(marineArmor, BOOT_ID, 3).setUnlocalizedName("OrangeGrenadierBoots");

		// Recon Armor
		reconHelmet = new ReconArmor(marineArmor, HELMET_ID, 0).setUnlocalizedName("ReconHelmet");
		reconChestplate = new ReconArmor(marineArmor, CHESTPLATE_ID, 1).setUnlocalizedName("ReconChestplate");
		reconLeggings = new ReconArmor(marineArmor, LEGGING_ID, 2).setUnlocalizedName("ReconLeggings");
		reconBoots = new ReconArmor(marineArmor, BOOT_ID, 3).setUnlocalizedName("ReconBoots");

		blueReconHelmet = new ReconArmor(marineArmor, HELMET_ID, 0).setUnlocalizedName("BlueReconHelmet");
		blueReconChestplate = new ReconArmor(marineArmor, CHESTPLATE_ID, 1).setUnlocalizedName("BlueReconChestplate");
		blueReconLeggings = new ReconArmor(marineArmor, LEGGING_ID, 2).setUnlocalizedName("BlueReconLeggings");
		blueReconBoots = new ReconArmor(marineArmor, BOOT_ID, 3).setUnlocalizedName("BlueReconBoots");

		redReconHelmet = new ReconArmor(marineArmor, HELMET_ID, 0).setUnlocalizedName("RedReconHelmet");
		redReconChestplate = new ReconArmor(marineArmor, CHESTPLATE_ID, 1).setUnlocalizedName("RedReconChestplate");
		redReconLeggings = new ReconArmor(marineArmor, LEGGING_ID, 2).setUnlocalizedName("RedReconLeggings");
		redReconBoots = new ReconArmor(marineArmor, BOOT_ID, 3).setUnlocalizedName("RedReconBoots");

		// Marine Armor
		marineHelmet = new MarineArmor(marineArmor, HELMET_ID, 0).setUnlocalizedName("MarineHelmet");
		marineChestplate = new MarineArmor(marineArmor, CHESTPLATE_ID, 1).setUnlocalizedName("MarineChestplate");
		marineLeggings = new MarineArmor(marineArmor, LEGGING_ID, 2).setUnlocalizedName("MarineLeggings");
		marineBoots = new MarineArmor(marineArmor, BOOT_ID, 3).setUnlocalizedName("MarineBoots");

		redMarineHelmet = new MarineArmor(marineArmor, HELMET_ID, 0).setUnlocalizedName("RedMarineHelmet");
		redMarineChestplate = new MarineArmor(marineArmor, CHESTPLATE_ID, 1).setUnlocalizedName("RedMarineChestplate");
		redMarineLeggings = new MarineArmor(marineArmor, LEGGING_ID, 2).setUnlocalizedName("RedMarineLeggings");
		redMarineBoots = new MarineArmor(marineArmor, BOOT_ID, 3).setUnlocalizedName("RedMarineBoots");

		blueMarineHelmet = new MarineArmor(marineArmor, HELMET_ID, 0).setUnlocalizedName("BlueMarineHelmet");
		blueMarineChestplate = new MarineArmor(marineArmor, CHESTPLATE_ID, 1).setUnlocalizedName("BlueMarineChestplate");
		blueMarineLeggings = new MarineArmor(marineArmor, LEGGING_ID, 2).setUnlocalizedName("BlueMarineLeggings");
		blueMarineBoots = new MarineArmor(marineArmor, BOOT_ID, 3).setUnlocalizedName("BlueMarineBoots");

		jetpack = new HaloArmor(haloArmor, CHESTPLATE_ID, 1).setUnlocalizedName("Jetpack");

		blueSpartanHelmet = new HaloArmor(haloArmor, HELMET_ID, 0).setUnlocalizedName("BlueSpartanHelmet");
		blueSpartanChestplate = new HaloArmor(haloArmor, CHESTPLATE_ID, 1).setUnlocalizedName("BlueSpartanChestplate");
		blueSpartanLeggings = new HaloArmor(haloArmor, LEGGING_ID, 2).setUnlocalizedName("BlueSpartanLeggings");
		blueSpartanBoots = new HaloArmor(haloArmor, BOOT_ID, 3).setUnlocalizedName("BlueSpartanBoots");

		greenSpartanHelmet = new HaloArmor(haloArmor, HELMET_ID, 0).setUnlocalizedName("GreenSpartanHelmet");
		greenSpartanChestplate = new HaloArmor(haloArmor, CHESTPLATE_ID, 1).setUnlocalizedName("GreenSpartanChestplate");
		greenSpartanLeggings = new HaloArmor(haloArmor, LEGGING_ID, 2).setUnlocalizedName("GreenSpartanLeggings");
		greenSpartanBoots = new HaloArmor(haloArmor, BOOT_ID, 3).setUnlocalizedName("GreenSpartanBoots");

		redSpartanHelmet = new HaloArmor(haloArmor, HELMET_ID, 0).setUnlocalizedName("RedSpartanHelmet");
		redSpartanChestplate = new HaloArmor(haloArmor, CHESTPLATE_ID, 1).setUnlocalizedName("RedSpartanChestplate");
		redSpartanLeggings = new HaloArmor(haloArmor, LEGGING_ID, 2).setUnlocalizedName("RedSpartanLeggings");
		redSpartanBoots = new HaloArmor(haloArmor, BOOT_ID, 3).setUnlocalizedName("RedSpartanBoots");

		spartanHelmet = new HaloArmor(haloArmor, HELMET_ID, 0).setUnlocalizedName("SpartanHelmet");
		spartanChestplate = new HaloArmor(haloArmor, CHESTPLATE_ID, 1).setUnlocalizedName("SpartanChestplate");
		spartanLeggings = new HaloArmor(haloArmor, LEGGING_ID, 2).setUnlocalizedName("SpartanLeggings");
		spartanBoots = new HaloArmor(haloArmor, BOOT_ID, 3).setUnlocalizedName("SpartanBoots");
		covenantHelmet = new CovenantArmor(covenantArmor, HELMET_ID, 0).setUnlocalizedName("CovenantHelmet");
		covenantChestplate = new CovenantArmor(covenantArmor, CHESTPLATE_ID, 1).setUnlocalizedName("CovenantChestplate");
		covenantLeggings = new CovenantArmor(covenantArmor, LEGGING_ID, 2).setUnlocalizedName("CovenantLeggings");
		covenantBoots = new CovenantArmor(covenantArmor, BOOT_ID, 3).setUnlocalizedName("CovenantBoots");

		activeCamoChestplate = new ActiveCamoArmor(activeCamoArmor, CHESTPLATE_ID, 1).setUnlocalizedName("ActiveCamoChestplate");

		// Register Items
		GameRegistry.registerItem(itemWheel, "itemWheel");
		GameRegistry.registerItem(itemOil, "itemOil");
		GameRegistry.registerItem(itemAntiChip, "itemAntiChip");
		GameRegistry.registerItem(itemFusionCoil, "itemFusionCoil");
		GameRegistry.registerItem(covenantPiece, "covenantPiece");
		GameRegistry.registerItem(spartaniumIngot, "SpartaniumIngot");
		GameRegistry.registerItem(ammoRocket, "ammoRocket");
		GameRegistry.registerItem(jetpack, "Jetpack");
		GameRegistry.registerItem(ammoAssaultRifle, "ammoAssaultRifle");
		GameRegistry.registerItem(ammoPlasmaRocket, "ammoPlasmaRocket");
		GameRegistry.registerItem(itemRubber, "itemRubber");
		GameRegistry.registerItem(ammoPlasma, "ammoPlasma");
		GameRegistry.registerItem(ammoPrometheanMagazine, "ammoPrometheanMagazine");
		GameRegistry.registerItem(tankHarvester, "TankHarvester");
		GameRegistry.registerItem(prometheanHelmet, "prometheanHelmet");
		GameRegistry.registerItem(prometheanChestplate, "PrometheanChestplate");
		GameRegistry.registerItem(prometheanLeggings, "PrometheanLeggings");
		GameRegistry.registerItem(prometheanBoots, "PrometheanBoots");
		GameRegistry.registerItem(spartanLockeHelmet, "SpartanLockeHelmet");
		GameRegistry.registerItem(spartanLockeChestplate, "SpartanLockeChestplate");
		GameRegistry.registerItem(spartanLockeLeggings, "SpartanLockeLeggings");
		GameRegistry.registerItem(spartanLockeBoots, "SpartanLockeBoots");
		GameRegistry.registerItem(greenGrenadierHelmet, "GreenGrenadierHelmet");
		GameRegistry.registerItem(greenGrenadierChestplate, "GreenGrenadierChestplate");
		GameRegistry.registerItem(greenGrenadierLeggings, "GreenGrenadierLeggings");
		GameRegistry.registerItem(greenGrenadierBoots, "GreenGrenadierBoots");
		GameRegistry.registerItem(orangeGrenadierHelmet, "OrangeGrenadierHelmet");
		GameRegistry.registerItem(orangeGrenadierChestplate, "OrangeGrenadierChestplate");
		GameRegistry.registerItem(orangeGrenadierLeggings, "OrangeGrenadierLeggings");
		GameRegistry.registerItem(orangeGrenadierBoots, "OrangeGrenadierBoots");
		GameRegistry.registerItem(reconHelmet, "ReconHelmet");
		GameRegistry.registerItem(reconChestplate, "ReconChestplate");
		GameRegistry.registerItem(reconLeggings, "ReconLeggings");
		GameRegistry.registerItem(reconBoots, "ReconBoots");
		GameRegistry.registerItem(blueReconHelmet, "BlueReconHelmet");
		GameRegistry.registerItem(blueReconChestplate, "BlueReconChestplate");
		GameRegistry.registerItem(blueReconLeggings, "BlueReconLeggings");
		GameRegistry.registerItem(blueReconBoots, "BlueReconBoots");
		GameRegistry.registerItem(redReconHelmet, "RedReconHelmet");
		GameRegistry.registerItem(redReconChestplate, "RedReconChestplate");
		GameRegistry.registerItem(redReconLeggings, "RedReconLeggings");
		GameRegistry.registerItem(redReconBoots, "RedReconBoots");
		GameRegistry.registerItem(marineHelmet, "MarineHelmet");
		GameRegistry.registerItem(marineChestplate, "MarineChestplate");
		GameRegistry.registerItem(marineLeggings, "MarineLeggings");
		GameRegistry.registerItem(marineBoots, "MarineBoots");
		GameRegistry.registerItem(redMarineHelmet, "RedMarineHelmet");
		GameRegistry.registerItem(redMarineChestplate, "RedMarineChestplate");
		GameRegistry.registerItem(redMarineLeggings, "RedMarineLeggings");
		GameRegistry.registerItem(redMarineBoots, "RedMarineBoots");
		GameRegistry.registerItem(blueMarineHelmet, "BlueMarineHelmet");
		GameRegistry.registerItem(blueMarineChestplate, "BlueMarineChestplate");
		GameRegistry.registerItem(blueMarineLeggings, "BlueMarineLeggings");
		GameRegistry.registerItem(blueMarineBoots, "BlueMarineBoots");
		GameRegistry.registerItem(spartanHelmet, "SpartanHelmet");
		GameRegistry.registerItem(spartanChestplate, "SpartanChestplate");
		GameRegistry.registerItem(spartanLeggings, "SpartanLeggings");
		GameRegistry.registerItem(spartanBoots, "SpartanBoots");
		GameRegistry.registerItem(redSpartanHelmet, "RedSpartanHelmet");
		GameRegistry.registerItem(redSpartanChestplate, "RedSpartanChestplate");
		GameRegistry.registerItem(redSpartanLeggings, "RedSpartanLeggings");
		GameRegistry.registerItem(redSpartanBoots, "RedSpartanBoots");
		GameRegistry.registerItem(greenSpartanHelmet, "GreenSpartanHelmet");
		GameRegistry.registerItem(greenSpartanChestplate, "GreenSpartanChestplate");
		GameRegistry.registerItem(greenSpartanLeggings, "GreenSpartanLeggings");
		GameRegistry.registerItem(greenSpartanBoots, "GreenSpartanBoots");
		GameRegistry.registerItem(blueSpartanHelmet, "BlueSpartanHelmet");
		GameRegistry.registerItem(blueSpartanChestplate, "BlueSpartanChestplate");
		GameRegistry.registerItem(blueSpartanLeggings, "BlueSpartanLeggings");
		GameRegistry.registerItem(blueSpartanBoots, "BlueSpartanBoots");
		GameRegistry.registerItem(covenantHelmet, "CovenantHelmet");
		GameRegistry.registerItem(covenantChestplate, "CovenantChestplate");
		GameRegistry.registerItem(covenantLeggings, "CovenantLeggings");
		GameRegistry.registerItem(covenantBoots, "CovenantBoots");
		GameRegistry.registerItem(activeCamoChestplate, "ActiveCamoChestplate");

		GameRegistry.registerItem(ItemMongoose.instance, ItemMongoose.name);
		GameRegistry.registerItem(ItemWarthogTurret.instance, ItemWarthogTurret.name);
		GameRegistry.registerItem(FragGrenade.instance, FragGrenade.name);
		GameRegistry.registerItem(ItemScattershot.instance, ItemScattershot.name);
		GameRegistry.registerItem(ItemEnergySword.instance, ItemEnergySword.name);
		GameRegistry.registerItem(PrometheanSword.instance, PrometheanSword.name);
		GameRegistry.registerItem(ItemRocketLauncher.instance, ItemRocketLauncher.name);
		GameRegistry.registerItem(PurplePlasmaIngot.instance, PurplePlasmaIngot.name);
		GameRegistry.registerItem(ItemFuelRodCannon.instance, ItemFuelRodCannon.name);
		GameRegistry.registerItem(PlasmaRifle.instance, PlasmaRifle.name);
		GameRegistry.registerItem(ItemCarbineAmmo.instance, ItemCarbineAmmo.name);
		GameRegistry.registerItem(ItemBoltshot.instance, ItemBoltshot.name);
		GameRegistry.registerItem(ItemCarbineRifle.instance, ItemCarbineRifle.name);
		GameRegistry.registerItem(ItemNeedler.instance, ItemNeedler.name);
		GameRegistry.registerItem(ItemWarthog.instance, ItemWarthog.name);
		GameRegistry.registerItem(GreenPlasmaIngot.instance, GreenPlasmaIngot.name);
		GameRegistry.registerItem(PulseGrenade.instance, PulseGrenade.name);
		GameRegistry.registerItem(Pistol.instance, Pistol.name);
		GameRegistry.registerItem(ItemNeedlerAmmo.instance, ItemNeedlerAmmo.name);
		GameRegistry.registerItem(RedPlasmaIngot.instance, RedPlasmaIngot.name);
		GameRegistry.registerItem(TitaniumIngot.instance, TitaniumIngot.name);
		GameRegistry.registerItem(SteelIngot.instance, SteelIngot.name);
		GameRegistry.registerItem(ItemSniperRifle.instance, ItemSniperRifle.name);
		GameRegistry.registerItem(ItemLightRifle.instance, ItemLightRifle.name);
		GameRegistry.registerItem(ItemScorpion.instance, ItemScorpion.name);
		GameRegistry.registerItem(ItemIncinerationCannon.instance, ItemIncinerationCannon.name);
		GameRegistry.registerItem(ItemSuppressor.instance, ItemSuppressor.name);
		GameRegistry.registerItem(ItemForerunnerShard.instance, ItemForerunnerShard.name);
		GameRegistry.registerItem(ItemAssaultRifle.instance, ItemAssaultRifle.name);
		GameRegistry.registerItem(ItemBattleRifle.instance, ItemBattleRifle.name);
		GameRegistry.registerItem(ItemHealthPack.instance, ItemHealthPack.name);
		GameRegistry.registerItem(ItemRedPlasmaAmmo.instance, ItemRedPlasmaAmmo.name);
		GameRegistry.registerItem(ItemGhost.instance, ItemGhost.name);
	}

	public void registerBlocks()
	{
		// Register Blocks
		GameRegistry.registerBlock(haloOre, "HaloOre");
		GameRegistry.registerBlock(redPlasmaOre, "RedPlasmaOre");
		GameRegistry.registerBlock(greenPlasmaOre, "GreenPlasmaOre");
		GameRegistry.registerBlock(purplePlasmaOre, "PurplePlasmaOre");
		GameRegistry.registerBlock(forerunnerOre, "ForerunnerOre");

		GameRegistry.registerBlock(RedPlasmaBlock.instance, RedPlasmaBlock.name);
		GameRegistry.registerBlock(PurplePlasmaBlock.instance, PurplePlasmaBlock.name);
		GameRegistry.registerBlock(RoofBlock.instance, RoofBlock.name);
		GameRegistry.registerBlock(ForerunnerWallBlock.instance, ForerunnerWallBlock.name);
		GameRegistry.registerBlock(ForerunnerFloorBlock.instance, ForerunnerFloorBlock.name);
		GameRegistry.registerBlock(HaloBlock.instance, HaloBlock.name);
		GameRegistry.registerBlock(SteelBlock.instance, SteelBlock.name);
		GameRegistry.registerBlock(TitaniumBlock.instance, TitaniumBlock.name);
	}

	public void registerEntities()
	{
		// Register Entities
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityMongoose.class, "Mongoose", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityScorpion.class, "Socrpion", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityPlasmaRocket.class, "PlasmaRocket", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityGhost.class, "Ghost", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityPurplePlasma.class, "PurplePlasma", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityWarthogTurret.class, "WarthogTurret", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityRocket.class, "Rocket", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityRedPlasma.class, "RedPlasma", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityGreenPlasma.class, "GreenPlasma", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityWarthog.class, "Warthog", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityFragGrenade.class, "fragGrenade", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityPulseGrenade.class, "pulseGrenade", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerModEntity(EntityOrangePlasma.class, "OrangePlasma", getRandomID(), HaloCraft.instance(), 250, 15, true);

		EntityRegistry.registerModEntity(EntityElite.class, "GoldenElite", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerEgg(EntityElite.class, 0xFFEE00, 0xFFFFFF);
		EntityRegistry.addSpawn(EntityElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityRedElite.class, "RedElite", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerEgg(EntityRedElite.class, 0xFF0000, 0x000000);
		EntityRegistry.addSpawn(EntityRedElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityBlueElite.class, "BlueElite", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerEgg(EntityBlueElite.class, 0x002FFF, 0xCC00FF);
		EntityRegistry.addSpawn(EntityBlueElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityGrunt.class, "Grunt", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerEgg(EntityGrunt.class, 0x4F2E00, 0x424242);
		EntityRegistry.addSpawn(EntityGrunt.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityPromethean.class, "Promethean", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerEgg(EntityPromethean.class, 0x000000, 0xFF7700);
		EntityRegistry.addSpawn(EntityPromethean.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityMarine.class, "Marine", getRandomID(), HaloCraft.instance(), 250, 15, true);
		EntityRegistry.registerEgg(EntityMarine.class, 0x000000, 0x47BEE6);
		EntityRegistry.addSpawn(EntityMarine.class, 15, 4, 10, EnumCreatureType.CREATURE, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);
	}

	public int getRandomID()
	{
		counter++;
		return counter + EntityRegistry.findGlobalUniqueEntityId();
	}

	public void initializeWorldGeneration()
	{
		haloOreGen = new HaloGenerationClass();

		// World Gen Registration
		GameRegistry.registerWorldGenerator(haloOreGen, 1);
	}

	public void registerCraftingRecipies()
	{
		// Block Recipes
		GameRegistry.addRecipe(new ItemStack(HaloBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(TitaniumBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', TitaniumIngot.instance });
		GameRegistry.addRecipe(new ItemStack(SteelBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', SteelBlock.instance });
		GameRegistry.addRecipe(new ItemStack(PurplePlasmaBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', PurplePlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(RedPlasmaBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(itemRubber, 2), new Object[] { "XXX", "XXX", "XXX", 'X', itemOil });

		// Gun Recipes
		GameRegistry.addRecipe(new ItemStack(ItemBattleRifle.instance, 1), new Object[] { "ZA ", "XXY", " AX", 'X', spartaniumIngot, 'Y', new ItemStack(Items.gunpowder), 'Z', new ItemStack(Blocks.glass_pane), 'A', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(Pistol.instance, 1), new Object[] { "   ", " XY", "  Z", 'X', spartaniumIngot, 'Y', new ItemStack(Items.gunpowder), 'Z', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ItemSniperRifle.instance, 1), new Object[] { "XYX", "ZYY", " IY", 'X', new ItemStack(Blocks.glass_pane), 'Y', spartaniumIngot, 'Z', new ItemStack(Items.gunpowder), 'I', new ItemStack(Items.iron_ingot) });

		// Recipes
		GameRegistry.addRecipe(new ItemStack(ItemWarthogTurret.instance, 1), new Object[] { "  Z", "XXX", "YXY", 'X', HaloBlock.instance, 'Y', itemWheel, 'Z', ItemAssaultRifle.instance });
		GameRegistry.addRecipe(new ItemStack(ItemWarthog.instance, 1), new Object[] { "   ", "XXX", "YXY", 'X', HaloBlock.instance, 'Y', itemWheel });
		GameRegistry.addRecipe(new ItemStack(ItemScorpion.instance, 1), new Object[] { "YXX", "XXX", "XXX", 'X', HaloBlock.instance, 'Y', ItemRocketLauncher.instance });
		GameRegistry.addRecipe(new ItemStack(ItemGhost.instance, 1), new Object[] { "   ", "XY ", "YYY", 'X', PlasmaRifle.instance, 'Y', PurplePlasmaBlock.instance });
		GameRegistry.addRecipe(new ItemStack(ItemIncinerationCannon.instance, 1), new Object[] { "  X", "YYX", " ZY", 'X', ItemRedPlasmaAmmo.instance, 'Y', RedPlasmaBlock.instance, 'Z', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(tankHarvester, 1), new Object[] { "XXX", "XYX", "XXX", 'X', spartaniumIngot, 'Y', ItemScorpion.instance });

		// Pulse Grenade
		GameRegistry.addRecipe(new ItemStack(PulseGrenade.instance, 1), new Object[] { " X ", "XYX", " X ", 'X', RedPlasmaIngot.instance, 'Y', Blocks.tnt });

		// Spartan Armor
		GameRegistry.addRecipe(new ItemStack(spartanHelmet, 1), new Object[] { "XXX", "X X", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(spartanChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(spartanLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(spartanBoots, 1), new Object[] { "X X", "X X", 'X', spartaniumIngot });

		// Spartan Locke Armor
		GameRegistry.addRecipe(new ItemStack(spartanLockeHelmet, 1), new Object[] { "XXX", "XYX", "XXX", 'X', TitaniumIngot.instance, 'Y', spartanHelmet });
		GameRegistry.addRecipe(new ItemStack(spartanLockeChestplate, 1), new Object[] { "XXX", "XYX", "XXX", 'X', TitaniumIngot.instance, 'Y', spartanChestplate });
		GameRegistry.addRecipe(new ItemStack(spartanLockeLeggings, 1), new Object[] { "XXX", "XYX", "XXX", 'X', TitaniumIngot.instance, 'Y', spartanLeggings });
		GameRegistry.addRecipe(new ItemStack(spartanLockeBoots, 1), new Object[] { "XXX", "XYX", "XXX", 'X', TitaniumIngot.instance, 'Y', spartanBoots });

		// Recon Armor
		GameRegistry.addRecipe(new ItemStack(reconHelmet, 1), new Object[] { "XXX", "X X", 'X', SteelIngot.instance });
		GameRegistry.addRecipe(new ItemStack(reconChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', SteelIngot.instance });
		GameRegistry.addRecipe(new ItemStack(reconLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', SteelIngot.instance });
		GameRegistry.addRecipe(new ItemStack(reconBoots, 1), new Object[] { "X X", "X X", 'X', SteelIngot.instance });

		// Grenadier Armor
		GameRegistry.addRecipe(new ItemStack(greenGrenadierHelmet, 1), new Object[] { "XXX", "X X", 'X', TitaniumIngot.instance });
		GameRegistry.addRecipe(new ItemStack(greenGrenadierChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', TitaniumIngot.instance });
		GameRegistry.addRecipe(new ItemStack(greenGrenadierLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', TitaniumIngot.instance });
		GameRegistry.addRecipe(new ItemStack(greenGrenadierBoots, 1), new Object[] { "X X", "X X", 'X', TitaniumIngot.instance });

		// Promethean Armor
		GameRegistry.addRecipe(new ItemStack(prometheanHelmet, 1), new Object[] { "XXX", "X X", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(prometheanChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(prometheanLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(prometheanBoots, 1), new Object[] { "X X", "X X", 'X', RedPlasmaIngot.instance });

		// Marine Armor
		GameRegistry.addRecipe(new ItemStack(marineHelmet, 1), new Object[] { "XXX", "Y Y", 'X', spartaniumIngot, 'Y', Items.leather });
		GameRegistry.addRecipe(new ItemStack(marineChestplate, 1), new Object[] { "Y Y", "XXX", "XXX", 'X', spartaniumIngot, 'Y', Items.leather });
		GameRegistry.addRecipe(new ItemStack(marineLeggings, 1), new Object[] { "YYY", "X X", "X X", 'X', spartaniumIngot, 'Y', Items.leather });
		GameRegistry.addRecipe(new ItemStack(marineBoots, 1), new Object[] { "Y Y", "X X", 'X', spartaniumIngot, 'Y', Items.leather });

		GameRegistry.addRecipe(new ItemStack(covenantHelmet, 1), new Object[] { "XXX", "X X", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(covenantChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(covenantLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(covenantBoots, 1), new Object[] { "X X", "X X", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(ammoRocket, 5), new Object[] { " X ", " X ", " YZ", 'X', spartaniumIngot, 'Y', new ItemStack(Items.gunpowder), 'Z', new ItemStack(Items.string) });
		GameRegistry.addRecipe(new ItemStack(ammoPlasmaRocket, 5), new Object[] { " X ", " X ", " YZ", 'X', GreenPlasmaIngot.instance, 'Y', new ItemStack(Items.gunpowder), 'Z', new ItemStack(Items.string) });

		GameRegistry.addRecipe(new ItemStack(ItemRedPlasmaAmmo.instance, 1), new Object[] { " X ", " X ", " YZ", 'X', RedPlasmaIngot.instance, 'Y', new ItemStack(Items.gunpowder), 'Z', new ItemStack(Items.string) });
		GameRegistry.addRecipe(new ItemStack(ItemMongoose.instance, 1), new Object[] { "X  ", "YYY", "ZYZ", 'X', spartaniumIngot, 'Y', HaloBlock.instance, 'Z', itemWheel });

		// Forerunner Blocks
		GameRegistry.addRecipe(new ItemStack(ForerunnerFloorBlock.instance, 1), new Object[] { "XX ", "XX ", 'X', new ItemStack(ItemForerunnerShard.instance) });
		GameRegistry.addRecipe(new ItemStack(ForerunnerWallBlock.instance, 1), new Object[] { "XX ", "XX ", 'X', new ItemStack(ForerunnerFloorBlock.instance) });
		GameRegistry.addRecipe(new ItemStack(RoofBlock.instance, 1), new Object[] { "XX ", "XX ", 'X', new ItemStack(ForerunnerWallBlock.instance) });

		GameRegistry.addRecipe(new ItemStack(itemWheel, 1), new Object[] { "XXX", "XYX", "XXX", 'X', itemRubber, 'Y', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ItemEnergySword.instance, 1), new Object[] { " X ", " X ", " Y ", 'X', PurplePlasmaIngot.instance, 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(PrometheanSword.instance, 1), new Object[] { " X ", " X ", " Y ", 'X', RedPlasmaIngot.instance, 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(ItemRocketLauncher.instance, 1), new Object[] { " XX", "YYY", " IZ", 'X', ammoRocket, 'Y', spartaniumIngot, 'Z', HaloBlock.instance, 'I', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ItemFuelRodCannon.instance, 1), new Object[] { "XXZ", "XYZ", " XX", 'X', GreenPlasmaIngot.instance, 'Y', covenantPiece, 'Z', ammoPlasmaRocket });
		GameRegistry.addRecipe(new ItemStack(ItemAssaultRifle.instance, 1), new Object[] { "   ", "XXY", " ZX", 'X', spartaniumIngot, 'Y', new ItemStack(Items.gunpowder), 'Z', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ammoAssaultRifle, 15), new Object[] { " X ", " X ", "XYX", 'X', new ItemStack(Items.gold_ingot), 'Y', new ItemStack(Items.gunpowder) });
		GameRegistry.addRecipe(new ItemStack(ItemCarbineAmmo.instance, 15), new Object[] { " X ", " X ", "XYX", 'X', new ItemStack(GreenPlasmaIngot.instance), 'Y', new ItemStack(Items.gunpowder) });
		GameRegistry.addRecipe(new ItemStack(ItemNeedlerAmmo.instance, 15), new Object[] { " X ", " X ", "XYX", 'X', new ItemStack(PurplePlasmaIngot.instance), 'Y', new ItemStack(Items.gunpowder) });
		GameRegistry.addRecipe(new ItemStack(ItemCarbineRifle.instance, 1), new Object[] { "XZ ", "PGG", " CG", 'X', covenantPiece, 'C', new ItemStack(ItemCarbineAmmo.instance), 'Z', new ItemStack(RedPlasmaIngot.instance), 'P', new ItemStack(PurplePlasmaIngot.instance), 'G', new ItemStack(GreenPlasmaIngot.instance) });
		GameRegistry.addRecipe(new ItemStack(ItemNeedler.instance, 1), new Object[] { "XXX", "YYY", "  Y", 'X', ItemNeedlerAmmo.instance, 'Y', PurplePlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(PlasmaRifle.instance, 1), new Object[] { "YY ", " XY", "YY ", 'X', ammoPlasma, 'Y', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(FragGrenade.instance, 1), new Object[] { " X ", "XYX", "XXX", 'X', new ItemStack(Items.iron_ingot), 'Y', new ItemStack(Blocks.tnt) });

		GameRegistry.addRecipe(new ItemStack(ItemScattershot.instance, 1), new Object[] { "X  ", "YYY", "YZZ", 'X', itemAntiChip, 'Y', RedPlasmaIngot.instance, 'Z', ammoPrometheanMagazine });
		GameRegistry.addRecipe(new ItemStack(ItemLightRifle.instance, 1), new Object[] { "XY ", "YYY", "YZA", 'X', new ItemStack(Blocks.stained_glass_pane, 1, 14), 'Y', RedPlasmaIngot.instance, 'Z', ammoPrometheanMagazine, 'A', itemAntiChip });
		GameRegistry.addRecipe(new ItemStack(ItemSuppressor.instance, 1), new Object[] { "XYY", "YY ", 'X', itemAntiChip, 'Y', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(ItemBoltshot.instance, 1), new Object[] { "XYY", "Y  ", 'X', itemAntiChip, 'Y', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(ammoPrometheanMagazine, 1), new Object[] { "XXY", 'X', RedPlasmaIngot.instance, 'Y', ItemForerunnerShard.instance });
		GameRegistry.addRecipe(new ItemStack(itemFusionCoil, 1), new Object[] { "XYX", 'X', itemAntiChip, 'Y', SteelIngot.instance });
		GameRegistry.addRecipe(new ItemStack(itemAntiChip, 1), new Object[] { "XXX", "YYY", "XXX", 'X', TitaniumIngot.instance, 'Y', RedPlasmaIngot.instance });

		GameRegistry.addRecipe(new ItemStack(jetpack, 1), new Object[] { "XXX", "YXY", " Z ", 'X', TitaniumIngot.instance, 'Y', itemFusionCoil, 'Z', new ItemStack(Items.leather) });

		// Red Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(redSpartanHelmet, 1), new ItemStack(Items.dye, 1, 1), spartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(redSpartanChestplate, 1), new ItemStack(Items.dye, 1, 1), spartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(redSpartanLeggings, 1), new ItemStack(Items.dye, 1, 1), spartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(redSpartanBoots, 1), new ItemStack(Items.dye, 1, 1), spartanBoots);

		// Red Marine Armor
		GameRegistry.addShapelessRecipe(new ItemStack(redMarineHelmet, 1), new ItemStack(Items.dye, 1, 1), marineHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(redMarineChestplate, 1), new ItemStack(Items.dye, 1, 1), marineChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(redMarineLeggings, 1), new ItemStack(Items.dye, 1, 1), marineLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(redMarineBoots, 1), new ItemStack(Items.dye, 1, 1), marineBoots);

		// Blue Marine Armor
		GameRegistry.addShapelessRecipe(new ItemStack(blueMarineHelmet, 1), new ItemStack(Items.dye, 1, 6), marineHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(blueMarineChestplate, 1), new ItemStack(Items.dye, 1, 6), marineChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(blueMarineLeggings, 1), new ItemStack(Items.dye, 1, 6), marineLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(blueMarineBoots, 1), new ItemStack(Items.dye, 1, 6), marineBoots);

		// Green Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(greenSpartanHelmet, 1), new ItemStack(Items.dye, 1, 10), spartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(greenSpartanChestplate, 1), new ItemStack(Items.dye, 1, 10), spartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(greenSpartanLeggings, 1), new ItemStack(Items.dye, 1, 10), spartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(greenSpartanBoots, 1), new ItemStack(Items.dye, 1, 10), spartanBoots);

		// Blue Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(blueSpartanHelmet, 1), new ItemStack(Items.dye, 1, 6), spartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(blueSpartanChestplate, 1), new ItemStack(Items.dye, 1, 6), spartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(blueSpartanLeggings, 1), new ItemStack(Items.dye, 1, 6), spartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(blueSpartanBoots, 1), new ItemStack(Items.dye, 1, 6), spartanBoots);

		// Orange Grenadier Armor
		GameRegistry.addShapelessRecipe(new ItemStack(orangeGrenadierHelmet, 1), new ItemStack(Items.dye, 1, 14), greenGrenadierHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(orangeGrenadierChestplate, 1), new ItemStack(Items.dye, 1, 14), greenGrenadierChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(orangeGrenadierLeggings, 1), new ItemStack(Items.dye, 1, 14), greenGrenadierLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(orangeGrenadierBoots, 1), new ItemStack(Items.dye, 1, 14), greenGrenadierBoots);

		// Red Recon Armor
		GameRegistry.addShapelessRecipe(new ItemStack(redReconHelmet, 1), new ItemStack(Items.dye, 1, 1), reconHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(redReconChestplate, 1), new ItemStack(Items.dye, 1, 1), reconChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(redReconLeggings, 1), new ItemStack(Items.dye, 1, 1), reconLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(redReconBoots, 1), new ItemStack(Items.dye, 1, 1), reconBoots);

		// Blue Recon Armor
		GameRegistry.addShapelessRecipe(new ItemStack(blueReconHelmet, 1), new ItemStack(Items.dye, 1, 6), reconHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(blueReconChestplate, 1), new ItemStack(Items.dye, 1, 6), reconChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(blueReconLeggings, 1), new ItemStack(Items.dye, 1, 6), reconLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(blueReconBoots, 1), new ItemStack(Items.dye, 1, 6), reconBoots);

		GameRegistry.addShapelessRecipe(new ItemStack(covenantPiece, 1), new ItemStack(Items.blaze_rod, 1), new ItemStack(Items.coal, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHealthPack.instance, 1), new ItemStack(Items.nether_wart, 1), new ItemStack(Items.speckled_melon, 1), new ItemStack(Blocks.wool, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(activeCamoChestplate, 1), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.fermented_spider_eye, 1), new ItemStack(Items.nether_wart, 1), spartanChestplate);

		GameRegistry.addShapelessRecipe(new ItemStack(SteelIngot.instance, 1), Items.iron_ingot, spartaniumIngot);
		GameRegistry.addShapelessRecipe(new ItemStack(TitaniumIngot.instance, 1), SteelIngot.instance, spartaniumIngot);

		GameRegistry.addSmelting(haloOre, new ItemStack(spartaniumIngot, 1), 0.1f);
		GameRegistry.addSmelting(new ItemStack(Blocks.dirt), new ItemStack(itemOil, 1), 0.1f);
		GameRegistry.addSmelting(redPlasmaOre, new ItemStack(RedPlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addSmelting(purplePlasmaOre, new ItemStack(PurplePlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addSmelting(forerunnerOre, new ItemStack(ItemForerunnerShard.instance, 1), 0.1f);
		GameRegistry.addSmelting(GreenPlasmaIngot.instance, new ItemStack(ammoPlasma, 1), 0.1f);
		GameRegistry.addSmelting(greenPlasmaOre, new ItemStack(GreenPlasmaIngot.instance, 1), 0.1f);
	}

	public void registerPackets()
	{
		HalocraftPacketHandler.INSTANCE.registerMessage(FireMessageHandler.class, FireMessage.class, 0, Side.SERVER);
	}

	public void registerEntityRenderers()
	{
		;
	}

	public void registerItemRenderers()
	{
		;
	}

	public void registerBlockRenderers()
	{
		;
	}

	public void registerHandlers()
	{
		;
	}

	public void registerCustomModelResources()
	{
		;
	}
}
