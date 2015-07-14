package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PurplePlasmaIngot extends Item {
	public static final PurplePlasmaIngot instance = new PurplePlasmaIngot();
    public static final String name = "PurplePlasmaIngot";
    
	public PurplePlasmaIngot() {
        setMaxStackSize(16);
        setCreativeTab(halocraft.Main.haloCreativeTab);
        setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
