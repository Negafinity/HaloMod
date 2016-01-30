package halocraft;

import halocraft.proxies.CommonProxy;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = HaloCraft.MODID, version = HaloCraft.VERSION)
public class HaloCraft
{
	public static final String MODID = "halocraft";
	public static final String VERSION = "1.6";
	
	@SidedProxy(clientSide = "halocraft.proxies.ClientProxy", serverSide = "halocraft.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance(HaloCraft.MODID)
	private static HaloCraft instance;

	public static HaloCraft instance()
	{
		return HaloCraft.instance;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLLog.getLogger().info("[HaloCraft 2.0]: Starting to load...");

		proxy.initializeCreativeTabs();
		proxy.initializeMaterials();
		
		proxy.initializeItems();
		proxy.registerBlocks();
		proxy.registerEntities();
		proxy.registerCraftingRecipies();
		
		proxy.initializeWorldGeneration();
		
		if (event.getSide() == Side.CLIENT)
			proxy.registerCustomModelResources();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Register Handlers
		proxy.registerHandlers();

		// Register Rendering Classes
		proxy.registerItemRenderers();
		proxy.registerBlockRenderers();
		proxy.registerEntityRenderers();
		
		proxy.registerPackets();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		FMLLog.getLogger().info("[HaloCraft 2.0]: Loaded Successfully!");
		FMLLog.getLogger().info("[HaloCraft 2.0]: This mod was created by NEGAFINITY, if you have issues please post them on GitHub!");
	}
}
