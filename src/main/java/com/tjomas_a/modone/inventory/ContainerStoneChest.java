package com.tjomas_a.modone.inventory;

import com.tjomas_a.modone.tileentity.StoneChestTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerStoneChest extends ContainerMO
{
    public static final int STONE_CHEST_INVENTORY_ROWS = 3;
    public static final int STONE_CHEST_INVENTORY_COLUMNS = 9;
    public static final int STONE_CHEST_INVENTORY_SIZE = STONE_CHEST_INVENTORY_ROWS * STONE_CHEST_INVENTORY_COLUMNS;

    private StoneChestTileEntity stoneChestTileEntity;
    private int chestInventoryRows;
    private int chestInventoryColumns;

    public ContainerStoneChest(InventoryPlayer inventoryPlayer, StoneChestTileEntity stoneChestTileEntity)
    {
        this.stoneChestTileEntity = stoneChestTileEntity;
        stoneChestTileEntity.openInventory();

        if(this.stoneChestTileEntity.getState() == 0)
        {
            chestInventoryRows = STONE_CHEST_INVENTORY_ROWS;
            chestInventoryColumns = STONE_CHEST_INVENTORY_COLUMNS;
        }

        for (int chestRowIndex = 0; chestRowIndex < chestInventoryRows; ++chestRowIndex)
        {
            for (int chestColumnIndex = 0; chestColumnIndex < chestInventoryColumns; ++chestColumnIndex)
            {
                if (this.stoneChestTileEntity.getState() == 0)
                {
                    this.addSlotToContainer(new Slot(stoneChestTileEntity, chestColumnIndex + chestRowIndex * chestInventoryColumns,  8 + chestColumnIndex * 18, 18 + chestRowIndex * 18));
                }
            }
        }

        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex)
        {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex)
            {
                if (this.stoneChestTileEntity.getState() == 0)
                {
                    this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 35 + inventoryColumnIndex * 18, 104 + inventoryRowIndex * 18));
                }

            }
        }
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarSlotIndex)
        {
            if (this.stoneChestTileEntity.getState() == 0)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 35 + actionBarSlotIndex * 18, 162));
            }
        }
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer)
    {
        super.onContainerClosed(entityPlayer);
        stoneChestTileEntity.closeInventory();
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
    {
        ItemStack newItemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack = slot.getStack();
            newItemStack = itemStack.copy();

            if (slotIndex < chestInventoryRows * chestInventoryColumns)
            {
                if (!this.mergeItemStack(itemStack, chestInventoryRows * chestInventoryColumns, inventorySlots.size(), false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemStack, 0, chestInventoryRows * chestInventoryColumns, false))
            {
                return null;
            }

            if (itemStack.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return newItemStack;
    }
}