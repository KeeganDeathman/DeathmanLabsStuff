package keegan.dlstuff.blocks;

import org.lwjgl.input.Keyboard;

import keegan.dlstuff.DLStuff;
import keegan.dlstuff.tileentity.TileEntityDLLaptop;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MouseHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDLLaptop extends Block implements ITileEntityProvider
{
	

	public BlockDLLaptop(Material p_i45394_1_) 
	{
		super(p_i45394_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TileEntityDLLaptop();
	}
	
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
    {
    	int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
    	world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }
	
	@Override
    public boolean isOpaqueCube() 
    {
            return false;
    }
    
    public boolean shouldSideBeRendered(IBlockAccess access, int i, int j, int k, int l)
	{
    	return false;
	}
    
    @Override
    public boolean renderAsNormalBlock()
    {
    	return false;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	if(!world.isRemote)
    	{
    		if(!player.isSneaking() && !Keyboard.isKeyDown(Keyboard.KEY_LCONTROL))
        	{
        		player.openGui(DLStuff.instance, 0, world, x, y, z);
        		return true;
        	}
        	else if(!player.isSneaking() && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL))
        	{
        		TileEntityDLLaptop te = (TileEntityDLLaptop)world.getTileEntity(x, y, z);
        		if(te.tablet)
        		{
        			player.inventory.addItemStackToInventory(te.tabletItem);
        			te.setTablet(false);
        			te.setInventorySlotContents(0, null);
        			world.markBlockForUpdate(x, y, z);
        			return true;
        		}
        		if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().isItemEqual(new ItemStack(DLStuff.itemUnProgrammedDPad)))
        		{
        			player.inventory.decrStackSize(player.inventory.currentItem, 1);
        			te.setTabletItem(new ItemStack(DLStuff.itemUnProgrammedDPad));
            		te.setTablet(true);
            		world.markBlockForUpdate(x, y, z);
            		return true;
        		}
        		return false;
        	}
    	}
    	return false;
    }

}
