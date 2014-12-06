package keegan.dlstuff.tileentity;

import keegan.dlstuff.DLStuff;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDLLaptop extends TileEntity implements IInventory
{
	
	public static boolean tablet;
	
	public ItemStack tabletItem;
	
	public TileEntityDLLaptop()
	{
		tablet = false;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		tag.setBoolean("Tablet", tablet);
		if(tabletItem != null)
			tabletItem.writeToNBT(tag);
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		tablet = tag.getBoolean("Tablet");
		tabletItem = ItemStack.loadItemStackFromNBT(tag);
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemStack decrStackSize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int arg0, ItemStack arg1) {
		if(arg0 == 0 && arg1.getItem() == DLStuff.itemDPad)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInventorySlotContents(int arg0, ItemStack arg1) {
		// TODO Auto-generated method stub
		
	}

	public static boolean isTablet() {
		return tablet;
	}

	public static void setTablet(boolean tablet) {
		TileEntityDLLaptop.tablet = tablet;
	}

	public ItemStack getTabletItem() {
		return tabletItem;
	}

	public void setTabletItem(ItemStack tabletItem) {
		this.tabletItem = tabletItem;
	}
}
