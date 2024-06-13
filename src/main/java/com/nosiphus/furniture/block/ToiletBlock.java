package com.nosiphus.furniture.block;

import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.entity.SeatEntity;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import com.nosiphus.furniture.blockentity.ToiletBlockEntity;
import com.nosiphus.furniture.core.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToiletBlock extends FurnitureHorizontalBlock implements EntityBlock
{

    public final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public ToiletBlock(Properties properties)
    {
        super(properties);
    }

    private VoxelShape getShape(BlockState state)
    {

        if(SHAPES.containsKey(state))
        {
            return SHAPES.get(state);
        }

        List<VoxelShape> shapes = new ArrayList<>();
        Direction direction = state.getValue(DIRECTION);

        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.2, 6.4, 8.16, 12.8, 18.4, 9.76), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.2, 6.4, 6.24, 12.8, 18.4, 7.84), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.6, 16.0, 1.6, 16.0, 17.6, 14.4), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.4, 4.8, 2.4, 16.0, 16.0, 13.6), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 4.8, 2.4, 10.4, 9.6, 4.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 4.8, 4.0, 3.2, 9.6, 12.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 4.8, 12.0, 10.4, 9.6, 13.6), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 4.8, 4.0, 11.2, 5.6, 6.4), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 4.8, 9.6, 11.2, 5.6, 12.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.2, 4.8, 4.0, 11.2, 6.4, 12.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.2, 0.0, 4.0, 14.4, 4.8, 12.0), Direction.EAST))[direction.get2DDataValue()]);

        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return this.getShape(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return this.getShape(state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player playerEntity, InteractionHand hand, BlockHitResult result)
    {
        if(!level.isClientSide())
        {
            if(playerEntity.isCrouching()) {
                level.playSound(null, pos, ModSounds.BLOCK_TOILET_FLUSH.get(), SoundSource.BLOCKS, 0.75F, 1.0F);
            }
            ItemStack heldItem = playerEntity.getItemInHand(hand);
            if(heldItem.getItem() == Items.GLASS_BOTTLE)
            {
                IFluidHandler handler = FluidUtil.getFluidHandler(level, pos, null).orElse(null);
                if(handler.getFluidInTank(0).getAmount() > 0 && !level.isClientSide())
                {
                    if(!playerEntity.getAbilities().instabuild)
                    {
                        ItemStack waterPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
                        heldItem.shrink(1);
                        if(heldItem.isEmpty())
                        {
                            playerEntity.setItemInHand(hand, waterPotion);
                        }
                        else if(!playerEntity.getInventory().add(waterPotion))
                        {
                            playerEntity.drop(waterPotion, false);
                        }
                        else if(playerEntity instanceof ServerPlayer)
                        {
                            playerEntity.inventoryMenu.sendAllDataToRemote();
                        }
                    }

                    level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    handler.drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.EXECUTE);
                }
                return InteractionResult.sidedSuccess(level.isClientSide());
            }

            if(!heldItem.isEmpty() && heldItem.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent())
            {
                return FluidUtil.interactWithFluidHandler(playerEntity, hand, level, pos, result.getDirection()) ? InteractionResult.SUCCESS : InteractionResult.PASS;
            }

            if(heldItem.isEmpty() || !heldItem.isEmpty() && !heldItem.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent()) {
                return SeatEntity.create(level, pos, 0.4, playerEntity, state.getValue(DIRECTION));
            }

            BlockPos waterPos = pos.below().below();
            if(this.isWaterSource(level, waterPos))
            {
                IFluidHandler handler = FluidUtil.getFluidHandler(level, pos, null).orElse(null);
                if(handler.getFluidInTank(0).getAmount() != handler.getTankCapacity(0))
                {
                    handler.fill(new FluidStack(Fluids.WATER, FluidType.BUCKET_VOLUME), IFluidHandler.FluidAction.EXECUTE);
                    level.playSound(null, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

                    Direction direction = state.getValue(DIRECTION);
                    double posX = pos.getX() + 0.5 + direction.getNormal().getX() * 0.1;
                    double posY = pos.getY() + 1.15;
                    double posZ = pos.getZ() + 0.5 + direction.getNormal().getZ() * 0.1;
                    ((ServerLevel) level).sendParticles(ParticleTypes.FALLING_WATER, posX, posY, posZ, 10, 0.01, 0.01, 0.01, 0);

                    int adjacentSources = 0;
                    adjacentSources += this.isWaterSource(level, waterPos.north()) ? 1 : 0;
                    adjacentSources += this.isWaterSource(level, waterPos.east()) ? 1 : 0;
                    adjacentSources += this.isWaterSource(level, waterPos.south()) ? 1 : 0;
                    adjacentSources += this.isWaterSource(level, waterPos.west()) ? 1 : 0;
                    if(adjacentSources < 2) //If it has less then two adjacent water sources, it is not infinite and thus it should be consumed
                    {
                        level.setBlockAndUpdate(waterPos, Blocks.AIR.defaultBlockState());
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    private boolean isWaterSource(Level level, BlockPos pos)
    {
        return level.getFluidState(pos).getType() == Fluids.WATER;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new ToiletBlockEntity(pos, state);
    }

}