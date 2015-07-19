package halocraft.items;

import halocraft.Main;
import halocraft.entities.EntityBullet;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBattleRifle extends Item {
	public static final ItemBattleRifle instance = new ItemBattleRifle();
    public static final String name = "itemBattleRifle";
    
	public ItemBattleRifle(){
		setCreativeTab(halocraft.Main.haloCreativeTab);
		setUnlocalizedName("halocraft:" + name.toLowerCase());
		setMaxStackSize(1);
		setMaxDamage(1000);
	}
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn){
		if(playerIn.capabilities.isCreativeMode || playerIn.inventory.consumeInventoryItem(halocraft.Main.ammoAssaultRifle)){
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!worldIn.isRemote)
		    {
				EntityBullet bullet = new EntityBullet(worldIn, playerIn);
				bullet.damage = 8;
				worldIn.spawnEntityInWorld(bullet);
				itemStackIn.damageItem(1, playerIn);
			}
	         return itemStackIn;
	   }
	   return itemStackIn;
	}
}
