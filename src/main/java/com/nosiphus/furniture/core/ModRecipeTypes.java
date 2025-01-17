package com.nosiphus.furniture.core;

import com.nosiphus.furniture.Reference;
import com.nosiphus.furniture.item.crafting.ChoppingRecipe;
import com.nosiphus.furniture.item.crafting.CookingRecipe;
import com.nosiphus.furniture.item.crafting.ToastingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeTypes {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Reference.MOD_ID);

    public static final RegistryObject<RecipeType<ChoppingRecipe>> CHOPPING = register("chopping");
    public static final RegistryObject<RecipeType<CookingRecipe>> COOKING = register("cooking");
    public static final RegistryObject<RecipeType<ToastingRecipe>> TOASTING = register("toasting");

    private static <T extends Recipe<?>> RegistryObject<RecipeType<T>> register(String name)
    {
        return RECIPE_TYPES.register(name, () -> new RecipeType<>()
        {
            @Override
            public String toString()
            {
                return name;
            }
        });
    }


}
