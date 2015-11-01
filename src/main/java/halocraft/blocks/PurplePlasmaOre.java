package halocraft.blocks;

import halocraft.HaloCraft;
import halocraft.items.GreenPlasmaIngot;
import halocraft.items.PurplePlasmaIngot;
import halocraft.items.RedPlasmaIngot;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PurplePlasmaOre extends Block {
	
    public PurplePlasmaOre(Material material) 
    {
            super(material);
            setHardness(4.0F); // 33% harder than diamond
            setStepSound(Block.soundTypePiston);
            setUnlocalizedName("PurplePlasmaOre");
            setCreativeTab(CreativeTabs.tabMaterials);
            setHarvestLevel("pickaxe", 3);
    }
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return PurplePlasmaIngot.instance;
    }

}
