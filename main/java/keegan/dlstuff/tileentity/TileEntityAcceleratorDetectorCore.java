package keegan.dlstuff.tileentity;

import keegan.dlstuff.DLStuff;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAcceleratorDetectorCore extends TileEntity
{

	private boolean isMultiblockComplete = false;
	private boolean isPowered = false;
	
	@Override
	public void updateEntity()
	{
		Block[][][] multiblocks = new Block[11][11][3];
		// First slice [x][y][0]
		multiblocks[0][0][0] = worldObj.getBlock(xCoord - 5, yCoord - 5, zCoord - 1);
		multiblocks[1][0][0] = worldObj.getBlock(xCoord - 4, yCoord - 5, zCoord - 1);
		multiblocks[2][0][0] = worldObj.getBlock(xCoord - 3, yCoord - 5, zCoord - 1);
		multiblocks[3][0][0] = worldObj.getBlock(xCoord - 2, yCoord - 5, zCoord - 1);
		multiblocks[4][0][0] = worldObj.getBlock(xCoord - 1, yCoord - 5, zCoord - 1);
		multiblocks[5][0][0] = worldObj.getBlock(xCoord, yCoord - 5, zCoord - 1);
		multiblocks[6][0][0] = worldObj.getBlock(xCoord + 1, yCoord - 5, zCoord - 1);
		multiblocks[7][0][0] = worldObj.getBlock(xCoord + 2, yCoord - 5, zCoord - 1);
		multiblocks[8][0][0] = worldObj.getBlock(xCoord + 3, yCoord - 5, zCoord - 1);
		multiblocks[9][0][0] = worldObj.getBlock(xCoord + 4, yCoord - 5, zCoord - 1);
		multiblocks[10][0][0] = worldObj.getBlock(xCoord + 5, yCoord - 5, zCoord - 1);
		multiblocks[0][1][0] = worldObj.getBlock(xCoord - 5, yCoord - 4, zCoord - 1);
		multiblocks[1][1][0] = worldObj.getBlock(xCoord - 4, yCoord - 4, zCoord - 1);
		multiblocks[2][1][0] = worldObj.getBlock(xCoord - 3, yCoord - 4, zCoord - 1);
		multiblocks[3][1][0] = worldObj.getBlock(xCoord - 2, yCoord - 4, zCoord - 1);
		multiblocks[4][1][0] = worldObj.getBlock(xCoord - 1, yCoord - 4, zCoord - 1);
		multiblocks[5][1][0] = worldObj.getBlock(xCoord, yCoord - 4, zCoord - 1);
		multiblocks[6][1][0] = worldObj.getBlock(xCoord + 1, yCoord - 4, zCoord - 1);
		multiblocks[7][1][0] = worldObj.getBlock(xCoord + 2, yCoord - 4, zCoord - 1);
		multiblocks[8][1][0] = worldObj.getBlock(xCoord + 3, yCoord - 4, zCoord - 1);
		multiblocks[9][1][0] = worldObj.getBlock(xCoord + 4, yCoord - 4, zCoord - 1);
		multiblocks[10][1][0] = worldObj.getBlock(xCoord + 5, yCoord - 4, zCoord - 1);
		multiblocks[0][2][0] = worldObj.getBlock(xCoord - 5, yCoord - 3, zCoord - 1);
		multiblocks[1][2][0] = worldObj.getBlock(xCoord - 4, yCoord - 3, zCoord - 1);
		multiblocks[2][2][0] = worldObj.getBlock(xCoord - 3, yCoord - 3, zCoord - 1);
		multiblocks[3][2][0] = worldObj.getBlock(xCoord - 2, yCoord - 3, zCoord - 1);
		multiblocks[4][2][0] = worldObj.getBlock(xCoord - 1, yCoord - 3, zCoord - 1);
		multiblocks[5][2][0] = worldObj.getBlock(xCoord, yCoord - 3, zCoord - 1);
		multiblocks[6][2][0] = worldObj.getBlock(xCoord + 1, yCoord - 3, zCoord - 1);
		multiblocks[7][2][0] = worldObj.getBlock(xCoord + 2, yCoord - 3, zCoord - 1);
		multiblocks[8][2][0] = worldObj.getBlock(xCoord + 3, yCoord - 3, zCoord - 1);
		multiblocks[9][2][0] = worldObj.getBlock(xCoord + 4, yCoord - 3, zCoord - 1);
		multiblocks[10][2][0] = worldObj.getBlock(xCoord + 5, yCoord - 3, zCoord - 1);
		multiblocks[0][3][0] = worldObj.getBlock(xCoord - 5, yCoord - 2, zCoord - 1);
		multiblocks[1][3][0] = worldObj.getBlock(xCoord - 4, yCoord - 2, zCoord - 1);
		multiblocks[2][3][0] = worldObj.getBlock(xCoord - 3, yCoord - 2, zCoord - 1);
		multiblocks[3][3][0] = worldObj.getBlock(xCoord - 2, yCoord - 2, zCoord - 1);
		multiblocks[4][3][0] = worldObj.getBlock(xCoord - 1, yCoord - 2, zCoord - 1);
		multiblocks[5][3][0] = worldObj.getBlock(xCoord, yCoord - 2, zCoord - 1);
		multiblocks[6][3][0] = worldObj.getBlock(xCoord + 1, yCoord - 2, zCoord - 1);
		multiblocks[7][3][0] = worldObj.getBlock(xCoord + 2, yCoord - 2, zCoord - 1);
		multiblocks[8][3][0] = worldObj.getBlock(xCoord + 3, yCoord - 2, zCoord - 1);
		multiblocks[9][3][0] = worldObj.getBlock(xCoord + 4, yCoord - 2, zCoord - 1);
		multiblocks[10][3][0] = worldObj.getBlock(xCoord + 5, yCoord - 2, zCoord - 1);
		multiblocks[0][4][0] = worldObj.getBlock(xCoord - 5, yCoord - 1, zCoord - 1);
		multiblocks[1][4][0] = worldObj.getBlock(xCoord - 4, yCoord - 1, zCoord - 1);
		multiblocks[2][4][0] = worldObj.getBlock(xCoord - 3, yCoord - 1, zCoord - 1);
		multiblocks[3][4][0] = worldObj.getBlock(xCoord - 2, yCoord - 1, zCoord - 1);
		multiblocks[4][4][0] = worldObj.getBlock(xCoord - 1, yCoord - 1, zCoord - 1);
		multiblocks[5][4][0] = worldObj.getBlock(xCoord, yCoord - 1, zCoord - 1);
		multiblocks[6][4][0] = worldObj.getBlock(xCoord + 1, yCoord - 1, zCoord - 1);
		multiblocks[7][4][0] = worldObj.getBlock(xCoord + 2, yCoord - 1, zCoord - 1);
		multiblocks[8][4][0] = worldObj.getBlock(xCoord + 3, yCoord - 1, zCoord - 1);
		multiblocks[9][4][0] = worldObj.getBlock(xCoord + 4, yCoord - 1, zCoord - 1);
		multiblocks[10][4][0] = worldObj.getBlock(xCoord + 5, yCoord - 1, zCoord - 1);
		multiblocks[0][5][0] = worldObj.getBlock(xCoord - 5, yCoord, zCoord - 1);
		multiblocks[1][5][0] = worldObj.getBlock(xCoord - 4, yCoord, zCoord - 1);
		multiblocks[2][5][0] = worldObj.getBlock(xCoord - 3, yCoord, zCoord - 1);
		multiblocks[3][5][0] = worldObj.getBlock(xCoord - 2, yCoord, zCoord - 1);
		multiblocks[4][5][0] = worldObj.getBlock(xCoord - 1, yCoord, zCoord - 1);
		multiblocks[5][5][0] = worldObj.getBlock(xCoord, yCoord, zCoord - 1);
		multiblocks[6][5][0] = worldObj.getBlock(xCoord + 1, yCoord, zCoord - 1);
		multiblocks[7][5][0] = worldObj.getBlock(xCoord + 2, yCoord, zCoord - 1);
		multiblocks[8][5][0] = worldObj.getBlock(xCoord + 3, yCoord, zCoord - 1);
		multiblocks[9][5][0] = worldObj.getBlock(xCoord + 4, yCoord, zCoord - 1);
		multiblocks[10][5][0] = worldObj.getBlock(xCoord + 5, yCoord, zCoord - 1);
		multiblocks[0][6][0] = worldObj.getBlock(xCoord - 5, yCoord + 1, zCoord - 1);
		multiblocks[1][6][0] = worldObj.getBlock(xCoord - 4, yCoord + 1, zCoord - 1);
		multiblocks[2][6][0] = worldObj.getBlock(xCoord - 3, yCoord + 1, zCoord - 1);
		multiblocks[3][6][0] = worldObj.getBlock(xCoord - 2, yCoord + 1, zCoord - 1);
		multiblocks[4][6][0] = worldObj.getBlock(xCoord - 1, yCoord + 1, zCoord - 1);
		multiblocks[5][6][0] = worldObj.getBlock(xCoord, yCoord + 1, zCoord - 1);
		multiblocks[6][6][0] = worldObj.getBlock(xCoord + 1, yCoord + 1, zCoord - 1);
		multiblocks[7][6][0] = worldObj.getBlock(xCoord + 2, yCoord + 1, zCoord - 1);
		multiblocks[8][6][0] = worldObj.getBlock(xCoord + 3, yCoord + 1, zCoord - 1);
		multiblocks[9][6][0] = worldObj.getBlock(xCoord + 4, yCoord + 1, zCoord - 1);
		multiblocks[10][6][0] = worldObj.getBlock(xCoord + 5, yCoord + 1, zCoord - 1);
		multiblocks[0][7][0] = worldObj.getBlock(xCoord - 5, yCoord + 2, zCoord - 1);
		multiblocks[1][7][0] = worldObj.getBlock(xCoord - 4, yCoord + 2, zCoord - 1);
		multiblocks[2][7][0] = worldObj.getBlock(xCoord - 3, yCoord + 2, zCoord - 1);
		multiblocks[3][7][0] = worldObj.getBlock(xCoord - 2, yCoord + 2, zCoord - 1);
		multiblocks[4][7][0] = worldObj.getBlock(xCoord - 1, yCoord + 2, zCoord - 1);
		multiblocks[5][7][0] = worldObj.getBlock(xCoord, yCoord + 2, zCoord - 1);
		multiblocks[6][7][0] = worldObj.getBlock(xCoord + 1, yCoord + 2, zCoord - 1);
		multiblocks[7][7][0] = worldObj.getBlock(xCoord + 2, yCoord + 2, zCoord - 1);
		multiblocks[8][7][0] = worldObj.getBlock(xCoord + 3, yCoord + 2, zCoord - 1);
		multiblocks[9][7][0] = worldObj.getBlock(xCoord + 4, yCoord + 2, zCoord - 1);
		multiblocks[10][7][0] = worldObj.getBlock(xCoord + 5, yCoord + 2, zCoord - 1);
		multiblocks[0][8][0] = worldObj.getBlock(xCoord - 5, yCoord + 3, zCoord - 1);
		multiblocks[1][8][0] = worldObj.getBlock(xCoord - 4, yCoord + 3, zCoord - 1);
		multiblocks[2][8][0] = worldObj.getBlock(xCoord - 3, yCoord + 3, zCoord - 1);
		multiblocks[3][8][0] = worldObj.getBlock(xCoord - 2, yCoord + 3, zCoord - 1);
		multiblocks[4][8][0] = worldObj.getBlock(xCoord - 1, yCoord + 3, zCoord - 1);
		multiblocks[5][8][0] = worldObj.getBlock(xCoord, yCoord + 3, zCoord - 1);
		multiblocks[6][8][0] = worldObj.getBlock(xCoord + 1, yCoord + 3, zCoord - 1);
		multiblocks[7][8][0] = worldObj.getBlock(xCoord + 2, yCoord + 3, zCoord - 1);
		multiblocks[8][8][0] = worldObj.getBlock(xCoord + 3, yCoord + 3, zCoord - 1);
		multiblocks[9][8][0] = worldObj.getBlock(xCoord + 4, yCoord + 3, zCoord - 1);
		multiblocks[10][8][0] = worldObj.getBlock(xCoord + 5, yCoord + 3, zCoord - 1);
		multiblocks[0][9][0] = worldObj.getBlock(xCoord - 5, yCoord + 4, zCoord - 1);
		multiblocks[1][9][0] = worldObj.getBlock(xCoord - 4, yCoord + 4, zCoord - 1);
		multiblocks[2][9][0] = worldObj.getBlock(xCoord - 3, yCoord + 4, zCoord - 1);
		multiblocks[3][9][0] = worldObj.getBlock(xCoord - 2, yCoord + 4, zCoord - 1);
		multiblocks[4][9][0] = worldObj.getBlock(xCoord - 1, yCoord + 4, zCoord - 1);
		multiblocks[5][9][0] = worldObj.getBlock(xCoord, yCoord + 4, zCoord - 1);
		multiblocks[6][9][0] = worldObj.getBlock(xCoord + 1, yCoord + 4, zCoord - 1);
		multiblocks[7][9][0] = worldObj.getBlock(xCoord + 2, yCoord + 4, zCoord - 1);
		multiblocks[8][9][0] = worldObj.getBlock(xCoord + 3, yCoord + 4, zCoord - 1);
		multiblocks[9][9][0] = worldObj.getBlock(xCoord + 4, yCoord + 4, zCoord - 1);
		multiblocks[10][9][0] = worldObj.getBlock(xCoord + 5, yCoord + 4, zCoord - 1);
		multiblocks[0][10][0] = worldObj.getBlock(xCoord - 5, yCoord + 5, zCoord - 1);
		multiblocks[1][10][0] = worldObj.getBlock(xCoord - 4, yCoord + 5, zCoord - 1);
		multiblocks[2][10][0] = worldObj.getBlock(xCoord - 3, yCoord + 5, zCoord - 1);
		multiblocks[3][10][0] = worldObj.getBlock(xCoord - 2, yCoord + 5, zCoord - 1);
		multiblocks[4][10][0] = worldObj.getBlock(xCoord - 1, yCoord + 5, zCoord - 1);
		multiblocks[5][10][0] = worldObj.getBlock(xCoord, yCoord + 5, zCoord - 1);
		multiblocks[6][10][0] = worldObj.getBlock(xCoord + 1, yCoord + 5, zCoord - 1);
		multiblocks[7][10][0] = worldObj.getBlock(xCoord + 2, yCoord + 5, zCoord - 1);
		multiblocks[8][10][0] = worldObj.getBlock(xCoord + 3, yCoord + 5, zCoord - 1);
		multiblocks[9][10][0] = worldObj.getBlock(xCoord + 4, yCoord + 5, zCoord - 1);
		multiblocks[10][10][0] = worldObj.getBlock(xCoord + 5, yCoord + 5, zCoord - 1);

		// Middle slice [x][y][1]
		multiblocks[0][0][1] = worldObj.getBlock(xCoord - 5, yCoord - 5, zCoord);
		multiblocks[1][0][1] = worldObj.getBlock(xCoord - 4, yCoord - 5, zCoord);
		multiblocks[2][0][1] = worldObj.getBlock(xCoord - 3, yCoord - 5, zCoord);
		multiblocks[3][0][1] = worldObj.getBlock(xCoord - 2, yCoord - 5, zCoord);
		multiblocks[4][0][1] = worldObj.getBlock(xCoord - 1, yCoord - 5, zCoord);
		multiblocks[5][0][1] = worldObj.getBlock(xCoord, yCoord - 5, zCoord);
		multiblocks[6][0][1] = worldObj.getBlock(xCoord + 1, yCoord - 5, zCoord);
		multiblocks[7][0][1] = worldObj.getBlock(xCoord + 2, yCoord - 5, zCoord);
		multiblocks[8][0][1] = worldObj.getBlock(xCoord + 3, yCoord - 5, zCoord);
		multiblocks[9][0][1] = worldObj.getBlock(xCoord + 4, yCoord - 5, zCoord);
		multiblocks[10][0][1] = worldObj.getBlock(xCoord + 5, yCoord - 5, zCoord);
		multiblocks[0][1][1] = worldObj.getBlock(xCoord - 5, yCoord - 4, zCoord);
		multiblocks[1][1][1] = worldObj.getBlock(xCoord - 4, yCoord - 4, zCoord);
		multiblocks[2][1][1] = worldObj.getBlock(xCoord - 3, yCoord - 4, zCoord);
		multiblocks[3][1][1] = worldObj.getBlock(xCoord - 2, yCoord - 4, zCoord);
		multiblocks[4][1][1] = worldObj.getBlock(xCoord - 1, yCoord - 4, zCoord);
		multiblocks[5][1][1] = worldObj.getBlock(xCoord, yCoord - 4, zCoord);
		multiblocks[6][1][1] = worldObj.getBlock(xCoord + 1, yCoord - 4, zCoord);
		multiblocks[7][1][1] = worldObj.getBlock(xCoord + 2, yCoord - 4, zCoord);
		multiblocks[8][1][1] = worldObj.getBlock(xCoord + 3, yCoord - 4, zCoord);
		multiblocks[9][1][1] = worldObj.getBlock(xCoord + 4, yCoord - 4, zCoord);
		multiblocks[10][1][1] = worldObj.getBlock(xCoord + 5, yCoord - 4, zCoord);
		multiblocks[0][2][1] = worldObj.getBlock(xCoord - 5, yCoord - 3, zCoord);
		multiblocks[1][2][1] = worldObj.getBlock(xCoord - 4, yCoord - 3, zCoord);
		multiblocks[2][2][1] = worldObj.getBlock(xCoord - 3, yCoord - 3, zCoord);
		multiblocks[3][2][1] = worldObj.getBlock(xCoord - 2, yCoord - 3, zCoord);
		multiblocks[4][2][1] = worldObj.getBlock(xCoord - 1, yCoord - 3, zCoord);
		multiblocks[5][2][1] = worldObj.getBlock(xCoord, yCoord - 3, zCoord);
		multiblocks[6][2][1] = worldObj.getBlock(xCoord + 1, yCoord - 3, zCoord);
		multiblocks[7][2][1] = worldObj.getBlock(xCoord + 2, yCoord - 3, zCoord);
		multiblocks[8][2][1] = worldObj.getBlock(xCoord + 3, yCoord - 3, zCoord);
		multiblocks[9][2][1] = worldObj.getBlock(xCoord + 4, yCoord - 3, zCoord);
		multiblocks[10][2][1] = worldObj.getBlock(xCoord + 5, yCoord - 3, zCoord);
		multiblocks[0][3][1] = worldObj.getBlock(xCoord - 5, yCoord - 2, zCoord);
		multiblocks[1][3][1] = worldObj.getBlock(xCoord - 4, yCoord - 2, zCoord);
		multiblocks[2][3][1] = worldObj.getBlock(xCoord - 3, yCoord - 2, zCoord);
		multiblocks[3][3][1] = worldObj.getBlock(xCoord - 2, yCoord - 2, zCoord);
		multiblocks[4][3][1] = worldObj.getBlock(xCoord - 1, yCoord - 2, zCoord);
		multiblocks[5][3][1] = worldObj.getBlock(xCoord, yCoord - 2, zCoord);
		multiblocks[6][3][1] = worldObj.getBlock(xCoord + 1, yCoord - 2, zCoord);
		multiblocks[7][3][1] = worldObj.getBlock(xCoord + 2, yCoord - 2, zCoord);
		multiblocks[8][3][1] = worldObj.getBlock(xCoord + 3, yCoord - 2, zCoord);
		multiblocks[9][3][1] = worldObj.getBlock(xCoord + 4, yCoord - 2, zCoord);
		multiblocks[10][3][1] = worldObj.getBlock(xCoord + 5, yCoord - 2, zCoord);
		multiblocks[0][4][1] = worldObj.getBlock(xCoord - 5, yCoord - 1, zCoord);
		multiblocks[1][4][1] = worldObj.getBlock(xCoord - 4, yCoord - 1, zCoord);
		multiblocks[2][4][1] = worldObj.getBlock(xCoord - 3, yCoord - 1, zCoord);
		multiblocks[3][4][1] = worldObj.getBlock(xCoord - 2, yCoord - 1, zCoord);
		multiblocks[4][4][1] = worldObj.getBlock(xCoord - 1, yCoord - 1, zCoord);
		multiblocks[5][4][1] = worldObj.getBlock(xCoord, yCoord - 1, zCoord);
		multiblocks[6][4][1] = worldObj.getBlock(xCoord + 1, yCoord - 1, zCoord);
		multiblocks[7][4][1] = worldObj.getBlock(xCoord + 2, yCoord - 1, zCoord);
		multiblocks[8][4][1] = worldObj.getBlock(xCoord + 3, yCoord - 1, zCoord);
		multiblocks[9][4][1] = worldObj.getBlock(xCoord + 4, yCoord - 1, zCoord);
		multiblocks[10][4][1] = worldObj.getBlock(xCoord + 5, yCoord - 1, zCoord);
		multiblocks[0][5][1] = worldObj.getBlock(xCoord - 5, yCoord, zCoord);
		multiblocks[1][5][1] = worldObj.getBlock(xCoord - 4, yCoord, zCoord);
		multiblocks[2][5][1] = worldObj.getBlock(xCoord - 3, yCoord, zCoord);
		multiblocks[3][5][1] = worldObj.getBlock(xCoord - 2, yCoord, zCoord);
		multiblocks[4][5][1] = worldObj.getBlock(xCoord - 1, yCoord, zCoord);
		multiblocks[5][5][1] = worldObj.getBlock(xCoord, yCoord, zCoord);
		multiblocks[6][5][1] = worldObj.getBlock(xCoord + 1, yCoord, zCoord);
		multiblocks[7][5][1] = worldObj.getBlock(xCoord + 2, yCoord, zCoord);
		multiblocks[8][5][1] = worldObj.getBlock(xCoord + 3, yCoord, zCoord);
		multiblocks[9][5][1] = worldObj.getBlock(xCoord + 4, yCoord, zCoord);
		multiblocks[10][5][1] = worldObj.getBlock(xCoord + 5, yCoord, zCoord);
		multiblocks[0][6][1] = worldObj.getBlock(xCoord - 5, yCoord + 1, zCoord);
		multiblocks[1][6][1] = worldObj.getBlock(xCoord - 4, yCoord + 1, zCoord);
		multiblocks[2][6][1] = worldObj.getBlock(xCoord - 3, yCoord + 1, zCoord);
		multiblocks[3][6][1] = worldObj.getBlock(xCoord - 2, yCoord + 1, zCoord);
		multiblocks[4][6][1] = worldObj.getBlock(xCoord - 1, yCoord + 1, zCoord);
		multiblocks[5][6][1] = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
		multiblocks[6][6][1] = worldObj.getBlock(xCoord + 1, yCoord + 1, zCoord);
		multiblocks[7][6][1] = worldObj.getBlock(xCoord + 2, yCoord + 1, zCoord);
		multiblocks[8][6][1] = worldObj.getBlock(xCoord + 3, yCoord + 1, zCoord);
		multiblocks[9][6][1] = worldObj.getBlock(xCoord + 4, yCoord + 1, zCoord);
		multiblocks[10][6][1] = worldObj.getBlock(xCoord + 5, yCoord + 1, zCoord);
		multiblocks[0][7][1] = worldObj.getBlock(xCoord - 5, yCoord + 2, zCoord);
		multiblocks[1][7][1] = worldObj.getBlock(xCoord - 4, yCoord + 2, zCoord);
		multiblocks[2][7][1] = worldObj.getBlock(xCoord - 3, yCoord + 2, zCoord);
		multiblocks[3][7][1] = worldObj.getBlock(xCoord - 2, yCoord + 2, zCoord);
		multiblocks[4][7][1] = worldObj.getBlock(xCoord - 1, yCoord + 2, zCoord);
		multiblocks[5][7][1] = worldObj.getBlock(xCoord, yCoord + 2, zCoord);
		multiblocks[6][7][1] = worldObj.getBlock(xCoord + 1, yCoord + 2, zCoord);
		multiblocks[7][7][1] = worldObj.getBlock(xCoord + 2, yCoord + 2, zCoord);
		multiblocks[8][7][1] = worldObj.getBlock(xCoord + 3, yCoord + 2, zCoord);
		multiblocks[9][7][1] = worldObj.getBlock(xCoord + 4, yCoord + 2, zCoord);
		multiblocks[10][7][1] = worldObj.getBlock(xCoord + 5, yCoord + 2, zCoord);
		multiblocks[0][8][1] = worldObj.getBlock(xCoord - 5, yCoord + 3, zCoord);
		multiblocks[1][8][1] = worldObj.getBlock(xCoord - 4, yCoord + 3, zCoord);
		multiblocks[2][8][1] = worldObj.getBlock(xCoord - 3, yCoord + 3, zCoord);
		multiblocks[3][8][1] = worldObj.getBlock(xCoord - 2, yCoord + 3, zCoord);
		multiblocks[4][8][1] = worldObj.getBlock(xCoord - 1, yCoord + 3, zCoord);
		multiblocks[5][8][1] = worldObj.getBlock(xCoord, yCoord + 3, zCoord);
		multiblocks[6][8][1] = worldObj.getBlock(xCoord + 1, yCoord + 3, zCoord);
		multiblocks[7][8][1] = worldObj.getBlock(xCoord + 2, yCoord + 3, zCoord);
		multiblocks[8][8][1] = worldObj.getBlock(xCoord + 3, yCoord + 3, zCoord);
		multiblocks[9][8][1] = worldObj.getBlock(xCoord + 4, yCoord + 3, zCoord);
		multiblocks[10][8][1] = worldObj.getBlock(xCoord + 5, yCoord + 3, zCoord);
		multiblocks[0][9][1] = worldObj.getBlock(xCoord - 5, yCoord + 4, zCoord);
		multiblocks[1][9][1] = worldObj.getBlock(xCoord - 4, yCoord + 4, zCoord);
		multiblocks[2][9][1] = worldObj.getBlock(xCoord - 3, yCoord + 4, zCoord);
		multiblocks[3][9][1] = worldObj.getBlock(xCoord - 2, yCoord + 4, zCoord);
		multiblocks[4][9][1] = worldObj.getBlock(xCoord - 1, yCoord + 4, zCoord);
		multiblocks[5][9][1] = worldObj.getBlock(xCoord, yCoord + 4, zCoord);
		multiblocks[6][9][1] = worldObj.getBlock(xCoord + 1, yCoord + 4, zCoord);
		multiblocks[7][9][1] = worldObj.getBlock(xCoord + 2, yCoord + 4, zCoord);
		multiblocks[8][9][1] = worldObj.getBlock(xCoord + 3, yCoord + 4, zCoord);
		multiblocks[9][9][1] = worldObj.getBlock(xCoord + 4, yCoord + 4, zCoord);
		multiblocks[10][9][1] = worldObj.getBlock(xCoord + 5, yCoord + 4, zCoord);
		multiblocks[0][10][1] = worldObj.getBlock(xCoord - 5, yCoord + 5, zCoord);
		multiblocks[1][10][1] = worldObj.getBlock(xCoord - 4, yCoord + 5, zCoord);
		multiblocks[2][10][1] = worldObj.getBlock(xCoord - 3, yCoord + 5, zCoord);
		multiblocks[3][10][1] = worldObj.getBlock(xCoord - 2, yCoord + 5, zCoord);
		multiblocks[4][10][1] = worldObj.getBlock(xCoord - 1, yCoord + 5, zCoord);
		multiblocks[5][10][1] = worldObj.getBlock(xCoord, yCoord + 5, zCoord);
		multiblocks[6][10][1] = worldObj.getBlock(xCoord + 1, yCoord + 5, zCoord);
		multiblocks[7][10][1] = worldObj.getBlock(xCoord + 2, yCoord + 5, zCoord);
		multiblocks[8][10][1] = worldObj.getBlock(xCoord + 3, yCoord + 5, zCoord);
		multiblocks[9][10][1] = worldObj.getBlock(xCoord + 4, yCoord + 5, zCoord);
		multiblocks[10][10][1] = worldObj.getBlock(xCoord + 5, yCoord + 5, zCoord);

		// Third slice [x][y][2]
		multiblocks[0][0][2] = worldObj.getBlock(xCoord - 5, yCoord - 5, zCoord + 1);
		multiblocks[1][0][2] = worldObj.getBlock(xCoord - 4, yCoord - 5, zCoord + 1);
		multiblocks[2][0][2] = worldObj.getBlock(xCoord - 3, yCoord - 5, zCoord + 1);
		multiblocks[3][0][2] = worldObj.getBlock(xCoord - 2, yCoord - 5, zCoord + 1);
		multiblocks[4][0][2] = worldObj.getBlock(xCoord - 1, yCoord - 5, zCoord + 1);
		multiblocks[5][0][2] = worldObj.getBlock(xCoord, yCoord - 5, zCoord + 1);
		multiblocks[6][0][2] = worldObj.getBlock(xCoord + 1, yCoord - 5, zCoord + 1);
		multiblocks[7][0][2] = worldObj.getBlock(xCoord + 2, yCoord - 5, zCoord + 1);
		multiblocks[8][0][2] = worldObj.getBlock(xCoord + 3, yCoord - 5, zCoord + 1);
		multiblocks[9][0][2] = worldObj.getBlock(xCoord + 4, yCoord - 5, zCoord + 1);
		multiblocks[10][0][2] = worldObj.getBlock(xCoord + 5, yCoord - 5, zCoord + 1);
		multiblocks[0][1][2] = worldObj.getBlock(xCoord - 5, yCoord - 4, zCoord + 1);
		multiblocks[1][1][2] = worldObj.getBlock(xCoord - 4, yCoord - 4, zCoord + 1);
		multiblocks[2][1][2] = worldObj.getBlock(xCoord - 3, yCoord - 4, zCoord + 1);
		multiblocks[3][1][2] = worldObj.getBlock(xCoord - 2, yCoord - 4, zCoord + 1);
		multiblocks[4][1][2] = worldObj.getBlock(xCoord - 1, yCoord - 4, zCoord + 1);
		multiblocks[5][1][2] = worldObj.getBlock(xCoord, yCoord - 4, zCoord + 1);
		multiblocks[6][1][2] = worldObj.getBlock(xCoord + 1, yCoord - 4, zCoord + 1);
		multiblocks[7][1][2] = worldObj.getBlock(xCoord + 2, yCoord - 4, zCoord + 1);
		multiblocks[8][1][2] = worldObj.getBlock(xCoord + 3, yCoord - 4, zCoord + 1);
		multiblocks[9][1][2] = worldObj.getBlock(xCoord + 4, yCoord - 4, zCoord + 1);
		multiblocks[10][1][2] = worldObj.getBlock(xCoord + 5, yCoord - 4, zCoord + 1);
		multiblocks[0][2][2] = worldObj.getBlock(xCoord - 5, yCoord - 3, zCoord + 1);
		multiblocks[1][2][2] = worldObj.getBlock(xCoord - 4, yCoord - 3, zCoord + 1);
		multiblocks[2][2][2] = worldObj.getBlock(xCoord - 3, yCoord - 3, zCoord + 1);
		multiblocks[3][2][2] = worldObj.getBlock(xCoord - 2, yCoord - 3, zCoord + 1);
		multiblocks[4][2][2] = worldObj.getBlock(xCoord - 1, yCoord - 3, zCoord + 1);
		multiblocks[5][2][2] = worldObj.getBlock(xCoord, yCoord - 3, zCoord + 1);
		multiblocks[6][2][2] = worldObj.getBlock(xCoord + 1, yCoord - 3, zCoord + 1);
		multiblocks[7][2][2] = worldObj.getBlock(xCoord + 2, yCoord - 3, zCoord + 1);
		multiblocks[8][2][2] = worldObj.getBlock(xCoord + 3, yCoord - 3, zCoord + 1);
		multiblocks[9][2][2] = worldObj.getBlock(xCoord + 4, yCoord - 3, zCoord + 1);
		multiblocks[10][2][2] = worldObj.getBlock(xCoord + 5, yCoord - 3, zCoord + 1);
		multiblocks[0][3][2] = worldObj.getBlock(xCoord - 5, yCoord - 2, zCoord + 1);
		multiblocks[1][3][2] = worldObj.getBlock(xCoord - 4, yCoord - 2, zCoord + 1);
		multiblocks[2][3][2] = worldObj.getBlock(xCoord - 3, yCoord - 2, zCoord + 1);
		multiblocks[3][3][2] = worldObj.getBlock(xCoord - 2, yCoord - 2, zCoord + 1);
		multiblocks[4][3][2] = worldObj.getBlock(xCoord - 1, yCoord - 2, zCoord + 1);
		multiblocks[5][3][2] = worldObj.getBlock(xCoord, yCoord - 2, zCoord + 1);
		multiblocks[6][3][2] = worldObj.getBlock(xCoord + 1, yCoord - 2, zCoord + 1);
		multiblocks[7][3][2] = worldObj.getBlock(xCoord + 2, yCoord - 2, zCoord + 1);
		multiblocks[8][3][2] = worldObj.getBlock(xCoord + 3, yCoord - 2, zCoord + 1);
		multiblocks[9][3][2] = worldObj.getBlock(xCoord + 4, yCoord - 2, zCoord + 1);
		multiblocks[10][3][2] = worldObj.getBlock(xCoord + 5, yCoord - 2, zCoord + 1);
		multiblocks[0][4][2] = worldObj.getBlock(xCoord - 5, yCoord - 1, zCoord + 1);
		multiblocks[1][4][2] = worldObj.getBlock(xCoord - 4, yCoord - 1, zCoord + 1);
		multiblocks[2][4][2] = worldObj.getBlock(xCoord - 3, yCoord - 1, zCoord + 1);
		multiblocks[3][4][2] = worldObj.getBlock(xCoord - 2, yCoord - 1, zCoord + 1);
		multiblocks[4][4][2] = worldObj.getBlock(xCoord - 1, yCoord - 1, zCoord + 1);
		multiblocks[5][4][2] = worldObj.getBlock(xCoord, yCoord - 1, zCoord + 1);
		multiblocks[6][4][2] = worldObj.getBlock(xCoord + 1, yCoord - 1, zCoord + 1);
		multiblocks[7][4][2] = worldObj.getBlock(xCoord + 2, yCoord - 1, zCoord + 1);
		multiblocks[8][4][2] = worldObj.getBlock(xCoord + 3, yCoord - 1, zCoord + 1);
		multiblocks[9][4][2] = worldObj.getBlock(xCoord + 4, yCoord - 1, zCoord + 1);
		multiblocks[10][4][2] = worldObj.getBlock(xCoord + 5, yCoord - 1, zCoord + 1);
		multiblocks[0][5][2] = worldObj.getBlock(xCoord - 5, yCoord, zCoord + 1);
		multiblocks[1][5][2] = worldObj.getBlock(xCoord - 4, yCoord, zCoord + 1);
		multiblocks[2][5][2] = worldObj.getBlock(xCoord - 3, yCoord, zCoord + 1);
		multiblocks[3][5][2] = worldObj.getBlock(xCoord - 2, yCoord, zCoord + 1);
		multiblocks[4][5][2] = worldObj.getBlock(xCoord - 1, yCoord, zCoord + 1);
		multiblocks[5][5][2] = worldObj.getBlock(xCoord, yCoord, zCoord + 1);
		multiblocks[6][5][2] = worldObj.getBlock(xCoord + 1, yCoord, zCoord + 1);
		multiblocks[7][5][2] = worldObj.getBlock(xCoord + 2, yCoord, zCoord + 1);
		multiblocks[8][5][2] = worldObj.getBlock(xCoord + 3, yCoord, zCoord + 1);
		multiblocks[9][5][2] = worldObj.getBlock(xCoord + 4, yCoord, zCoord + 1);
		multiblocks[10][5][2] = worldObj.getBlock(xCoord + 5, yCoord, zCoord + 1);
		multiblocks[0][6][2] = worldObj.getBlock(xCoord - 5, yCoord + 1, zCoord + 1);
		multiblocks[1][6][2] = worldObj.getBlock(xCoord - 4, yCoord + 1, zCoord + 1);
		multiblocks[2][6][2] = worldObj.getBlock(xCoord - 3, yCoord + 1, zCoord + 1);
		multiblocks[3][6][2] = worldObj.getBlock(xCoord - 2, yCoord + 1, zCoord + 1);
		multiblocks[4][6][2] = worldObj.getBlock(xCoord - 1, yCoord + 1, zCoord + 1);
		multiblocks[5][6][2] = worldObj.getBlock(xCoord, yCoord + 1, zCoord + 1);
		multiblocks[6][6][2] = worldObj.getBlock(xCoord + 1, yCoord + 1, zCoord + 1);
		multiblocks[7][6][2] = worldObj.getBlock(xCoord + 2, yCoord + 1, zCoord + 1);
		multiblocks[8][6][2] = worldObj.getBlock(xCoord + 3, yCoord + 1, zCoord + 1);
		multiblocks[9][6][2] = worldObj.getBlock(xCoord + 4, yCoord + 1, zCoord + 1);
		multiblocks[10][6][2] = worldObj.getBlock(xCoord + 5, yCoord + 1, zCoord + 1);
		multiblocks[0][7][2] = worldObj.getBlock(xCoord - 5, yCoord + 2, zCoord + 1);
		multiblocks[1][7][2] = worldObj.getBlock(xCoord - 4, yCoord + 2, zCoord + 1);
		multiblocks[2][7][2] = worldObj.getBlock(xCoord - 3, yCoord + 2, zCoord + 1);
		multiblocks[3][7][2] = worldObj.getBlock(xCoord - 2, yCoord + 2, zCoord + 1);
		multiblocks[4][7][2] = worldObj.getBlock(xCoord - 1, yCoord + 2, zCoord + 1);
		multiblocks[5][7][2] = worldObj.getBlock(xCoord, yCoord + 2, zCoord + 1);
		multiblocks[6][7][2] = worldObj.getBlock(xCoord + 1, yCoord + 2, zCoord + 1);
		multiblocks[7][7][2] = worldObj.getBlock(xCoord + 2, yCoord + 2, zCoord + 1);
		multiblocks[8][7][2] = worldObj.getBlock(xCoord + 3, yCoord + 2, zCoord + 1);
		multiblocks[9][7][2] = worldObj.getBlock(xCoord + 4, yCoord + 2, zCoord + 1);
		multiblocks[10][7][2] = worldObj.getBlock(xCoord + 5, yCoord + 2, zCoord + 1);
		multiblocks[0][8][2] = worldObj.getBlock(xCoord - 5, yCoord + 3, zCoord + 1);
		multiblocks[1][8][2] = worldObj.getBlock(xCoord - 4, yCoord + 3, zCoord + 1);
		multiblocks[2][8][2] = worldObj.getBlock(xCoord - 3, yCoord + 3, zCoord + 1);
		multiblocks[3][8][2] = worldObj.getBlock(xCoord - 2, yCoord + 3, zCoord + 1);
		multiblocks[4][8][2] = worldObj.getBlock(xCoord - 1, yCoord + 3, zCoord + 1);
		multiblocks[5][8][2] = worldObj.getBlock(xCoord, yCoord + 3, zCoord + 1);
		multiblocks[6][8][2] = worldObj.getBlock(xCoord + 1, yCoord + 3, zCoord + 1);
		multiblocks[7][8][2] = worldObj.getBlock(xCoord + 2, yCoord + 3, zCoord + 1);
		multiblocks[8][8][2] = worldObj.getBlock(xCoord + 3, yCoord + 3, zCoord + 1);
		multiblocks[9][8][2] = worldObj.getBlock(xCoord + 4, yCoord + 3, zCoord + 1);
		multiblocks[10][8][2] = worldObj.getBlock(xCoord + 5, yCoord + 3, zCoord + 1);
		multiblocks[0][9][2] = worldObj.getBlock(xCoord - 5, yCoord + 4, zCoord + 1);
		multiblocks[1][9][2] = worldObj.getBlock(xCoord - 4, yCoord + 4, zCoord + 1);
		multiblocks[2][9][2] = worldObj.getBlock(xCoord - 3, yCoord + 4, zCoord + 1);
		multiblocks[3][9][2] = worldObj.getBlock(xCoord - 2, yCoord + 4, zCoord + 1);
		multiblocks[4][9][2] = worldObj.getBlock(xCoord - 1, yCoord + 4, zCoord + 1);
		multiblocks[5][9][2] = worldObj.getBlock(xCoord, yCoord + 4, zCoord + 1);
		multiblocks[6][9][2] = worldObj.getBlock(xCoord + 1, yCoord + 4, zCoord + 1);
		multiblocks[7][9][2] = worldObj.getBlock(xCoord + 2, yCoord + 4, zCoord + 1);
		multiblocks[8][9][2] = worldObj.getBlock(xCoord + 3, yCoord + 4, zCoord + 1);
		multiblocks[9][9][2] = worldObj.getBlock(xCoord + 4, yCoord + 4, zCoord + 1);
		multiblocks[10][9][2] = worldObj.getBlock(xCoord + 5, yCoord + 4, zCoord + 1);
		multiblocks[0][10][2] = worldObj.getBlock(xCoord - 5, yCoord + 5, zCoord + 1);
		multiblocks[1][10][2] = worldObj.getBlock(xCoord - 4, yCoord + 5, zCoord + 1);
		multiblocks[2][10][2] = worldObj.getBlock(xCoord - 3, yCoord + 5, zCoord + 1);
		multiblocks[3][10][2] = worldObj.getBlock(xCoord - 2, yCoord + 5, zCoord + 1);
		multiblocks[4][10][2] = worldObj.getBlock(xCoord - 1, yCoord + 5, zCoord + 1);
		multiblocks[5][10][2] = worldObj.getBlock(xCoord, yCoord + 5, zCoord + 1);
		multiblocks[6][10][2] = worldObj.getBlock(xCoord + 1, yCoord + 5, zCoord + 1);
		multiblocks[7][10][2] = worldObj.getBlock(xCoord + 2, yCoord + 5, zCoord + 1);
		multiblocks[8][10][2] = worldObj.getBlock(xCoord + 3, yCoord + 5, zCoord + 1);
		multiblocks[9][10][2] = worldObj.getBlock(xCoord + 4, yCoord + 5, zCoord + 1);
		multiblocks[10][10][2] = worldObj.getBlock(xCoord + 5, yCoord + 5, zCoord + 1);
		if (multiblocks[3][0][0] != null && multiblocks[4][0][0] != null && multiblocks[5][0][0] != null && multiblocks[6][0][0] != null && multiblocks[7][0][0] != null && multiblocks[2][1][0] != null && multiblocks[3][1][0] != null && multiblocks[4][1][0] != null && multiblocks[5][1][0] != null && multiblocks[6][1][0] != null && multiblocks[7][1][0] != null && multiblocks[8][1][0] != null && multiblocks[1][2][0] != null && multiblocks[2][2][0] != null && multiblocks[3][2][0] != null && multiblocks[4][2][0] != null && multiblocks[5][2][0] != null && multiblocks[6][2][0] != null && multiblocks[7][2][0] != null && multiblocks[8][2][0] != null && multiblocks[9][2][0] != null && multiblocks[0][3][0] != null && multiblocks[1][3][0] != null && multiblocks[2][3][0] != null && multiblocks[3][3][0] != null && multiblocks[4][3][0] != null && multiblocks[5][3][0] != null && multiblocks[6][3][0] != null && multiblocks[7][3][0] != null && multiblocks[8][3][0] != null
				&& multiblocks[9][3][0] != null && multiblocks[10][3][0] != null && multiblocks[0][4][0] != null && multiblocks[1][4][0] != null && multiblocks[2][4][0] != null && multiblocks[3][4][0] != null && multiblocks[4][4][0] != null && multiblocks[5][4][0] != null && multiblocks[6][4][0] != null && multiblocks[7][4][0] != null && multiblocks[8][4][0] != null && multiblocks[9][4][0] != null && multiblocks[10][4][0] != null && multiblocks[0][5][0] != null && multiblocks[1][5][0] != null && multiblocks[2][5][0] != null && multiblocks[3][5][0] != null && multiblocks[4][5][0] != null && multiblocks[5][5][0] != null && multiblocks[6][5][0] != null && multiblocks[7][5][0] != null && multiblocks[8][5][0] != null && multiblocks[9][5][0] != null && multiblocks[10][5][0] != null && multiblocks[0][6][0] != null && multiblocks[1][6][0] != null && multiblocks[2][6][0] != null && multiblocks[3][6][0] != null && multiblocks[4][6][0] != null && multiblocks[5][6][0] != null
				&& multiblocks[6][6][0] != null && multiblocks[7][6][0] != null && multiblocks[8][6][0] != null && multiblocks[9][6][0] != null && multiblocks[10][6][0] != null && multiblocks[0][7][0] != null && multiblocks[1][7][0] != null && multiblocks[2][7][0] != null && multiblocks[3][7][0] != null && multiblocks[4][7][0] != null && multiblocks[5][7][0] != null && multiblocks[6][7][0] != null && multiblocks[7][7][0] != null && multiblocks[8][7][0] != null && multiblocks[9][7][0] != null && multiblocks[10][7][0] != null && multiblocks[1][8][0] != null && multiblocks[2][8][0] != null && multiblocks[3][8][0] != null && multiblocks[4][8][0] != null && multiblocks[5][8][0] != null && multiblocks[6][8][0] != null && multiblocks[7][8][0] != null && multiblocks[8][8][0] != null && multiblocks[9][8][0] != null && multiblocks[2][9][0] != null && multiblocks[3][9][0] != null && multiblocks[4][9][0] != null && multiblocks[5][9][0] != null && multiblocks[6][9][0] != null
				&& multiblocks[7][9][0] != null && multiblocks[8][9][0] != null && multiblocks[3][10][0] != null && multiblocks[4][10][0] != null && multiblocks[5][10][0] != null && multiblocks[6][10][0] != null && multiblocks[7][10][0] != null && multiblocks[3][0][1] != null && multiblocks[4][0][1] != null && multiblocks[5][0][1] != null && multiblocks[6][0][1] != null && multiblocks[7][0][1] != null && multiblocks[2][1][1] != null && multiblocks[3][1][1] != null && multiblocks[4][1][1] != null && multiblocks[5][1][1] != null && multiblocks[6][1][1] != null && multiblocks[7][1][1] != null && multiblocks[8][1][1] != null && multiblocks[1][2][1] != null && multiblocks[2][2][1] != null && multiblocks[3][2][1] != null && multiblocks[4][2][1] != null && multiblocks[5][2][1] != null && multiblocks[6][2][1] != null && multiblocks[7][2][1] != null && multiblocks[8][2][1] != null && multiblocks[9][2][1] != null && multiblocks[0][3][1] != null && multiblocks[1][3][1] != null
				&& multiblocks[2][3][1] != null && multiblocks[3][3][1] != null && multiblocks[4][3][1] != null && multiblocks[5][3][1] != null && multiblocks[6][3][1] != null && multiblocks[7][3][1] != null && multiblocks[8][3][1] != null && multiblocks[9][3][1] != null && multiblocks[10][3][1] != null && multiblocks[0][4][1] != null && multiblocks[1][4][1] != null && multiblocks[2][4][1] != null && multiblocks[3][4][1] != null && multiblocks[4][4][1] != null && multiblocks[5][4][1] != null && multiblocks[6][4][1] != null && multiblocks[7][4][1] != null && multiblocks[8][4][1] != null && multiblocks[9][4][1] != null && multiblocks[10][4][1] != null && multiblocks[0][5][1] != null && multiblocks[1][5][1] != null && multiblocks[2][5][1] != null && multiblocks[3][5][1] != null && multiblocks[4][5][1] != null && multiblocks[5][5][1] != null && multiblocks[6][5][1] != null && multiblocks[7][5][1] != null && multiblocks[8][5][1] != null && multiblocks[9][5][1] != null
				&& multiblocks[10][5][1] != null && multiblocks[0][6][1] != null && multiblocks[1][6][1] != null && multiblocks[2][6][1] != null && multiblocks[3][6][1] != null && multiblocks[4][6][1] != null && multiblocks[5][6][1] != null && multiblocks[6][6][1] != null && multiblocks[7][6][1] != null && multiblocks[8][6][1] != null && multiblocks[9][6][1] != null && multiblocks[10][6][1] != null && multiblocks[0][7][1] != null && multiblocks[1][7][1] != null && multiblocks[2][7][1] != null && multiblocks[3][7][1] != null && multiblocks[4][7][1] != null && multiblocks[5][7][1] != null && multiblocks[6][7][1] != null && multiblocks[7][7][1] != null && multiblocks[8][7][1] != null && multiblocks[9][7][1] != null && multiblocks[10][7][1] != null && multiblocks[1][8][1] != null && multiblocks[2][8][1] != null && multiblocks[3][8][1] != null && multiblocks[4][8][1] != null && multiblocks[5][8][1] != null && multiblocks[6][8][1] != null && multiblocks[7][8][1] != null
				&& multiblocks[8][8][1] != null && multiblocks[9][8][1] != null && multiblocks[2][9][1] != null && multiblocks[3][9][1] != null && multiblocks[4][9][1] != null && multiblocks[5][9][1] != null && multiblocks[6][9][1] != null && multiblocks[7][9][1] != null && multiblocks[8][9][1] != null && multiblocks[3][10][1] != null && multiblocks[4][10][1] != null && multiblocks[5][10][1] != null && multiblocks[6][10][1] != null && multiblocks[7][10][1] != null && multiblocks[3][0][2] != null && multiblocks[4][0][2] != null && multiblocks[5][0][2] != null && multiblocks[6][0][2] != null && multiblocks[7][0][2] != null && multiblocks[2][1][2] != null && multiblocks[3][1][2] != null && multiblocks[4][1][2] != null && multiblocks[5][1][2] != null && multiblocks[6][1][2] != null && multiblocks[7][1][2] != null && multiblocks[8][1][2] != null && multiblocks[1][2][2] != null && multiblocks[2][2][2] != null && multiblocks[3][2][2] != null && multiblocks[4][2][2] != null
				&& multiblocks[5][2][2] != null && multiblocks[6][2][2] != null && multiblocks[7][2][2] != null && multiblocks[8][2][2] != null && multiblocks[9][2][2] != null && multiblocks[0][3][2] != null && multiblocks[1][3][2] != null && multiblocks[2][3][2] != null && multiblocks[3][3][2] != null && multiblocks[4][3][2] != null && multiblocks[5][3][2] != null && multiblocks[6][3][2] != null && multiblocks[7][3][2] != null && multiblocks[8][3][2] != null && multiblocks[9][3][2] != null && multiblocks[10][3][2] != null && multiblocks[0][4][2] != null && multiblocks[1][4][2] != null && multiblocks[2][4][2] != null && multiblocks[3][4][2] != null && multiblocks[4][4][2] != null && multiblocks[5][4][2] != null && multiblocks[6][4][2] != null && multiblocks[7][4][2] != null && multiblocks[8][4][2] != null && multiblocks[9][4][2] != null && multiblocks[10][4][2] != null && multiblocks[0][5][2] != null && multiblocks[1][5][2] != null && multiblocks[2][5][2] != null
				&& multiblocks[3][5][2] != null && multiblocks[4][5][2] != null && multiblocks[5][5][2] != null && multiblocks[6][5][2] != null && multiblocks[7][5][2] != null && multiblocks[8][5][2] != null && multiblocks[9][5][2] != null && multiblocks[10][5][2] != null && multiblocks[0][6][2] != null && multiblocks[1][6][2] != null && multiblocks[2][6][2] != null && multiblocks[3][6][2] != null && multiblocks[4][6][2] != null && multiblocks[5][6][2] != null && multiblocks[6][6][2] != null && multiblocks[7][6][2] != null && multiblocks[8][6][2] != null && multiblocks[9][6][2] != null && multiblocks[10][6][2] != null && multiblocks[0][7][2] != null && multiblocks[1][7][2] != null && multiblocks[2][7][2] != null && multiblocks[3][7][2] != null && multiblocks[4][7][2] != null && multiblocks[5][7][2] != null && multiblocks[6][7][2] != null && multiblocks[7][7][2] != null && multiblocks[8][7][2] != null && multiblocks[9][7][2] != null && multiblocks[10][7][2] != null
				&& multiblocks[1][8][2] != null && multiblocks[2][8][2] != null && multiblocks[3][8][2] != null && multiblocks[4][8][2] != null && multiblocks[5][8][2] != null && multiblocks[6][8][2] != null && multiblocks[7][8][2] != null && multiblocks[8][8][2] != null && multiblocks[9][8][2] != null && multiblocks[2][9][2] != null && multiblocks[3][9][2] != null && multiblocks[4][9][2] != null && multiblocks[5][9][2] != null && multiblocks[6][9][2] != null && multiblocks[7][9][2] != null && multiblocks[8][9][2] != null && multiblocks[3][10][2] != null && multiblocks[4][10][2] != null && multiblocks[5][10][2] != null && multiblocks[6][10][2] != null && multiblocks[7][10][2] != null)
		{
			if (multiblocks[5][5][1].equals(DLStuff.blockAcceleratorDetectorCore))
			{

				if (multiblocks[5][4][1].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[6][4][1].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[4][5][1].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[6][5][1].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[4][6][1].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[5][6][1].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[6][6][1].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[4][4][0].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[5][4][0].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[6][4][0].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[4][5][0].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[6][5][0].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[4][6][0].equals(DLStuff.blockAcceleratorTrackingDetector)
						&& multiblocks[5][6][0].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[6][6][0].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[4][4][2].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[5][4][2].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[6][4][2].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[4][5][2].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[6][5][2].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[4][6][2].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[5][6][2].equals(DLStuff.blockAcceleratorTrackingDetector) && multiblocks[6][6][2].equals(DLStuff.blockAcceleratorTrackingDetector))
				{
					if (multiblocks[3][3][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[4][3][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[5][3][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[6][3][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][3][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][4][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][4][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][5][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][5][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][6][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][6][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][7][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[4][7][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[5][7][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[6][7][1].equals(DLStuff.blockAcceleratorSolenoid)
							&& multiblocks[7][7][1].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][3][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[4][3][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[5][3][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[6][3][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][3][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][4][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][4][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][5][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][5][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][6][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][6][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][7][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[4][7][0].equals(DLStuff.blockAcceleratorSolenoid)
							&& multiblocks[5][7][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[6][7][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][7][0].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][3][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[4][3][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[5][3][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[6][3][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][3][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][4][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][4][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][5][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][5][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[3][6][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][6][2].equals(DLStuff.blockAcceleratorSolenoid)
							&& multiblocks[3][7][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[4][7][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[5][7][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[6][7][2].equals(DLStuff.blockAcceleratorSolenoid) && multiblocks[7][7][2].equals(DLStuff.blockAcceleratorSolenoid))
					{
						if (multiblocks[3][2][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[4][2][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[5][2][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[6][2][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[7][2][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][3][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][3][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][4][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][4][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][5][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][5][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter)
								&& multiblocks[2][6][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][6][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][7][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][7][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[3][8][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[4][8][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[5][8][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[6][8][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[7][8][1].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[3][2][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[4][2][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter)
								&& multiblocks[5][2][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[6][2][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[7][2][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][3][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][3][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][4][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][4][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][5][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][5][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][6][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][6][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter)
								&& multiblocks[2][7][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][7][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[3][8][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[4][8][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[5][8][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[6][8][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[7][8][0].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[3][2][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[4][2][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[5][2][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[6][2][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter)
								&& multiblocks[7][2][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][3][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][3][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][4][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][4][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][5][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][5][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][6][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][6][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[2][7][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[8][7][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter)
								&& multiblocks[3][8][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[4][8][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[5][8][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[6][8][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter) && multiblocks[7][8][2].equals(DLStuff.blockAcceleratorElectromagneticCalorimeter))
						{
							if (multiblocks[3][1][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[4][1][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[5][1][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[6][1][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[7][1][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][3][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][3][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][4][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][4][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][5][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][5][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][6][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][6][1].equals(DLStuff.blockAcceleratorHadronCalorimeter)
									&& multiblocks[1][7][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][7][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[3][9][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[4][9][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[5][9][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[6][9][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[7][9][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[2][2][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[8][2][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[2][8][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[8][8][1].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[3][1][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[4][1][0].equals(DLStuff.blockAcceleratorHadronCalorimeter)
									&& multiblocks[5][1][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[6][1][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[7][1][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][3][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][3][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][4][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][4][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][5][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][5][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][6][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][6][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][7][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][7][0].equals(DLStuff.blockAcceleratorHadronCalorimeter)
									&& multiblocks[3][9][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[4][9][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[5][9][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[6][9][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[7][9][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[2][2][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[8][2][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[2][8][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[8][8][0].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[3][1][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[4][1][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[5][1][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[6][1][2].equals(DLStuff.blockAcceleratorHadronCalorimeter)
									&& multiblocks[7][1][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][3][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][3][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][4][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][4][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][5][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][5][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][6][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][6][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[1][7][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[9][7][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[3][9][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[4][9][2].equals(DLStuff.blockAcceleratorHadronCalorimeter)
									&& multiblocks[5][9][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[6][9][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[7][9][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[2][2][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[8][2][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[2][8][2].equals(DLStuff.blockAcceleratorHadronCalorimeter) && multiblocks[8][8][2].equals(DLStuff.blockAcceleratorHadronCalorimeter))
							{
								if (multiblocks[5][5][2].equals(DLStuff.blockAcceleratorTube) && multiblocks[5][5][0].equals(DLStuff.blockAcceleratorTube))
								{
									if (multiblocks[3][0][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[4][0][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[5][0][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[6][0][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[7][0][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][3][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][3][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][4][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][4][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][5][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][5][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][6][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][6][1].equals(DLStuff.blockAcceleratorMuonDetector)
											&& multiblocks[0][7][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][7][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[3][10][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[4][10][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[5][10][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[6][10][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[7][10][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[2][1][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[1][2][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[8][1][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[9][2][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[1][8][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[2][9][1].equals(DLStuff.blockAcceleratorMuonDetector)
											&& multiblocks[8][9][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[9][8][1].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[3][0][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[4][0][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[5][0][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[6][0][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[7][0][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][3][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][3][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][4][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][4][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][5][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][5][0].equals(DLStuff.blockAcceleratorMuonDetector)
											&& multiblocks[0][6][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][6][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][7][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][7][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[3][10][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[4][10][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[5][10][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[6][10][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[7][10][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[2][1][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[1][2][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[8][1][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[9][2][0].equals(DLStuff.blockAcceleratorMuonDetector)
											&& multiblocks[1][8][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[2][9][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[8][9][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[9][8][0].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[3][0][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[4][0][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[5][0][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[6][0][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[7][0][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][3][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][3][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][4][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][4][2].equals(DLStuff.blockAcceleratorMuonDetector)
											&& multiblocks[0][5][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][5][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][6][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][6][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[0][7][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[10][7][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[3][10][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[4][10][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[5][10][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[6][10][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[7][10][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[2][1][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[1][2][2].equals(DLStuff.blockAcceleratorMuonDetector)
											&& multiblocks[8][1][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[9][2][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[1][8][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[2][9][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[8][9][2].equals(DLStuff.blockAcceleratorMuonDetector) && multiblocks[9][8][2].equals(DLStuff.blockAcceleratorMuonDetector))
									{
										//((TileEntityAcceleratorTube) worldObj.getTileEntity(xCoord, yCoord, zCoord + 1)).addDetector(((TileEntityAcceleratorTube) worldObj.getTileEntity(xCoord, yCoord, zCoord - 1)));
										isMultiblockComplete = true;
									} else
									{
										
										isMultiblockComplete = false;
									}
								} else
									isMultiblockComplete = false;
							} else
							{
								
								isMultiblockComplete = false;
							}
						} else
						{
							
							isMultiblockComplete = false;
						}
					} else
					{
						
						isMultiblockComplete = false;
					}
				} else
				{
					
					isMultiblockComplete = false;
				}
			}
		} else
		{
			
			isMultiblockComplete = false;
		}
	}
	
	public boolean isMultiblockComplete()
	{
		return isMultiblockComplete;
	}

	public boolean isPowered()
	{
		return isPowered;
	}
	
	public boolean isGoodForLaunch()
	{
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) != null)
			return isAcceleratorComplete() && isPowered;
		return false;
	}
	
	public boolean isAcceleratorComplete()
	{
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) != null && worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) != null
		&& worldObj.getTileEntity(xCoord, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord, yCoord, zCoord - 2) != null
		&& worldObj.getTileEntity(xCoord + 1, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 1, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 2, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 2, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 3, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 3, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 4, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 4, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 5, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 5, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 6, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 6, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 7, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 7, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 8, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 8, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 9, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 9, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 10, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 10, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 11, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 11, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 12, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 12, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 13, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 13, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 14, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 14, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 15, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 15, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 16, yCoord, zCoord + 2) != null && worldObj.getTileEntity(xCoord + 16, yCoord, zCoord + 2) != null
		&& worldObj.getTileEntity(xCoord + 16, yCoord, zCoord + 1) != null && worldObj.getTileEntity(xCoord + 16, yCoord, zCoord + 1) != null
		&& worldObj.getTileEntity(xCoord + 16, yCoord, zCoord) != null)
		{
			if(worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord, yCoord, zCoord - 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 1, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 1, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 2, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 2, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 3, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 3, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 4, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 4, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 5, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 5, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 6, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 6, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 7, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 7, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 8, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 8, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 9, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 9, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 10, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 10, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 11, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 11, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 12, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 12, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 13, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 13, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 14, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 14, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 15, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 15, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 16, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 16, yCoord, zCoord + 2) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 16, yCoord, zCoord + 1) instanceof TileEntityAcceleratorTube && worldObj.getTileEntity(xCoord + 16, yCoord, zCoord + 1) instanceof TileEntityAcceleratorTube
					&& worldObj.getTileEntity(xCoord + 16, yCoord, zCoord) instanceof TileEntityAcceleratorTube)
			{
				return true;
			}
		}
		return false;
	}

	public void setPowered(boolean isPowered)
	{
		this.isPowered = isPowered;
	}
}
