package keegan.dlstuff.multipart;

import codechicken.lib.vec.BlockCoord;
import codechicken.multipart.TileMultipart;
import net.minecraft.world.IBlockAccess;

public class MultipartHelp
{
	public TileMultipart getMultipartTile(IBlockAccess iba, BlockCoord bc)
	{
		return getMultipartTile(iba, bc.x, bc.y, bc.z);
	}

	public TileMultipart getMultipartTile(IBlockAccess iba, int x, int y, int z)
	{
		if (iba.getTileEntity(x, y, z) instanceof TileMultipart) return (TileMultipart) iba.getTileEntity(x, y, z);
		return null;
	}

}
