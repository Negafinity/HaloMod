package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCarbineAmmo extends Item {
	public static final ItemCarbineAmmo instance = new ItemCarbineAmmo();
    public static final String name = "ItemCarbineAmmo";
    
	public ItemCarbineAmmo() {
        setMaxStackSize(32);
        setCreativeTab(halocraft.Main.haloCreativeTab);
        setMaxDamage(32);
        setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
