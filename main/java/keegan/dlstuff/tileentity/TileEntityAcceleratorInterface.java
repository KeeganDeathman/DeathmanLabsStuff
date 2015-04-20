package keegan.dlstuff.tileentity;

import keegan.dlstuff.DLStuff;
import keegan.dlstuff.recipes.DLRecipes;
import keegan.labstuff.tileentity.DataConnectedDevice;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAcceleratorInterface extends DataConnectedDevice implements IInventory
{

	private ItemStack[] chestContents = new ItemStack[3];
	private TileEntityAcceleratorControlPanel control;
	
	@Override
	public int getSizeInventory()
	{
		// TODO Auto-generated method stub
		return chestContents.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return chestContents[slot];
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		if(this.getId() == null)
			registerWithNetwork();
		if(getNetwork() != null)
		{
			while(control == null)
			{
				for(int i = 0; i < getNetwork().getDeviceCount(); i++)
				{
					if(getNetwork().getDeviceByIndex(i) instanceof TileEntityAcceleratorControlPanel)
					{
						System.out.println("Control detected");
						control = (TileEntityAcceleratorControlPanel) getNetwork().getDeviceByIndex(i);
					}
				}
			}
		}
		else
			System.out.println("no network");
		if(control != null)
		{
			if(getStackInSlot(0) != null)
			{
				DataPackage hasMatter = new DataPackage(control, "particlesLoaded");
				getNetwork().sendMessage(hasMatter);
			}
			else
			{
				DataPackage hasMatter = new DataPackage(control, "particlesNotLoaded");
				getNetwork().sendMessage(hasMatter);
			}
			TileEntity core = worldObj.getTileEntity(xCoord - 6, yCoord, zCoord);
			if(core instanceof TileEntityAcceleratorDetectorCore)
			{
				if(((TileEntityAcceleratorDetectorCore) core).isGoodForLaunch())
				{
					DataPackage isPowered = new DataPackage(control, "powered");
					getNetwork().sendMessage(isPowered);
				}
				else
				{
					DataPackage isPowered = new DataPackage(control, "notPowered");
					getNetwork().sendMessage(isPowered);
				}
			}
		}
	}
	
	@Override
	public void performAction(String command)
	{
		if(command.startsWith("newDiscovery_"))
		{
			command.replace("newDiscovery_", "");
			int discovery = Integer.parseInt(command);
			setInventorySlotContents(1, DLRecipes.accelDiscoveries.get(discovery).getDiscoveryFlashDrive());
		}
		if(command.startsWith("launch"))
		{
			decrStackSize(0, 1);
		}
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amt) 
	{
		// TODO Auto-generated method stub
		ItemStack stack = getStackInSlot(slot);
		if (stack != null)
		{
				if (stack.stackSize <= amt)
				{
					setInventorySlotContents(slot, null);
				}
				else
				{
					stack = stack.splitStack(amt);
					if (stack.stackSize == 0)
					{
						setInventorySlotContents(slot, null);
					}
				}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) 
	{
		// TODO Auto-generated method stub
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) 
	{
		chestContents[slot] = itemstack;
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
		{
			itemstack.stackSize = getInventoryStackLimit();
		}
		
	}

	@Override
	public int getInventoryStackLimit() 
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) 
	{
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		if(slot == 0)
			return true;
		if(slot == 2 && (itemstack.isItemEqual(new ItemStack(DLStuff.itemWarpDriveBattery)) || itemstack.isItemEqual(new ItemStack(DLStuff.itemEmptyWarpDriveBattery))))
			return true;
		return false;
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "AceleratorInterface";
	}



	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void openInventory() {
		// TODO Auto-generated method stub

	}
}

