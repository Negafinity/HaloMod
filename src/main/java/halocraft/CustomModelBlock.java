package halocraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

public class CustomModelBlock extends Block
{
    public static final CustomModelBlock instance = new CustomModelBlock();
    public static final String name = "CustomModelBlock";
    private int counter = 1;
    private ExtendedBlockState state = new ExtendedBlockState(this, new IProperty[0], new IUnlistedProperty[]{ B3DLoader.B3DFrameProperty.instance });

    private CustomModelBlock()
    {
        super(Material.iron);
        setCreativeTab(CreativeTabs.tabBlock);
        setUnlocalizedName("halocraft:" + name);
    }
    
    @Override
    public boolean isOpaqueCube() { return false; }

    @Override
    public boolean isFullCube() { return false; }

    @Override
    public boolean isVisuallyOpaque() { return false; }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        B3DLoader.B3DState newState = new B3DLoader.B3DState(null, counter);
        return ((IExtendedBlockState)this.state.getBaseState()).withProperty(B3DLoader.B3DFrameProperty.instance, newState);
    }
}