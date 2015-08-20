package halocraft.items;

import halocraft.Main;
import net.minecraft.item.ItemSword;

public class PrometheanSword extends ItemSword
{
	public static final PrometheanSword instance = new PrometheanSword();
    public static final String name = "PrometheanSword";
    
	public PrometheanSword()
	{
		super(Main.PrometheanMaterial);
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}

}
