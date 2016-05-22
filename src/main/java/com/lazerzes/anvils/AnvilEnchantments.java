package com.lazerzes.anvils;
//created by lazerzes

import com.lazerzes.anvils.handler.EventListener;
import com.lazerzes.anvils.library.AnvilRecipes;
import com.lazerzes.anvils.library.MiscLib;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MiscLib.MOD_ID, name = MiscLib.MOD_NAME, version = MiscLib.MOD_VERSION)
public class AnvilEnchantments {

    @EventHandler
    public static void init(FMLInitializationEvent event){

        AnvilRecipes.registerVanillaEnchantments();
        EventListener listener = new EventListener();

    }

}
