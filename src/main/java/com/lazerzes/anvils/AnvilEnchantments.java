package com.lazerzes.anvils;
//created by lazerzes

import com.lazerzes.anvils.handler.AnvilRecipeHandler;
import com.lazerzes.anvils.library.MiscLib;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = MiscLib.MOD_ID, name = MiscLib.MOD_NAME, version = MiscLib.MOD_VERSION)
public class AnvilEnchantments {


    private static File configDir;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configDir = new File(event.getModConfigurationDirectory(), "anvils");
    }

    @EventHandler
    public static void init(FMLInitializationEvent event){

        AnvilRecipeHandler.init(new File(configDir, "recipes"));

    }


}
