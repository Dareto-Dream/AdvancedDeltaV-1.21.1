package com.deltavdevs.advanceddeltav.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import org.jetbrains.annotations.NotNull;

public class LavaLamp extends Block {
    private static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 16, 10);
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public LavaLamp(Properties properties) {
        super(properties);

        this.registerDefaultState(this.stateDefinition.any().setValue(ACTIVE, false));
    }

    @Override
    public int getLightEmission(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        if (state.getValue(ACTIVE)) {
            return 10; // Full brightness when active
        } else {
            return 0; // No light when inactive
        }
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    public @NotNull VoxelShape getVisualShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, Level level, @NotNull BlockPos pos,
                                                        @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            BlockState newState = state.setValue(ACTIVE, !state.getValue(ACTIVE));
            level.setBlock(pos, newState, 3);
        }
        return InteractionResult.SUCCESS;
    }

    // Register the property to the block
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }
}