package keegan.dlstuff.multipart;

public class RibbonPart //extends McSidedMetaPart
{

	/*public static int[] metaSideMap = new int[]
	{
			-1, 4, 5, 2, 3, 0
	};
	public static int[] sideMetaMap = new int[]
	{
			5, 0, 3, 4, 1, 2
	};

	MultipartHelp multiHelp;

	public RibbonPart()
	{
		multiHelp = new MultipartHelp();
	}

	public RibbonPart(int meta)
	{
		super(meta);
		multiHelp = new MultipartHelp();
	}

	@Override
	public Cuboid6 getBounds()
	{
		return getBounds(meta);
	}

	public Cuboid6 getBounds(int meta)
	{
		if (meta == 0) return new Cuboid6(.05, .95, .05, .95, 1, .95);
		if (meta == 1) return new Cuboid6(.05, 0, .05, .95, .05, .95);
		if (meta == 2) return new Cuboid6(.05, .05, .95, .95, .95, 1);
		if (meta == 3) return new Cuboid6(.05, .05, 0, .95, .95, .05);
		if (meta == 4) return new Cuboid6(.95, .05, .05, 1, .95, .95);
		if (meta == 5)
			return new Cuboid6(0, .05, .05, .05, .95, .95);
		else
			return new Cuboid6(.05, 0, .05, .95, .05, .95);
	}

	@Override
	public int sideForMeta(int arg0)
	{
		return ForgeDirection.OPPOSITES[meta];
	}

	@Override
	public Block getBlock()
	{
		// TODO Auto-generated method stub
		return DLStuff.blockDSCRibbonCable;
	}

	@Override
	public String getType()
	{
		// TODO Auto-generated method stub
		return "multiDSCRibbon";
	}

	public static McBlockPart placement(World world, BlockCoord pos, int side)
	{
		pos = pos.copy().offset(ForgeDirection.OPPOSITES[side]);
		Block block = world.getBlock(pos.x, pos.y, pos.z);
		if (!block.isSideSolid(world, pos.x, pos.y, pos.z, ForgeDirection.getOrientation(side))) return null;
		return new RibbonPart(side);
	}

	@Override
	public boolean activate(EntityPlayer player, MovingObjectPosition hit, ItemStack item)
	{
		if (!getWorld().isRemote)
		{
			TileEntity tile = getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord);
			if (tile instanceof TileEntityRibbonCable)
			{
				player.addChatMessage(new ChatComponentText("Network is holding " + ((TileEntityRibbonCable) tile).getDeviceCount()));
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public void invalidateConvertedTile()
	{
		super.invalidateConvertedTile();
		devices = ((TileEntityRibbonCable) getTile()).devices;
		networked = ((TileEntityRibbonCable) getTile()).networked;
		tickCount = ((TileEntityRibbonCable) getTile()).tickCount;
	}

	protected ArrayList<DSCPart> devices;
	private boolean networked;
	private int tickCount;

	public void addDevice(DSCPart device)
	{
		devices.add(device);
		RibbonPart next = getNetwork((RibbonPart) this.getTile());
		if (next != null)
		{
			next.addDevice(device, (RibbonPart) this.getTile());
		}
	}

	public void addDevice(DSCPart device, RibbonPart src)
	{
		devices.add(device);
		RibbonPart next = getNetwork(src);
		if (next != null)
		{
			next.addDevice(device, (RibbonPart) this.getTile());
		}
	}

	public RibbonPart getNetwork()
	{
		if (!getWorld().isRemote)
		{
			if (getWorld().getTileEntity(getTile().xCoord + 1, getTile().yCoord, getTile().zCoord) != null && getWorld().getTileEntity(getTile().xCoord + 1, getTile().yCoord, getTile().zCoord) instanceof RibbonPart)
			{
				return (RibbonPart) getWorld().getTileEntity(getTile().xCoord + 1, getTile().yCoord, getTile().zCoord);
			}
			if (getWorld().getTileEntity(getTile().xCoord - 1, getTile().yCoord, getTile().zCoord) != null && getWorld().getTileEntity(getTile().xCoord - 1, getTile().yCoord, getTile().zCoord) instanceof RibbonPart)
			{
				return (RibbonPart) getWorld().getTileEntity(getTile().xCoord - 1, getTile().yCoord, getTile().zCoord);
			}
			if (getWorld().getTileEntity(getTile().xCoord, getTile().yCoord + 1, getTile().zCoord) != null && getWorld().getTileEntity(getTile().xCoord, getTile().yCoord + 1, getTile().zCoord) instanceof RibbonPart)
			{
				return (RibbonPart) getWorld().getTileEntity(getTile().xCoord, getTile().yCoord + 1, getTile().zCoord);
			}
			if (getWorld().getTileEntity(getTile().xCoord, getTile().yCoord - 1, getTile().zCoord) != null && getWorld().getTileEntity(getTile().xCoord, getTile().yCoord - 1, getTile().zCoord) instanceof RibbonPart)
			{
				return (RibbonPart) getWorld().getTileEntity(getTile().xCoord, getTile().yCoord - 1, getTile().zCoord);
			}
			if (getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord + 1) != null && getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord + 1) instanceof RibbonPart)
			{
				return (RibbonPart) getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord + 1);
			}
			if (getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord - 1) != null && getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord - 1) instanceof RibbonPart)
			{
				return (RibbonPart) getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord - 1);
			}
		}
		return null;
	}

	public RibbonPart getNetwork(RibbonPart src)
	{
		if (!getWorld().isRemote)
		{
			TileMultipart posX = multiHelp.getMultipartTile(getWorld(), getTile().xCoord + 1, getTile().yCoord, getTile().zCoord);
			TileMultipart negX = multiHelp.getMultipartTile(getWorld(), getTile().xCoord - 1, getTile().yCoord, getTile().zCoord);
			TileMultipart posY = multiHelp.getMultipartTile(getWorld(), getTile().xCoord, getTile().yCoord + 1, getTile().zCoord);
			TileMultipart negY = multiHelp.getMultipartTile(getWorld(), getTile().xCoord, getTile().yCoord - 1, getTile().zCoord);
			TileMultipart posZ = multiHelp.getMultipartTile(getWorld(), getTile().xCoord, getTile().yCoord, getTile().zCoord + 1);
			TileMultipart negZ = multiHelp.getMultipartTile(getWorld(), getTile().xCoord, getTile().yCoord, getTile().zCoord - 1);
			if (posX != null && posX instanceof RibbonPart && !posX.equals(src) && !posX.equals(src))
			{
				return (RibbonPart) posX;
			}
			if (negX != null && negX instanceof RibbonPart && !negX.equals(src))
			{
				return (RibbonPart) negX;
			}
			if (posY != null && posY instanceof RibbonPart && !posY.equals(src))
			{
				return (RibbonPart) posY;
			}
			if (negY != null && negY instanceof RibbonPart && !negY.equals(src))
			{
				return (RibbonPart) negY;
			}
			if (posZ != null && posZ instanceof RibbonPart && !posZ.equals(src))
			{
				return (RibbonPart) posZ;
			}
			if (negZ != null && negZ instanceof RibbonPart && !negZ.equals(src))
			{
				return (RibbonPart) negZ;
			}
		}
		return null;
	}

	public RibbonPart getNetworkWithDevices()
	{
		if (!getWorld().isRemote)
		{
			if (getWorld().getTileEntity(getTile().xCoord + 1, getTile().yCoord, getTile().zCoord) != null && getWorld().getTileEntity(getTile().xCoord + 1, getTile().yCoord, getTile().zCoord) instanceof RibbonPart)
			{
				RibbonPart cable = (RibbonPart) getWorld().getTileEntity(getTile().xCoord + 1, getTile().yCoord, getTile().zCoord);
				if (cable.devices != null && cable.getDeviceCount() > 0) return cable;
			}
			if (getWorld().getTileEntity(getTile().xCoord - 1, getTile().yCoord, getTile().zCoord) != null && getWorld().getTileEntity(getTile().xCoord - 1, getTile().yCoord, getTile().zCoord) instanceof RibbonPart)
			{
				RibbonPart cable = (RibbonPart) getWorld().getTileEntity(getTile().xCoord - 1, getTile().yCoord, getTile().zCoord);
				if (cable.devices != null && cable.getDeviceCount() > 0) return cable;
			}
			if (getWorld().getTileEntity(getTile().xCoord, getTile().yCoord + 1, getTile().zCoord) != null && getWorld().getTileEntity(getTile().xCoord, getTile().yCoord + 1, getTile().zCoord) instanceof RibbonPart)
			{
				RibbonPart cable = (RibbonPart) getWorld().getTileEntity(getTile().xCoord, getTile().yCoord + 1, getTile().zCoord);
				if (cable.devices != null && cable.getDeviceCount() > 0) return cable;
			}
			if (getWorld().getTileEntity(getTile().xCoord, getTile().yCoord - 1, getTile().zCoord) != null && getWorld().getTileEntity(getTile().xCoord, getTile().yCoord - 1, getTile().zCoord) instanceof RibbonPart)
			{
				RibbonPart cable = (RibbonPart) getWorld().getTileEntity(getTile().xCoord, getTile().yCoord - 1, getTile().zCoord);
				if (cable.devices != null && cable.getDeviceCount() > 0) return cable;
			}
			if (getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord + 1) != null && getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord + 1) instanceof RibbonPart)
			{
				RibbonPart cable = (RibbonPart) getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord + 1);
				if (cable.devices != null && cable.getDeviceCount() > 0) return cable;
			}
			if (getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord - 1) != null && getWorld().getTileEntity(getTile().xCoord, getTile().yCoord, getTile().zCoord - 1) instanceof RibbonPart)
			{
				BlockDSCRibbonCable cable = (BlockDSCRibbonCable) getWorld().getBlock(x(), y(), z() - 1);
				if (cable.devices != null && cable.getDeviceCount() > 0) return cable;
			}
		}
		return null;
	}

	public void validateDevices()
	{
		for (DSCPart device : devices)
		{
			if (getWorld().getTileEntity(device.xCoord, device.yCoord, device.zCoord).equals(device))
			{}
			else
			{
				removeDeviceById(device.getId());
			}
		}
	}

	public DSCPart getDeviceById(String id)
	{
		for (DSCPart device : devices)
		{
			if (device.getId() == id)
			{
				return device;
			}
		}
		return null;
	}

	public int getDeviceCount()
	{
		return devices.size();
	}

	public DSCPart getDeviceByIndex(int index)
	{
		if (devices.get(index) != null) return devices.get(index);
		return null;
	}

	public void removeDeviceById(String id)
	{
		for (DSCPart device : devices)
		{
			if (device.getId().equals(id))
			{
				devices.remove(device);
				RibbonPart next = getNetwork();
				if (next != null)
				{
					next.removeDeviceById(id, this);
				}
			}
		}
	}

	public void removeDeviceById(String id, RibbonPart src)
	{
		for (DSCPart device : devices)
		{
			if (device.getId().equals(id))
			{
				devices.remove(device);
				RibbonPart next = getNetwork(src);
				if (next != null)
				{
					next.removeDeviceById(id, this);
				}
			}
		}
	}

	public void removeDeviceByIndex(int index)
	{
		if (devices.get(index) != null)
		{
			devices.remove(index);
			RibbonPart next = getNetwork();
			if (next != null)
			{
				next.removeDeviceByIndex(index, this);
			}
		}
	}

	public void removeDeviceByIndex(int index, RibbonPart src)
	{
		if (devices.get(index) != null) devices.remove(index);
		RibbonPart next = getNetwork(src);
		if (next != null)
		{
			next.removeDeviceByIndex(index, this);
		}
	}

	public void sendMessage(DataPackage msg)
	{
		if (getDeviceById(msg.getTarget().getId()) != null)
		{
			msg.getTarget().performAction(msg.getMessage());
		}
	}

	@Override
	public void update()
	{
		tickCount++;
		if (tickCount >= 120)
		{
			if (!networked)
			{
				if (getNetworkWithDevices() != null)
				{
					ArrayList<DSCPart> devices2 = getNetworkWithDevices().devices;
					if (devices2 != null)
					{
						devices = devices2;
						if (devices.size() > 0) networked = true;
					}
				}
			}
		}
	}
*/
}
