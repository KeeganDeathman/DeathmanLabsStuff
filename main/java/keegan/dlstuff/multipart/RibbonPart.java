package keegan.dlstuff.multipart;

import keegan.dlstuff.DLStuff;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import codechicken.lib.vec.*;
import codechicken.multipart.minecraft.*;

public class RibbonPart extends McSidedMetaPart
{
	
	public static int[] metaSideMap = new int[]{-1, 4, 5, 2, 3, 0};
    public static int[] sideMetaMap = new int[]{5, 0, 3, 4, 1, 2};
	
    public RibbonPart()
    {
    	
    }
    
	public RibbonPart(int meta)
	{
		super(meta);
	}

	@Override
	public Cuboid6 getBounds()
	{
		return getBounds(meta);
	}
	
	public Cuboid6 getBounds(int meta)
	{
		if(meta == 0)
			return new Cuboid6(0,.95,0,1,1,1);
		if(meta == 1)
			return new Cuboid6(0,0,0,1,.05,1);
		if(meta == 2)
			return new Cuboid6(0,0,.95,1,1,1);
		if(meta == 3)
			return new Cuboid6(0,0,0,1,1,.05);
		if(meta == 4)
			return new Cuboid6(.95,0,0,1,1,1);
		if(meta == 5)
			return new Cuboid6(0,0,0,.05,1,1);
		else
			return new Cuboid6(0,0,0,1,.05,1);
	}

	@Override
	public int sideForMeta(int arg0)
	{
		return ForgeDirection.OPPOSITES[meta];
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
	
	public static McBlockPart placement(World world, BlockCoord pos, int side)
	{
		pos = pos.copy().offset(ForgeDirection.OPPOSITES[side]);
        Block block = world.getBlock(pos.x, pos.y, pos.z);
        if(!block.isSideSolid(world, pos.x, pos.y, pos.z, ForgeDirection.getOrientation(side)))
            return null;
		return new RibbonPart(side);
	}

}
