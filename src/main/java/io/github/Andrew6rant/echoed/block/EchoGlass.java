package io.github.Andrew6rant.echoed.block;

import io.github.Andrew6rant.echoed.Echoed;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class EchoGlass extends AbstractGlassBlock {
    public EchoGlass(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return context.isHolding(Item.fromBlock(Echoed.ECHO_GLASS)) || context.isHolding(Echoed.ECHO_KEY) ? VoxelShapes.fullCube(): VoxelShapes.empty();
    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return context.isHolding(Echoed.ECHO_KEY) ? VoxelShapes.empty(): VoxelShapes.fullCube();
    }
    /*
    public float getBlastResistance() {
        return this.resistance;
    }
     */
}
