package keegan.dlstuff.network;

import codechicken.lib.packet.PacketCustom;
import codechicken.lib.packet.PacketCustom.IClientPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.INetHandlerPlayClient;

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
