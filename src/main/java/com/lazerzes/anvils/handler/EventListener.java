package com.lazerzes.anvils.handler;
//created by lazerzes

import com.lazerzes.anvils.api.AnvilRecipes;
import com.lazerzes.anvils.api.AnvilRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventListener {

    public EventListener(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onAnvil(AnvilUpdateEvent event){

        AnvilRecipe eventIn = new AnvilRecipe(event.getLeft(), event.getRight(), event.getOutput(), event.getCost(), false);

        for(AnvilRecipe recipe : AnvilRecipes.getRecipes()){

            if(eventIn.equals(recipe)){

                event.setCost(recipe.getCost());
                event.setOutput(recipe.getOutput().copy());
                return;

            }

        }

    }

}
