package keegan.dlstuff.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import keegan.dlstuff.tileentity.TileEntityGravityManipulater;
import keegan.labstuff.PacketHandling.AbstractPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PacketGravity extends AbstractPacket
{

	private int x,y,z,gravity;
	
	public PacketGravity(){}
	
	public PacketGravity(int x, int y, int z, int gravity)
	{
		this.x = x;
		this.y = y ;
		this.z = z;
		this.gravity = gravity;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(gravity);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.gravity = buffer.readInt();

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
		if(te instanceof TileEntityGravityManipulater)
		{
			System.out.println("Performing action");
			((TileEntityGravityManipulater) te).setGravityModifier(gravity);
		}
		else
		{
			System.out.println("Nope, its something else");
		}

	}

}
