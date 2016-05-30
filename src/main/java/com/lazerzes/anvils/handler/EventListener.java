package com.lazerzes.anvils.handler;
//created by lazerzes

import com.lazerzes.anvils.library.AnvilRecipeLib;
import com.lazerzes.anvils.util.AnvilRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventListener {

    public EventListener(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onAnvil(AnvilUpdateEvent event){

        AnvilRecipe eventIn = new AnvilRecipe(event.getLeft(), event.getRight(), event.getOutput(), event.getCost(), false);

        for(AnvilRecipe recipe : AnvilRecipeLib.getRecipes()){

            if(eventIn.matchesRecipe(recipe)){
                event.setCost(recipe.getCost());
                event.setOutput(recipe.getOutput().copy());
                return;

            }

        }

    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load loadEvent){

        AnvilRecipeLib.bookHandler.clear();

        for(AnvilRecipe recipe : AnvilRecipeLib.getRecipes()){
            if(recipe.showInBook){
                AnvilRecipeLib.bookHandler.add(recipe);
            }
        }

    }

}
