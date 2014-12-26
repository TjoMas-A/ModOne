package com.tjomas_a.modone.network;

import com.tjomas_a.modone.network.message.*;
import com.tjomas_a.modone.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

    public static void init()
    {
        INSTANCE.registerMessage(MessageMOTileEntity.class, MessageMOTileEntity.class, 0, Side.CLIENT);
        INSTANCE.registerMessage(MessageStoneChestTileEntity.class, MessageStoneChestTileEntity.class, 3, Side.CLIENT);
    }
}
