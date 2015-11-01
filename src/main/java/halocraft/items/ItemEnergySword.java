package halocraft.items;

import halocraft.HaloCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemEnergySword extends ItemSword
{
	//Following is so you can access it in pre-init
	public static final ItemEnergySword instance = new ItemEnergySword();
	public static final String name = "EnergySword";

	public ItemEnergySword()
	{
		super(HaloCraft.HaloMaterial);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}