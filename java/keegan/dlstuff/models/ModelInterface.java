package keegan.dlstuff.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelInterface extends ModelBase
{
  //fields
    ModelRenderer Projector;
    ModelRenderer Screen;
  
  public ModelInterface()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Projector = new ModelRenderer(this, 0, 0);
      Projector.addBox(0F, 0F, 0F, 14, 1, 14);
      Projector.setRotationPoint(-7F, 23F, -7F);
      Projector.setTextureSize(128, 64);
      Projector.mirror = true;
      setRotation(Projector, 0F, 0F, 0F);
      Screen = new ModelRenderer(this, 0, 35);
      Screen.addBox(0F, 0F, 0F, 1, 6, 4);
      Screen.setRotationPoint(7F, -3F, -2F);
      Screen.setTextureSize(128, 64);
      Screen.mirror = true;
      setRotation(Screen, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Projector.render(f5);
    Screen.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
  }

}
