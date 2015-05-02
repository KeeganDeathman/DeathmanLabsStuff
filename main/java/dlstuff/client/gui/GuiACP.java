package keegan.dlstuff.client.gui;

import keegan.dlstuff.container.ContainerACP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiACP extends GuiContainer
{

	private ResourceLocation Tex;
	
	public GuiACP()
	{
		super(new ContainerACP());
		this.xSize = 256;
		this.ySize = 256;
		Tex = new ResourceLocation("dlstuff:textures/gui/acp.png");
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
