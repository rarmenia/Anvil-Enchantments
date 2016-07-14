package com.lazerzes.anvils.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {

    public static NBTTagCompound getNBT(ItemStack stack){

        NBTTagCompound result = stack.getTagCompound();

        if(result == null){
            result = new NBTTagCompound();
        }

        return result;

    }

}
