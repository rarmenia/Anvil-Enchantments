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

        for(AnvilRecipe r : AnvilEnchantments.anvilRegistry.getRuntimeRecipes()){

            if(r.check(event.getLeft(), event.getRight())){
                result = r;
                break;
            }

        }


        if(result == null && AnvilConfig.general.enableEnchantmentStripping){

            if (event.getLeft().isItemEnchanted() && event.getRight().getItem() == Items.WRITABLE_BOOK){


                ArrayList<EnchantmentData> enchantmentDatas = new ArrayList<>();
                NBTTagList tagList = event.getLeft().getEnchantmentTagList();
                for (int i = 0; i < tagList.tagCount(); i++){

                    NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                    int id = tagCompound.getShort("id");
                    int lvl = tagCompound.getShort("lvl");

                    Enchantment temp = Enchantment.getEnchantmentByID(id);

                    if(temp != null) {
                        enchantmentDatas.add(new EnchantmentData(temp, lvl));
                    }

                }

                ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK, 1);
                for(EnchantmentData ench : enchantmentDatas){

                    ItemEnchantedBook.addEnchantment(enchantedBook, ench);

                }

                event.setCost(AnvilConfig.value.costEnchantmentStripping);
                event.setOutput(enchantedBook);


            }

        }else if(result != null){

            event.setMaterialCost(result.getMaterialCost());
            event.setCost(result.getAnvilLevelCost());
            event.setOutput(result.getAnvilOutput());

        }

    }

}
