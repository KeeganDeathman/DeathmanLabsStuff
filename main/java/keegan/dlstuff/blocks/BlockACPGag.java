package keegan.dlstuff.blocks;

import keegan.dlstuff.DLStuff;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.*;

public class BlockACPGag extends Block
{

	private int[] coreCoords;

	public BlockACPGag(Material p_i45394_1_)
	{
		super(p_i45394_1_);
		coreCoords = new int[3];
	}

	public Block setCore(int x, int y, int z)
	{
		coreCoords[0] = x;
		coreCoords[1] = y;
		coreCoords[2] = z;
		return this;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if (!world.isRemote)
		{
			// System.out.println("Server");
			if (!player.isSneaking())
			{
				player.openGui(DLStuff.instance, 3, world, coreCoords[0], coreCoords[1], coreCoords[2]);
				return true;
			}
		}
		return false;
	}
	
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

}