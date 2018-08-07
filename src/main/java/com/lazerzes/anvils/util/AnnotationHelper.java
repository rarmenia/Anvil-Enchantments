package com.lazerzes.anvils.util;

import com.lazerzes.anvils.api.AnvilPlugin;
import com.lazerzes.anvils.api.IModPlugin;
import com.lazerzes.anvils.plugin.VanillaPlugin;
import mezz.jei.util.Log;
import net.minecraftforge.fml.common.discovery.ASMDataTable;

import java.util.ArrayList;
import java.util.Set;

public class AnnotationHelper {

    public static void ensureVanilla(ArrayList<IModPlugin> modPlugins){

        IModPlugin vanilla = null;
        for(IModPlugin iModPlugin : modPlugins){

            if(iModPlugin instanceof VanillaPlugin){
                vanilla = iModPlugin;
                break;
            }

        }

        if(vanilla != null){
            modPlugins.remove(vanilla);
            modPlugins.add(0, vanilla);
        }

    }

    public static ArrayList<IModPlugin> getPlugins(ASMDataTable dataTable){
        return getInstances(dataTable, AnvilPlugin.class, IModPlugin.class);
    }

    private static <T> ArrayList<T> getInstances(ASMDataTable dataTable, Class annotationClass, Class<T> instanceClass) {
        String annotationClassName = annotationClass.getCanonicalName();
        Set<ASMDataTable.ASMData> data = dataTable.getAll(annotationClassName);
        ArrayList<T> instances = new ArrayList<>();
        for (ASMDataTable.ASMData asmData : data) {
            try {
                Class<?> asmClass = Class.forName(asmData.getClassName());
                Class<? extends T> asmInstanceClass = asmClass.asSubclass(instanceClass);
                T instance = asmInstanceClass.newInstance();
                instances.add(instance);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | LinkageError e) {
                Log.get().error("Failed to load: {}", asmData.getClassName(), e);
            }
        }
        return instances;
    }

}
