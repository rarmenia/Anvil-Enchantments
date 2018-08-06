package com.lazerzes.anvils;
//created by lazerzes

import com.lazerzes.anvils.handler.AnvilRecipeHandler;
import com.lazerzes.anvils.library.MiscLib;

import com.lazerzes.anvils.recipe.AnvilRecipe;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

@Mod(modid = MiscLib.MOD_ID, name = MiscLib.MOD_NAME, version = MiscLib.MOD_VERSION, dependencies = MiscLib.MOD_DEPENDENCIES)
public class AnvilEnchantments {


    private static File configDir;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configDir = new File(event.getModConfigurationDirectory(), "anvils");
        AnvilRecipeHandler.init(new File(configDir, "recipes"));
    }

    @EventHandler
    public static void init(FMLInitializationEvent event){

        final CreativeTabs TAB_ANV = new CreativeTabs(MiscLib.MOD_ID) {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Blocks.ANVIL, 1);
            }

            @Override
            @SideOnly(Side.CLIENT)
            public void displayAllRelevantItems(NonNullList<ItemStack> dispList){
                for(AnvilRecipe r : AnvilRecipeHandler.registeredRecipes){
                    if(r.showRecipe) {
                        dispList.add(r.getAnvilOutput());
                    }
                }
            }


        };

    }


}
