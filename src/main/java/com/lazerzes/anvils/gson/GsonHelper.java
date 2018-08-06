package com.lazerzes.anvils.gson;

import com.google.gson.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.lang.reflect.Type;

public class GsonHelper {

    public static abstract class Serializer<T> implements JsonDeserializer<T>, JsonSerializer<T>{

        @Override
        public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException{
            return context.deserialize(jsonElement, getType());
        }

        @Override
        public JsonElement serialize(T t, Type type, JsonSerializationContext context){
            return context.serialize(t);
        }

        public abstract Class<T> getType();

    }

    public static final Serializer<ResourceLocation> RESOURCE_LOCATION_SERIALIZER = new Serializer<ResourceLocation>() {
        @Override
        public Class<ResourceLocation> getType() {
            return ResourceLocation.class;
        }

        @Override
        public ResourceLocation deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException{
            String domain = json.getAsJsonObject().get("domain").getAsString();
            String path = json.getAsJsonObject().get("path").getAsString();
            return new ResourceLocation(domain, path);
        }

        @Override
        public JsonElement serialize(ResourceLocation src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject object = new JsonObject();
            object.addProperty("domain", src.getResourceDomain());
            object.addProperty("path", src.getResourcePath());
            return object;
        }

    };


    public static final Serializer<NBTTagCompound> NBT_SERIALIZER = new Serializer<NBTTagCompound>() {
        @Override
        public Class<NBTTagCompound> getType() {
            return NBTTagCompound.class;
        }

        @Override
        public NBTTagCompound deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException{
            String nbt = json.getAsJsonObject().get("data").getAsString();
            try {
                return JsonToNBT.getTagFromJson(nbt);
            }catch(NBTException e){
                e.printStackTrace();
            }
            return new NBTTagCompound();
        }

        @Override
        public JsonElement serialize(NBTTagCompound src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject object = new JsonObject();
            object.addProperty("data", src.toString());
            return object;
        }

    };


    public static final Serializer<ItemStack> ITEM_STACK_SERIALIZER = new Serializer<ItemStack>() {
        @Override
        public Class<ItemStack> getType() {
            return ItemStack.class;
        }

        @Override
        public ItemStack deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException{
            ResourceLocation registry = context.deserialize(json.getAsJsonObject().get("registry").getAsJsonObject(), ResourceLocation.class);
            NBTTagCompound nbtTagCompound = context.deserialize(json.getAsJsonObject().get("nbt"), NBTTagCompound.class);
            int itemCount = json.getAsJsonObject().get("count").getAsInt();
            ItemStack stack = new ItemStack(ForgeRegistries.ITEMS.getValue(registry), itemCount);
            stack.setTagCompound(nbtTagCompound);

            return stack;
        }

        @Override
        public JsonElement serialize(ItemStack src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject obj = new JsonObject();
            obj.add("registry", context.serialize(src.getItem().getRegistryName()));
            obj.add("nbt", context.serialize(src.getTagCompound()));
            obj.add("count", context.serialize(src.getCount()));
            return obj;
        }

    };


    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().registerTypeAdapter(RESOURCE_LOCATION_SERIALIZER.getType(), RESOURCE_LOCATION_SERIALIZER).registerTypeAdapter(NBT_SERIALIZER.getType(), NBT_SERIALIZER).registerTypeAdapter(ITEM_STACK_SERIALIZER.getType(), ITEM_STACK_SERIALIZER).create();

}
