package com.lazerzes.anvils.intergration.jei;

import com.lazerzes.anvils.AnvilEnchantments;
import com.lazerzes.anvils.handler.AnvilRecipeHandler;
import com.lazerzes.anvils.api.anvil.AnvilRecipe;
import mezz.jei.api.*;


import java.util.ArrayList;
import java.util.Collections;


@JEIPlugin
public class AnvilEnchantmentsJEIPlugin implements IModPlugin{

    @Override
    public void register(IModRegistry registry){
        ArrayList<AnvilRecipe> internal = AnvilEnchantments.anvilRegistry.getRuntimeRecipes();

        for(AnvilRecipe rec : internal){
            if(rec.showRecipe){
                registry.addAnvilRecipe(rec.getAnvilLeft(), Collections.singletonList(rec.getAnvilRight()), Collections.singletonList(rec.getAnvilOutput()));
            }
        }
    }


}
