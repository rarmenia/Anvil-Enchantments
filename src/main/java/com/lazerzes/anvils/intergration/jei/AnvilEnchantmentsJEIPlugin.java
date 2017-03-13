package com.lazerzes.anvils.intergration.jei;

import com.lazerzes.anvils.api.AnvilRecipe;
import com.lazerzes.anvils.api.AnvilRecipes;
import com.lazerzes.anvils.intergration.jei.subtypes.EnchantedBookSubtypeInterpreter;
import com.lazerzes.anvils.intergration.jei.subtypes.PotionSubtypeInterpreter;
import com.sun.istack.internal.NotNull;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JEIPlugin
public class AnvilEnchantmentsJEIPlugin extends BlankModPlugin{

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry){
        subtypeRegistry.registerSubtypeInterpreter(Items.ENCHANTED_BOOK, EnchantedBookSubtypeInterpreter.INSTANCE);
        subtypeRegistry.registerSubtypeInterpreter(Items.POTIONITEM, PotionSubtypeInterpreter.INSTANCE);
        subtypeRegistry.registerSubtypeInterpreter(Items.SPLASH_POTION, PotionSubtypeInterpreter.INSTANCE);
        subtypeRegistry.registerSubtypeInterpreter(Items.LINGERING_POTION, PotionSubtypeInterpreter.INSTANCE);
    }



    @Override
    public void register(@NotNull IModRegistry registry){

        IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();

        ArrayList<AnvilRecipe> internal = AnvilRecipes.getRecipes();

        for(AnvilRecipe rec : internal){
            if(rec.showRecipe) {
                registry.addAnvilRecipe(rec.left, Collections.singletonList(rec.right), Collections.singletonList(rec.output));
            }
        }

    }


}
