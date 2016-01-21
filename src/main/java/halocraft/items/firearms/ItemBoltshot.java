package halocraft.items.firearms;

import halocraft.entities.EntityOrangePlasma;
import halocraft.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBoltshot extends ItemFirearm
{
	public static String name = "itemBoltshot";
	public static ItemFirearm instance = new ItemBoltshot();

	public ItemBoltshot()
	{
		super();

		this.damage = 7;
		this.ammo = CommonProxy.ammoPrometheanMagazine;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.capabilities.isCreativeMode || this.canDamageAmmo(worldIn, playerIn))
		{
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote)
			{
				EntityOrangePlasma bullet = new EntityOrangePlasma(worldIn, playerIn);
				bullet.damage = this.damage;
				worldIn.spawnEntityInWorld(bullet);
				itemStackIn.damageItem(1, playerIn);
			}
		}

		return itemStackIn;
	}
}
