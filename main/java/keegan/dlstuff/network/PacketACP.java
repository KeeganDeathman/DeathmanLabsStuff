package keegan.dlstuff.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import keegan.dlstuff.tileentity.TileEntityAcceleratorControlPanel;
import keegan.labstuff.PacketHandling.AbstractPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PacketACP extends AbstractPacket
{

	private int x, y, z;
	private String button;
	
	public PacketACP() {}
	
	public PacketACP(int x, int y, int z, String button)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.button = button;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		ByteBufUtils.writeUTF8String(buffer, button);

	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		button = ByteBufUtils.readUTF8String(buffer);

	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		World world = player.worldObj;
		TileEntity te = world.getTileEntity(x,y,z);
		if(te instanceof TileEntityAcceleratorControlPanel)
		{
			if(button.equals("launch"))
				((TileEntityAcceleratorControlPanel)te).launch();
		}
	}

}
