package keegan.dlstuff.blocks;

import keegan.dlstuff.DLStuff;
import keegan.dlstuff.tileentity.DSCBench;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockDSCBench extends Block implements ITileEntityProvider
{

	public BlockDSCBench(Material p_i45394_1_)
	{
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		// TODO Auto-generated method stub
		return new DSCBench();
	}
	
	private IIcon side1;
	private IIcon side2;
	
	@Override
    // registerIcons
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        // blockIcon - blockIcon
        this.side1 = this.blockIcon = par1IconRegister.registerIcon("dlstuff:dscbench");
        this.side2 = par1IconRegister.registerIcon("dlstuff:DSC");
    }
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if(side == 1)
		{
			return this.side1;
		}
		return this.side2;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if (!world.isRemote)
		{
			// System.out.println("Server");
			DSCBench te = (DSCBench) world.getTileEntity(x, y, z);
			if (!player.isSneaking() && te != null)
			{
				// System.out.println("All systems are go!");
				player.openGui(DLStuff.instance, 6, world, x, y, z);
				// System.out.println("Gui opened");
				return true;
			}
		}
		return false;
	}


	
}
