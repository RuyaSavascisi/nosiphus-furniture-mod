package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.nosiphus.furniture.blockentity.ToasterBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class ToasterBlockEntityRenderer implements BlockEntityRenderer<ToasterBlockEntity> {

    public ToasterBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(ToasterBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        NonNullList<ItemStack> toaster = blockEntity.getToaster();
        for(int j = 0; j < toaster.size(); j++) {
            ItemStack stack = toaster.get(j);
            if(!stack.isEmpty()) {
                poseStack.pushPose();
                poseStack.translate(0.5, 1.0, 0.5);
                poseStack.mulPose(Axis.XP.rotationDegrees(90F));
                poseStack.translate(-0.2 + 0.4 * (j % 2), -0.2 + 0.4 * (j / 2), 0.0);
                poseStack.scale(0.375F, 0.375F, 0.375F);
                poseStack.mulPose(Axis.ZP.rotationDegrees(90F * blockEntity.getRotations()[j]));
                Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.FIXED, light, overlay, poseStack, source, blockEntity.getLevel(), 0);
                poseStack.popPose();
            }
        }
    }

}
