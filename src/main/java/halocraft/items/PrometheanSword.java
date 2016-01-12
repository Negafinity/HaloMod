package halocraft.items;

import halocraft.proxies.CommonProxy;
import net.minecraft.item.ItemSword;

public class PrometheanSword extends ItemSword
{
	public static final PrometheanSword instance = new PrometheanSword();
    public static final String name = "PrometheanSword";
    
	public PrometheanSword()
	{
		super(CommonProxy.prometheanMaterial);
		setCreativeTab(CommonProxy.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

}
