package com.lazerzes.anvils.recipe;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;

public class AnvilRecipe {

    protected ItemStack anvilLeft;
    protected ItemStack anvilRight;
    protected ItemStack anvilOutput;
    protected int anvilLevelCost;


    public AnvilRecipe(ItemStack left, ItemStack right, ItemStack output, int cost){

        anvilLeft = left;
        anvilRight = right;
        anvilOutput = output;
        anvilLevelCost = cost;

    }

    public AnvilRecipe(ItemStack left, ItemStack right, Enchantment out, int enchantLevel, int cost){

        ItemStack output = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(output, new EnchantmentData(out, enchantLevel));

        anvilLeft = left;
        anvilRight = right;
        anvilOutput = output;
        anvilLevelCost = cost;

    }



    public boolean check(ItemStack left, ItemStack right){

        //Check if stack requirement is met.
        if( !(left.getCount() >= anvilLeft.getCount() && right.getCount() >= anvilRight.getCount())){ return false; }

        return true;

    }

    public ItemStack getAnvilOutput(){

        return anvilOutput.copy();

    }

    public int getAnvilLevelCost(){
        return anvilLevelCost;
    }


}
