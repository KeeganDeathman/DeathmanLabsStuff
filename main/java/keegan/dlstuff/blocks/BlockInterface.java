package keegan.dlstuff.blocks;

import keegan.dlstuff.DLStuff;
import keegan.dlstuff.tileentity.TileEntityInterface;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockInterface extends Block implements ITileEntityProvider
{

	
	
	public BlockInterface(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		// TODO Auto-generated method stub
		return new TileEntityInterface();
	}
	
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
    {
    	int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
    	world.setBlockMetadataWithNotify(x, y, z, l, 2);
    	this.setBlockBounds(0, 0, 0, 1, 2, 1);
    	world.setBlock(x, y+1, z, DLStuff.blockGag);
    	BlockGag gag = (BlockGag)world.getBlock(x, y+1, z);
    	gag.setBlockToGagFor("Interface");
    }
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par5)
	{
		world.setBlockToAir(x, y+1, z);
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
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
    	return AxisAlignedBB.getBoundingBox(x, y, z, x, y+2, z);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	System.out.println("Welcome to the Vocal Interface");
    	//player.openGui(DLStuff.instance, 1, world, x, y, z);
    	return true;
    }

}
