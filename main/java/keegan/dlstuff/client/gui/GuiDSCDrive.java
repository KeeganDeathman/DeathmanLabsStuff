package keegan.dlstuff.client.gui;

import org.lwjgl.opengl.GL11;

import keegan.dlstuff.DLStuff;
import keegan.dlstuff.container.ContainerDSCDrive;
import keegan.dlstuff.items.ItemDiscoveryDrive;
import keegan.dlstuff.network.PacketDSCDrive;
import keegan.dlstuff.recipes.*;
import keegan.dlstuff.tileentity.DSCDrive;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

public class GuiDSCDrive extends GuiContainer
{

	private ResourceLocation Tex;
	private DSCDrive tile;
	
	public GuiDSCDrive(InventoryPlayer inv, DSCDrive te)
	{
		super(new ContainerDSCDrive(inv,te));
		tile = te;
		Tex = new ResourceLocation("dlstuff:textures/gui/dscdrive.png");
		this.xSize = 256;
		this.ySize = this.xSize;
	}

	@Override
	public void handleMouseClick(Slot slot, int x, int y, int theotherthing)
	{
		super.handleMouseClick(slot, x, y, theotherthing);
		if(slot != null && slot.getStack() != null)
		{
			System.out.println("1");
			if(slot.getStack().getItem() instanceof ItemDiscoveryDrive)
			{
				System.out.println("2");
				AcceleratorDiscovery dis;
				for(AcceleratorDiscovery d : DLRecipes.accelDiscoveries)
				{
					System.out.println("3");
					if(d.getDiscoveryFlashDrive().getItem().equals(slot.getStack().getItem()))
					{
						dis = d;
						System.out.println("4");
						DLStuff.packetPipeline.sendToServer(new PacketDSCDrive(dis,tile.xCoord, tile.yCoord, tile.zCoord));
					}
				}
			}

		}
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(Tex);
		int x = (this.width - 256) / 2;
		int y = (this.height - 256) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, 256, 256);
	}

}
