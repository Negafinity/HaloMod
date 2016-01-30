package halocraft.items.firearms;

import halocraft.entities.EntityPlasmaRocket;
import halocraft.items.FuelRodCannonTask;
import halocraft.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Timer;

public class ItemFuelRodCannon extends ItemFirearm
{
	private Timer timer = new Timer();
	public boolean canShoot = true;

	public static String name = "itemFuelRodCannon";
	public static ItemFirearm instance = new ItemFuelRodCannon();

	public ItemFuelRodCannon()
	{
		super();

		this.ammoItem = CommonProxy.ammoPlasmaRocket;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{	
		if (canShoot)
		{
			if (playerIn.capabilities.isCreativeMode || playerIn.inventory.consumeInventoryItem(this.ammoItem))
			{
				worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

				if (!worldIn.isRemote)
				{
					worldIn.spawnEntityInWorld(new EntityPlasmaRocket(worldIn, playerIn));
					itemStackIn.damageItem(1, playerIn);
					canShoot = false;
					timer.schedule(new FuelRodCannonTask(this), 3000);
				}
			}
		}

		return itemStackIn;
	}
}
