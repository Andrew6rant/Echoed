package io.github.Andrew6rant.echoed.block;

import io.github.Andrew6rant.echoed.registry.BlockEntityRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class StatueBlock extends Block implements BlockEntityProvider {

    public StatueBlock() {
        super(AbstractBlock.Settings.of(Material.STONE).nonOpaque());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getPlayerFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.PETRIFIED_ALLAY_BLOCK_ENTITY.instantiate(pos, state);
    }
}
