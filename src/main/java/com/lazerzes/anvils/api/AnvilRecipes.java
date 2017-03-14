package com.lazerzes.anvils.api;
//created by lazerzes

import com.lazerzes.anvils.api.AnvilRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;

public class AnvilRecipes {

    private static ArrayList<AnvilRecipe> recipes = new ArrayList<AnvilRecipe>();

    static int super_cheap = 3, cheap = 5, mid = 10, expensive = 15;
    public static class Levels{
        public static int protection ;
        public static int fireProtection ;
        public static int blastProtection ;
        public static int projProtection ;
        public static int thorns ;
        public static int frostWalker ;
        public static int featherFalling ;
        public static int aquaAffinity ;
        public static int waterBreathing ;
        public static int depthStrider ;
        public static int sharpness ;
        public static int power ;
        public static int smite ;
        public static int arthropods;
        public static int fireAspect;
        public static int flame;
        public static int knockback;
        public static int punch ;
        public static int fortune ;
        public static int looting ;
        public static int luckOfSea ;
        public static int efficiency ;
        public static int lure ;
        public static int silkTouch ;
        public static int unbreaking ;
        public static int infinity ;
        public static int mending ;
    }

    public static void registerVanillaEnchantmentRecipes(){

        ItemStack book = new ItemStack(Items.BOOK, 1);

        //Protection
        if( Levels.protection >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Items.IRON_INGOT, 4), Enchantments.PROTECTION, 1, Levels.protection, true));

        //Fire Protection
        if(Levels.fireProtection >= 0)
          addRecipe( new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Items.MAGMA_CREAM, 3), Enchantments.FIRE_PROTECTION, 1, Levels.fireProtection, true));

        //Blast Protection
        if( Levels.blastProtection >= 0)
          addRecipe( new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Blocks.OBSIDIAN, 2), Enchantments.BLAST_PROTECTION, 1, Levels.blastProtection, true));

        //Projectile Protection
        if(Levels.projProtection >= 0)
          addRecipe( new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Items.ARROW, 4), Enchantments.PROJECTILE_PROTECTION, 1, Levels.projProtection, true));

        //Thorns
        if(Levels.thorns >= 0)
          addRecipe( new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Blocks.CACTUS, 6), Enchantments.THORNS, 1, Levels.thorns, true));

        //Frost Walker
        if( Levels.frostWalker >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Blocks.ICE,4), Enchantments.FROST_WALKER, 1, Levels.frostWalker, true));

        //Feather Falling
        if(Levels.featherFalling >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Items.FEATHER, 8), Enchantments.FEATHER_FALLING, 1, Levels.featherFalling, true));

        //Aqua Affinity
        if(Levels.aquaAffinity >= 0){
          addRecipe( new AnvilRecipe(book, Items.POTIONITEM.getDefaultInstance(), Enchantments.AQUA_AFFINITY, 1, Levels.aquaAffinity, true));
        }
        //Respiration
        if(Levels.waterBreathing >= 0)
          addRecipe( new AnvilRecipe(Enchantments.AQUA_AFFINITY, 1, new ItemStack(Items.PRISMARINE_SHARD), Enchantments.RESPIRATION, 1, Levels.waterBreathing, true));

        //Depth Strider
        if(Levels.depthStrider >= 0)
          addRecipe( new AnvilRecipe(Enchantments.AQUA_AFFINITY, 1, new ItemStack(Blocks.ICE, 8), Enchantments.DEPTH_STRIDER, 1, Levels.depthStrider, true));

        //Sharpness
        if(Levels.sharpness >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Items.QUARTZ, 8), Enchantments.SHARPNESS, 1, Levels.sharpness, true));

        //Power
        if(Levels.power >= 0)
          addRecipe( new AnvilRecipe(Enchantments.EFFICIENCY, 1, new ItemStack(Items.ARROW, 4), Enchantments.POWER, 1,  Levels.power, true));

        //Smite
        if(Levels.smite >= 0)
          addRecipe( new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Items.SPECKLED_MELON), Enchantments.SMITE, 1, Levels.smite , true));

        //Bane of Arthropods
        if(Levels.arthropods >= 0)
          addRecipe( new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Items.SPIDER_EYE, 3), Enchantments.BANE_OF_ARTHROPODS, 1, Levels.arthropods , true));

        //Fire Aspect
        if(Levels.fireAspect >= 0)
          addRecipe( new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Items.BLAZE_POWDER, 3), Enchantments.FIRE_ASPECT, 1, Levels.fireAspect , true));

        //Flame
        if(Levels.flame >= 0)
          addRecipe( new AnvilRecipe(Enchantments.FIRE_ASPECT, 1, new ItemStack(Items.ARROW, 4), Enchantments.FLAME, 1, Levels.flame, true));

        //Knockback
        if(Levels.knockback >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Blocks.PISTON, 2), Enchantments.KNOCKBACK, 1, Levels.knockback, true));

        //Punch
        if(Levels.punch >= 0)
          addRecipe( new AnvilRecipe(Enchantments.KNOCKBACK, 1, new ItemStack(Items.ARROW, 4), Enchantments.PUNCH, 1, Levels.punch , true));

        //Fortune
        if(Levels.fortune >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Items.DYE, 16, EnumDyeColor.BLUE.getDyeDamage()), Enchantments.FORTUNE, 1, Levels.fortune , true));

        //Looting
        if(Levels.looting >= 0)
          addRecipe( new AnvilRecipe(Enchantments.FORTUNE, 1, new ItemStack(Items.ROTTEN_FLESH, 8), Enchantments.LOOTING, 1, Levels.looting, true));

        //Luck of the Sea
        if(Levels.luckOfSea >= 0)
          addRecipe( new AnvilRecipe(Enchantments.FORTUNE, 1 , new ItemStack(Items.RABBIT_FOOT, 1), Enchantments.LUCK_OF_THE_SEA, 1, Levels.luckOfSea , true));

        //Efficiency
        if(Levels.efficiency >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Items.REDSTONE, 18), Enchantments.EFFICIENCY, 1, Levels.efficiency , true));

        //Lure
        if(Levels.lure >= 0)
          addRecipe( new AnvilRecipe(Enchantments.EFFICIENCY, 1, new ItemStack(Items.PRISMARINE_CRYSTALS, 3), Enchantments.LURE, 1, Levels.lure , true));

        //Silk Touch
        if(Levels.silkTouch >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Items.GHAST_TEAR, 3), Enchantments.SILK_TOUCH, 1, Levels.silkTouch, true));

        //Unbreaking
        if(Levels.unbreaking >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Blocks.OBSIDIAN, 3), Enchantments.UNBREAKING, 1, Levels.unbreaking, true));

        //Infinity
        if(Levels.infinity >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Items.ARROW, 64), Enchantments.INFINITY, 1, Levels.infinity, true));

        //Mending
        if(Levels.mending  >= 0)
          addRecipe( new AnvilRecipe(book, new ItemStack(Items.GOLDEN_APPLE, 3), Enchantments.MENDING, 1, Levels.mending, true));

    }

    public static void addRecipe(AnvilRecipe recipeToAdd){
        recipes.add(recipeToAdd);
    }

    public static ArrayList<AnvilRecipe> getRecipes(){
        return recipes;
    }

}
