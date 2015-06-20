package halocraft.items;

import halocraft.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemEnergySword extends ItemSword{
	//Following is so you can access it in pre-init
	public static final ItemEnergySword instance = new ItemEnergySword();
    public static final String name = "EnergySword";
    
	public ItemEnergySword() {
		super(Main.HaloMaterial);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}