package com.lazerzes.anvils.handler;
//created by lazerzes

import com.lazerzes.anvils.AnvilRecipe;
import com.lazerzes.anvils.helper.AnvilRecipeHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventListener {

    public EventListener(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onAnvil(AnvilUpdateEvent event){

        AnvilRecipe result = AnvilRecipeHelper.getResult(new AnvilRecipe(event.getLeft(), event.getRight()));

        if(result != null){
            event.setCost(result.getCost());
            event.setOutput(result.getOutput());
            return;
        }

    }

}
