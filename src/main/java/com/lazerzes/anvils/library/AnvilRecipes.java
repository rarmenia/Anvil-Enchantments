package com.lazerzes.anvils.library;
//created by lazerzes

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;

import java.util.ArrayList;

public class AnvilRecipes {

    public static class AnvilRecipe{
        public ItemStack left, right, output;
        public int cost;

        public AnvilRecipe(ItemStack left, ItemStack right, int cost, ItemStack output){
            this.left = left;
            this.right = right;
            this.cost = cost;
            this.output = output;
        }

    }


    public static ArrayList<AnvilRecipe> anvilRecipes = new ArrayList<AnvilRecipe>();

    public static void registerRecipes(){

        ItemStack book = (new ItemStack(Items.book, 1));
        ItemStack special = new ItemStack(Items.enchanted_book, 1);
        ItemStack crafting = null;
        ItemStack output = new ItemStack(Items.enchanted_book, 1);
        int cost = 5;

        //Protection
        crafting = new ItemStack(Items.iron_ingot, 3);
        output.addEnchantment(Enchantments.protection, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Fire Protection
        crafting = new ItemStack(Items.magma_cream, 2);
        output.addEnchantment(Enchantments.fireProtection, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Feather Falling
        crafting = new ItemStack(Items.feather, 8);
        output.addEnchantment(Enchantments.featherFalling, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Blast Protection
        crafting = new ItemStack(Blocks.obsidian, 4);
        output.addEnchantment(Enchantments.blastProtection, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Projectile Protection
        special.addEnchantment(Enchantments.protection, 1);
        crafting = new ItemStack(Items.arrow, 4);
        output.addEnchantment(Enchantments.projectileProtection, 1);
        anvilRecipes.add(new AnvilRecipe(special, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);
        special = new ItemStack(Items.enchanted_book, 1);

        //Respiration
        crafting = new ItemStack(Items.potionitem, 1, PotionType.getID(PotionTypes.water_breathing));
        output.addEnchantment(Enchantments.respiration, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Aqua Affinity
        crafting = new ItemStack(Items.potionitem, 1, PotionType.getID(PotionTypes.water));
        output.addEnchantment(Enchantments.aquaAffinity, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Thorns
        crafting = new ItemStack(Blocks.cactus, 10);
        output.addEnchantment(Enchantments.thorns, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Depth Strider
        crafting = new ItemStack(Items.potionitem, 1, PotionType.getID(PotionTypes.swiftness));
        output.addEnchantment(Enchantments.depthStrider, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Frost Walker
        crafting = new ItemStack(Blocks.packed_ice, 4);
        output.addEnchantment(Enchantments.frostWalker, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Sharpness
        crafting = new ItemStack(Items.quartz, 4);
        output.addEnchantment(Enchantments.sharpness, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Smite
        crafting = new ItemStack(Items.splash_potion, 1, PotionType.getID(PotionTypes.healing));
        output.addEnchantment(Enchantments.smite, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Bane of Arthropods
        crafting = new ItemStack(Items.spider_eye, 4);
        output.addEnchantment(Enchantments.baneOfArthropods, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Knockback
        crafting = new ItemStack(Blocks.piston, 1);
        output.addEnchantment(Enchantments.knockback, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Fire Aspect
        crafting = new ItemStack(Items.blaze_rod, 3);
        output.addEnchantment(Enchantments.fireAspect, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Looting
        special.addEnchantment(Enchantments.fortune, 1);
        crafting = new ItemStack(Items.rotten_flesh, 8);
        output.addEnchantment(Enchantments.looting, 1);
        anvilRecipes.add(new AnvilRecipe(special, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);
        special = new ItemStack(Items.enchanted_book, 1);

        //Efficiency
        crafting = new ItemStack(Items.redstone, 16);
        output.addEnchantment(Enchantments.efficiency, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Silk Touch
        crafting = new ItemStack(Items.ghast_tear, 4);
        output.addEnchantment(Enchantments.silkTouch, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Unbreaking
        crafting = new ItemStack(Blocks.iron_block, 3);
        output.addEnchantment(Enchantments.unbreaking, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Fortune
        crafting = new ItemStack(Items.dye, 16, EnumDyeColor.BLUE.getDyeDamage());
        output.addEnchantment(Enchantments.fortune, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Power
        special.addEnchantment(Enchantments.efficiency, 1);
        crafting = new ItemStack(Items.arrow, 4);
        output.addEnchantment(Enchantments.power, 1);
        anvilRecipes.add(new AnvilRecipe(special, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);
        special = new ItemStack(Items.enchanted_book, 1);

        //Punch
        special.addEnchantment(Enchantments.knockback, 1);
        output.addEnchantment(Enchantments.punch, 1);
        anvilRecipes.add(new AnvilRecipe(special, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);
        special = new ItemStack(Items.enchanted_book, 1);

        //Flame
        special.addEnchantment(Enchantments.fireAspect, 1);
        output.addEnchantment(Enchantments.flame, 1);
        anvilRecipes.add(new AnvilRecipe(special, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);
        special = new ItemStack(Items.enchanted_book, 1);

        //Infinity
        crafting = new ItemStack(Items.nether_star, 1);
        output.addEnchantment(Enchantments.infinity, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Luck of the Sea
        crafting = new ItemStack(Items.rabbit_foot, 1);
        output.addEnchantment(Enchantments.luckOfTheSea, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Lure
        crafting = new ItemStack(Items.prismarine_crystals, 4);
        output.addEnchantment(Enchantments.lure, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

        //Mending
        cost = 15;
        crafting = new ItemStack(Items.golden_apple, 3);
        output.addEnchantment(Enchantments.mending, 1);
        anvilRecipes.add(new AnvilRecipe(book, crafting, cost, output));
        output = new ItemStack(Items.enchanted_book, 1);

    }

    public static ItemStack removeEnchantment(ItemStack stack){

        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("ench")){
            stack.getTagCompound().removeTag("ench");
        }

        return stack;

    }

}
