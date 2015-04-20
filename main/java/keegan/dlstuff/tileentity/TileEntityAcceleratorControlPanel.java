package keegan.dlstuff.tileentity;

import java.util.*;

import keegan.dlstuff.recipes.*;
import keegan.labstuff.tileentity.DataConnectedDevice;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityAcceleratorControlPanel extends DataConnectedDevice
{
	private boolean hasMatter;
	private boolean isPowered;
	private boolean isRunning;
	private ArrayList<AcceleratorDiscovery> discovered = new ArrayList<AcceleratorDiscovery>();
	
	public TileEntityAcceleratorControlPanel()
	{
		hasMatter = false;
		isPowered = false;
		isRunning = false;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		for(int i = 0; i < discovered.size(); i++)
		{
			tag.setInteger("discovered_"+i, discovered.get(i).getIndex());
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		for(int i = 0; i < DLRecipes.accelDiscoveries.size(); i++)
		{
			if(tag.hasKey("discovered_"+i))
				discovered.add(DLRecipes.accelDiscoveries.get(tag.getInteger("discovered_"+i)));
		}
	}
	
	@Override
	public void performAction(String command)
	{
		if(command.equals("particlesLoaded"))
		{
			hasMatter = true;
			System.out.println("loaded");
		}
		if(command.equals("particlesNotLoaded"))
		{
			hasMatter = false;
		}
		if(command.equals("powered"))
		{
			isPowered = true;
			System.out.println("powered");
		}
		if(command.equals("notPowered"))
		{
			isPowered = false;
		}
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		if(getNetwork() != null)
		{
			isRunning = hasMatter && isPowered;
			for(int i = 0; i < getNetwork().getDeviceCount(); i++)
			{
				if(getNetwork().getDeviceByIndex(i) instanceof TileEntityAcceleratorInterface)
				{
					if(isRunning)
					{
						Random r = new Random();
						int Low = 0;
						int High = 100;
						int R = r.nextInt(High-Low) + Low;
						if(R == 74)
						{
							int discovery = 0;
							boolean good = false;
							while(!good)
							{
								for(int j = 0; j < discovered.size(); j++)
								{
									if(DLRecipes.accelDiscoveries.get(discovery).equals(discovered.get(j)))
										discovery++;
									else
									{
										AcceleratorDiscovery discov = DLRecipes.accelDiscoveries.get(discovery);
										for(int k = 0; k < discovered.size(); k++)
										{
											if(discov.getDependency() != null)
											{	
												if(discov.getDependency().equals(discovered.get(k)) )
												{
													good = true;
												}
												else
												{
													discovery++;
												}
											}
											else
											{
												good = true;
											}
										}
									}
								}
								getNetwork().sendMessage(new DataPackage(getNetwork().getDeviceByIndex(i), "discovery_" + discovery));
							}
						}
					}
				}
			}
		}
	}
	
	public void launch()
	{
		if(getNetwork() != null)
		{
			for(int i = 0; i < getNetwork().getDeviceCount(); i++)
			{
				if(getNetwork().getDeviceByIndex(i) instanceof TileEntityAcceleratorInterface && hasMatter && isPowered)
				{
					getNetwork().sendMessage(new DataPackage(getNetwork().getDeviceByIndex(i), "launch"));
				}
			}
		}
	}
}
