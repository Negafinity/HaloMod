package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RedPlasmaIngot extends Item {
	public static final RedPlasmaIngot instance = new RedPlasmaIngot();
    public static final String name = "RedPlasmaIngot";
    
	public RedPlasmaIngot() {
        setMaxStackSize(16);
        setCreativeTab(halocraft.Main.haloCreativeTab);
        setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
