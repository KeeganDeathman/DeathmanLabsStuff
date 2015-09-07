package keegan.dlstuff.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import keegan.dlstuff.client.gui.laptop.GuiDLLaptop;
import keegan.dlstuff.container.*;
import keegan.dlstuff.container.laptop.ContainerDLLaptop;
import keegan.dlstuff.tileentity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntityDLLaptop)
		{
			return new ContainerDLLaptop(player.inventory, (TileEntityDLLaptop) te);
		}
		if (te instanceof TileEntityGravityManipulater)
		{
			return new ContainerGravity(player.inventory, (TileEntityGravityManipulater) te);
		}
		if (te instanceof TileEntityAcceleratorControlPanel)
		{
			return new ContainerACP();
		}
		if (te instanceof TileEntityAcceleratorInterface)
		{
			return new ContainerAcceleratorInterface(player.inventory, (TileEntityAcceleratorInterface) te);
		}
		if(te instanceof DSCDrive)
		{
			return new ContainerDSCDrive(player.inventory, (DSCDrive) te);
		}
		if(te instanceof DSCBench)
		{
			return new ContainerDSCBench(player.inventory, (DSCBench) te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntityDLLaptop)
		{
			return new GuiDLLaptop((TileEntityDLLaptop) te, player.inventory, player);
		}
		if (te instanceof TileEntityGravityManipulater)
		{
			return new GuiGravityManipulater((TileEntityGravityManipulater) te, player.inventory);
		}
		if (te instanceof TileEntityAcceleratorControlPanel)
		{
			return new GuiACP((TileEntityAcceleratorControlPanel)te);
		}
		if (te instanceof TileEntityAcceleratorInterface)
		{
			return new GuiAcceleratorInterface(player.inventory, (TileEntityAcceleratorInterface) te);
		}
		if(te instanceof DSCDrive)
		{
			return new GuiDSCDrive(player.inventory, (DSCDrive) te);
		}
		if(te instanceof DSCBench)
		{
			return new GuiDSCBench(player.inventory, (DSCBench) te);
		}
		return null;
	}

}
