package com.stardewcraft.blocks;

import com.stardewcraft.StardewCraft;
import com.stardewcraft.blockentities.SafeBoxBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;

public class SafeBoxBlock extends Block implements BlockEntityProvider {
    public SafeBoxBlock(Settings settings) {
        super(settings);
    }
    // Your block properties and constructor

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SafeBoxBlockEntity(pos, state);
    }

}
