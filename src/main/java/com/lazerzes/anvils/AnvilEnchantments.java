package com.lazerzes.anvils;
//created by lazerzes

import com.lazerzes.anvils.handler.EventListener;
import com.lazerzes.anvils.library.AnvilRecipeLib;
import com.lazerzes.anvils.library.MiscLib;
import com.lazerzes.anvils.util.AnvilRecipe;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MiscLib.MOD_ID, name = MiscLib.MOD_NAME, version = MiscLib.MOD_VERSION)
public class AnvilEnchantments {

    @EventHandler
    public static void init(FMLInitializationEvent event){

        AnvilRecipeLib.registerVanillaEnchantmentRecipes();
        EventListener listener = new EventListener();

    }

}
