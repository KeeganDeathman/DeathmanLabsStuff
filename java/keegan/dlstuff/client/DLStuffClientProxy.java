package keegan.dlstuff.client;

import keegan.dlstuff.DLStuff;
import keegan.dlstuff.common.DLStuffCommonProxy;
import keegan.dlstuff.render.ItemRenderDLLaptop;
import keegan.dlstuff.render.RenderDLLaptop;
import keegan.dlstuff.render.RenderInterface;
import keegan.dlstuff.tileentity.TileEntityDLLaptop;
import keegan.dlstuff.tileentity.TileEntityInterface;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;

public class DLStuffClientProxy extends DLStuffCommonProxy
{
	@Override
	public void registerRenders()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDLLaptop.class, new RenderDLLaptop());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DLStuff.blockDLLaptop), new ItemRenderDLLaptop());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInterface.class, new RenderInterface());
	}
	
	@Override
	public void initMod(){
		
	}
}