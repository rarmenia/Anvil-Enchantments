package com.lazerzes.anvils.handler;


import com.google.common.collect.Lists;
import com.lazerzes.anvils.gson.GsonHelper;
import com.lazerzes.anvils.recipe.AnvilRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AnvilRecipeHandler {


    public static ArrayList<AnvilRecipe> registeredRecipes = new ArrayList<>();


    public static void init(File dir){
        try {
            if(!dir.exists() && dir.mkdir()){
                for(Pair<String, AnvilRecipe> r : getDefaults()){
                    String json = GsonHelper.GSON.toJson(r.getRight());
                    FileWriter writer = new FileWriter(new File(dir, r.getLeft() + ".json"));
                    writer.write(json);
                    writer.close();
                }
            }

            File[] recipes = dir.listFiles((FileFilter) FileFilterUtils.suffixFileFilter(".json"));
            if (recipes == null){return;}

            for (File file : recipes){
                FileReader reader = new FileReader(file);
                AnvilRecipe anvilRecipe = GsonHelper.GSON.fromJson(reader, AnvilRecipe.class);
                registeredRecipes.add(anvilRecipe);
                reader.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static List<Pair<String, AnvilRecipe>> getDefaults(){

        List<Pair<String, AnvilRecipe>> defaults = Lists.newArrayList();

        defaults.add(Pair.of("aqua_affinity", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Blocks.WATERLILY, 1), Enchantments.AQUA_AFFINITY, 1, 5, "Aqua Affinity")));
        defaults.add(Pair.of("bane_of_arthropods_1", new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Items.SPIDER_EYE, 3), Enchantments.BANE_OF_ARTHROPODS, 1, 3, "Bane of Arthropods 1")));
        defaults.add(Pair.of("blast_protection_1", new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Blocks.OBSIDIAN, 4), Enchantments.BLAST_PROTECTION, 1, 3, "Blast Protection 1")));
        defaults.add(Pair.of("curse_of_binding", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.CHORUS_FRUIT, 8), Enchantments.BINDING_CURSE, 1, 10, "Curse of Binding")));
        defaults.add(Pair.of("curse_of_vanishing", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.CHORUS_FRUIT_POPPED, 8), Enchantments.VANISHING_CURSE, 1, 10, "Curse of Vanishing")));
        defaults.add(Pair.of("depth_strider_1", new AnvilRecipe(Enchantments.AQUA_AFFINITY, 1, new ItemStack(Blocks.ICE, 8), Enchantments.DEPTH_STRIDER, 1, 7, "Depth Strider 1")));
        defaults.add(Pair.of("efficiency_1",  new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.REDSTONE, 18), Enchantments.EFFICIENCY, 1, 5, "Efficiency 1")));
        defaults.add(Pair.of("feather_falling_1", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.FEATHER, 8), Enchantments.FEATHER_FALLING, 1, 7, "Feather Falling 1")));
        defaults.add(Pair.of("fire_aspect_1", new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Items.BLAZE_POWDER, 3), Enchantments.FIRE_ASPECT, 1, 4, "Fire Aspect 1")));
        defaults.add(Pair.of("fire_protection_1", new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Items.MAGMA_CREAM, 3), Enchantments.FIRE_PROTECTION, 1, 3, "Fire Protection 1")));
        defaults.add(Pair.of("flame_1", new AnvilRecipe(Enchantments.FIRE_ASPECT, 1, new ItemStack(Items.ARROW, 4), Enchantments.FLAME, 1, 3, "Flame 1")));
        defaults.add(Pair.of("fortune_1", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.DYE, 16, EnumDyeColor.BLUE.getDyeDamage()), Enchantments.FORTUNE, 1, 9, "Fortune 1")));
        defaults.add(Pair.of("frost_walker_1", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Blocks.ICE,4), Enchantments.FROST_WALKER, 1, 7, "Frost Walker 1")));
        defaults.add(Pair.of("infinity", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.ARROW, 64), Enchantments.INFINITY, 1, 13, "Infinity")));
        defaults.add(Pair.of("knockback_1", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Blocks.PISTON, 2), Enchantments.KNOCKBACK, 1, 4, "Knockback 1")));
        defaults.add(Pair.of("looting_1", new AnvilRecipe(Enchantments.FORTUNE, 1, new ItemStack(Items.ROTTEN_FLESH, 8), Enchantments.LOOTING, 1, 5, "Looting 1")));
        defaults.add(Pair.of("luck_of_the_sea_1", new AnvilRecipe(Enchantments.FORTUNE, 1 , new ItemStack(Items.RABBIT_FOOT, 1), Enchantments.LUCK_OF_THE_SEA, 1, 5, "Luck of the Sea 1")));
        defaults.add(Pair.of("lure_1", new AnvilRecipe(Enchantments.EFFICIENCY, 1, new ItemStack(Items.PRISMARINE_CRYSTALS, 3), Enchantments.LURE, 1, 7, "Lure 1")));
        defaults.add(Pair.of("mending", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.GOLDEN_APPLE, 3), Enchantments.MENDING, 1, 15, "Mending")));
        defaults.add(Pair.of("power_1", new AnvilRecipe(Enchantments.EFFICIENCY, 1, new ItemStack(Items.ARROW, 4), Enchantments.POWER, 1,  3, "Power 1")));
        defaults.add(Pair.of("projectile_protection_1", new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Items.ARROW, 4), Enchantments.PROJECTILE_PROTECTION, 1, 3, "Projectile Protection 1")));
        defaults.add(Pair.of("protection_1", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.IRON_INGOT, 4), Enchantments.PROTECTION, 1, 5, "Protection 1")));
        defaults.add(Pair.of("punch_1", new AnvilRecipe(Enchantments.KNOCKBACK, 1, new ItemStack(Items.ARROW, 4), Enchantments.PUNCH, 1, 3, "Punch 1")));
        defaults.add(Pair.of("respiration_1", new AnvilRecipe(Enchantments.AQUA_AFFINITY, 1, new ItemStack(Items.PRISMARINE_SHARD), Enchantments.RESPIRATION, 1, 6, "Respiration 1")));
        defaults.add(Pair.of("sharpness_1", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.QUARTZ, 8), Enchantments.SHARPNESS, 1, 3, "Sharpness 1")));
        defaults.add(Pair.of("silk_touch", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Items.GHAST_TEAR, 3), Enchantments.SILK_TOUCH, 1, 10, "Silk Touch")));
        defaults.add(Pair.of("smite_1", new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Items.SPECKLED_MELON), Enchantments.SMITE, 1, 3, "Smite 1")));
        defaults.add(Pair.of("sweeping_edge_1", new AnvilRecipe(Enchantments.SHARPNESS, 1, new ItemStack(Blocks.PISTON, 1), Enchantments.SWEEPING, 1, 5, "Sweeping Edge 1")));
        defaults.add(Pair.of("thorns_1", new AnvilRecipe(Enchantments.PROTECTION, 1, new ItemStack(Blocks.CACTUS, 6), Enchantments.THORNS, 1, 5, "Thorns 1")));
        defaults.add(Pair.of("unbreaking_1", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Blocks.OBSIDIAN, 3), Enchantments.UNBREAKING, 1, 5, "Unbreaking 1")));

        return defaults;

    }

}
