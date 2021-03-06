package dark.fluid.client.render;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dark.core.client.renders.RenderMachine;
import dark.core.prefab.helpers.ConnectionHelper;
import dark.fluid.client.model.ModelCenterTank;
import dark.fluid.client.model.ModelCornerTank;
import dark.fluid.client.model.ModelTank;
import dark.fluid.common.FluidMech;
import dark.fluid.common.machines.TileEntityBoiler;
@SideOnly(Side.CLIENT)
public class RenderBoiler extends RenderMachine
{
    int type = 0;
    private ModelTank model;
    private ModelCenterTank model2;
    private ModelCornerTank model3;

    public RenderBoiler(float par1)
    {
        model = new ModelTank(par1);
        model2 = new ModelCenterTank(par1);
        model3 = new ModelCornerTank(par1);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float d3)
    {

        GL11.glPushMatrix();
        GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        TileEntity[] connected = ((TileEntityBoiler) tileEntity).connectedBlocks;
        int meta = 0;
        if (connected[5] == null && connected[3] == null && connected[4] == null && connected[2] == null || ((TileEntityBoiler) tileEntity).tankCount < 2)
        {
            bindTextureByName(FluidMech.instance.PREFIX, FluidMech.MODEL_DIRECTORY + "tankTexture.png");
            model.generalRender(0.0625F);
        }
        else if (ConnectionHelper.corner(tileEntity) == 0 || ((TileEntityBoiler) tileEntity).tankCount > 2)
        {
            bindTextureByName(FluidMech.instance.PREFIX, FluidMech.MODEL_DIRECTORY + "tankBlock.png");
            model2.renderBlock(0.0625F);
        }
        else
        {
            int corner = ConnectionHelper.corner(tileEntity);
            bindTextureByName(FluidMech.instance.PREFIX, FluidMech.MODEL_DIRECTORY + "CornerTank.png");
            switch (corner)
            {
                case 1:
                    GL11.glRotatef(270f, 0f, 1f, 0f);
                    break;
                case 2:
                    GL11.glRotatef(0f, 0f, 1f, 0f);
                    break;
                case 3:
                    GL11.glRotatef(90f, 0f, 1f, 0f);
                    break;
                case 4:
                    GL11.glRotatef(180f, 0f, 1f, 0f);
                    break;
            }
            model3.renderCorner(0.0625f);

        }
        GL11.glPopMatrix();
    }

    @Override
    public ResourceLocation getTexture(int block, int meta)
    {
        // TODO Auto-generated method stub
        return null;
    }

}