package keegan.dlstuff.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.Entity;

public class ModelABRID extends ModelBase
{
  //fields
    ModelRenderer Reactor;
    ModelRenderer Chemical;
    ModelRenderer Paladium;
    ModelRenderer Arc_Input;
    ModelRenderer Output;
  
  public ModelABRID()
  {
    textureWidth = 512;
    textureHeight = 256;
    
      Reactor = new ModelRenderer(this, 0, 0);
      Reactor.addBox(0F, 0F, 0F, 80, 48, 80);
      Reactor.setRotationPoint(-8F, -24F, -8F);
      Reactor.setTextureSize(512, 256);
      Reactor.mirror = true;
      setRotation(Reactor, 0F, 0F, 0F);
      Chemical = new ModelRenderer(this, 423, 29);
      Chemical.addBox(0F, 0F, 0F, 40, 24, 1);
      Chemical.setRotationPoint(12F, -12F, 72F);
      Chemical.setTextureSize(512, 256);
      Chemical.mirror = true;
      setRotation(Chemical, 0F, 0F, 0F);
      Paladium = new ModelRenderer(this, 350, 50);
      Paladium.addBox(0F, 0F, 0F, 1, 24, 40);
      Paladium.setRotationPoint(-9F, -12F, 12F);
      Paladium.setTextureSize(512, 256);
      Paladium.mirror = true;
      setRotation(Paladium, 0F, 0F, 0F);
      Arc_Input = new ModelRenderer(this, 350, 89);
      Arc_Input.addBox(0F, 0F, 0F, 1, 24, 40);
      Arc_Input.setRotationPoint(72F, -12F, 12F);
      Arc_Input.setTextureSize(512, 256);
      Arc_Input.mirror = true;
      setRotation(Arc_Input, 0F, 0F, 0F);
      Output = new ModelRenderer(this, 350, 0);
      Output.addBox(0F, 0F, 0F, 40, 24, 1);
      Output.setRotationPoint(12F, -12F, -9F);
      Output.setTextureSize(512, 256);
      Output.mirror = true;
      setRotation(Output, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Reactor.render(f5);
    Chemical.render(f5);
    Paladium.render(f5);
    Arc_Input.render(f5);
    Output.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
