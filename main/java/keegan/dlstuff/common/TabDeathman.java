package keegan.dlstuff.common;

import keegan.dlstuff.DLStuff;
import keegan.labstuff.common.TabLabStuff;
import net.minecraft.item.Item;

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
