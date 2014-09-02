package keegan.dlstuff.client.gui;

import keegan.dlstuff.client.gui.laptop.GuiDLLaptop;
import keegan.dlstuff.client.gui.laptop.GuiDLLaptopDrives;
import keegan.dlstuff.container.laptop.ContainerDLLaptop;
import keegan.dlstuff.container.laptop.ContainerDLLaptopDrives;
import keegan.dlstuff.tileentity.TileEntityDLLaptop;
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
			if(ID == 0)
			{
				return new ContainerDLLaptop(player.inventory, (TileEntityDLLaptop) te);
			}
			else if(ID == 1)
			{
				return new ContainerDLLaptopDrives(player.inventory, (TileEntityDLLaptop) te);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof TileEntityDLLaptop)
		{
			if(ID == 0)
			{
				return new GuiDLLaptop((TileEntityDLLaptop) te, player.inventory, player);
			}
			else if(ID == 1)
			{
				return new GuiDLLaptopDrives((TileEntityDLLaptop) te, player.inventory, player);
			}
		}
		return null;
	}

}
