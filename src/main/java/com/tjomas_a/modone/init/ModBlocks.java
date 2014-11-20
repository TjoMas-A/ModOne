package com.tjomas_a.modone.init;

import com.tjomas_a.modone.block.BlockHealingStation;
import com.tjomas_a.modone.block.BlockMO;
import com.tjomas_a.modone.block.BlockNovaculite;
import com.tjomas_a.modone.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockMO healingStation = new BlockHealingStation();
    public static final BlockMO novaculite = new BlockNovaculite();

    public static void init()
    {
        GameRegistry.registerBlock(healingStation, "healingStation");
        GameRegistry.registerBlock(novaculite, "novaculite");
    }
}
