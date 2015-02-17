package keegan.dlstuff.client.gui.laptop;

import keegan.dlstuff.container.laptop.ContainerDLLaptopDrives;
import keegan.dlstuff.tileentity.TileEntityDLLaptop;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiDLLaptopDrives extends GuiContainer
{
	
	ResourceLocation Tex = new ResourceLocation("dlstuff:textures/gui/laptop/drives.png");

	public GuiDLLaptopDrives(TileEntityDLLaptop te, InventoryPlayer inv, EntityPlayer player) 
	{
		super(new ContainerDLLaptopDrives(inv, te));
		this.xSize = 512;
		this.ySize = 512;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1,int arg2) 
	{
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    	this.mc.renderEngine.bindTexture(Tex);
	    	int x = (this.width - xSize) / 2;
			int y = (this.height - ySize) / 2;
			this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
	}

}
