package halocraft;

import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;

@Mod(modid="halocraft", version="pre1.0")
public class Main{
	public static String MODID = "halocraft";
	public static String VERSION = "1";
	public static ItemSword swordEnergySword;
	public static Block forerunnerBlock;
	public static Entity mobElite;
	@EventHandler
	public void init(FMLInitializationEvent e){
		swordEnergySword = new swordEnergySword(ToolMaterial.EMERALD);
		GameRegistry.registerItem(swordEnergySword, "energySword");
		forerunnerBlock = new forerunnerBlock(Material.rock);
		GameRegistry.registerBlock(forerunnerBlock, "forerunnerBlock");
		ModelResourceLocation res = new ModelResourceLocation("halocraft:energySword", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(swordEnergySword, 0, res);
		mobElite = new EntityElite(null);
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityElite.class, "Elite", randomID, 230, 78);
		EntityRegistry.addSpawn(EntityElite.class, 5, 1, 2, EnumCreatureType.MONSTER);
		RenderingRegistry.registerEntityRenderingHandler(EntityElite.class, new RenderEliteEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));
	}
	public static CreativeTabs haloWeapons = new CreativeTabs("Halo Weapons"){
	public Item getTabIconItem(){
	return Items.diamond_sword;
	}
	};
}
