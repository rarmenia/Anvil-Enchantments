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

        ItemStack book = new ItemStack(Items.book, 1);
        int super_cheap = 3, cheap = 5, mid = 10, expensive = 15;

        //Protection
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.iron_ingot, 4), Enchantments.protection, 1, cheap, true));

        //Fire Protection
        addRecipe( new AnvilRecipe(Enchantments.protection, 1, new ItemStack(Items.magma_cream, 3), Enchantments.fireProtection, 1, super_cheap, true));

        //Blast Protection
        addRecipe( new AnvilRecipe(Enchantments.protection, 1, new ItemStack(Blocks.obsidian, 2), Enchantments.blastProtection, 1, super_cheap, true));

        //Projectile Protection
        addRecipe( new AnvilRecipe(Enchantments.protection, 1, new ItemStack(Items.arrow, 4), Enchantments.projectileProtection, 1, super_cheap, true));

        //Thorns
        addRecipe( new AnvilRecipe(Enchantments.protection, 1, new ItemStack(Blocks.cactus, 6), Enchantments.thorns, 1, cheap, true));

        //Frost Walker
        addRecipe( new AnvilRecipe(book, new ItemStack(Blocks.ice,4), Enchantments.frostWalker, 1, mid, true));

        //Feather Falling
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.feather, 8), Enchantments.featherFalling, 1, cheap, true));

        //Aqua Affinity
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.potionitem, 1, PotionType.getID(PotionTypes.water)), Enchantments.aquaAffinity, 1, cheap, true));

        //Respiration
        addRecipe( new AnvilRecipe(Enchantments.aquaAffinity, 1, new ItemStack(Items.potionitem, 1, PotionType.getID(PotionTypes.water_breathing)), Enchantments.respiration, 1, cheap, true));

        //Depth Strider
        addRecipe( new AnvilRecipe(Enchantments.aquaAffinity, 1, new ItemStack(Blocks.ice, 8), Enchantments.respiration, 1, mid, true));

        //Sharpness
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.quartz, 8), Enchantments.sharpness, 1, cheap, true));

        //Power
        addRecipe( new AnvilRecipe(Enchantments.knockback, 1, new ItemStack(Items.arrow, 4), Enchantments.power, 1, super_cheap, true));

        //Smite
        addRecipe( new AnvilRecipe(Enchantments.sharpness, 1, new ItemStack(Items.splash_potion, 1, PotionType.getID(PotionTypes.healing)), Enchantments.smite, 1, super_cheap, true));

        //Bane of Arthropods
        addRecipe( new AnvilRecipe(Enchantments.sharpness, 1, new ItemStack(Items.spider_eye, 3), Enchantments.baneOfArthropods, 1, super_cheap, true));

        //Fire Aspect
        addRecipe( new AnvilRecipe(Enchantments.sharpness, 1, new ItemStack(Items.blaze_powder, 3), Enchantments.fireAspect, 1, super_cheap, true));

        //Flame
        addRecipe( new AnvilRecipe(Enchantments.fireAspect, 1, new ItemStack(Items.arrow, 4), Enchantments.flame, 1, super_cheap, true));

        //Knockback
        addRecipe( new AnvilRecipe(book, new ItemStack(Blocks.piston, 2), Enchantments.knockback, 1, mid, true));

        //Punch
        addRecipe( new AnvilRecipe(Enchantments.knockback, 1, new ItemStack(Items.arrow, 4), Enchantments.punch, 1, super_cheap, true));

        //Fortune
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.dye, 16, EnumDyeColor.BLUE.getDyeDamage()), Enchantments.fortune, 1, mid, true));

        //Looting
        addRecipe( new AnvilRecipe(Enchantments.fortune, 1, new ItemStack(Items.rotten_flesh, 8), Enchantments.looting, 1, super_cheap, true));

        //Luck of the Sea
        addRecipe( new AnvilRecipe(Enchantments.fortune, 1 , new ItemStack(Items.rabbit_foot, 1), Enchantments.luckOfTheSea, 1, super_cheap, true));

        //Efficiency
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.redstone, 18), Enchantments.efficiency, 1, cheap, true));

        //Lure
        addRecipe( new AnvilRecipe(Enchantments.efficiency, 1, new ItemStack(Items.prismarine_crystals, 3), Enchantments.lure, 1, super_cheap, true));

        //Silk Touch
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.ghast_tear, 3), Enchantments.silkTouch, 1, mid, true));

        //Unbreaking
        addRecipe( new AnvilRecipe(book, new ItemStack(Blocks.obsidian, 3), Enchantments.unbreaking, 1, mid, true));

        //Infinity
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.arrow, 64), Enchantments.infinity, 1, expensive, true));

        //Mending
        addRecipe( new AnvilRecipe(book, new ItemStack(Items.golden_apple, 3), Enchantments.mending, 1, expensive, true));

    }

    public static void addRecipe(AnvilRecipe recipeToAdd){
        recipes.add(recipeToAdd);
    }

    public static ArrayList<AnvilRecipe> getRecipes(){
        return recipes;
    }

}
