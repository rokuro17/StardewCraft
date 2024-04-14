package com.stardewcraft.blockentities;

import com.stardewcraft.StardewCraft;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScarecrowBlockEntity extends BlockEntity {
    public ScarecrowBlockEntity( BlockPos pos, BlockState state) {
        super(StardewCraft.SCARECROW_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ScarecrowBlockEntity blockEntity) {
        }
}
