package keegan.dlstuff.client.gui;

import org.lwjgl.opengl.GL11;

import keegan.dlstuff.container.ContainerAcceleratorInterface;
import keegan.dlstuff.tileentity.TileEntityAcceleratorInterface;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiAcceleratorInterface extends GuiContainer
{
	
	private ResourceLocation Tex;

	public GuiAcceleratorInterface(InventoryPlayer inv, TileEntityAcceleratorInterface tile)
	{
		super(new ContainerAcceleratorInterface(inv, tile));
		this.xSize = 256;
		this.ySize = 256;
		Tex = new ResourceLocation("dlstuff:textures/gui/acceleratorInterface.png");
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(Tex);
		int x = (this.width - xSize) / 2;
		int y = (this.height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
