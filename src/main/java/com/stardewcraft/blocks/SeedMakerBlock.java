package com.stardewcraft.blocks;

import com.mojang.serialization.MapCodec;
import com.stardewcraft.StardewCraft;
import com.stardewcraft.blockentities.SeedMakerEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class SeedMakerBlock extends BlockWithEntity {

    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public SeedMakerBlock(Settings settings){
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
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
        return type == StardewCraft.SEED_MAKER_ENTITY ? (BlockEntityTicker<T>) (world1, pos, state1, be) -> SeedMakerEntity.tick(world1, pos, state1, (SeedMakerEntity) be) : null;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(hand);
        SeedMakerEntity blockEntity = (SeedMakerEntity) world.getBlockEntity(pos);
        Random random = new Random();

        if (blockEntity != null) {
            if (heldItem.getItem() == StardewCraft.PARSNIP) {
                if (!world.isClient) {
                    blockEntity.startTimer();
                    blockEntity.setHasParsnip(true); // Set the flag to true when a parsnip is placed
                    heldItem.decrement(1);
                    player.setStackInHand(hand, heldItem);
                    return ActionResult.SUCCESS;
                }
            } else if (blockEntity.isTimerFinished() && blockEntity.getHasParsnip()) { // Check the flag before dropping seeds
                if (!world.isClient) {
                    int seedsCount = random.nextInt(5) + 1; // Randomly generate between 1 and 5 seeds
                    ItemScatterer.spawn(world, pos, new SimpleInventory(new ItemStack(StardewCraft.PARSNIP_SEEDS, seedsCount)));
                    blockEntity.resetTimer();
                    blockEntity.setHasParsnip(false); // Reset the flag after seeds are dropped
                    return ActionResult.SUCCESS;
                }
            } else if (blockEntity.getItems().isEmpty() && !blockEntity.isTimerFinished()) {
                if (world.isClient) {
                    world.addParticle(ParticleTypes.ASH, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0.02, 0);
                }
            }
        }

        return ActionResult.PASS;
    }
}
