package com.lazerzes.anvils.handler;

import com.lazerzes.anvils.AnvilConfig;
import com.lazerzes.anvils.AnvilEnchantments;
import com.lazerzes.anvils.api.anvil.AnvilRecipe;
import net.minecraft.init.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber
public class AnvilEventHandler {

    @SubscribeEvent
    public static void onAnvil(AnvilUpdateEvent event){

        AnvilRecipe result = null;

        for(AnvilRecipe r : AnvilEnchantments.anvilRegistry.getRuntimeRecipes()){

            if(r.check(event.getLeft(), event.getRight())){
                result = r;
            }

        }


        if(result == null && AnvilConfig.general.enableEnchantmentStripping){

            if (event.getLeft().isItemEnchanted() && event.getRight().getItem() == Items.WRITABLE_BOOK){

                //TODO : Add Enchantment Stripping : Remove the enchantments from an item and add them to an enchanted book.

            }

        }else if(result != null){

            event.setMaterialCost(result.getMaterialCost());
            event.setCost(result.getAnvilLevelCost());
            event.setOutput(result.getAnvilOutput());

        }

    }

}
