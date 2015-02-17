package keegan.dlstuff.recipes;

import static keegan.dlstuff.DLStuff.itemTouchMesh;
import static keegan.dlstuff.DLStuff.itemTouchScreen;
import static keegan.dlstuff.DLStuff.itemUnProgrammedDPad;

import java.util.ArrayList;

import keegan.labstuff.LabStuffMain;
import keegan.labstuff.recipes.Recipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class DLRecipes extends Recipes
{
	private static ArrayList<WebAction> webActions = new ArrayList<WebAction>();
	
	public static void registerShaplessCrafting()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(itemTouchScreen), new ItemStack(Blocks.glass_pane), new ItemStack(itemTouchMesh));
	}
	
	public static void registerShapedCrafting()
	{
		GameRegistry.addRecipe(new ItemStack(itemTouchMesh), "rsr","srs","rsr",'r',new ItemStack(Items.redstone),'s',new ItemStack(Items.string));
		GameRegistry.addRecipe(new ItemStack(itemUnProgrammedDPad),"pp ","pct","pp ",'t',new ItemStack(itemTouchScreen),'p',new ItemStack(LabStuffMain.itemPlastic),'c', new ItemStack(LabStuffMain.itemComputerCircuitBoard));
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
	
}
