package com.tjomas_a.modone.init;

import com.tjomas_a.modone.block.*;
import com.tjomas_a.modone.reference.Names;
import com.tjomas_a.modone.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockMO healingStation = new BlockHealingStation();
    public static final BlockMO novaculite = new BlockNovaculite();
    public static final BlockMO stoneChest = new BlockStoneChest();
    public static final BlockMO novaculiteTile = new BlockNovaculiteTile();

    public static void init()
    {
        GameRegistry.registerBlock(healingStation, Names.Blocks.HEAL);
        GameRegistry.registerBlock(novaculite, Names.Blocks.NOVA);
        GameRegistry.registerBlock(stoneChest, Names.Blocks.CHEST);
        GameRegistry.registerBlock(novaculiteTile, Names.Blocks.NOVA_TILE);
    }
}
