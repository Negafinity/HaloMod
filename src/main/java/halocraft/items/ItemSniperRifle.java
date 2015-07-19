package halocraft.items;

import java.util.Timer;
import java.util.TimerTask;

import halocraft.Main;
import halocraft.entities.EntityBullet;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSniperRifle extends Item {
	public static final ItemSniperRifle instance = new ItemSniperRifle();
    public static final String name = "itemSniperRifle";
    Timer t = new Timer();
    public boolean canShoot = true;
    
	public ItemSniperRifle(){
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
		setMaxDamage(1000);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn){
		if(canShoot)
		{
			if(playerIn.capabilities.isCreativeMode||playerIn.inventory.consumeInventoryItem(halocraft.Main.ammoAssaultRifle)){
				worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				if (!worldIn.isRemote)
				{	
					EntityBullet bullet = new EntityBullet(worldIn, playerIn);
					bullet.damage = 10;
					worldIn.spawnEntityInWorld(bullet);
					itemStackIn.damageItem(1, playerIn);
					canShoot = false;
					t.schedule(new IntervalTask(this), 1000);
				}
				return itemStackIn;
			}
		}
		return itemStackIn;
	}
}
