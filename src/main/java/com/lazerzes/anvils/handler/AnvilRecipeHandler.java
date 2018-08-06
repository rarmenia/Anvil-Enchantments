package com.lazerzes.anvils.handler;


import com.google.common.collect.Lists;
import com.lazerzes.anvils.gson.GsonHelper;
import com.lazerzes.anvils.recipe.AnvilRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
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

        defaults.add(Pair.of( "aqua_affinity", new AnvilRecipe(new ItemStack(Items.BOOK, 1), new ItemStack(Blocks.WATERLILY, 1), Enchantments.AQUA_AFFINITY, 1, 8)));

        return defaults;

    }

}
