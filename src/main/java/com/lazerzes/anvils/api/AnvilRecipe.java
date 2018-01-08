package com.lazerzes.anvils.api;

import com.lazerzes.anvils.util.NBTHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;

import java.util.List;

public class AnvilRecipe {

    public ItemStack left, right, output;
    private final int cost;
    public boolean showRecipe;

    public AnvilRecipe(ItemStack left, ItemStack right, ItemStack output, int cost, boolean showRecipe){

        this.left = left;
        this.right = right;
        this.output = output;
        this.cost = cost;
        this.showRecipe = showRecipe;

    }

    public AnvilRecipe(ItemStack left, ItemStack right, Enchantment out, int enchantLevel, int cost, boolean showRecipe){

        ItemStack output = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(output, new EnchantmentData(out, enchantLevel));

        this.left = left;
        this.right = right;
        this.output = output;
        this.cost = cost;
        this.showRecipe = showRecipe;

    }

    public AnvilRecipe(Enchantment leftIn, int leftInLevel, ItemStack right, Enchantment out, int enchantLevel, int cost, boolean showRecipe){

        ItemStack left = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(left, new EnchantmentData(leftIn, leftInLevel));

        ItemStack output = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(output, new EnchantmentData(out, enchantLevel));

        this.left = left;
        this.right = right;
        this.output = output;
        this.cost = cost;
        this.showRecipe = showRecipe;

    }

    public ItemStack getOutput() {
        return this.output.copy();
    }

    public int getCost(){
        return this.cost;
    }

    public boolean hasInvalid(){
//
//        if(this == null){
//            return true;
//        }

        if(this.left == ItemStack.EMPTY || this.left.getCount() <= 0){
            return true;
        }

        if(this.right == ItemStack.EMPTY || this.right.getCount() <= 0){
            return true;
        }

        if(this.cost < 0){
            return false;
        }

        return false;

    }

    public boolean doItemStacksMatch(AnvilRecipe other){

        if(this.left.getItem() != other.left.getItem() || this.left.getCount() != other.left.getCount()) {
            return false;
        }

        if(this.right.getItem() != other.right.getItem() || this.right.getCount() != other.right.getCount()){
            return false;
        }

        return true;
    }

    public boolean doesNBTMatch(AnvilRecipe other){

        NBTTagCompound thisLeft = NBTHelper.getNBT(this.left), otherLeft = NBTHelper.getNBT(other.left);
        NBTTagCompound thisRight = NBTHelper.getNBT(this.right), otherRight = NBTHelper.getNBT(other.right);

        if(!thisLeft.equals(otherLeft)){
            return false;
        }

        if(!thisRight.equals(otherRight)){
            return false;
        }

        return true;

    }

    public boolean equals(AnvilRecipe other){

        if(this.hasInvalid() || other.hasInvalid()){
            return false;
        }

        if(!this.doItemStacksMatch(other)) {
            return false;
        }

        if(this.left.getItem() instanceof ItemEnchantedBook || this.right.getItem() instanceof ItemEnchantedBook){

            //Enchanted Book Special Handler Left
            if(this.left.getItem() instanceof ItemEnchantedBook){

                NBTTagList enchListA = ItemEnchantedBook.getEnchantments(this.left), enchListB = ItemEnchantedBook.getEnchantments(other.left);
                if(!enchListA.equals(enchListB)){
                    return false;
                }

            }

            //Enchanted Book Special Handler Right
            if(this.right.getItem() instanceof ItemEnchantedBook){

                NBTTagList enchListA = ItemEnchantedBook.getEnchantments(this.right), enchListB = ItemEnchantedBook.getEnchantments(other.right);
                if(!enchListA.equals(enchListB)){
                    return false;
                }

            }

        }else if(this.left.getItem() instanceof ItemPotion || this.right.getItem() instanceof ItemPotion){


            //Potion Special Handler Left
            if(this.left.getItem() instanceof ItemPotion){

                List<PotionEffect> effectsA = PotionUtils.getEffectsFromStack(this.left);
                List<PotionEffect> effectsB = PotionUtils.getEffectsFromStack(other.left);

                if(!effectsA.containsAll(effectsB)){
                    return false;
                }

            }

            //Potion Special Handler Right
            if(this.right.getItem() instanceof ItemPotion){

                List<PotionEffect> effectsA = PotionUtils.getEffectsFromStack(this.right);
                List<PotionEffect> effectsB = PotionUtils.getEffectsFromStack(other.right);

                if(!effectsA.containsAll(effectsB)){
                    return false;
                }

            }

        }else{
            if(!this.doesNBTMatch(other)) {
                return false;
            }

            if(this.left.getMetadata() != other.left.getMetadata() || this.right.getMetadata() != other.right.getMetadata()){
                return false;
            }
        }

        return true;

    }

    public static ItemStack getEnchantedBook(Enchantment enchIn, int levelIn){

        ItemStack enchBook = new ItemStack(Items.ENCHANTED_BOOK, 1);
        ItemEnchantedBook.addEnchantment(enchBook, new EnchantmentData(enchIn, levelIn));

        return enchBook;

    }

}
