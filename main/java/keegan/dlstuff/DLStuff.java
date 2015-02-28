package keegan.dlstuff;

import java.io.File;

import keegan.dlstuff.blocks.*;
import keegan.dlstuff.client.gui.GuiHandler;
import keegan.dlstuff.common.*;
import keegan.dlstuff.items.*;
import keegan.dlstuff.network.*;
import keegan.dlstuff.recipes.*;
import keegan.dlstuff.tileentity.*;
import keegan.labstuff.LabStuffMain;
import keegan.labstuff.PacketHandling.PacketPipeline;
import keegan.labstuff.common.TabLabStuff;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
@Mod(version="1.0",modid="dlstuff",name="Deathman Labs Stuff", dependencies="required-after:labstuff@[2.5,)")
public class DLStuff 
{
	
	@SidedProxy(clientSide = "keegan.dlstuff.client.DLStuffClientProxy", serverSide = "keegan.dlstuff.common.DLStuffCommonProxy")
	public static DLStuffCommonProxy proxy;
	
	@Instance("dlstuff")
	public static DLStuff instance;
	
	public static final File DLFilesDir = new File(LabStuffMain.filesDir, "DLStuff");
	static {DLFilesDir.mkdirs();}
	
	//Blocks
	public static Block blockDLLaptop;
	public static Block blockInterface;
	public static Block blockGag;
	
	
	//Particle accelerator
	public static Block blockAcceleratorTube;
	public static Block blockAcelleratorCollisonTube;
	public static Block blockAcceleratorInterface;
	public static Block blockAcceleratorControlPanel;
	public static Block blockACPGag;
	
	//ABRID
	public static Block blockABRID;
	public static Block blockChemicalInjector;
	public static Block blockPalladiumInjector;
	public static Block blockArcInput;
	public static Block blockElectorstaticExtractor;
	public static Block blockPalladiumOre;
	public static Block blockElectromagneticFieldProjector;
	
	//WarpDrive
	public static Block blockGravityManipulater;
	
	
	
	//Items
	public static Item itemTouchMesh;
	public static Item itemTouchScreen;
	public static Item itemUnProgrammedDPad;
	public static Item itemDPad;
	
	//ABRID
	public static Item itemBottleOfABRIDChemical;
	public static Item itemPalladiumExtract;
	
	//WarpDrive
	public static Item itemWarpDriveBattery;
	public static Item itemEmptyWarpDriveBattery;
	
	public static final PacketPipeline packetPipeline = LabStuffMain.packetPipeline;
	
	//Other
	public static TabLabStuff tabDeathman = new TabDeathman("tabDeathman");
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		//Items
		itemDPad = new ItemDPad().setUnlocalizedName("itemDPad").setTextureName("dlstuff:itemDPad").setCreativeTab(tabDeathman);
		GameRegistry.registerItem(itemDPad, "dPad");
		itemTouchMesh = new ItemDPadPart().setUnlocalizedName("itemTouchMesh").setCreativeTab(tabDeathman).setTextureName("dlstuff:itemTouchMesh");
		GameRegistry.registerItem(itemTouchMesh, "touchMesh");
		itemTouchScreen = new ItemDPadPart().setCreativeTab(tabDeathman).setTextureName("dlstuff:itemTouchScreen").setUnlocalizedName("itemTouchScreen");
		GameRegistry.registerItem(itemTouchScreen, "touchScreen");
		itemUnProgrammedDPad = new ItemDPadPart().setUnlocalizedName("itemBiosFailDPad").setTextureName("dlstuff:itemBiosFailDPad").setCreativeTab(tabDeathman);
		GameRegistry.registerItem(itemUnProgrammedDPad, "biosFailDPad");
		itemWarpDriveBattery = new ItemWarpDriveBattery().setCreativeTab(tabDeathman).setUnlocalizedName("itemWarpDriveBattery").setTextureName("dlstuff:warpBattery");
		itemEmptyWarpDriveBattery = new ItemEmptyWarpDriveBattery().setCreativeTab(tabDeathman).setUnlocalizedName("itemEmptyWarpDriveBattery").setTextureName("dlstuff:warpBatteryEmpty");
		GameRegistry.registerItem(itemWarpDriveBattery, "itemWarpDriveBattery");
		GameRegistry.registerItem(itemEmptyWarpDriveBattery, "itemEmptyWarpDriveBattery");
		
		//Blocks
		blockDLLaptop = new BlockDLLaptop(Material.iron).setBlockName("blockDLLaptop").setCreativeTab(tabDeathman);
		GameRegistry.registerBlock(blockDLLaptop, "blockDLLaptop");
		blockInterface = new BlockInterface(Material.iron).setBlockName("blockInterface").setCreativeTab(tabDeathman);
		//GameRegistry.registerBlock(blockInterface, "blockInterface");
		blockGag = new BlockGag(Material.iron).setBlockName("blockGag").setBlockTextureName("dlstuff:blockGag");
		GameRegistry.registerBlock(blockGag, "gag");
		blockAcceleratorControlPanel = new BlockAcceleratorControlPanel().setBlockName("blockAcceleratorControlPanel").setCreativeTab(tabDeathman);
		GameRegistry.registerBlock(blockAcceleratorControlPanel, "blockAcceleratorControlPanel");
		blockACPGag = new BlockACPGag(Material.iron).setBlockName("blockACPGag").setBlockTextureName("dlstuff:blockGag");
		GameRegistry.registerBlock(blockACPGag, "blockACPGag");
		blockAcceleratorInterface = new BlockAcceleratorInterface().setBlockName("blockAcceleratorInterface").setCreativeTab(tabDeathman).setBlockTextureName("dlstuff:acceleratorInterface");
		GameRegistry.registerBlock(blockAcceleratorInterface, "blockAcceleratorInterface");
		blockAcceleratorTube = new BlockAcceleratorTube().setBlockName("blockAcceleratorTube").setCreativeTab(tabDeathman);
		blockGravityManipulater = new BlockGravityManipulater(Material.iron).setCreativeTab(tabDeathman).setBlockName("blockGravityManipulater").setBlockTextureName("dlstuff:blockGravity");
		GameRegistry.registerBlock(blockGravityManipulater, "blockGravityManipulater");
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		//Intialization stuff
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		proxy.registerRenders();
		
		//Crafting Recipes
		DLRecipes.registerShaplessCrafting();
		DLRecipes.registerShaplessCrafting();
		
		DLRecipes.addAction(new WebDownload());
		
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityDLLaptop.class, "TileEntityDLLaptop");
		GameRegistry.registerTileEntity(TileEntityGravityManipulater.class, "tileEntityGravity");		
		GameRegistry.registerTileEntity(TileEntityAcceleratorControlPanel.class, "TileEntityAcceleratorControlPanel");
		GameRegistry.registerTileEntity(TileEntityAcceleratorInterface.class, "TileEntityAcceleratorInterface");
		//Packets
		packetPipeline.registerPacket(PacketDLLaptopUSB.class);
		packetPipeline.registerPacket(PacketDLLaptopWeb.class);
		packetPipeline.registerPacket(PacketGravity.class);
	}
	
}
