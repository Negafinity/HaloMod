package halocraft.items;

import java.util.Timer;

import halocraft.Main;
import halocraft.entities.EntityPlasmaRocket;
import halocraft.entities.EntityRocket;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemFuelRodCannon extends Item {
	//Following is so you can access it in pre-init
	public static final ItemFuelRodCannon instance = new ItemFuelRodCannon();
	public static final String name = "itemFuelRodCannon";

	Timer t = new Timer();
	public boolean canShoot = true;

	public ItemFuelRodCannon(){
		super();
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
		setMaxDamage(1000);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if(canShoot)
		{
			if(playerIn.capabilities.isCreativeMode||playerIn.inventory.consumeInventoryItem(halocraft.Main.ammoPlasmaRocket))
			{
				worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				if (!worldIn.isRemote)
				{
					worldIn.spawnEntityInWorld(new EntityPlasmaRocket(worldIn, playerIn));
					itemStackIn.damageItem(1, playerIn);
					canShoot = false;
					t.schedule(new FuelRodCannonTask(this), 3000);
				}
			}
		}
		return itemStackIn;
	}
}
