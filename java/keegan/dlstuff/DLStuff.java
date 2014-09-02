package keegan.dlstuff;

import java.io.File;

import keegan.dlstuff.blocks.*;
import keegan.dlstuff.client.gui.*;
import keegan.dlstuff.common.*;
import keegan.dlstuff.items.*;
import keegan.dlstuff.tileentity.TileEntityDLLaptop;
import keegan.labstuff.LabStuffMain;
import keegan.labstuff.common.TabLabStuff;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
@Mod(version="1.0",modid="dlstuff",name="Deathman Labs Stuff", dependencies="required-after:labstuff")
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
	//Items
	public static Item itemTouchMesh;
	public static Item itemTouchScreen;
	public static Item itemUnProgrammedDPad;
	public static Item itemDPad;
	
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
		
		//Blocks
		blockDLLaptop = new BlockDLLaptop(Material.iron).setBlockName("blockDLLaptop").setCreativeTab(tabDeathman);
		GameRegistry.registerBlock(blockDLLaptop, "blockDLLaptop");
		blockInterface = new BlockInterface(Material.iron).setBlockName("blockInterface").setCreativeTab(tabDeathman);
		GameRegistry.registerBlock(blockInterface, "blockInterface");
		blockGag = new BlockGag(Material.iron).setBlockName("blockGag").setBlockTextureName("dlstuff:blockGag");
		GameRegistry.registerBlock(blockGag, "gag");
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityDLLaptop.class, "TileEntityDLLaptop");
		
		//Crafting Recipes
		GameRegistry.addRecipe(new ItemStack(itemTouchMesh), "rsr","srs","rsr",'r',new ItemStack(Items.redstone),'s',new ItemStack(Items.string));
		GameRegistry.addShapelessRecipe(new ItemStack(itemTouchScreen), new ItemStack(Blocks.glass_pane), new ItemStack(itemTouchMesh));
		GameRegistry.addRecipe(new ItemStack(itemUnProgrammedDPad),"pp ","pct","pp ",'t',new ItemStack(itemTouchScreen),'p',new ItemStack(LabStuffMain.itemPlastic),'c', new ItemStack(LabStuffMain.itemComputerCircuitBoard));
		
		//Other
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		proxy.registerRenders();
	}
	
}
