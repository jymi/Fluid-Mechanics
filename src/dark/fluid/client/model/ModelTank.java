// Date: 8/14/2012 1:48:41 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package dark.fluid.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class ModelTank extends ModelBase
{
    //One Block Tank
    ModelRenderer TANK_WALL_1;
    ModelRenderer TANK_WALL_2;
    ModelRenderer TANK_WALL_3;
    ModelRenderer TANK_WALL_4;
    ModelRenderer TANK_SUPPORT_1;
    ModelRenderer TANK_TOP_1;
    ModelRenderer TANK_WALL_5;
    ModelRenderer TANK_SUPPORT_2;
    ModelRenderer TANK_SUPPORT_3;
    ModelRenderer TANK_WALL_6;
    ModelRenderer TANK_TOP_2;
    ModelRenderer TANK_TOP_3;
    ModelRenderer TANK_VALVE;

    public ModelTank(float par1)
    {
        textureWidth = 128;
        textureHeight = 128;

        TANK_WALL_1 = new ModelRenderer(this, 0, 49);
        TANK_WALL_1.addBox(0F, 0F, 0F, 1, 12, 8, par1);
        TANK_WALL_1.setRotationPoint(6F, 12F, -4F);
        TANK_WALL_1.setTextureSize(128, 128);
        TANK_WALL_1.mirror = true;
        setRotation(TANK_WALL_1, 0F, 0F, 0F);
        TANK_WALL_2 = new ModelRenderer(this, 0, 70);
        TANK_WALL_2.addBox(0F, 0F, 0F, 1, 12, 7, par1);
        TANK_WALL_2.setRotationPoint(-8F, 12F, -4F);
        TANK_WALL_2.setTextureSize(128, 128);
        TANK_WALL_2.mirror = true;
        setRotation(TANK_WALL_2, 0F, 0F, 0F);
        TANK_WALL_3 = new ModelRenderer(this, 0, 34);
        TANK_WALL_3.addBox(0F, 0F, 0F, 8, 12, 1, par1);
        TANK_WALL_3.setRotationPoint(0F, 12F, 8F);
        TANK_WALL_3.setTextureSize(128, 128);
        TANK_WALL_3.mirror = true;
        setRotation(TANK_WALL_3, 0F, 2.617994F, 0F);
        TANK_WALL_4 = new ModelRenderer(this, 0, 34);
        TANK_WALL_4.addBox(0F, 0F, 0F, 8, 12, 1, par1);
        TANK_WALL_4.setRotationPoint(0F, 12F, -8F);
        TANK_WALL_4.setTextureSize(128, 128);
        TANK_WALL_4.mirror = true;
        setRotation(TANK_WALL_4, 0F, -0.5235988F, 0F);
        TANK_SUPPORT_1 = new ModelRenderer(this, 43, 22);
        TANK_SUPPORT_1.addBox(-1F, 0F, -8F, 2, 14, 16, par1);
        TANK_SUPPORT_1.setRotationPoint(0F, 10F, 0F);
        TANK_SUPPORT_1.setTextureSize(128, 128);
        TANK_SUPPORT_1.mirror = true;
        setRotation(TANK_SUPPORT_1, 0F, 0F, 0F);
        TANK_TOP_1 = new ModelRenderer(this, 43, 11);
        TANK_TOP_1.addBox(-8F, 0F, -4F, 16, 2, 8, par1);
        TANK_TOP_1.setRotationPoint(0F, 10F, 0F);
        TANK_TOP_1.setTextureSize(128, 128);
        TANK_TOP_1.mirror = true;
        setRotation(TANK_TOP_1, 0F, 0F, 0F);
        TANK_WALL_5 = new ModelRenderer(this, 0, 34);
        TANK_WALL_5.addBox(0F, 0F, 0F, 8, 12, 1, par1);
        TANK_WALL_5.setRotationPoint(0F, 12F, -7F);
        TANK_WALL_5.setTextureSize(128, 128);
        TANK_WALL_5.mirror = true;
        setRotation(TANK_WALL_5, 0F, -2.617994F, 0F);
        TANK_SUPPORT_2 = new ModelRenderer(this, 0, 0);
        TANK_SUPPORT_2.addBox(-1F, 0F, -9F, 2, 14, 18, par1);
        TANK_SUPPORT_2.setRotationPoint(0F, 10F, 0F);
        TANK_SUPPORT_2.setTextureSize(128, 128);
        TANK_SUPPORT_2.mirror = true;
        setRotation(TANK_SUPPORT_2, 0F, 1.047198F, 0F);
        TANK_SUPPORT_3 = new ModelRenderer(this, 0, 0);
        TANK_SUPPORT_3.addBox(-1F, 0F, -9F, 2, 14, 18, par1);
        TANK_SUPPORT_3.setRotationPoint(0F, 10F, 0F);
        TANK_SUPPORT_3.setTextureSize(128, 128);
        TANK_SUPPORT_3.mirror = true;
        setRotation(TANK_SUPPORT_3, 0F, -1.047198F, 0F);
        TANK_WALL_6 = new ModelRenderer(this, 0, 34);
        TANK_WALL_6.addBox(0F, 0F, 0F, 8, 12, 1, par1);
        TANK_WALL_6.setRotationPoint(0F, 12F, 7F);
        TANK_WALL_6.setTextureSize(128, 128);
        TANK_WALL_6.mirror = true;
        setRotation(TANK_WALL_6, 0F, 0.5235988F, 0F);
        TANK_TOP_2 = new ModelRenderer(this, 43, 0);
        TANK_TOP_2.addBox(-6F, 0F, -4F, 12, 2, 8, par1);
        TANK_TOP_2.setRotationPoint(0F, 10F, 0F);
        TANK_TOP_2.setTextureSize(128, 128);
        TANK_TOP_2.mirror = true;
        setRotation(TANK_TOP_2, 0F, 1.047198F, 0F);
        TANK_TOP_3 = new ModelRenderer(this, 43, 0);
        TANK_TOP_3.addBox(-6F, 0F, -4F, 12, 2, 8, par1);
        TANK_TOP_3.setRotationPoint(0F, 10F, 0F);
        TANK_TOP_3.setTextureSize(128, 128);
        TANK_TOP_3.mirror = true;
        setRotation(TANK_TOP_3, 0F, -1.047198F, 0F);
        TANK_VALVE = new ModelRenderer(this, 84, 0);
        TANK_VALVE.addBox(0F, 0F, 0F, 2, 1, 2, par1);
        TANK_VALVE.setRotationPoint(-1F, 9F, -1F);
        TANK_VALVE.setTextureSize(128, 128);
        TANK_VALVE.mirror = true;
        setRotation(TANK_VALVE, 0F, 0F, 0F);
    }

    public void generalRender(float f5)
    {
        TANK_WALL_1.render(f5);
        TANK_WALL_2.render(f5);
        TANK_WALL_3.render(f5);
        TANK_WALL_4.render(f5);
        TANK_SUPPORT_1.render(f5);
        TANK_TOP_1.render(f5);
        TANK_WALL_5.render(f5);
        TANK_SUPPORT_2.render(f5);
        TANK_SUPPORT_3.render(f5);
        TANK_WALL_6.render(f5);
        TANK_TOP_2.render(f5);
        TANK_TOP_3.render(f5);
        TANK_VALVE.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
