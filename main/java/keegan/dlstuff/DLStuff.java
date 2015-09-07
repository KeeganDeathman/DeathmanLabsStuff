package keegan.dlstuff;

import java.io.File;

import codechicken.lib.packet.PacketCustom;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import keegan.dlstuff.blocks.*;
import keegan.dlstuff.client.gui.GuiHandler;
import keegan.dlstuff.common.*;
import keegan.dlstuff.items.*;
import keegan.dlstuff.multipart.TileEntityRibbonCable;
import keegan.dlstuff.network.*;
import keegan.dlstuff.recipes.*;
import keegan.dlstuff.tileentity.*;
import keegan.labstuff.LabStuffMain;
import keegan.labstuff.PacketHandling.PacketPipeline;
import keegan.labstuff.common.TabLabStuff;
import keegan.labstuff.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
@Mod(version="1.0",modid="dlstuff",name="Deathman Labs Stuff", dependencies="required-after:labstuff@[2.5,);after:ForgeMultipart")
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
	public static Block blockAcceleratorDetectorCore;
	public static Block blockAcceleratorTrackingDetector;
	public static Block blockAcceleratorSolenoid;
	public static Block blockAcceleratorElectromagneticCalorimeter;
	public static Block blockAcceleratorHadronCalorimeter;
	public static Block blockAcceleratorMuonDetector;
	public static Block blockAcceleratorInterface;
	public static Block blockAcceleratorPowerInput;
	public static Block blockAcceleratorControlPanel;
	public static Block blockACPGag;
	
	//GBRID
	public static Block blockGBRID;
	public static Block blockChemicalInjector;
	public static Block blockPalladiumInjector;
	public static Block blockArcInput;
	public static Block blockElectorstaticExtractor;
	public static Block blockPalladiumOre;
	public static Block blockElectromagneticFieldProjector;
	
	//DiscoverySupercomputer
	public static Block blockDSCCore;
	public static Block blockDSCRam;
	public static Block blockDSCWorkbench;
	public static Block blockDSCDrive;
	public static Block blockDSCOS;
	public static Block blockDSCRibbonCable;
	
	//WarpDrive
	public static Block blockGravityManipulater;
	
	
	
	//Items
	public static Item itemTouchMesh;
	public static Item itemTouchScreen;
	public static Item itemUnProgrammedDPad;
	public static Item itemDPad;
	
	//Accelerator
	public static Item itemAdvancedAccelInterface;
	public static Item itemGluonDetector;
	
	//Discoveries
	public static Item itemDiscoveryDrive;
	public static Item itemDiscoveryAntiMatter;
	public static Item itemDiscoveryNegativeEnergy;
	public static Item itemDiscoveryWarp;
	public static Item itemDiscoveryTemporal;
	public static Item itemDiscoveryDesign;
	public static Item itemEtchedDiscovery;
	public static Item itemDrilledDiscovery;
	public static Item itemDSCCoreDesign;
	public static Item itemEtchedDSCCore;
	public static Item itemDrilledDSCCore;
	public static Item itemDSCRamDesign;
	public static Item itemEtchedDSCRam;
	public static Item itemDrilledDSCRam;
	public static Item itemDSCOSDesign;
	public static Item itemEtchedDSCOS;
	public static Item itemDrilledDSCOS;
	public static Item itemDSCBenchDesign;
	public static Item itemEtchedDSCBench;
	public static Item itemDrilledDSCBench;
	public static Item itemDSCDriveDesign;
	public static Item itemEtchedDSCDrive;
	public static Item itemDrilledDSCDrive;

	
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
		itemEmptyWarpDriveBattery = new ItemEmptyWarpDriveBattery().setCreativeTab(tabDeathman).setUnlocalizedName("itemEmptyWarpDriveBattery").setTextureName("dlstuff:warpBattery");
		GameRegistry.registerItem(itemWarpDriveBattery, "itemWarpDriveBattery");
		GameRegistry.registerItem(itemEmptyWarpDriveBattery, "itemEmptyWarpDriveBattery");
		itemDiscoveryDrive = new ItemDiscoveryDrive().setCreativeTab(tabDeathman).setUnlocalizedName("itemDiscovery");
		GameRegistry.registerItem(itemDiscoveryDrive, "itemDiscovery");
		itemDiscoveryAntiMatter = new ItemDiscoveryDrive().setCreativeTab(tabDeathman).setUnlocalizedName("itemDiscoveryAntiMatter");
		GameRegistry.registerItem(itemDiscoveryAntiMatter, "itemDiscoveryAntiMatter");
		itemDiscoveryNegativeEnergy = new ItemDiscoveryDrive().setCreativeTab(tabDeathman).setUnlocalizedName("itemDiscoveryNegativeEnergy");
		GameRegistry.registerItem(itemDiscoveryNegativeEnergy, "itemDiscoveryNegativeEnergy");
		itemDiscoveryWarp = new ItemDiscoveryDrive().setCreativeTab(tabDeathman).setUnlocalizedName("itemDiscoveryWarp");
		GameRegistry.registerItem(itemDiscoveryWarp, "itemDiscoveryWarp");
		itemAdvancedAccelInterface = new ItemAcceInterfaceUpgrade().setCreativeTab(tabDeathman).setUnlocalizedName("itemAccelInterfaceUpgrade").setTextureName("dlstuff:discovDrive");
		GameRegistry.registerItem(itemAdvancedAccelInterface, "itemAccelInterfaceUpgrade");
		itemGluonDetector = new ItemGluonDetector().setCreativeTab(tabDeathman).setUnlocalizedName("itemGluonDetector").setTextureName("dlstuff:gluon");
		GameRegistry.registerItem(itemGluonDetector, "itemGluonDetector");
		
		itemDiscoveryDesign = new ItemCircuitDesign().setCreativeTab(tabDeathman).setUnlocalizedName("itemDiscoveryDriveDesgin");
		itemDrilledDiscovery = new ItemPartialCircuitBoard().setUnlocalizedName("itemDrilledDiscovery").setTextureName("labstuff:itemDrilledCircuitBoard").setCreativeTab(tabDeathman);
		itemEtchedDiscovery = new ItemPartialCircuitBoard().setUnlocalizedName("itemEtchedDiscovery").setTextureName("labstuff:itemEtchedCircuitBoard").setCreativeTab(tabDeathman);
		itemDSCCoreDesign = new ItemCircuitDesign().setCreativeTab(tabDeathman).setUnlocalizedName("itemDSCCoreDesgin");
		itemDrilledDSCCore = new ItemPartialCircuitBoard().setUnlocalizedName("itemDrilledDSCCore").setTextureName("labstuff:itemDrilledCircuitBoard").setCreativeTab(tabDeathman);
		itemEtchedDSCCore = new ItemPartialCircuitBoard().setUnlocalizedName("itemEtchedDSCCore").setTextureName("labstuff:itemEtchedCircuitBoard").setCreativeTab(tabDeathman);
		itemDSCRamDesign = new ItemCircuitDesign().setCreativeTab(tabDeathman).setUnlocalizedName("itemDSCRamDesgin");
		itemDrilledDSCRam = new ItemPartialCircuitBoard().setUnlocalizedName("itemDrilledDSCRam").setTextureName("labstuff:itemDrilledCircuitBoard").setCreativeTab(tabDeathman);
		itemEtchedDSCRam = new ItemPartialCircuitBoard().setUnlocalizedName("itemEtchedDSCRam").setTextureName("labstuff:itemEtchedCircuitBoard").setCreativeTab(tabDeathman);
		itemDSCOSDesign = new ItemCircuitDesign().setCreativeTab(tabDeathman).setUnlocalizedName("itemDSCOSDesgin");
		itemDrilledDSCOS = new ItemPartialCircuitBoard().setUnlocalizedName("itemDrilledDSCOS").setTextureName("labstuff:itemDrilledCircuitBoard").setCreativeTab(tabDeathman);
		itemEtchedDSCOS = new ItemPartialCircuitBoard().setUnlocalizedName("itemEtchedDSCOS").setTextureName("labstuff:itemEtchedCircuitBoard").setCreativeTab(tabDeathman);
		itemDSCBenchDesign = new ItemCircuitDesign().setCreativeTab(tabDeathman).setUnlocalizedName("itemDSCBenchDesgin");
		itemDrilledDSCBench = new ItemPartialCircuitBoard().setUnlocalizedName("itemDrilledDSCBench").setTextureName("labstuff:itemDrilledCircuitBoard").setCreativeTab(tabDeathman);
		itemEtchedDSCBench = new ItemPartialCircuitBoard().setUnlocalizedName("itemEtchedDSCBench").setTextureName("labstuff:itemEtchedCircuitBoard").setCreativeTab(tabDeathman);
		itemDSCDriveDesign = new ItemCircuitDesign().setCreativeTab(tabDeathman).setUnlocalizedName("itemDSCDriveDesgin");
		itemDrilledDSCDrive = new ItemPartialCircuitBoard().setUnlocalizedName("itemDrilledDSCDrive").setTextureName("labstuff:itemDrilledCircuitBoard").setCreativeTab(tabDeathman);
		itemEtchedDSCDrive = new ItemPartialCircuitBoard().setUnlocalizedName("itemEtchedDSCDrive").setTextureName("labstuff:itemEtchedCircuitBoard").setCreativeTab(tabDeathman);
		GameRegistry.registerItem(itemDiscoveryDesign, "itemDiscoveryDriveDesign");
		GameRegistry.registerItem(itemDrilledDiscovery, "itemDrilledDiscovery");
		GameRegistry.registerItem(itemEtchedDiscovery, "itemEtchedDiscovery");
		GameRegistry.registerItem(itemDSCCoreDesign, "itemDSCCoreDesign");
		GameRegistry.registerItem(itemDrilledDSCCore, "itemDrilledDSCCore");
		GameRegistry.registerItem(itemEtchedDSCCore, "itemEtchedDSCCore");
		GameRegistry.registerItem(itemDSCRamDesign, "itemDSCRamDesign");
		GameRegistry.registerItem(itemDrilledDSCRam, "itemDrilledDSCRam");
		GameRegistry.registerItem(itemEtchedDSCRam, "itemEtchedDSCRam");
		GameRegistry.registerItem(itemDSCOSDesign, "itemDSCOSDesign");
		GameRegistry.registerItem(itemDrilledDSCOS, "itemDrilledDSCOS");
		GameRegistry.registerItem(itemEtchedDSCOS, "itemEtchedDSCOS");
		GameRegistry.registerItem(itemDSCBenchDesign, "itemDSCBenchDesign");
		GameRegistry.registerItem(itemDrilledDSCBench, "itemDrilledDSCBench");
		GameRegistry.registerItem(itemEtchedDSCBench, "itemEtchedDSCBench");
		GameRegistry.registerItem(itemDSCDriveDesign, "itemDSCDriveDesign");
		GameRegistry.registerItem(itemDrilledDSCDrive, "itemDrilledDSCDrive");
		GameRegistry.registerItem(itemEtchedDSCDrive, "itemEtchedDSCDrive");

		
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
		GameRegistry.registerBlock(blockAcceleratorTube, "blockAcceleratorTube");
		blockAcceleratorDetectorCore = new BlockAcceleratorDetectorCore(Material.iron).setBlockName("blockAccleratorDetectorCore").setBlockTextureName("dlstuff:detectorCore").setCreativeTab(tabDeathman);
		blockAcceleratorTrackingDetector = new BlockAcceleratorDetector().setBlockName("blockAcceleratorTrackingDetector").setBlockTextureName("dlstuff:trackingDetector").setCreativeTab(tabDeathman);
		blockAcceleratorSolenoid = new BlockAcceleratorDetector().setBlockName("blockAcceleratorSolenoid").setBlockTextureName("dlstuff:solenoid").setCreativeTab(tabDeathman);
		blockAcceleratorElectromagneticCalorimeter = new BlockAcceleratorDetector().setBlockName("blockAcceleratorElectromagneticCalorimeter").setBlockTextureName("dlstuff:electroCalorimeter").setCreativeTab(tabDeathman);
		blockAcceleratorHadronCalorimeter = new BlockAcceleratorDetector().setBlockName("blockAcceleratorHadronCalorimeter").setBlockTextureName("dlstuff:hadron").setCreativeTab(tabDeathman);
		blockAcceleratorMuonDetector = new BlockAcceleratorDetector().setBlockName("blockAcceleratorMuonDetector").setBlockTextureName("dlstuff:muon").setCreativeTab(tabDeathman);
		blockAcceleratorPowerInput = new BlockAcceleratorPowerInput().setBlockName("blockAcceleratorPowerInput").setBlockTextureName("dlstuff:acceleratorInterface").setCreativeTab(tabDeathman);
		GameRegistry.registerBlock(blockAcceleratorDetectorCore, "blockAccleratorDetectorCore");
		GameRegistry.registerBlock(blockAcceleratorTrackingDetector, "blockAcceleratorTrackingDetector");
		GameRegistry.registerBlock(blockAcceleratorSolenoid, "blockAcceleratorSolenoid");
		GameRegistry.registerBlock(blockAcceleratorElectromagneticCalorimeter, "blockAcceleratorElectromagneticCalorimeter");
		GameRegistry.registerBlock(blockAcceleratorHadronCalorimeter, "blockAcceleratorHadronCalorimeter");
		GameRegistry.registerBlock(blockAcceleratorMuonDetector, "blockAcceleratorMuonDetector");
		GameRegistry.registerBlock(blockAcceleratorPowerInput, "blockAcceleratorPowerInput");
		
		
		blockDSCRibbonCable = new BlockDSCRibbonCable(Material.iron).setBlockName("blockDSCRibbonCable").setBlockTextureName("dlstuff:DSCRibbonCable").setCreativeTab(tabDeathman);
		blockDSCCore = new BlockDSCCore(Material.iron).setBlockName("blockDSCCore").setBlockTextureName("dlstuff:DSCCore").setCreativeTab(tabDeathman);
		blockDSCOS = new BlockDSCOS(Material.iron).setBlockName("blockDSCOS").setBlockTextureName("dlstuff:DSCOS").setCreativeTab(tabDeathman);
		blockDSCRam = new BlockDSCRam(Material.iron).setBlockName("blockDSCRam").setBlockTextureName("dlstuff:DSCRam").setCreativeTab(tabDeathman);
		blockDSCDrive = new BlockDSCDrive(Material.iron).setBlockName("blockDSCDrive").setBlockTextureName("dlstuff:DSCDrive").setCreativeTab(tabDeathman);
		blockDSCWorkbench = new BlockDSCBench(Material.iron).setBlockName("blockDSCBench").setCreativeTab(tabDeathman);
		GameRegistry.registerBlock(blockDSCRibbonCable, "blockDSCRibbonCable");
		GameRegistry.registerBlock(blockDSCCore, "blockDSCCore");
		GameRegistry.registerBlock(blockDSCOS, "blockDSCOS");
		GameRegistry.registerBlock(blockDSCRam, "blockDSCRam");
		GameRegistry.registerBlock(blockDSCDrive, "blockDSCDrive");
		GameRegistry.registerBlock(blockDSCWorkbench, "blockDSCBench");

		
		blockGravityManipulater = new BlockGravityManipulater(Material.iron).setCreativeTab(tabDeathman).setBlockName("blockGravityManipulater").setBlockTextureName("dlstuff:blockGravity");
		GameRegistry.registerBlock(blockGravityManipulater, "blockGravityManipulater");
		
		if(Loader.isModLoaded("ForgeMultipart"))
		{
			//new RegisterMulti();
		}
		MinecraftForge.EVENT_BUS.register(new DLEventHandler());
		PacketCustom.assignHandler(PacketHandler.channel, new PacketHandler());
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		//Intialization stuff
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		proxy.registerRenders();
		
		//Crafting Recipes
		DLRecipes.registerShaplessCrafting();
		DLRecipes.registerShapedCrafting();
		
		DLRecipes.addAction(new WebDownload());
		DLRecipes.addAccelDiscovery(null, new ItemStack(itemDiscoveryAntiMatter));
		DLRecipes.addAccelDiscovery(DLRecipes.getDiscovFromDrive(itemDiscoveryAntiMatter), new ItemStack(itemDiscoveryNegativeEnergy));
		DLRecipes.addAccelDiscovery(DLRecipes.getDiscovFromDrive(itemDiscoveryNegativeEnergy), new ItemStack(itemDiscoveryWarp));
		DLRecipes.addDiscovItem(new ItemStack(itemAdvancedAccelInterface, 1), new ItemStack(LabStuffMain.itemElectromagnet, 1), new ItemStack(LabStuffMain.itemCopperIngot,2), new ItemStack(Items.iron_ingot, 5), DLRecipes.getDiscovFromDrive(itemDiscoveryAntiMatter), "Advanced Accelerator Interface Upgrade");
		DLRecipes.addDiscovItem(new ItemStack(itemEmptyWarpDriveBattery, 1), new ItemStack(LabStuffMain.itemElectromagnet, 1), new ItemStack(LabStuffMain.itemCopperIngot,2), new ItemStack(Items.iron_ingot, 5), DLRecipes.getDiscovFromDrive(itemDiscoveryWarp), "Warp Drive Battery (Empty)");
		DLRecipes.addDiscovItem(new ItemStack(blockGravityManipulater), new ItemStack(Items.iron_ingot, 8), new ItemStack(LabStuffMain.itemElectromagnet), new ItemStack(itemTouchScreen), DLRecipes.getDiscovFromDrive(itemDiscoveryWarp), "Gravity Manipulater");
		DLRecipes.addCircuitDesign("DiscoveryDrive", itemDiscoveryDesign);
		DLRecipes.addCircuitCreation("DiscoveryDrive", itemEtchedDiscovery, itemDrilledDiscovery, itemDiscoveryDrive);
		DLRecipes.addCircuitDesign("DSCCore", itemDSCCoreDesign);
		DLRecipes.addCircuitCreation("DSCCore", itemEtchedDSCCore, itemDrilledDSCCore, Item.getItemFromBlock(blockDSCCore));
		DLRecipes.addCircuitDesign("DSCRam", itemDSCRamDesign);
		DLRecipes.addCircuitCreation("DSCRam", itemEtchedDSCRam, itemDrilledDSCRam, Item.getItemFromBlock(blockDSCRam));
		DLRecipes.addCircuitDesign("DSCOS", itemDSCOSDesign);
		DLRecipes.addCircuitCreation("DSCOS", itemEtchedDSCOS, itemDrilledDSCOS, Item.getItemFromBlock(blockDSCOS));
		DLRecipes.addCircuitDesign("DSCBench", itemDSCBenchDesign);
		DLRecipes.addCircuitCreation("DSCBench", itemEtchedDSCBench, itemDrilledDSCBench, Item.getItemFromBlock(blockDSCWorkbench));
		DLRecipes.addCircuitDesign("DSCDrive", itemDSCDriveDesign);
		DLRecipes.addCircuitCreation("DSCDrive", itemEtchedDSCDrive, itemDrilledDSCDrive, Item.getItemFromBlock(blockDSCDrive));
		
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityDLLaptop.class, "TileEntityDLLaptop");
		GameRegistry.registerTileEntity(TileEntityGravityManipulater.class, "tileEntityGravity");		
		GameRegistry.registerTileEntity(TileEntityAcceleratorControlPanel.class, "TileEntityAcceleratorControlPanel");
		GameRegistry.registerTileEntity(TileEntityAcceleratorInterface.class, "TileEntityAcceleratorInterface");
		GameRegistry.registerTileEntity(TileEntityAcceleratorTube.class, "TileEntityAcceleratorTube");
		GameRegistry.registerTileEntity(TileEntityAcceleratorDetectorCore.class, "TileEntityAcceleratorDetectorCore");
		GameRegistry.registerTileEntity(TileEntityAcceleratorPowerInput.class, "TileEntityPowerInput");
		GameRegistry.registerTileEntity(TileEntityRibbonCable.class, "TileEntityRibbonCable");
		GameRegistry.registerTileEntity(TileEntityDSCCore.class, "TileEntityDSCCore");
		GameRegistry.registerTileEntity(DSCRam.class, "DSCRam");
		GameRegistry.registerTileEntity(DSCOS.class, "DSCOS");
		GameRegistry.registerTileEntity(DSCDrive.class, "DSCDrive");
		GameRegistry.registerTileEntity(DSCPart.class, "DSCPart");
		GameRegistry.registerTileEntity(DSCBench.class, "DSCBench");
		//Packets
		packetPipeline.registerPacket(PacketDLLaptopUSB.class);
		packetPipeline.registerPacket(PacketDLLaptopWeb.class);
		packetPipeline.registerPacket(PacketGravity.class);
		packetPipeline.registerPacket(PacketACP.class);
		packetPipeline.registerPacket(PacketDSCDrive.class);
		packetPipeline.registerPacket(PacketDSCBench.class);
	}
	
}
