package keegan.dlstuff.container.laptop;

import keegan.dlstuff.tileentity.TileEntityDLLaptop;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerDLLaptop extends Container
{
	public ContainerDLLaptop(InventoryPlayer inv, TileEntityDLLaptop tileEntity) 
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return true;
	}
}
