package halocraft.packets;

import halocraft.entities.EntityBullet;
import halocraft.entities.EntityPurplePlasma;
import halocraft.entities.EntityRocket;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FireMessageHandler implements IMessageHandler<FireMessage, IMessage> {
	@Override 
  	public IMessage onMessage(FireMessage message, MessageContext ctx) {

		final EntityPlayerMP serverPlayerIn = ctx.getServerHandler().playerEntity;
		final World worldIn = serverPlayerIn.worldObj;
		WorldServer mainThread = (WorldServer)(serverPlayerIn.worldObj);
		
		// The value that was sent
		int value = message.toSend;
		
		if(value == 1){
			mainThread.addScheduledTask(new Runnable() {
			    @Override
			    public void run() {
		            if (!worldIn.isRemote)
		            {	
		            	worldIn.spawnEntityInWorld(new EntityRocket(worldIn, serverPlayerIn));
		            }
			    }
			  });
		}
		else if(value == 2)
		{
			mainThread.addScheduledTask(new Runnable() {
			    @Override
			    public void run() {
		            if (!worldIn.isRemote)
		            {	
		            	worldIn.spawnEntityInWorld(new EntityPurplePlasma(worldIn, serverPlayerIn));
		            }
			    }
			  });
		}
		else if(value == 3)
		{
			mainThread.addScheduledTask(new Runnable() {
			    @Override
			    public void run() {
		            if (!worldIn.isRemote)
		            {	
		            	worldIn.spawnEntityInWorld(new EntityBullet(worldIn, serverPlayerIn));
		            }
			    }
			  });
		}
		return null;
	}
}