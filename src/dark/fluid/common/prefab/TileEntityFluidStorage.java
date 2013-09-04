package dark.fluid.common.prefab;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import dark.core.interfaces.ColorCode.IColorCoded;
import dark.core.prefab.helpers.FluidHelper;

public abstract class TileEntityFluidStorage extends TileEntityFluidDevice implements IFluidHandler, IColorCoded
{

    public FluidTank fluidTank = new FluidTank(this.getTankSize());

    @Override
    public String getMeterReading(EntityPlayer user, ForgeDirection side, EnumTools tool)
    {
        if (tool != EnumTools.PIPE_GUAGE)
        {
            return null;
        }
        if (this.getTank().getFluid() == null)
        {
            return "Empty";
        }
        return String.format("%d/%d %S Stored", getTank().getFluid().amount / FluidContainerRegistry.BUCKET_VOLUME, this.getTank().getCapacity() / FluidContainerRegistry.BUCKET_VOLUME, getTank().getFluid().getFluid().getLocalizedName());
    }

    @Override
    public boolean canTileConnect(TileEntity entity, ForgeDirection dir)
    {
        return entity instanceof IFluidHandler;
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill)
    {
        if (resource == null || resource.getFluid() == null || !FluidHelper.isValidLiquid(getColor(), resource.getFluid()))
        {
            return 0;
        }
        else if (this.getTank().getFluid() != null && !resource.isFluidEqual(this.getTank().getFluid()))
        {
            return 0;
        }
        return this.getTank().fill(resource, doFill);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
    {
        if (this.getTank().getFluid() == null)
        {
            return null;
        }
        FluidStack stack = this.getTank().getFluid();
        if (maxDrain < stack.amount)
        {
            stack = FluidHelper.getStack(stack, maxDrain);
        }
        return this.getTank().drain(maxDrain, doDrain);
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from)
    {
        if (this.getTank() != null)
        {
            return new FluidTankInfo[] { new FluidTankInfo(this.getTank()) };
        }
        return new FluidTankInfo[1];
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        if (nbt.hasKey("stored"))
        {
            NBTTagCompound tag = nbt.getCompoundTag("stored");
            String name = tag.getString("LiquidName");
            int amount = nbt.getInteger("Amount");
            Fluid fluid = FluidRegistry.getFluid(name);
            if (fluid != null)
            {
                FluidStack liquid = new FluidStack(fluid, amount);
                getTank().setFluid(liquid);
            }
        }
        else
        {
            //System.out.println("Loading fluid tank");
            getTank().readFromNBT(nbt.getCompoundTag("FluidTank"));
            //System.out.println("Tank: "+ (getTank().getFluid() != null ? getTank().getFluid().fluidID +"@"+getTank().getFluid().amount+"mb" : "Empty"));

        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        if (this.getTank() != null)
        {
            //System.out.println("Saving fluid tank");
            //System.out.println("Tank: "+ (getTank().getFluid() != null ? getTank().getFluid().fluidID +"@"+getTank().getFluid().amount+"mb" : "Empty"));
            nbt.setCompoundTag("FluidTank", this.getTank().writeToNBT(new NBTTagCompound()));
        }
    }

    /** Is the internal tank full */
    public boolean isFull()
    {
        return this.getTank().getFluid() != null && this.getTank().getFluid().amount >= this.getTank().getCapacity();
    }

    /** gets the liquidStack stored in the internal tank */
    public FluidStack getStoredLiquid()
    {
        return this.getTank().getFluid();
    }

    public FluidTank getTank()
    {
        if (this.fluidTank == null)
        {
            this.fluidTank = new FluidTank(this.getTankSize());
        }
        return this.fluidTank;
    }

    /** gets the max storage limit of the tank */
    public abstract int getTankSize();

}