package com.lazerzes.anvils.intergration.jei;

import com.lazerzes.anvils.handler.AnvilRecipeHandler;
import com.lazerzes.anvils.recipe.AnvilRecipe;
import mezz.jei.api.*;


import java.util.ArrayList;
import java.util.Collections;


@JEIPlugin
public class AnvilEnchantmentsJEIPlugin implements IModPlugin{

    @Override
    public void register(IModRegistry registry){
        ArrayList<AnvilRecipe> internal = AnvilRecipeHandler.registeredRecipes;

        for(AnvilRecipe rec : internal){
            if(rec.showRecipe){
                registry.addAnvilRecipe(rec.getAnvilLeft(), Collections.singletonList(rec.getAnvilRight()), Collections.singletonList(rec.getAnvilOutput()));
            }
        }
    }


}
