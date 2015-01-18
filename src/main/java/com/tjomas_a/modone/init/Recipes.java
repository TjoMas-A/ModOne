package com.tjomas_a.modone.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ModItems.flag), "wrw", "rrr", "wrw", 'w', new ItemStack(Blocks.wool, 1, 0), 'r', new ItemStack(Blocks.wool, 1, 14));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.healingStation), " f ", "fff", " ff", 'f', new ItemStack(ModItems.flag)));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.novaculiteTile, 4, 0), "nn ", "nn ", "   ", 'n', new ItemStack(ModBlocks.novaculite));
    }
}
