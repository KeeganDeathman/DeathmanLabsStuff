package keegan.dlstuff.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import keegan.dlstuff.DLStuff;
import keegan.dlstuff.common.DLStuffCommonProxy;
import keegan.dlstuff.multipart.TileEntityRibbonCable;
import keegan.dlstuff.render.*;
import keegan.dlstuff.tileentity.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

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
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DLStuff.blockDSCRibbonCable), new ItemRendererRibbonCable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRibbonCable.class, new RenderRibbonCable());
	}
	
	@Override
	public void initMod(){
		
	}
}