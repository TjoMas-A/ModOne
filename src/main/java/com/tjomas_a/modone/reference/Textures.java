package com.tjomas_a.modone.reference;

import com.tjomas_a.modone.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static final class Gui
    {
        private static final String GUI_SHEET_LOCATION = "textures/gui/";
        public static final ResourceLocation STONE_CHEST = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "stoneChestGUI.png");
    }
}
