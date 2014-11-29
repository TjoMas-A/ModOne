package com.tjomas_a.modone.handler;

import java.io.File;

import com.tjomas_a.modone.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler
{
    public static Configuration config;

    public static boolean testValue;
    public static int novaculiteAmount;

    public static void init(File configFile)
    {
        if(config == null)
        {
            config = new Configuration(configFile);
            loadConfiguration();
        }

    }

    private static void loadConfiguration()
    {
        testValue = config.get(Configuration.CATEGORY_GENERAL, "testValue", false, "Example config value").getBoolean(false);
        novaculiteAmount = config.get(Configuration.CATEGORY_GENERAL, "novaculiteAmount", 7, "Amount of novaculite generating in the world; use 0 for none.").getInt(7);

        if (config.hasChanged())
        {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent (ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

}
