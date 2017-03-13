package com.lazerzes.anvils.intergration.jei.subtypes;

import com.sun.istack.internal.Nullable;
import mezz.jei.api.ISubtypeRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;

import java.util.List;

public class PotionSubtypeInterpreter implements ISubtypeRegistry.ISubtypeInterpreter{

    public static final PotionSubtypeInterpreter INSTANCE = new PotionSubtypeInterpreter();

    private PotionSubtypeInterpreter() {

    }

    @Nullable
    @Override
    public String getSubtypeInfo(ItemStack itemStack) {
        if (!itemStack.hasTagCompound()) {
            return null;
        }
        PotionType potionType = PotionUtils.getPotionFromItem(itemStack);
        String potionTypeString = potionType.getNamePrefixed("");
        StringBuilder stringBuilder = new StringBuilder(potionTypeString);
        List<PotionEffect> effects = PotionUtils.getEffectsFromStack(itemStack);
        for (PotionEffect effect : effects) {
            stringBuilder.append(";").append(effect);
        }

        return stringBuilder.toString();
    }

}
