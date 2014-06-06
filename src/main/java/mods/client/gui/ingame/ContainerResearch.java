package mods.client.gui.ingame;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerResearch extends Container
{
    public ContainerResearch(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
    {
        this.addSlotToContainer(new Slot(par1InventoryPlayer, 0, 124, 35));
        int l;
        int i1;

        for (l = 0; l < 3; ++l)
        {
            for (i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        for (l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, l, 8 + l * 18, 142));
        }

    }


    /**
     * Called when the container is closed.
     */
    @Override
	public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        super.onContainerClosed(par1EntityPlayer);
    }

    @Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
		return true;
        //return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != Blocks.crafting_table ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }

    @Override
	public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot)
    {
        return true;
    }
}