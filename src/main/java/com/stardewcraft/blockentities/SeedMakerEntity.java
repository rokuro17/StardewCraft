package com.stardewcraft.blockentities;

import com.stardewcraft.StardewCraft;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeedMakerEntity extends BlockEntity {
    private boolean hasParsnip = false;

    public SeedMakerEntity(BlockPos pos, BlockState state) {
        super(StardewCraft.SEED_MAKER_ENTITY, pos, state);
    }

    public void setHasParsnip(boolean hasParsnip) {
        this.hasParsnip = hasParsnip;
    }

    public boolean getHasParsnip() {
        return this.hasParsnip;
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putBoolean("hasParsnip", hasParsnip);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        hasParsnip = nbt.getBoolean("hasParsnip");
    }
    private final List<ItemStack> inventory = new ArrayList<>(Collections.nCopies(1, ItemStack.EMPTY));
    private int timer = 0;
    public void startTimer() {
        timer = 1200; // 1200 ticks = 1 minute in real time
    }

    public boolean isTimerFinished() {
        return timer <= 0;
    }

    public void resetTimer() {
        timer = 0;
    }
    public static void tick(World world, BlockPos pos, BlockState state, SeedMakerEntity blockEntity) {
        if (blockEntity.timer > 0) {
            blockEntity.timer--;
        }
    }
    public List<ItemStack> getItems() {
        return inventory;
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
}