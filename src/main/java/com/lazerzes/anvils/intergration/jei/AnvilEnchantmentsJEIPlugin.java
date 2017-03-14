package com.lazerzes.anvils.intergration.jei;

import com.lazerzes.anvils.api.AnvilRecipe;
import com.lazerzes.anvils.api.AnvilRecipes;
import mezz.jei.api.*;


import java.util.ArrayList;
import java.util.Collections;


@JEIPlugin
public class AnvilEnchantmentsJEIPlugin extends BlankModPlugin{

    @Override
    public void register(IModRegistry registry){

        ArrayList<AnvilRecipe> internal = AnvilRecipes.getRecipes();

        for(AnvilRecipe rec : internal){
            if(rec.showRecipe) {
                registry.addAnvilRecipe(rec.left, Collections.singletonList(rec.right), Collections.singletonList(rec.output));
            }
        }

    }


}
