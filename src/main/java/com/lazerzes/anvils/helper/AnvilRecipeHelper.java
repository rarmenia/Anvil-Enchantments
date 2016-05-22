package com.lazerzes.anvils.helper;
//created by lazerzes

import com.lazerzes.anvils.library.AnvilRecipes;
import net.minecraft.item.ItemStack;

public class AnvilRecipeHelper {

    public static AnvilRecipes.AnvilRecipe getResult(ItemStack left, ItemStack right){

        System.out.println("Left: " + left);
        System.out.println("Right: " + right);

        for(AnvilRecipes.AnvilRecipe recipe : AnvilRecipes.anvilRecipes){

            System.out.println("Rec Left: " + recipe.left);
            System.out.println("Rec Right: " + recipe.right);

            if(left.getItem() == recipe.left.getItem() && right.getItem() == recipe.right.getItem()){

                if(left.stackSize == recipe.left.stackSize && right.stackSize == recipe.right.stackSize){

                    return recipe;

                }

            }

        }

        return null;

    }

}
