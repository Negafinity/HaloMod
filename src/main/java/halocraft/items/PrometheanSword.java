package halocraft.items;

import halocraft.HaloCraft;
import net.minecraft.item.ItemSword;

public class PrometheanSword extends ItemSword
{
	public static final PrometheanSword instance = new PrometheanSword();
    public static final String name = "PrometheanSword";
    
	public PrometheanSword()
	{
		super(HaloCraft.PrometheanMaterial);
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

}
