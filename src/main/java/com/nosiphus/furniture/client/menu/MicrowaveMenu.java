package com.nosiphus.furniture.client.menu;

import com.nosiphus.furniture.blockentity.MicrowaveBlockEntity;
import com.nosiphus.furniture.core.ModMenuTypes;
import com.nosiphus.furniture.core.ModRecipeTypes;
import com.nosiphus.furniture.inventory.MicrowaveSlot;
import com.nosiphus.furniture.inventory.RedstoneSlot;
import com.nosiphus.furniture.recipe.CookingRecipe;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MicrowaveMenu extends AbstractContainerMenu {

    protected final MicrowaveBlockEntity blockEntity;

    public MicrowaveMenu(int ID, Inventory inventory, MicrowaveBlockEntity blockEntity) {
        super(ModMenuTypes.MICROWAVE.get(), ID);
        this.blockEntity = blockEntity;

        this.addSlot(new MicrowaveSlot(blockEntity, 0, 65, 43));
        this.addSlot(new RedstoneSlot(blockEntity, 1, 126, 40));

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; ++j)
            {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 92));
            }
        }

        for(int i = 0; i < 9; i++)
        {
            this.addSlot(new Slot(inventory, i, i * 18 + 8, 150));
        }

    }

    @Override
    public boolean stillValid(Player player) {
        return this.blockEntity.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player playerEntity, int index)
    {
        ItemStack clickedStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if(slot != null && slot.hasItem())
        {
            ItemStack slotStack = slot.getItem();
            clickedStack = slotStack.copy();
            if(index < this.blockEntity.getContainerSize())
            {
                if(!this.moveItemStackTo(slotStack, this.blockEntity.getContainerSize(), this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if(!this.moveItemStackTo(slotStack, 0, this.blockEntity.getContainerSize(), false))
            {
                return ItemStack.EMPTY;
            }

            if(slotStack.isEmpty())
            {
                slot.set(ItemStack.EMPTY);
            }
            else
            {
                slot.setChanged();
            }
        }
        return clickedStack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
    }

    public MicrowaveBlockEntity getBlockEntity() {
        return blockEntity;
    }

}
