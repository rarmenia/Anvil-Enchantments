package com.lazerzes.anvils.handler;
//created by lazerzes

import com.lazerzes.anvils.helper.AnvilRecipeHelper;
import com.lazerzes.anvils.library.AnvilRecipes;
import com.sun.jna.platform.win32.WinBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventListener {

    public EventListener(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onAnvil(AnvilUpdateEvent event){
        System.out.println("AnvilUpdateEvent Called");
        AnvilRecipes.AnvilRecipe helper = AnvilRecipeHelper.getResult(event.getLeft(), event.getRight());
        System.out.println(helper);

        if(helper != null){
            System.out.println("helper not null");
            event.setOutput(helper.output);
            event.setCost(helper.cost);
            return;

        }

    }

}
