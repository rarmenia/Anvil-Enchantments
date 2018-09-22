package com.lazerzes.anvils.api.anvil;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;

public class AnvilRecipe {

    public String recipeName;
    protected ItemStack anvilLeft;
    protected ItemStack anvilRight;
    protected ItemStack anvilOutput;
    protected int anvilLevelCost;
    public boolean showRecipe;


    public AnvilRecipe(ItemStack left, ItemStack right, ItemStack output, int cost, String name){

        anvilLeft = left;
        anvilRight = right;
        anvilOutput = output;
        anvilLevelCost = cost;
        showRecipe = true;
        recipeName = name;

    }

    public AnvilRecipe(ItemStack left, ItemStack right, Enchantment out, int enchantLevel, int cost, String name){

        ItemStack output = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(output, new EnchantmentData(out, enchantLevel));

        anvilLeft = left;
        anvilRight = right;
        anvilOutput = output;
        anvilLevelCost = cost;
        showRecipe = true;
        recipeName = name;

    }

    public AnvilRecipe(Enchantment leftIn, int leftInLevel, ItemStack right, Enchantment out, int enchantLevel, int cost, String name){

        ItemStack left = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(left, new EnchantmentData(leftIn, leftInLevel));

        ItemStack output = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(output, new EnchantmentData(out, enchantLevel));

        anvilLeft = left;
        anvilRight = right;
        anvilOutput = output;
        anvilLevelCost = cost;
        showRecipe = true;
        recipeName = name;

    }

    public AnvilRecipe(ItemStack left, ItemStack right, ItemStack output, int cost, boolean show, String name){

        anvilLeft = left;
        anvilRight = right;
        anvilOutput = output;
        anvilLevelCost = cost;
        showRecipe = show;
        recipeName = name;

    }

    public AnvilRecipe(ItemStack left, ItemStack right, Enchantment out, int enchantLevel, int cost, boolean show, String name){

        ItemStack output = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(output, new EnchantmentData(out, enchantLevel));

        anvilLeft = left;
        anvilRight = right;
        anvilOutput = output;
        anvilLevelCost = cost;
        showRecipe = show;
        recipeName = name;

    }

    public AnvilRecipe(Enchantment leftIn, int leftInLevel, ItemStack right, Enchantment out, int enchantLevel, int cost, boolean show, String name){

        ItemStack left = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(left, new EnchantmentData(leftIn, leftInLevel));

        ItemStack output = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(output, new EnchantmentData(out, enchantLevel));

        anvilLeft = left;
        anvilRight = right;
        anvilOutput = output;
        anvilLevelCost = cost;
        showRecipe = show;
        recipeName = name;

    }



    public boolean check(ItemStack left, ItemStack right){

        //Check if stack requirement is met.
        if( !(left.getCount() == anvilLeft.getCount() && right.getCount() >= anvilRight.getCount())){ return false; }

        if( !(left.getItem().equals(anvilLeft.getItem()) && right.getItem().equals(anvilRight.getItem()))){return false;}

        //Check if item Metadata is the same.
        if( !(left.getMetadata() == anvilLeft.getMetadata() && right.getMetadata() == anvilRight.getMetadata()))

        //Check if item BASELINE NBTs are the same.]
        if( !(ItemStack.areItemStackTagsEqual(left, anvilLeft) && ItemStack.areItemStacksEqual(right, anvilRight))){ return false; }

        //Enchanted Book Special Handler Left
        if(left.getItem() instanceof ItemEnchantedBook){

            NBTTagList enchListA = ItemEnchantedBook.getEnchantments(left), enchListB = ItemEnchantedBook.getEnchantments(anvilLeft);
            if(!enchListA.equals(enchListB)){
                return false;
            }

        }

        //Enchanted Book Special Handler Right
        if(right.getItem() instanceof ItemEnchantedBook){

            NBTTagList enchListA = ItemEnchantedBook.getEnchantments(right), enchListB = ItemEnchantedBook.getEnchantments(anvilRight);
            if(!enchListA.equals(enchListB)){
                return false;
            }

        }


        return true;

    }

    public ItemStack getAnvilLeft() {
        return anvilLeft.copy();
    }

    public ItemStack getAnvilRight() {
        return anvilRight.copy();
    }

    public ItemStack getAnvilOutput(){

        return anvilOutput.copy();

    }

    public int getAnvilLevelCost(){
        return anvilLevelCost;
    }

    public int getMaterialCost(){
        return anvilRight.copy().getCount();
    }

    public String getRecipeName(){

        if(recipeName == null || recipeName == ""){
            return anvilOutput.getDisplayName();
        }

        return recipeName;

    }


}
