package halocraft.items;

import halocraft.Main;
import halocraft.entities.EntityRocket;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class RocketLauncher extends Item {
	//Following is so you can access it in pre-init
	public static final RocketLauncher instance = new RocketLauncher();
	public static final String name = "RocketLauncher";
	
	public RocketLauncher(){
	     super();
	     setCreativeTab(CreativeTabs.tabCombat);
	     setUnlocalizedName("halocraft:" + name.toLowerCase());
	     setMaxStackSize(1);
	     setMaxDamage(1000);
	}
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if(playerIn.capabilities.isCreativeMode || playerIn.inventory.consumeInventoryItem(halocraft.Main.ammoRocket))
        {
            worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!worldIn.isRemote)
            {
                worldIn.spawnEntityInWorld(new EntityRocket(worldIn, playerIn));
                itemStackIn.damageItem(1, playerIn);
            }
        }
            return itemStackIn;
     }
   }
