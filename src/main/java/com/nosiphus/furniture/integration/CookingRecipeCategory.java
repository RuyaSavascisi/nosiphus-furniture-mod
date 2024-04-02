package com.nosiphus.furniture.integration;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.core.ModBlocks;
import com.nosiphus.furniture.recipe.CookingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CookingRecipeCategory implements IRecipeCategory<CookingRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "cooking");
    public final static ResourceLocation TEXTURE = new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "textures/gui/microwave.png");
    private final IDrawable background;
    private final IDrawable icon;

    public CookingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MICROWAVE_LIGHT.get()));
    }

    @Override
    public RecipeType<CookingRecipe> getRecipeType() {
        return JEINFMPlugin.INFUSION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container.nfm.microwave");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, CookingRecipe cookingRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(cookingRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(cookingRecipe.getResultItem());
    }
}