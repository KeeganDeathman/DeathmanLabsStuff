package keegan.dlstuff.tileentity;

import keegan.dlstuff.render.RenderAcceleratorTube;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAcceleratorTube extends TileEntity
{
	private int corners;
	private int straights;
	private boolean hasWestToNorth;
	private boolean hasNorthToEast;
	private boolean hasEastToSouth;
	private boolean hasSouthToWest;
	private boolean hasDetector;
	
	private boolean up;
	private boolean down;
	private boolean east;
	private boolean west;
	private boolean north;
	private boolean south;
	private String type;
	
	private RenderAcceleratorTube renderer;
	
	public TileEntityAcceleratorTube()
	{
		corners = 0;
		straights = 0;
		hasWestToNorth = false;
		hasSouthToWest = false;
		hasNorthToEast = false;
		hasEastToSouth = false;
		hasDetector = false;
		
		up = false;
		down = false;
		east = false;
		west = false;
		north = false;
		south = false;
		type = "invalid";
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("corners", corners);
		tagCompound.setInteger("straights", straights);
		tagCompound.setBoolean("hasWestToNorth", hasWestToNorth);
		tagCompound.setBoolean("hasNorthToEast", hasNorthToEast);
		tagCompound.setBoolean("hasEastToSouth", hasEastToSouth);
		tagCompound.setBoolean("hasSouthToWest", hasSouthToWest);
		tagCompound.setBoolean("hasDetector", hasDetector);
		
		tagCompound.setBoolean("up", up);
		tagCompound.setBoolean("down", down);
		tagCompound.setBoolean("east", east);
		tagCompound.setBoolean("west", west);
		tagCompound.setBoolean("north", north);
		tagCompound.setBoolean("south", south);
		tagCompound.setString("type", type);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		this.corners = tagCompound.getInteger("corners");
		this.straights = tagCompound.getInteger("straights");
		this.hasWestToNorth = tagCompound.getBoolean("hasWestToNorth");
		this.hasNorthToEast = tagCompound.getBoolean("hasNorthToEast");
		this.hasEastToSouth = tagCompound.getBoolean("hasEastToSouth");
		this.hasSouthToWest = tagCompound.getBoolean("hasSouthToWest");
		this.hasDetector = tagCompound.getBoolean("hasDetector");
		
		this.up = tagCompound.getBoolean("up");
		this.down = tagCompound.getBoolean("down");
		this.east = tagCompound.getBoolean("east");
		this.west = tagCompound.getBoolean("west");
		this.north = tagCompound.getBoolean("north");
		this.south = tagCompound.getBoolean("south");
		this.type = tagCompound.getString("type");
	}
	
	public boolean isAcceleratorComplete()
	{
		if(corners == 4 && straights == 27 && hasDetector && hasWestToNorth && hasNorthToEast && hasEastToSouth && hasSouthToWest && hasDetector)
			return true;
		return false;
	}
	
	public void updateSides(boolean up, boolean down, boolean east, boolean west, boolean north, boolean south)
	{
		this.up = up;
		this.down = down;
		this.east = east;
		this.west = west;
		this.north = north;
		this.south = south;
		String oldType = type;
		if(!up && !down)
		{
			if(east)
			{
				if(west)
					type = "straight";
				else if(north)
					type = "ne";
				else if(south)
					type = "es";
			}
			else if(west)
			{
				if(north)
					type = "wn";
				else if(south)
					type = "sw";
			}
			else if(north)
			{
				if(south)
					type = "straight";
			}
		}
		if(!(type.equals(oldType)))
		{
			TileEntityAcceleratorTube nextTube = getNextTube(this);
			if(oldType.equals("invalid"))
			{
				if(type.equals("straight"))
				{
					nextTube.changeStraight(this);
				}
				if(type.equals("wn"))
					nextTube.addCorner(this, true, false, false, false);
				if(type.equals("ne"))
					nextTube.addCorner(this, false, true, false, false);
				if(type.equals("es"))
					nextTube.addCorner(this, false, false, true, false);
				if(type.equals("sw"))
					nextTube.addCorner(this, false, false, false, true);
			}
		}
	}
	
	private TileEntityAcceleratorTube getNextTube(TileEntityAcceleratorTube src)
	{
		TileEntity posX = worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
		TileEntity posZ = worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
		TileEntity negX = worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
		TileEntity negZ = worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
		if(posX instanceof TileEntityAcceleratorTube && posX != null && !posX.equals(src))
			return (TileEntityAcceleratorTube)posX;
		if(posZ instanceof TileEntityAcceleratorTube && posZ != null && !posZ.equals(src))
			return (TileEntityAcceleratorTube)posZ;
		if(negX instanceof TileEntityAcceleratorTube && negX != null && !negX.equals(src))
			return (TileEntityAcceleratorTube)negX;
		if(negZ instanceof TileEntityAcceleratorTube && negZ != null && !negZ.equals(src))
			return (TileEntityAcceleratorTube)negZ;
		return null;
	}
	
	public void changeStraight(TileEntityAcceleratorTube src)
	{
		TileEntityAcceleratorTube nextTube = getNextTube(src);
		straights = src.straights;
		if(nextTube != null)
		{
			if(nextTube.straights != straights)
				nextTube.changeStraight(this);
		}
	}
	
	public void addCorner(TileEntityAcceleratorTube src, boolean wn, boolean ne, boolean es, boolean sw)
	{
		TileEntityAcceleratorTube nextTube = getNextTube(src);
			corners += 1;
			
		if(wn)
			hasWestToNorth = true;
		else if(ne)
			hasNorthToEast = true;
		else if(es)
			hasEastToSouth = true;
		else if(sw)
			hasSouthToWest = true;
		if(nextTube != null)
		{
			if(nextTube.corners != corners)
				nextTube.addCorner(this, wn, ne, es, sw);
		}
	}
	
	public void subCorner(TileEntityAcceleratorTube src, boolean wn, boolean ne, boolean es, boolean sw)
	{
		TileEntityAcceleratorTube nextTube = getNextTube(src);
		corners -= 1;
			
		if(wn)
			hasWestToNorth = false;
		else if(ne)
			hasNorthToEast = false;
		else if(es)
			hasEastToSouth = false;
		else if(sw)
			hasSouthToWest = false;
		if(nextTube != null)
		{
			if(nextTube.corners != corners)
				nextTube.subCorner(this, wn, ne, es, sw);
		}
	}
	
	public void addDetector(TileEntityAcceleratorTube src)
	{
		TileEntityAcceleratorTube nextTube = getNextTube(src);
		if(!hasDetector)
		{	
			hasDetector = true;
			if(nextTube != null)
			{
				if(!nextTube.hasDetector)
					nextTube.addDetector(this);
			}
		}
	}
	
	public void subDetector(TileEntityAcceleratorTube src)
	{
		TileEntityAcceleratorTube nextTube = getNextTube(src);
		if(hasDetector)
		{	
			hasDetector = false;
			if(nextTube != null)
			{
				if(nextTube.hasDetector)
					nextTube.subDetector(this);
			}
		}
	}
	
	public RenderAcceleratorTube getRenderer()
	{
		return renderer;
	}
	
	public void setRenderer(RenderAcceleratorTube renderer)
	{
		this.renderer = renderer;
	}
	
	public int getCorners()
	{
		return corners;
	}
	public void setCorners(int corners)
	{
		this.corners = corners;
	}
	public int getStraights()
	{
		return straights;
	}
	public void setStraights(int straights)
	{
		this.straights = straights;
	}
	public boolean isHasWestToNorth()
	{
		return hasWestToNorth;
	}
	public void setHasWestToNorth(boolean hasWestToNorth)
	{
		this.hasWestToNorth = hasWestToNorth;
	}
	public boolean isHasNorthToEast()
	{
		return hasNorthToEast;
	}
	public void setHasNorthToEast(boolean hasNorthToEast)
	{
		this.hasNorthToEast = hasNorthToEast;
	}
	public boolean isHasEastToSouth()
	{
		return hasEastToSouth;
	}
	public void setHasEastToSouth(boolean hasEastToSouth)
	{
		this.hasEastToSouth = hasEastToSouth;
	}
	public boolean isHasSouthToWest()
	{
		return hasSouthToWest;
	}
	public void setHasSouthToWest(boolean hasSouthToWest)
	{
		this.hasSouthToWest = hasSouthToWest;
	}
	public boolean isHasDetector()
	{
		return hasDetector;
	}
	public void setHasDetector(boolean hasDetector)
	{
		this.hasDetector = hasDetector;
	}

	public boolean isUp()
	{
		return up;
	}

	public void setUp(boolean up)
	{
		this.up = up;
	}

	public boolean isDown()
	{
		return down;
	}

	public void setDown(boolean down)
	{
		this.down = down;
	}

	public boolean isEast()
	{
		return east;
	}

	public void setEast(boolean east)
	{
		this.east = east;
	}

	public boolean isWest()
	{
		return west;
	}

	public void setWest(boolean west)
	{
		this.west = west;
	}

	public boolean isNorth()
	{
		return north;
	}

	public void setNorth(boolean north)
	{
		this.north = north;
	}

	public boolean isSouth()
	{
		return south;
	}

	public void setSouth(boolean south)
	{
		this.south = south;
	}
	
	
}
