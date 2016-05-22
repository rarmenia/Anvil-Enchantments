package com.lazerzes.anvils;
//created by lazerzes

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AnvilRecipe {

    private ItemStack left, right, output;
    private int cost;
    public boolean showInBook;

    public AnvilRecipe(ItemStack left, ItemStack right, ItemStack output, int cost, boolean showInBook){

        this.left = left;
        this.right = right;
        this.output = output;
        this.cost = cost;
        this.showInBook = showInBook;

    }

    public AnvilRecipe(ItemStack left, ItemStack right, Enchantment out, int enchantLevel, int cost, boolean showInBook){

        ItemStack output = new ItemStack(Items.enchanted_book, 1);
        output.addEnchantment(out, enchantLevel);

        this.left = left;
        this.right = right;
        this.output = output;
        this.cost = cost;
        this.showInBook = showInBook;

    }

    public AnvilRecipe(ItemStack left, ItemStack right){

        this.left = left;
        this.right = right;

    }

    public ItemStack getLeft(){ return left; }
    public ItemStack getRight(){ return right; }
    public ItemStack getOutput(){ return output; }
    public int getCost(){ return cost; }

    public void setLeft(ItemStack left){ this.left = left; }
    public void setRight(ItemStack right){ this.right = right; }
    public void setOutput(ItemStack output){ this.output = output; }
    public void setCost(int cost){ this.cost = cost; }

    public boolean matchesRecipe(AnvilRecipe other){

        if(stacksSame(this.left, other.left) && stacksSame(this.right, other.right)){
            return true;
        }

        return false;

    }

    private boolean stacksSame(ItemStack a, ItemStack b){

        if(a != null && b != null){

            if(a.getItem() == b.getItem()){

                if(a.getMetadata() == b.getMetadata()){

                    if(a.stackSize == b.stackSize){

                        if(a.isItemEnchanted() && b.isItemEnchanted()){

                            if(a.getEnchantmentTagList() == b.getEnchantmentTagList()){
                                return true;
                            }

                        }else{

                            return true;

                        }

                    }

                }

            }

        }

        return false;

    }

}
