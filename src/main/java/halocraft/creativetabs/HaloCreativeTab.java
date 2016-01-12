package halocraft.creativetabs;

import halocraft.proxies.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HaloCreativeTab extends CreativeTabs
{
	public HaloCreativeTab(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return CommonProxy.spartanHelmet;
	}
}
