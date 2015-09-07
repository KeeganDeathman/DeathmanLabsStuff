package keegan.labstuff.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityIndustrialMotorShaft extends TileEntityRotary
{
	public TileEntityIndustrialMotorShaft()
	{
		setDirIn(ForgeDirection.DOWN);
		setDirOut(ForgeDirection.UP);
	}
	
	@Override
	public void updateEntity()
	{
		if(worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityIndustrialMotorContact)
		{
			if(((TileEntityIndustrialMotorContact)worldObj.getTileEntity(xCoord, yCoord - 1, zCoord)).isPowered)
				addEnergy(500);
		}
	}
}
