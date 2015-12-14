package halocraft.items;

import halocraft.HaloCraft;
import net.minecraft.item.ItemSword;

public class PrometheanSword extends ItemSword
{
	public static final PrometheanSword instance = new PrometheanSword();
    public static final String name = "PrometheanSword";
    
	public PrometheanSword()
	{
		super(HaloCraft.prometheanMaterial);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

}
