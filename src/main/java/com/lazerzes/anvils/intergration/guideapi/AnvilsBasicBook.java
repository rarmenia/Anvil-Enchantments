package com.lazerzes.anvils.intergration.guideapi;

import amerifrance.guideapi.api.GuideAPI;
import amerifrance.guideapi.api.GuideBook;
import amerifrance.guideapi.api.IGuideBook;
import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.api.impl.Book;
import amerifrance.guideapi.api.impl.abstraction.CategoryAbstract;
import amerifrance.guideapi.api.impl.abstraction.EntryAbstract;
import amerifrance.guideapi.category.CategoryItemStack;
import amerifrance.guideapi.entry.EntryItemStack;
import amerifrance.guideapi.page.PageIRecipe;
import amerifrance.guideapi.page.PageImage;
import amerifrance.guideapi.page.PageItemStack;
import com.lazerzes.anvils.handler.AnvilRecipeHandler;
import com.lazerzes.anvils.recipe.AnvilRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@GuideBook
public class AnvilsBasicBook implements IGuideBook {

    public static Book basicGuide;

    @Nullable
    @Override
    public Book buildBook() {
        Map<ResourceLocation, EntryAbstract> entries = new LinkedHashMap<ResourceLocation, EntryAbstract>();

        int i = 0;
        for (AnvilRecipe r : AnvilRecipeHandler.registeredRecipes){
            List<IPage> page = new ArrayList<IPage>();
            page.add(new PageItemStack("Left", r.getAnvilLeft()));
            page.add(new PageItemStack("Right", r.getAnvilRight()));
            page.add(new PageItemStack(String.format("%d Levels", r.getAnvilLevelCost()), new ItemStack(Items.EXPERIENCE_BOTTLE, r.getAnvilLevelCost())));
            entries.put(new ResourceLocation("anvils", String.format("basic_recipes_entry_%d", i)), new EntryItemStack(page, r.getRecipeName(), r.getAnvilOutput()));
            i++;
        }

        List<CategoryAbstract> categories = new ArrayList<CategoryAbstract>();
        categories.add(new CategoryItemStack(entries, "Recipes", new ItemStack(Items.ENCHANTED_BOOK, 1)));

        basicGuide = new Book();
        basicGuide.setTitle("AnvilEnchantments Basic Recipe Guide(WIP)");
        basicGuide.setDisplayName("AnvilEnchantments Basic Guide(WIP)");
        basicGuide.setAuthor("lazerzes");
        basicGuide.setColor(Color.WHITE);
        basicGuide.setCategoryList(categories);
        basicGuide.setRegistryName(new ResourceLocation("anvils", "basic_guide_book"));
        return basicGuide;

    }

    @Override
    public void handleModel(@Nonnull ItemStack bookStack) {
        GuideAPI.setModel(basicGuide);
    }


    @Override
    public void handlePost(@Nonnull ItemStack bookStack) {
        GameRegistry.addSmelting(Items.BOOK, bookStack, 0.5f);
    }
}


