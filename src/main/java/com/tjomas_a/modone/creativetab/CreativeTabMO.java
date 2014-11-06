package com.tjomas_a.modone.creativetab;

import com.tjomas_a.modone.init.ModBlocks;
import com.tjomas_a.modone.init.ModItems;
import com.tjomas_a.modone.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMO
{
    public static final CreativeTabs MO_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.flag;
        }
    };
}
