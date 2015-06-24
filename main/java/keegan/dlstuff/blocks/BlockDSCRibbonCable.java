package keegan.dlstuff.blocks;

import keegan.dlstuff.multipart.TileEntityRibbonCable;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.*;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockDSCRibbonCable extends Block implements ITileEntityProvider
{

	private ForgeDirection EAST = ForgeDirection.EAST;
	private ForgeDirection WEST = ForgeDirection.WEST;
	private ForgeDirection SOUTH = ForgeDirection.SOUTH;
	private ForgeDirection NORTH = ForgeDirection.NORTH;
	private ForgeDirection UP = ForgeDirection.UP;
	private ForgeDirection DOWN = ForgeDirection.DOWN;

	public BlockDSCRibbonCable(Material p_i45394_1_)
	{
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata_of_the_item)
	{
		return side;// this sets the metadata of the block to side
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return world.isSideSolid(x - 1, y, z, EAST) || world.isSideSolid(x + 1, y, z, WEST) || world.isSideSolid(x, y, z - 1, SOUTH) || world.isSideSolid(x, y, z + 1, NORTH) || world.isSideSolid(x, y - 1, z, UP) || world.isSideSolid(x, y + 1, z, DOWN);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		// make it drop if support block is removed
		if (!this.canPlaceBlockAt(world, x, y, z))
		{
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
			return;
		}
		else
		{
			int l = world.getBlockMetadata(x, y, z);
			if (!canPlaceBlockOnSide(world, x, y, z, l))
			{
				this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean shouldSideBeRendered(IBlockAccess access, int i, int j, int k, int l)
	{
		return true;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	// and you probably want to set the block bounds based on the side it is
	// attached to
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		if (l == 1)
			this.setBlockBounds(0F, 0F, 0F, 1F, .05F, 1F);
		else if (l == 0)
			this.setBlockBounds(0F, .95F, 0F, 1F, 1F, 1F);
		else if (l == 2)
			this.setBlockBounds(0F, 0F, .95F, 1F, 1F, 1F);
		else if (l == 3)
			this.setBlockBounds(0F, 0F, 0F, 1F, 1F, .05F);
		else if (l == 4)
			this.setBlockBounds(.95F, 0F, 0F, 1F, 1F, 1F);
		else if (l == 5) 
			this.setBlockBounds(0F, 0F, 0F, .05F, 1F, 1F);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		// TODO Auto-generated method stub
		return new TileEntityRibbonCable();
	}

}
