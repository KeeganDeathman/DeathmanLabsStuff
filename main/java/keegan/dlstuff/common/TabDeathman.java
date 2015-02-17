package keegan.dlstuff.common;

import keegan.labstuff.LabStuffMain;
import keegan.labstuff.common.TabLabStuff;

import net.minecraft.item.Item;
import keegan.dlstuff.DLStuff;

public class TabDeathman extends TabLabStuff 
{

	public TabDeathman(String label) 
	{
		super(label);
	}
	
	public Item getTabIconItem()
	{
		
		return DLStuff.itemDPad;
	}
	
	public String getTranslatedTabLabel()
	{
		
		return "DeathmanLabsStuff";
		
	}

}
