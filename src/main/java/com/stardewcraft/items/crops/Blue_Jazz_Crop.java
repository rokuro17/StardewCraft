package com.stardewcraft.items.crops;

import com.stardewcraft.StardewCraft;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

import javax.swing.text.html.BlockView;

/**
 *
 *  This class implements the Blue Jazz crop
 *
 * @author  Gabriel Pizarro, Daniel Monferrer
 * @version 0.0.1
 **/
public class Blue_Jazz_Crop extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D)
    };

    public Blue_Jazz_Crop(AbstractBlock.Settings settings) {
        super(settings);
    }
    /**
     * Method that returns the seeds item for the Blue Jazz crop
     * @return int This returns the seeds item
     */
    @Override
    public ItemConvertible getSeedsItem() {
        return StardewCraft.BLUE_JAZZ_SEEDS;
    }
    /**
     * Method that returns the voxel shape for the crop depending on the growth stage in the state
     * @param state The BlockState from where the growth state will be extracted
     * @param world The view
     * @param pos The position of the block
     * @param context The ShapeContext
     * @return VoxelShape This returns the VoxelShape for the crop
     */
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }
}