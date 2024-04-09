package com.stardewcraft.blocks;

import com.mojang.serialization.MapCodec;
import com.stardewcraft.blockentities.SeedMakerEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SeedMakerBlock extends BlockWithEntity {

    public SeedMakerBlock(Settings settings){
        super(settings);
    }

    public static final VoxelShape CUBE1 = VoxelShapes.cuboid(4D, 1D, 3D, 14D, 8D, 13D);
    public static final VoxelShape CUBE2 = VoxelShapes.cuboid(8D, 10D, 7D, 10D, 14D, 9D);
    public static final VoxelShape CUBE3 = VoxelShapes.cuboid(7D, 14D, 6D, 11D, 16D, 10D);
    public static final VoxelShape CUBE4 = VoxelShapes.cuboid(5D, 8D, 4D, 13D, 9D, 12D);
    public static final VoxelShape CUBE5 = VoxelShapes.cuboid(6D, 9D, 5D, 12D, 10D, 11D);
    public static final VoxelShape CUBE6 = VoxelShapes.cuboid(5D, 0D, 4D, 13D, 1D, 12D);
    private static final VoxelShape COMPLEX_SHAPE = VoxelShapes.union(CUBE1, CUBE2, CUBE3, CUBE4, CUBE5, CUBE6);

    public VoxelShape getOutlineShape(BlockView view, BlockPos pos, ShapeContext context) {
        return COMPLEX_SHAPE;
    }
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SeedMakerEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return null;
    }
}
