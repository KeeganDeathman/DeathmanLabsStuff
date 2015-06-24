package keegan.dlstuff.network;

import keegan.dlstuff.common.DLEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.INetHandlerPlayClient;
import codechicken.lib.packet.*;
import codechicken.lib.packet.PacketCustom.IClientPacketHandler;

public class ClientPacketHandler implements IClientPacketHandler
{

	@Override
	public void handlePacket(PacketCustom packet, Minecraft sender, INetHandlerPlayClient netHandler)
	{
		switch (packet.getType())
		{
		case 1:// what to do based on the packet type set on creation and
				// sending
		}
	}

}
