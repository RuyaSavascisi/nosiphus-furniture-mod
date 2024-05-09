package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.util.BlockEntityUtil;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import com.nosiphus.furniture.blockentity.ChoppingBoardBlockEntity;
import com.nosiphus.furniture.core.ModItems;
import com.nosiphus.furniture.recipe.ChoppingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChoppingBoardBlock extends FurnitureHorizontalBlock implements EntityBlock
{

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ChoppingBoardBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] CHOPPING_BOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.0, 0.0, 0.5, 13.0, 1.0, 15.5), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(CHOPPING_BOARD[direction.get2DDataValue()]);
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return SHAPES.get(state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack heldItem = player.getItemInHand(hand);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if(blockEntity instanceof ChoppingBoardBlockEntity) {
            ChoppingBoardBlockEntity choppingBoardBlockEntity = (ChoppingBoardBlockEntity) blockEntity;
            if(!heldItem.isEmpty()) {
                Optional<ChoppingRecipe> optional = choppingBoardBlockEntity.findMatchingRecipe(heldItem);
                if(optional.isPresent()) {
                    if(choppingBoardBlockEntity.getFood() == null) {
                        choppingBoardBlockEntity.setFood(new ItemStack(heldItem.getItem(), 1, heldItem.getTag()));
                        BlockEntityUtil.sendUpdatePacket(blockEntity);
                        if(!player.getAbilities().instabuild) {
                            heldItem.shrink(1);
                        }
                        return InteractionResult.SUCCESS;
                    } else {
                        if(!level.isClientSide()) {
                            ItemEntity foodEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.4, pos.getZ() + 0.5, choppingBoardBlockEntity.getFood());
                            level.addFreshEntity(foodEntity);
                            choppingBoardBlockEntity.setFood(null);
                            BlockEntityUtil.sendUpdatePacket(blockEntity);
                        }
                        return InteractionResult.SUCCESS;
                    }
                } else if(heldItem.getItem() == ModItems.KNIFE.get() && choppingBoardBlockEntity.getFood() != null) {
                    if(choppingBoardBlockEntity.chopFood()) {
                        heldItem.setDamageValue(heldItem.getDamageValue() - 1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
            if(choppingBoardBlockEntity.getFood() != null) {
                if(!level.isClientSide()) {
                    ItemEntity foodEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.4, pos.getZ() + 0.5, choppingBoardBlockEntity.getFood());
                    level.addFreshEntity(foodEntity);
                }
                choppingBoardBlockEntity.setFood(null);
                BlockEntityUtil.sendUpdatePacket(blockEntity);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChoppingBoardBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
    }

}