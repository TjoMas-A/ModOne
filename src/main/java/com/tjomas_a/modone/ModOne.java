package com.tjomas_a.modone;

import com.tjomas_a.modone.handler.ConfigurationHandler;
import com.tjomas_a.modone.init.ModBlocks;
import com.tjomas_a.modone.init.ModItems;
import com.tjomas_a.modone.init.Recipes;
import com.tjomas_a.modone.proxy.IProxy;
import com.tjomas_a.modone.reference.Reference;
import com.tjomas_a.modone.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid= Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class ModOne
{
    @Mod.Instance(Reference.MOD_ID)
    public static ModOne instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
        ModBlocks.init();
        LogHelper.info("Pre-Init Complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();
        LogHelper.info("Init Complete");
        GameRegistry.registerWorldGenerator(new WorldGenNova(ModBlocks.novaculite, 32, ConfigurationHandler.novaculiteAmount), 1000);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post-Init Complete");
    }
}