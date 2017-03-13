package com.lazerzes.anvils.intergration.jei.subtypes;

import com.sun.istack.internal.Nullable;
import mezz.jei.api.ISubtypeRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;

import java.util.ArrayList;

public class EnchantedBookSubtypeInterpreter implements ISubtypeRegistry.ISubtypeInterpreter{

    public static final EnchantedBookSubtypeInterpreter INSTANCE = new EnchantedBookSubtypeInterpreter();

    private EnchantedBookSubtypeInterpreter(){

    }

    @Nullable
    @Override
    public String getSubtypeInfo(ItemStack itemStack) {
        if(!itemStack.hasTagCompound()){
            return null;
        }

        if(!(itemStack.getItem() instanceof ItemEnchantedBook)){
            return null;
        }

        NBTTagList enchList = Items.ENCHANTED_BOOK.getEnchantments(itemStack);

        String enchBookTypeString = "EnchBook:";
        StringBuilder stringBuilder = new StringBuilder(enchBookTypeString);

        for(int i = 0; i < enchList.tagCount(); i++){
            int id = enchList.getCompoundTagAt(i).getShort("id");
            int lvl = enchList.getCompoundTagAt(i).getShort("lvl");

            stringBuilder.append(id).append("-").append(lvl).append(";");
        }

        return stringBuilder.toString();

    }
}
