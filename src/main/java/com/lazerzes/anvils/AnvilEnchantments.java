package com.lazerzes.anvils;
//created by lazerzes

import com.lazerzes.anvils.handler.EventListener;
import com.lazerzes.anvils.api.AnvilRecipes;
import com.lazerzes.anvils.library.MiscLib;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MiscLib.MOD_ID, name = MiscLib.MOD_NAME, version = MiscLib.MOD_VERSION)
public class AnvilEnchantments {


    private static Configuration config;
    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        int super_cheap = 3, cheap = 5, mid = 10, expensive = 15;
        int minValue = -1, maxValue = 99;
        String category = MiscLib.MOD_ID;
        String comment = "Level required to add enchantmet with the item; set -1 to disable completely";
        AnvilRecipes.Levels.protection = config.getInt("protection", category, cheap, minValue, maxValue, comment);
        
        
        config.save();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event){

        AnvilRecipes.registerVanillaEnchantmentRecipes();
        EventListener listener = new EventListener();

    }

}
