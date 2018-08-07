package com.lazerzes.anvils.registry;

import com.lazerzes.anvils.api.anvil.AnvilRecipe;
import com.lazerzes.anvils.api.anvil.IAnvilRegistry;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

public class AnvilRegistry implements IAnvilRegistry {

    private ArrayList<Pair<String, AnvilRecipe>> files;
    private ArrayList<AnvilRecipe> runtime;

    public AnvilRegistry(){
        files = new ArrayList<>();
        runtime = new ArrayList<>();
    }

    @Override
    public void registerConfigRecipe(String name, AnvilRecipe recipe) {
        files.add(Pair.of(name, recipe));
    }

    @Override
    public void registerConfigRecipe(Pair<String, AnvilRecipe> stringAnvilRecipePair) {
        files.add(stringAnvilRecipePair);

    }

    @Override
    public void registerBaseRecipe(AnvilRecipe recipe) {
        runtime.add(recipe);

    }

    public void addRecipe(AnvilRecipe recipe){
        runtime.add(recipe);
    }

    public ArrayList<Pair<String, AnvilRecipe>> getFileRecipes(){
        return (ArrayList<Pair<String, AnvilRecipe>>) this.files.clone();
    }

    public ArrayList<AnvilRecipe> getRuntimeRecipes(){
        return (ArrayList<AnvilRecipe>) this.runtime.clone();
    }

    public void clearFiles(){
        this.files.clear();
    }

    public void joinRegistry(AnvilRegistry registry){

        this.runtime.addAll(registry.runtime);
        this.files.addAll(registry.files);

    }
}
