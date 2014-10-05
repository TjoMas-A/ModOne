package com.tjomas_a.modone.init;

import com.tjomas_a.modone.item.ItemFlag;
import com.tjomas_a.modone.item.ItemMO;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static final ItemMO flag = new ItemFlag();

    public static void init()
    {
        GameRegistry.registerItem(flag, "flag");
    }
}
