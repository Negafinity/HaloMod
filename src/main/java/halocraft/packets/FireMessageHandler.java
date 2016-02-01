package halocraft.packets;

import halocraft.entities.EntityBullet;
import halocraft.entities.EntityPurplePlasma;
import halocraft.entities.EntityRocket;
import halocraft.entities.EntityWarthogTurret;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.List;

public class FireMessageHandler implements IMessageHandler<FireMessage, IMessage>
{

	@Override
	public IMessage onMessage(FireMessage message, MessageContext ctx)
	{
		final EntityPlayerMP serverPlayerIn = ctx.getServerHandler().playerEntity;
		final World worldIn = serverPlayerIn.worldObj;
		WorldServer mainThread = (WorldServer) (serverPlayerIn.worldObj);

		// The value that was sent
		int value = message.toSend;

		if (value == 1)
		{
			mainThread.addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					EntityRocket er = new EntityRocket(worldIn, serverPlayerIn);
					er.shootingEntity = serverPlayerIn.ridingEntity;
					worldIn.spawnEntityInWorld(er);
				}
			});
		}
		else if (value == 2)
		{
			mainThread.addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					EntityPurplePlasma purplePlasma = new EntityPurplePlasma(worldIn, serverPlayerIn);
					purplePlasma.shootingEntity = serverPlayerIn.ridingEntity;
					purplePlasma.damage = 7;
					worldIn.spawnEntityInWorld(purplePlasma);
				}
			});
		}
		else if (value == 3)
		{
			mainThread.addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					if (isThirdRider(worldIn, serverPlayerIn))
					{
						worldIn.spawnEntityInWorld(new EntityBullet(worldIn, serverPlayerIn));
					}
				}
			});
		}
		return null;
	}

	public boolean isThirdRider(World worldIn, EntityPlayerMP serverPlayerIn)
	{
		List<EntityWarthogTurret> entities = worldIn.getEntitiesWithinAABB(EntityWarthogTurret.class, serverPlayerIn.getEntityBoundingBox().expand(4, 4, 4));
		if (entities != null)
		{
			for (EntityWarthogTurret e : entities)
			{
				if (e.thirdRider == serverPlayerIn)
				{
					return true;
				}
			}
		}
		return false;
	}
}
