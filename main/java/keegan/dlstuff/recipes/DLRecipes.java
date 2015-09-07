package keegan.dlstuff.recipes;

import static keegan.dlstuff.DLStuff.*;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import keegan.labstuff.LabStuffMain;
import keegan.labstuff.recipes.Recipes;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntity;

public class DLRecipes extends Recipes
{
	public static ArrayList<WebAction> webActions = new ArrayList<WebAction>();
	public static ArrayList<AcceleratorDiscovery> accelDiscoveries = new ArrayList<AcceleratorDiscovery>();
	public static ArrayList<DiscoveryItem> discoveryItems = new ArrayList<DiscoveryItem>();
	
	public static void registerShaplessCrafting()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(itemTouchScreen), new ItemStack(Blocks.glass_pane), new ItemStack(itemTouchMesh));
	}
	
	public static void registerShapedCrafting()
	{
		GameRegistry.addRecipe(new ItemStack(itemTouchMesh), "rsr","srs","rsr",'r',new ItemStack(Items.redstone),'s',new ItemStack(Items.string));
		GameRegistry.addRecipe(new ItemStack(itemUnProgrammedDPad),"pp ","pct","pp ",'t',new ItemStack(itemTouchScreen),'p',new ItemStack(LabStuffMain.itemPlastic),'c', new ItemStack(LabStuffMain.itemComputerCircuitBoard));
		GameRegistry.addRecipe(new ItemStack(itemGluonDetector), " e ", "e e", " e ", 'e', new ItemStack(LabStuffMain.itemElectromagnet));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorHadronCalorimeter), "iei", "ihi", "iei", 'i', new ItemStack(Items.iron_ingot), 'e', new ItemStack(LabStuffMain.itemElectromagnet), 'h', new ItemStack(itemGluonDetector));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorElectromagneticCalorimeter), "iei", "i i", "iei", 'i', new ItemStack(Items.iron_ingot), 'e', new ItemStack(LabStuffMain.itemElectromagnet));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorSolenoid), "iei", "iei", "iei", 'i', new ItemStack(Items.iron_ingot), 'e', new ItemStack(LabStuffMain.itemElectromagnet));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorMuonDetector), "iie", "iie", "iie", 'i', new ItemStack(Items.iron_ingot), 'e', new ItemStack(LabStuffMain.itemElectromagnet));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorTrackingDetector), "ies", "ies", "ies", 'i', new ItemStack(Items.iron_ingot), 'e', new ItemStack(LabStuffMain.itemElectromagnet), 's', new ItemStack(LabStuffMain.itemSiliconWafer));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorDetectorCore), "ici", "cpc", "ici", 'i', new ItemStack(Items.iron_ingot), 'c', new ItemStack(LabStuffMain.itemInterCircuitBoard), 'p', new ItemStack(blockAcceleratorTube));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorTube), "iii", "eee", "iii", 'i', new ItemStack(Items.iron_ingot), 'e', new ItemStack(LabStuffMain.itemElectromagnet));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorInterface), "iii", "tht", "iii", 'i', new ItemStack(Items.iron_ingot), 't', new ItemStack(blockAcceleratorTube), 'h', new ItemStack(Blocks.hopper));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorPowerInput), "iii", "tpt", "iii", 'i', new ItemStack(Items.iron_ingot), 't', new ItemStack(blockAcceleratorTube), 'p', new ItemStack(LabStuffMain.blockPowerCable));
		GameRegistry.addRecipe(new ItemStack(blockAcceleratorControlPanel), "lbb", "ici", "iii", 'i', new ItemStack(Items.iron_ingot), 'l', new ItemStack(Blocks.redstone_lamp), 'b', new ItemStack(Blocks.stone_button), 'c', new ItemStack(LabStuffMain.itemComputerCircuitBoard));
		GameRegistry.addRecipe(new ItemStack(blockDLLaptop), "imt", "ick", "iii", 'i', new ItemStack(Items.iron_ingot), 't', new ItemStack(itemTouchScreen), 'm', new ItemStack(LabStuffMain.itemMonitor), 'c', new ItemStack(LabStuffMain.itemComputerTower), 'k', new ItemStack(LabStuffMain.itemKeyboard));
		GameRegistry.addRecipe(new ItemStack(blockDSCRibbonCable), "ccc", "ccc","ccc", 'c', new ItemStack(LabStuffMain.blockDataCable));
	}
	
	public static void registerSmelting()
	{
		
	}

	public static void performAction(String action, TileEntity tile) {
		for(WebAction webAction : webActions)
		{
			if(action.startsWith(webAction.getID()))
				webAction.performAction(action.substring(action.indexOf(webAction.getID())), tile);
		}
	}
	
	public static void addAction(WebAction action)
	{
		webActions.add(action);
	}
	
	public static void addAccelDiscovery(AcceleratorDiscovery dependency, ItemStack flash)
	{
		AcceleratorDiscovery discovery = new AcceleratorDiscovery(dependency, flash, accelDiscoveries.size());
		accelDiscoveries.add(discovery);
	}
	
	public static void addDiscovItem(ItemStack r, ItemStack i1, ItemStack i2, ItemStack i3, AcceleratorDiscovery d, String name)
	{
		DiscoveryItem item = new DiscoveryItem(r,i1,i2,i3,d, name, discoveryItems.size());
		discoveryItems.add(item);
	}

	public static AcceleratorDiscovery getDiscovFromDrive(Item flash)
	{
		for(AcceleratorDiscovery discov : accelDiscoveries)
		{
			if(discov.getDiscoveryFlashDrive().isItemEqual(new ItemStack(flash)))
				return discov;
		}
		return null;
	}
	
}
