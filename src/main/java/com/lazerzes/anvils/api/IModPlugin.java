package com.lazerzes.anvils.api;

import com.lazerzes.anvils.api.anvil.IAnvilRegistry;

public interface IModPlugin {

    String getPluginId();
    void registerRecipes(IAnvilRegistry anvilRegistry);

}
