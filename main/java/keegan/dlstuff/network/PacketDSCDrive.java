package keegan.dlstuff.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import keegan.dlstuff.recipes.*;
import keegan.dlstuff.tileentity.DSCDrive;
import keegan.labstuff.PacketHandling.AbstractPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class PacketDSCDrive extends AbstractPacket
{
	private AcceleratorDiscovery discov;
	private int x,y,z;
	
	public PacketDSCDrive(){}
	public PacketDSCDrive(AcceleratorDiscovery dis, int x, int y, int z)
	{
		discov = dis;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	@Override
	public void decodeInto(ChannelHandlerContext arg0, ByteBuf arg1)
	{
		int dis = arg1.readInt();
		x = arg1.readInt();
		y = arg1.readInt();
		z = arg1.readInt();
		discov = DLRecipes.accelDiscoveries.get(dis);
		System.out.println("Only 60's kids.");

	}

	@Override
	public void encodeInto(ChannelHandlerContext arg0, ByteBuf arg1)
	{
		int dis = discov.getIndex();
		arg1.writeInt(dis);
		arg1.writeInt(x);
		arg1.writeInt(y);
		arg1.writeInt(z);
		System.out.println("Only 70's kids.");

	}

	@Override
	public void handleClientSide(EntityPlayer arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void handleServerSide(EntityPlayer arg0)
	{
		TileEntity tile = arg0.worldObj.getTileEntity(x, y, z);
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		if(tile != null & tile instanceof DSCDrive)
		{
			System.out.println("Only 80's kids.");
			((DSCDrive)tile).install(discov);
		}
	}

}
