package halocraft.items.firearms;

import halocraft.entities.EntityRocket;
import halocraft.proxies.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRocketLauncher extends ItemFirearm
{
	public static final ItemRocketLauncher instance = new ItemRocketLauncher();
	public static final String name = "itemRocketLauncher";

	public ItemRocketLauncher()
	{
		super();

		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.capabilities.isCreativeMode || playerIn.inventory.consumeInventoryItem(CommonProxy.ammoRocket))
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
