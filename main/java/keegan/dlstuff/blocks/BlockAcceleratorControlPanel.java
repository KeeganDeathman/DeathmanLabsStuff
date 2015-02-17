package keegan.dlstuff.blocks;

import keegan.dlstuff.tileentity.TileEntityAcceleratorControlPanel;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAcceleratorControlPanel extends Block implements ITileEntityProvider
{

	public BlockAcceleratorControlPanel() 
	{
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityAcceleratorControlPanel();
	}
	
	

}
