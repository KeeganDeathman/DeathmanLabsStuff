package keegan.dlstuff.client.gui.laptop;

import org.lwjgl.opengl.GL11;

import keegan.dlstuff.container.laptop.ContainerDLLaptop;
import keegan.dlstuff.tileentity.TileEntityDLLaptop;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiDLLaptop extends GuiContainer
{
	
	private TileEntityDLLaptop tile;
	private EntityPlayer player;
	private ResourceLocation Tex = new ResourceLocation("dlstuff:textures/gui/laptop/desktop.png");
	private boolean startMenu = false;
	private int menuXSize = 512;
	private int menuYSize = 512;
	
	public GuiDLLaptop(TileEntityDLLaptop te, InventoryPlayer inv, EntityPlayer player) 
	{
		super(new ContainerDLLaptop(inv, te));
		tile = te;
		this.xSize = 256;
		this.ySize = 256;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int par3)
	{
		

		int x = (this.width - xSize) / 2;
		int y = (this.height - ySize) / 2;
		int texX = mouseX - x;
		int texY = mouseY - y;
		System.out.println(x + "," + y);
		if(mouseX >= x && mouseX <= x+xSize && mouseY >= y && mouseY <= y+ySize)
		{
			//Start button
			if(texX > 2 && texX < 17 && texY > 239 && texY < 1018)
			{
				System.out.println("Start button pressed");
				if(startMenu)
				{
					startMenu = false;
				}
				else if(!startMenu)
				{
					startMenu = true;
				}
			}
			if(texX>3 && texX < 56 && startMenu && texY > 159 && texY < 169)
			{
				System.out.println("GO INTERWEBZ!");
			}
			System.out.println(mouseX + "," + mouseY);
			System.out.println(texX + "," + texY);
		}
	}
	

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		if(startMenu)
		{
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			
			this.mc.renderEngine.bindTexture(new ResourceLocation("dlstuff:textures/gui/laptop/startmenu.png"));
	    	if(xSize == 512)
	    	{
	    		GL11.glScalef(menuXSize/512,menuYSize/512,0f);
	    		menuXSize=512;
	    		menuYSize=512;
	    	}
	    	if(xSize == 256)
	    	{
	    		GL11.glScalef(menuXSize/256,menuYSize/256,0f);
	    		menuXSize=256;
	    		menuYSize=256;
	    	}
	    	int x = (this.width - menuXSize) / 2;
			int y = (this.height - menuYSize) / 2;
			
			this.drawTexturedModalRect(0, 0, 0, 0, menuXSize, menuYSize);
		}
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	this.mc.renderEngine.bindTexture(Tex);
    	if(width < xSize || height < ySize)
    	{
    		GL11.glScalef(xSize/512, ySize/512, 0f);
    		ySize = 512;
    		xSize = 512;
    		if(width < xSize || height < ySize)
    		{
    			GL11.glScalef(xSize/256, ySize/256, 0f);
    			xSize = 256;
    			ySize = 256;
    		}
    	}
    	int x = (this.width - xSize) / 2;
		int y = (this.height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
