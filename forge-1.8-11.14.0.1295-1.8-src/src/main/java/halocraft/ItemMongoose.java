package halocraft;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemMongoose extends Item {
		public int colour;

		public ItemMongoose(int colour)
		{
			super();
			this.setUnlocalizedName("mongoose_" + colour);
			this.colour = colour;
			this.setMaxStackSize(1);
			this.setCreativeTab(CreativeTabs.tabTransport);
		}

		public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
		{
			if (!player.capabilities.isCreativeMode)
			{
				--stack.stackSize;
			}

			if (!world.isRemote)
			{
				EntityMongoose entityMongoose = new EntityMongoose(world, x, y + 1, z, colour);
				entityMongoose.rotationYaw = (float)((((MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) - 1) * 90) - 90);
				world.spawnEntityInWorld(entityMongoose); 
			}

			if(player.capabilities.isCreativeMode)
			{
				stack.stackSize--;
			}

			return true;
		}
	}

