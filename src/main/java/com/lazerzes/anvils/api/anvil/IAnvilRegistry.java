package com.lazerzes.anvils.api.anvil;

import org.apache.commons.lang3.tuple.Pair;

public interface IAnvilRegistry {

    /**
     * Registers a recipe that will have a json file associated with it.
     * Use this for recipes that users should be able to edit.
     *
     * @param name
     * @param recipe
     */
    void registerConfigRecipe(String name, AnvilRecipe recipe);


    /**
     * Registers a recipe that will have a json file associated with it.
     * Use this for recipes that users should be able to edit.
     *
     * @param stringAnvilRecipePair
     */
    void registerConfigRecipe(Pair<String, AnvilRecipe> stringAnvilRecipePair);

    /**
     * Registers a recipe that will not have a json file associated with it.
     * Use this for recipes that users should not be able to edit.
     * Use this for recipes that users should not be able to edit.
     *
     * @param recipe
     */
    default void registerBaseRecipe(AnvilRecipe recipe){}

}
