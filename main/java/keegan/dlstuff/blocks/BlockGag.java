package keegan.dlstuff.blocks;

import keegan.dlstuff.DLStuff;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGag extends Block
{
	
	public String gagFor = "";

	public BlockGag(Material p_i45394_1_) 
	{
		super(p_i45394_1_);
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
    
    public void setBlockToGagFor(String gag)
    {
    	gagFor = gag;
    	if(gag == "Interface")
    	{
    		System.out.println("Gagging for interface");
    		this.setBlockBounds(0, -1, 0, 1, 1, 1);
    	}
    }
    
    @Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par5)
	{
		if(gagFor == "Interface")
		{
			world.setBlockToAir(x, y-1, z);
		}
	}
    
    @Override
    public boolean renderAsNormalBlock()
    {
    	return false;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	if(gagFor == "Interface")
    	{
    		System.out.println("Welcome to the Vocal Interface");
    		//player.openGui(DLStuff.instance, 1, world, x, y-1, z);
    		return true;
    	}
    return false;
    }

}
