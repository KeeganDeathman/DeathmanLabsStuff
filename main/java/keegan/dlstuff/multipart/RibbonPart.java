package keegan.dlstuff.multipart;

import keegan.dlstuff.DLStuff;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.ForgeDirection;
import codechicken.lib.vec.Cuboid6;
import codechicken.multipart.minecraft.McSidedMetaPart;

public class RibbonPart extends McSidedMetaPart
{
	
	public RibbonPart(int meta)
	{
		super(meta);
	}

	@Override
	public Cuboid6 getBounds()
	{
		return new Cuboid6(0,0,0,1,1/16,0);
	}

	@Override
	public int sideForMeta(int arg0)
	{
		return ForgeDirection.getOrientation(meta).getOpposite().ordinal();
	}

	@Override
	public Block getBlock()
	{
		// TODO Auto-generated method stub
		return DLStuff.blockDSCRibbonCable;
	}

	@Override
	public String getType()
	{
		// TODO Auto-generated method stub
		return "multiDSCRibbon";
	}

}
