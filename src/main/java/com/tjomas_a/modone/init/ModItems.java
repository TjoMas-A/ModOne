package com.tjomas_a.modone.init;

import com.tjomas_a.modone.item.ItemFlag;
import com.tjomas_a.modone.item.ItemMO;
import com.tjomas_a.modone.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemMO flag = new ItemFlag();

    public static void init()
    {
        GameRegistry.registerItem(flag, "flag");
    }
}
