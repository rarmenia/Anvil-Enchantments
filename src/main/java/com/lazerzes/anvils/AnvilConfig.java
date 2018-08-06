package com.lazerzes.anvils;

import com.lazerzes.anvils.library.MiscLib;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = MiscLib.MOD_ID, name = MiscLib.MOD_ID + "/" + MiscLib.MOD_ID, category = "")
@Mod.EventBusSubscriber(modid = MiscLib.MOD_ID)
public class AnvilConfig {


    @Config.Comment({"GENERAL SETTINGS"})
    public static AnvilConfigGeneral general = new AnvilConfigGeneral();
    @Config.Comment({"VALUE SETTINGS"})
    public static AnvilConfigValue value = new AnvilConfigValue();


    public static class AnvilConfigGeneral{

        @Config.Comment({"Enables enchantment stripping."})
        public boolean enableEnchantmentStripping = true;

    }

    public static class AnvilConfigValue{

        @Config.Comment( {"Level requirement for enchantment stripping."} )
        public int costEnchantmentStripping = 15;

    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(MiscLib.MOD_ID)) {
            ConfigManager.sync(event.getModID(), Config.Type.INSTANCE); // Sync config values
        }
    }

}
