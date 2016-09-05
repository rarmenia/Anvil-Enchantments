package com.lazerzes.anvils;
//created by lazerzes

import com.lazerzes.anvils.handler.EventListener;
import com.lazerzes.anvils.api.AnvilRecipes;
import com.lazerzes.anvils.library.MiscLib;
import com.lazerzes.anvils.util.NBTHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MiscLib.MOD_ID, name = MiscLib.MOD_NAME, version = MiscLib.MOD_VERSION)
public class AnvilEnchantments {


    private static Configuration config;
    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        int super_cheap = 3, cheap = 5, mid = 10, expensive = 15;
        int minValue = -1, maxValue = 99;
        String category = MiscLib.MOD_NAME;
        String comment = "Level required to add enchantment with the item; set -1 to disable completely";
        AnvilRecipes.Levels.protection = config.getInt("protection", category, cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.fireProtection = config.getInt("fireProtection", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.blastProtection = config.getInt("blastProtection", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.projProtection = config.getInt("projProtection", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.thorns = config.getInt("thorns", category, cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.frostWalker = config.getInt("frostWalker", category, mid, minValue, maxValue, comment);
        AnvilRecipes.Levels.featherFalling = config.getInt("featherFalling", category, cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.aquaAffinity = config.getInt("aquaAffinity", category, cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.waterBreathing = config.getInt("waterBreathing", category, cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.depthStrider = config.getInt("depthStrider", category, mid, minValue, maxValue, comment);
        AnvilRecipes.Levels.sharpness = config.getInt("sharpness", category, cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.power = config.getInt("power", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.smite = config.getInt("smite", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.arthropods = config.getInt("arthropods", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.fireAspect = config.getInt("fireAspect", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.flame = config.getInt("flame", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.knockback = config.getInt("knockback", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.punch = config.getInt("punch", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.fortune = config.getInt("fortune", category, mid, minValue, maxValue, comment);
        AnvilRecipes.Levels.looting = config.getInt("looting", category, mid, minValue, maxValue, comment);
        AnvilRecipes.Levels.luckOfSea = config.getInt("luckOfSea", category, super_cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.efficiency = config.getInt("efficiency", category, cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.lure = config.getInt("lure", category, cheap, minValue, maxValue, comment);
        AnvilRecipes.Levels.silkTouch = config.getInt("silkTouch", category, mid, minValue, maxValue, comment);
        AnvilRecipes.Levels.unbreaking = config.getInt("unbreaking", category, mid, minValue, maxValue, comment);
        AnvilRecipes.Levels.infinity = config.getInt("infinity", category, expensive, minValue, maxValue, comment);
        AnvilRecipes.Levels.mending = config.getInt("mending", category, expensive, minValue, maxValue, comment);
        
        
        config.save();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event){

        AnvilRecipes.registerVanillaEnchantmentRecipes();
        EventListener listener = new EventListener();
        
//        addInstructionBookRecipe();
    }
    

    //I tried to add a manual. But every time i craft it, says "Invalid data tag", im sure the solution is something similar
    // so ill leave the code in case you want to tweak it
    
//    private static void addInstructionBookRecipe() {
////http://www.minecraftforge.net/forum/index.php?topic=31933.0
//        ItemStack manual = new ItemStack(Items.WRITTEN_BOOK);
//
//        NBTTagCompound tags = NBTHelper.getNBT(manual);
//        
//        tags.setString("author", "Lazerzes");
//        tags.setString("title", "Anvil Enchants");
//       NBTTagList pages = new NBTTagList();
//       pages.appendTag(new NBTTagString( "This is page 1"));

//       tags.setTag("pages", pages);
//      
//        
//        GameRegistry.addShapelessRecipe(manual, Items.BOOK,Blocks.ANVIL);
//    }

}
