package keegan.dlstuff.network;

import codechicken.lib.packet.PacketCustom;
import codechicken.lib.packet.PacketCustom.IServerPacketHandler;
import keegan.dlstuff.common.DLEventHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.INetHandlerPlayServer;

public class PacketHandler implements IServerPacketHandler
{
	public static Object channel = "dlstuff";// unique channel

	@Override
	public void handlePacket(PacketCustom packet, EntityPlayerMP sender, INetHandlerPlayServer netHandler)
	{
		switch (packet.getType())
		{
		case 1:// what to do based on the packet type set on creation and
				// sending
			DLEventHandler.place(sender, sender.worldObj);// do stuff server side
														// (we used the method
														// sendToServer,
														// remember?)
			break;
		}
	}
}
