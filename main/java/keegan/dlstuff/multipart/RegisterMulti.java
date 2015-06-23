package keegan.dlstuff.multipart;

import java.util.Arrays;

import keegan.dlstuff.DLStuff;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import codechicken.lib.vec.BlockCoord;
import codechicken.multipart.*;
import codechicken.multipart.MultiPartRegistry.*;
import codechicken.multipart.minecraft.*;

public class RegisterMulti implements IPartFactory, IPartConverter
{
	
	public RegisterMulti()
	{
		init();
	}
	
	@Override
    public TMultiPart createPart(String name, boolean client)
    {
        if(name.equals("multiDSCRibbon")) return new TorchPart();
        
        return null;
    }
    
    public void init()
    {
        MultiPartRegistry.registerConverter(this);
        MultiPartRegistry.registerParts(this, new String[]{
                "multiDSCRibbon"
            });
    }

    @Override
    public Iterable<Block> blockTypes() {
        return Arrays.asList(DLStuff.blockDSCRibbonCable);
    }

    @Override
    public TMultiPart convert(World world, BlockCoord pos)
    {
        Block b = world.getBlock(pos.x, pos.y, pos.z);
        int meta = world.getBlockMetadata(pos.x, pos.y, pos.z);
        if(b == DLStuff.blockDSCRibbonCable)
            return new RibbonPart(meta);
        
        return null;
    }
}

