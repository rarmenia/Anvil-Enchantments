package com.lazerzes.anvils.handler;


import com.google.common.collect.Lists;
import com.lazerzes.anvils.api.AnvilPlugin;
import com.lazerzes.anvils.api.IModPlugin;
import com.lazerzes.anvils.api.anvil.IAnvilRegistry;
import com.lazerzes.anvils.registry.AnvilRegistry;
import com.lazerzes.anvils.util.GsonHelper;
import com.lazerzes.anvils.api.anvil.AnvilRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnvilRecipeHandler {


    public static ArrayList<AnvilRecipe> registeredRecipes = new ArrayList<>();


    public static void initPlugins(File base_dir, ArrayList<IModPlugin> modPlugins, AnvilRegistry anvilRegistry){


        //Generate Files in not Exist and Gather Base Recipes
        for(IModPlugin plugin : modPlugins){

            String mod_name = plugin.getPluginId();
            File child_dir = new File(base_dir, mod_name);

            if(!child_dir.exists() && child_dir.mkdir()){
                AnvilRegistry tmp = new AnvilRegistry();
                plugin.registerRecipes(tmp);
                for(Pair<String, AnvilRecipe> pair : tmp.getFileRecipes()){
                    String json = GsonHelper.GSON.toJson(pair.getRight());
                    try {
                        FileWriter writer = new FileWriter(new File(child_dir, pair.getLeft() + ".json"));
                        writer.write(json);
                        writer.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
                tmp.clearFiles();
                anvilRegistry.joinRegistry(tmp);
            }

        }

        //Gather Recipes from Files
        String[] child_dirs = base_dir.list(FileFilterUtils.directoryFileFilter());
        for(String child : child_dirs){

            File child_dir = new File(base_dir, child);
            File[] files = child_dir.listFiles((FileFilter) FileFilterUtils.suffixFileFilter(".json"));
            if(files != null){
                for(File file : files){
                    try {
                        FileReader reader = new FileReader(file);
                        AnvilRecipe anvilRecipe = GsonHelper.GSON.fromJson(reader, AnvilRecipe.class);
                        anvilRegistry.addRecipe(anvilRecipe);
                        reader.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }

    }

}
