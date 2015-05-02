package keegan.dlstuff.client;

import keegan.dlstuff.DLStuff;
import keegan.dlstuff.common.DLStuffCommonProxy;
import keegan.dlstuff.render.*;
import keegan.dlstuff.tileentity.*;
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
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInterface.class, new RenderInterface());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAcceleratorControlPanel.class, new RenderAcceleratorControlPanel());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DLStuff.blockAcceleratorControlPanel), new ItemRenderAcceleratorControlPanel());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAcceleratorTube.class, new RenderAcceleratorTube());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DLStuff.blockAcceleratorTube), new ItemRenderAcceleratorPipe());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAcceleratorDetectorCore.class, new RenderAcceleratorDetector());
	}
	
	@Override
	public void initMod(){
		
	}
}