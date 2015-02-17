package keegan.dlstuff.client.gui;

import keegan.dlstuff.client.gui.laptop.GuiDLLaptop;
import keegan.dlstuff.container.ContainerGravity;
import keegan.dlstuff.container.laptop.ContainerDLLaptop;
import keegan.dlstuff.tileentity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler 
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof TileEntityDLLaptop)
		{
				return new ContainerDLLaptop(player.inventory, (TileEntityDLLaptop) te);
		}
		if(te instanceof TileEntityGravityManipulater)
		{
				return new ContainerGravity(player.inventory, (TileEntityGravityManipulater) te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof TileEntityDLLaptop)
		{
			return new GuiDLLaptop((TileEntityDLLaptop) te, player.inventory, player);
		}
		if(te instanceof TileEntityGravityManipulater)
		{
			return new GuiGravityManipulater((TileEntityGravityManipulater) te, player.inventory);
		}
		return null;
	}

}
