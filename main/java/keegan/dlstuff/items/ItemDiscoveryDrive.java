package keegan.dlstuff.items;

import net.minecraft.item.Item;

public class ItemDiscoveryDrive extends Item
{
	public ItemDiscoveryDrive()
	{
		this.setTextureName("dlstuff:discovDrive");
	}
	
	public String getDiscoveryName()
	{
		return this.getUnlocalizedName().replace("itemDiscovery", "");
	}
	

}
