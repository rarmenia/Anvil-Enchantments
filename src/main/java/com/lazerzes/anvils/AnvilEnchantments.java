package com.lazerzes.anvils;
//created by lazerzes

import com.lazerzes.anvils.api.IModPlugin;
import com.lazerzes.anvils.handler.AnvilRecipeHandler;
import com.lazerzes.anvils.library.MiscLib;

import com.lazerzes.anvils.api.anvil.AnvilRecipe;
import com.lazerzes.anvils.registry.AnvilRegistry;
import com.lazerzes.anvils.util.AnnotationHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;
import java.util.ArrayList;

@Mod(modid = MiscLib.MOD_ID, name = MiscLib.MOD_NAME, version = MiscLib.MOD_VERSION, dependencies = MiscLib.MOD_DEPENDENCIES)
public class AnvilEnchantments {


    private static File configDir;
    private static ArrayList<IModPlugin> modPlugins;
    public static AnvilRegistry anvilRegistry;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configDir = new File(event.getModConfigurationDirectory(), "anvils");

        ASMDataTable asmDataTable = event.getAsmData();
        modPlugins = AnnotationHelper.getPlugins(asmDataTable);
        AnnotationHelper.ensureVanilla(modPlugins);



    }

    @EventHandler
    public static void init(FMLInitializationEvent event){

        anvilRegistry = new AnvilRegistry();
        AnvilRecipeHandler.initPlugins(new File(configDir, "recipes"), modPlugins, anvilRegistry);

        final CreativeTabs TAB_ANV = new CreativeTabs(MiscLib.MOD_ID) {


            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Blocks.ANVIL, 1);
            }

            @Override
            @SideOnly(Side.CLIENT)
            public void displayAllRelevantItems(NonNullList<ItemStack> dispList){
                for(AnvilRecipe r : anvilRegistry.getRuntimeRecipes()){
                    if(r.showRecipe) {
                        dispList.add(r.getAnvilOutput());
                    }
                }
            }


        };

    }


}
