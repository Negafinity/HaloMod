package halocraft.packets;

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
		            	Vec3 vec = serverPlayerIn.getLookVec();
		            	BlockPos pos = serverPlayerIn.getPosition();
		            	double x = pos.getX();
		            	double y = pos.getY();
		            	double z = pos.getZ();
		            	double X = vec.xCoord;
		            	double Y = vec.yCoord;
		            	double Z = vec.zCoord;
		            	EntityRocket rocket = new EntityRocket(worldIn, x+X, y+Y, z+Z);
		                worldIn.spawnEntityInWorld(rocket);
		            }
			    }
			  });
		}
		return null;
	}
}