package halocraft.blocks;

import halocraft.Main;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HaloOre extends Block {
    public HaloOre(Material material) 
    {
            super(material);
            setHardness(4.0F); // 33% harder than diamond
            setStepSound(Block.soundTypePiston);
            setUnlocalizedName("HaloOre");
            setCreativeTab(CreativeTabs.tabBlock);
            setHarvestLevel("pickaxe", 3);
    }
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return halocraft.Main.HaloIngot;
    }

}
