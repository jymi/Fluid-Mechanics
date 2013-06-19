package dark.fluid.common.pipes;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidStack;
import universalelectricity.core.vector.Vector3;
import universalelectricity.core.vector.VectorHelper;
import dark.core.api.ColorCode;
import dark.core.hydraulic.helpers.FluidHelper;
import dark.core.network.fluid.NetworkPipes;

public class TileEntityGenericPipe extends TileEntityPipe
{
	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill)
	{
		if (resource == null)
		{
			return 0;
		}
		TileEntity tile = VectorHelper.getTileEntityFromSide(this.worldObj, new Vector3(this), from);
		return ((NetworkPipes) this.getTileNetwork()).addFluidToNetwork(tile, resource, doFill);
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill)
	{
		if (tankIndex != 0 || resource == null)
		{
			return 0;
		}
		return ((NetworkPipes) this.getTileNetwork()).addFluidToNetwork(this, resource, doFill);
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type)
	{
		return this.fakeTank;
	}

	@Override
	public boolean canTileConnect(TileEntity entity, ForgeDirection dir)
	{
		Vector3 vec = new Vector3(entity);
		int meta = vec.getBlockMetadata(this.worldObj);
		int blockID = vec.getBlockID(this.worldObj);

		if (entity instanceof TileEntityPipe && blockID == this.getBlockType().blockID)
		{
			return meta == this.getBlockMetadata();
		}

		return super.canTileConnect(entity, dir);
	}

	@Override
	public int getMaxFlowRate(LiquidStack stack, ForgeDirection side)
	{
		return FluidHelper.getDefaultFlowRate(stack);
	}

	@Override
	public ColorCode getColor()
	{
		return ColorCode.NONE;
	}
}