package com.tjomas_a.modone.init;

import com.tjomas_a.modone.reference.Names;
import com.tjomas_a.modone.tileentity.StoneChestTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(StoneChestTileEntity.class, Names.Blocks.CHEST);
    }
}
