package com.tjomas_a.modone.handler;

import com.tjomas_a.modone.client.gui.*;
import com.tjomas_a.modone.inventory.*;
import com.tjomas_a.modone.reference.GUIs;
import com.tjomas_a.modone.tileentity.*;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        if (id == GUIs.STONE_CHEST.ordinal())
        {
            StoneChestTileEntity stoneChestTileEntity = (StoneChestTileEntity) world.getTileEntity(x, y, z);
            return new ContainerStoneChest(entityPlayer.inventory, stoneChestTileEntity);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        if (id == GUIs.STONE_CHEST.ordinal())
        {
            StoneChestTileEntity stoneChestTileEntity = (StoneChestTileEntity) world.getTileEntity(x, y, z);
            return new GuiStoneChest(entityPlayer.inventory, stoneChestTileEntity);
        }

        return null;
    }
}
