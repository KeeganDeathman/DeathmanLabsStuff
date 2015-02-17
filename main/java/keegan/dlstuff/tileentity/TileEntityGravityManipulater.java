package keegan.dlstuff.tileentity;

import keegan.dlstuff.DLStuff;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGravityManipulater extends TileEntity implements IInventory
{
	
	private int gravityModifier;
	private int warpTime;
	
	private ItemStack[] chestContents  = new ItemStack[1];
	
	public TileEntityGravityManipulater()
	{
		gravityModifier = -5;
		warpTime = 0;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		tag.setInteger("gravityManipulater", gravityModifier);
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		gravityModifier = tag.getInteger("gravityModifier");
	}
	
	@Override
	public void updateEntity()
	{

		if(getStackInSlot(0).isItemEqual(new ItemStack(DLStuff.itemWarpDriveBattery)) && warpTime == 0)
		{
			decrStackSize(0, 1);
			warpTime = 36000;
		}
		if(warpTime > 0)
		{
			for(int i = 0; i < worldObj.playerEntities.size(); i++)
			{
				EntityPlayer player = (EntityPlayer) worldObj.playerEntities.get(i);
				if(!player.capabilities.isFlying && Math.abs(player.posX - xCoord) <= 25 && Math.abs(player.posY - yCoord) <= 26 && Math.abs(player.posZ - zCoord) <= 25)
					player.addVelocity(0, getGravityModifier(), 0);
			}
			warpTime -= 1;
			if(warpTime == 0)
			{
				worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord+1, zCoord, new ItemStack(DLStuff.itemEmptyWarpDriveBattery)));
			}
		}
	}

	public int getGravityModifier()
	{
		return gravityModifier;
	}

	public void setGravityModifier(int gravityModifier)
	{
		System.out.println("Changing gravity " + gravityModifier);
		this.gravityModifier = 0 - gravityModifier;
	}

	@Override
	public int getSizeInventory()
	{
		return chestContents.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return chestContents[slot];
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
		if(slot == 0 && (itemstack.isItemEqual(new ItemStack(DLStuff.itemWarpDriveBattery)) || itemstack.isItemEqual(new ItemStack(DLStuff.itemEmptyWarpDriveBattery))))
			return true;
		return false;
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "Gravity";
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
