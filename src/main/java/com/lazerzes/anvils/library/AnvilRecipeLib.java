package com.lazerzes.anvils.library;
//created by lazerzes

import com.lazerzes.anvils.util.AnvilRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;

import java.util.ArrayList;

public class AnvilRecipeLib {

    private static ArrayList<AnvilRecipe> recipes = new ArrayList<AnvilRecipe>();
    public static ArrayList<AnvilRecipe> bookHandler = new ArrayList<AnvilRecipe>();

    public static void registerVanillaEnchantmentRecipes(){

        ItemStack book = new ItemStack(Items.BOOK, 1);
        int super_cheap = 3, cheap = 5, mid = 10, expensive = 15;

        //Protection
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.IRON_INGOT, 4), Enchantments.PROTECTION, 1, cheap, true));

        //Fire Protection
        addRecipe( new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Items.MAGMA_CREAM, 3), Enchantments.FIRE_PROTECTION, 1, super_cheap, true));

        //Blast Protection
        addRecipe( new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Blocks.OBSIDIAN, 2), Enchantments.BLAST_PROTECTION, 1, super_cheap, true));

        //Projectile Protection
        addRecipe( new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Items.ARROW, 4), Enchantments.PROJECTILE_PROTECTION, 1, super_cheap, true));

        //Thorns
        addRecipe( new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Blocks.CACTUS, 6), Enchantments.THORNS, 1, cheap, true));

        //Frost Walker
        addRecipe( new AnvilRecipe(book, new ItemStack(Blocks.ICE,4), Enchantments.FROST_WALKER, 1, mid, true));

        //Feather Falling
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.FEATHER, 8), Enchantments.FEATHER_FALLING, 1, cheap, true));

        //Aqua Affinity
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.POTIONITEM, 1, PotionType.getID(PotionTypes.WATER)), Enchantments.AQUA_AFFINITY, 1, cheap, true));

        //Respiration
        addRecipe( new AnvilRecipe(Enchantments.AQUA_AFFINITY, 1, new ItemStack(Items.POTIONITEM, 1, PotionType.getID(PotionTypes.WATER_BREATHING)), Enchantments.RESPIRATION, 1, cheap, true));

        //Depth Strider
        addRecipe( new AnvilRecipe(Enchantments.AQUA_AFFINITY, 1, new ItemStack(Blocks.ICE, 8), Enchantments.DEPTH_STRIDER, 1, mid, true));

        //Sharpness
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.QUARTZ, 8), Enchantments.SHARPNESS, 1, cheap, true));

        //Power
        addRecipe( new AnvilRecipe(Enchantments.EFFICIENCY, 1, new ItemStack(Items.ARROW, 4), Enchantments.POWER, 1, super_cheap, true));

        //Smite
        addRecipe( new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Items.SPLASH_POTION, 1, PotionType.getID(PotionTypes.HEALING)), Enchantments.SMITE, 1, super_cheap, true));

        //Bane of Arthropods
        addRecipe( new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Items.SPIDER_EYE, 3), Enchantments.BANE_OF_ARTHROPODS, 1, super_cheap, true));

        //Fire Aspect
        addRecipe( new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Items.BLAZE_POWDER, 3), Enchantments.FIRE_ASPECT, 1, super_cheap, true));

        //Flame
        addRecipe( new AnvilRecipe(Enchantments.FIRE_ASPECT, 1, new ItemStack(Items.ARROW, 4), Enchantments.FLAME, 1, super_cheap, true));

        //Knockback
        addRecipe( new AnvilRecipe(book, new ItemStack(Blocks.PISTON, 2), Enchantments.KNOCKBACK, 1, mid, true));

        //Punch
        addRecipe( new AnvilRecipe(Enchantments.KNOCKBACK, 1, new ItemStack(Items.ARROW, 4), Enchantments.PUNCH, 1, super_cheap, true));

        //Fortune
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.DYE, 16, EnumDyeColor.BLUE.getDyeDamage()), Enchantments.FORTUNE, 1, mid, true));

        //Looting
        addRecipe( new AnvilRecipe(Enchantments.FORTUNE, 1, new ItemStack(Items.ROTTEN_FLESH, 8), Enchantments.LOOTING, 1, super_cheap, true));

        //Luck of the Sea
        addRecipe( new AnvilRecipe(Enchantments.FORTUNE, 1 , new ItemStack(Items.RABBIT_FOOT, 1), Enchantments.LUCK_OF_THE_SEA, 1, super_cheap, true));

        //Efficiency
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.REDSTONE, 18), Enchantments.EFFICIENCY, 1, cheap, true));

        //Lure
        addRecipe( new AnvilRecipe(Enchantments.EFFICIENCY, 1, new ItemStack(Items.PRISMARINE_CRYSTALS, 3), Enchantments.LURE, 1, super_cheap, true));

        //Silk Touch
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.GHAST_TEAR, 3), Enchantments.SILK_TOUCH, 1, mid, true));

        //Unbreaking
        addRecipe( new AnvilRecipe(book, new ItemStack(Blocks.OBSIDIAN, 3), Enchantments.UNBREAKING, 1, mid, true));

        //Infinity
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.ARROW, 64), Enchantments.INFINITY, 1, expensive, true));

        //Mending
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.GOLDEN_APPLE, 3), Enchantments.MENDING, 1, expensive, true));

    }

    public static void addRecipe(AnvilRecipe recipeToAdd){
        recipes.add(recipeToAdd);
    }

    public static ArrayList<AnvilRecipe> getRecipes(){
        return recipes;
    }

}
