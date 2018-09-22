package com.lazerzes.anvils.handler;

import com.lazerzes.anvils.AnvilConfig;
import com.lazerzes.anvils.AnvilEnchantments;
import com.lazerzes.anvils.api.anvil.AnvilRecipe;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;


@Mod.EventBusSubscriber
public class AnvilEventHandler {

    @SubscribeEvent
    public static void onAnvil(AnvilUpdateEvent event){

        AnvilRecipe result = null;


        if(AnvilConfig.general.enableEnchantmentStripping){
            //TODO :: AnvilEnchantments - Feature Enchantment Stripping (Harder than it looks) Issue #19(https://github.com/lazerzes/Anvil-Enchantments/issues/19)
        }

        for(AnvilRecipe r : AnvilEnchantments.anvilRegistry.getRuntimeRecipes()){

            if(r.check(event.getLeft(), event.getRight())){
                result = r;
                break;
            }

        }
        if(result != null) {
            event.setMaterialCost(result.getMaterialCost());
            event.setCost(result.getAnvilLevelCost());
            event.setOutput(result.getAnvilOutput());
        }

    }

}
