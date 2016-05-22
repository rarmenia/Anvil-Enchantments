package com.lazerzes.anvils.library;
//created by lazerzes

import com.lazerzes.anvils.AnvilRecipe;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.util.ArrayList;

public class AnvilRecipes {

    private static ArrayList<AnvilRecipe> recipes = new ArrayList<AnvilRecipe>();


    public static void registerVanillaEnchantments(){

        ItemStack book = new ItemStack(Items.book, 1);
        ItemStack baseBook = new ItemStack(Items.enchanted_book, 1);
        int super_cheap = 3, cheap = 5, mid = 10, expensive = 15;

        //Protection
        addRecipe(book, new ItemStack(Items.iron_ingot, 4), cheap, Enchantments.protection, 1, true);

        //Fire Protection - Child of Protection
        baseBook.addEnchantment(Enchantments.protection, 1);
        addRecipe(baseBook, new ItemStack(Items.magma_cream, 3), cheap, Enchantments.fireProtection, 1, true);

        //Blast Protection - Child of Protection
        addRecipe(baseBook, new ItemStack(Blocks.obsidian, 4), cheap, Enchantments.blastProtection, 1, true);

        //Projectile Protection - Child of Protection
        addRecipe(baseBook, new ItemStack(Items.arrow, 8), cheap, Enchantments.blastProtection, 1, true);

        //Thorns - Child of Protection
        addRecipe(baseBook, new ItemStack(Blocks.cactus, 4), cheap, Enchantments.thorns, 1, true);

        //Feather Falling
        addRecipe(book, new ItemStack(Items.feather, 8), mid, Enchantments.featherFalling, 1, true);

        //Aqua Affinity
        addRecipe(book, new ItemStack(Items.potionitem, 1, PotionType.getID(PotionTypes.water)), mid, Enchantments.aquaAffinity, 1, true);
        baseBook = new ItemStack(Items.enchanted_book);
        baseBook.addEnchantment(Enchantments.aquaAffinity, 1);

        //Respiration - Child of Aqua Affinity
        addRecipe(baseBook, new ItemStack(Items.potionitem, 1, PotionType.getID(PotionTypes.water_breathing)), cheap, Enchantments.respiration, 1, true);

        //Depth Strider - Child of Aqua Affinity
        addRecipe(baseBook, new ItemStack(Items.potionitem, 1, PotionType.getID(PotionTypes.swiftness)), cheap, Enchantments.depthStrider, 1, true);

        //Frost Walker
        addRecipe(book, new ItemStack(Blocks.packed_ice, 4), mid, Enchantments.frostWalker, 1, true);

        //Sharpness
        addRecipe(book, new ItemStack(Items.quartz, 8), cheap, Enchantments.sharpness, 1, true);
        baseBook = new ItemStack(Items.enchanted_book, 1);
        baseBook.addEnchantment(Enchantments.sharpness, 1);

        //Power - Child of Sharpness
        addRecipe(baseBook, new ItemStack(Items.arrow, 4), super_cheap, Enchantments.power, 1, true);

        //Smite - Child of Sharpness
        addRecipe(baseBook, new ItemStack(Items.potionitem, 1, PotionType.getID(PotionTypes.healing)), super_cheap, Enchantments.smite, 1, true);

        //Bane of Arthropods - Child of Sharpness
        addRecipe(baseBook, new ItemStack(Items.spider_eye, 1), super_cheap, Enchantments.baneOfArthropods, 1, true);

        //Knockback - Child of Sharpness
        addRecipe(baseBook, new ItemStack(Blocks.piston, 1), super_cheap, Enchantments.knockback, 1, true);
        baseBook = new ItemStack(Items.enchanted_book, 1);
        baseBook.addEnchantment(Enchantments.knockback, 1);

        //Punch - Child of Knockback
        addRecipe(baseBook, new ItemStack(Items.arrow, 4), super_cheap, Enchantments.punch, 1, true);

        //Fire Aspect - Child of Sharpness
        baseBook = new ItemStack(Items.enchanted_book, 1);
        baseBook.addEnchantment(Enchantments.sharpness, 1);
        addRecipe(baseBook, new ItemStack(Items.blaze_powder, 3), super_cheap, Enchantments.fireAspect, 1, true);
        baseBook = new ItemStack(Items.enchanted_book, 1);
        baseBook.addEnchantment(Enchantments.fireAspect, 1);

        //Flame - Child of Fire Aspect
        addRecipe(baseBook, new ItemStack(Items.arrow, 6), super_cheap, Enchantments.flame, 1, true);

        //Fortune
        addRecipe(book, new ItemStack(Items.dye, 16, EnumDyeColor.BLUE.getDyeDamage()), mid, Enchantments.fortune, 1, true);
        baseBook = new ItemStack(Items.enchanted_book, 1);
        baseBook.addEnchantment(Enchantments.fortune, 1);

        //Looting -- Child of Fortune
        addRecipe(baseBook, new ItemStack(Items.rotten_flesh, 16), cheap, Enchantments.looting, 1, true);

        //Luck of the Sea -- Child of Fortune
        addRecipe(baseBook, new ItemStack(Items.rabbit_foot, 1), super_cheap, Enchantments.luckOfTheSea, 1, true);

        //Efficiency
        addRecipe(book, new ItemStack(Items.redstone, 20), cheap, Enchantments.efficiency, 1, true);
        baseBook = new ItemStack(Items.enchanted_book, 1);
        baseBook.addEnchantment(Enchantments.efficiency, 1);

        //Lure - Child of Efficiency
        addRecipe(baseBook, new ItemStack(Items.prismarine_crystals, 3), super_cheap, Enchantments.lure, 1, true);

        //Unbreaking
        addRecipe(book, new ItemStack(Blocks.obsidian, 4), mid, Enchantments.unbreaking, 1, true);

        //Silk Touch
        addRecipe(book, new ItemStack(Items.ghast_tear, 4), expensive, Enchantments.silkTouch, 1, true);

        //Infinity
        addRecipe(book, new ItemStack(Items.arrow, 64), expensive, Enchantments.infinity, 1, true);

        //Mending
        addRecipe(book, new ItemStack(Items.golden_apple, 4), expensive, Enchantments.mending, 1, true);


    }

    public static void addRecipe(ItemStack leftIn, ItemStack rightIn, int anvilCost, ItemStack output, boolean showInBook){

        recipes.add(new AnvilRecipe(leftIn, rightIn, output, anvilCost, showInBook));

    }

    public static void addRecipe(ItemStack leftIn, ItemStack rightIn, int anvilCost, Enchantment enchantmentOut, int enchantmentLevel, boolean showInBook){

        ItemStack output = new ItemStack(Items.enchanted_book);
        output.addEnchantment(enchantmentOut, enchantmentLevel);
        addRecipe(leftIn, rightIn, anvilCost, output, showInBook);

    }

    public static ArrayList<AnvilRecipe> getRecipes(){ return recipes; }

}
