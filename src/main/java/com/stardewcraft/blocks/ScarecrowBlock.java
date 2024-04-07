package com.stardewcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ScarecrowBlock extends Block {

    public ScarecrowBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape STICK = VoxelShapes.cuboid(0.4375f, 0f, 0.4375f, 0.5625f, 0.5f, 0.5625f);
    private static final VoxelShape BODY = VoxelShapes.cuboid(0.1875f, 0.5f, 0.3125f, 0.8125f, 1.375f, 0.6875f);
    private static final VoxelShape ARM1 = VoxelShapes.cuboid(-0.0625f, 0.625f, 0.375f, 0.1875f, 1.375f, 0.6325f);
    private static final VoxelShape ARM2 = VoxelShapes.cuboid(0.8125f, 0.625f, 0.375f, 1.0625f, 1.375f, 0.625f);
    private static final VoxelShape HEAD = VoxelShapes.cuboid(0.25f, 1.375f, 0.25f, 0.75f, 1.875f, 0.75f);
    private static final VoxelShape HAT_PLANE = VoxelShapes.cuboid(0f, 1.75f, 0f, 1f, 1.75f, 1f);
    private static final VoxelShape HAT_COPE = VoxelShapes.cuboid(0.1875f, 1.75f, 0.1875f, 0.8125f, 2f, 0.8125f);
    private static final VoxelShape COMPLEX_SHAPE = VoxelShapes.union(STICK, BODY, ARM1, ARM2, HEAD, HAT_PLANE, HAT_COPE);

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(Text.translatable("no_crows_message"), false);
        }

        return ActionResult.SUCCESS;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return COMPLEX_SHAPE;
    }
}