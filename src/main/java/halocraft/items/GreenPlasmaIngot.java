package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GreenPlasmaIngot extends Item {
	public static final GreenPlasmaIngot instance = new GreenPlasmaIngot();
    public static final String name = "GreenPlasmaIngot";
    
	public GreenPlasmaIngot() {
        setMaxStackSize(16);
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
