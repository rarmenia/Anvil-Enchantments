package com.lazerzes.anvils.helper;
//created by lazerzes

import com.lazerzes.anvils.AnvilRecipe;
import com.lazerzes.anvils.library.AnvilRecipes;
import net.minecraft.item.ItemStack;

public class AnvilRecipeHelper {

   public static AnvilRecipe getResult(AnvilRecipe recipeIn){

       for (AnvilRecipe recipe : AnvilRecipes.getRecipes()){

           if(recipeIn.matchesRecipe(recipe)){
               return recipe;
           }

       }

       return null;

   }

}
