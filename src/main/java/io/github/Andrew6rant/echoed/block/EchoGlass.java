package io.github.Andrew6rant.echoed.block;

import com.unascribed.lib39.waypoint.api.AbstractHaloBlockEntity;
import io.github.Andrew6rant.echoed.Echoed;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EchoGlass extends AbstractGlassBlock implements BlockEntityProvider {
    public EchoGlass(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return context.isHolding(Echoed.ECHO_GLASS.asItem()) || context.isHolding(Echoed.ECHO_KEY) ? VoxelShapes.fullCube(): VoxelShapes.empty();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        //if (context instanceof EntityShapeContext entityShapeContext) {
        //    Entity entity = entityShapeContext.getEntity();
        //    if (entity != null) {
        //        if (entity.isSneaking()) {
        //            return VoxelShapes.empty();
        //        }
        //    }
        //}
        //return VoxelShapes.fullCube();
        return context.isHolding(Echoed.ECHO_KEY) ? VoxelShapes.empty(): VoxelShapes.fullCube();
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        Vec3d veloc = entity.getVelocity();
        if (entity.isSneaking()) {
            entity.setVelocity(veloc.getX(), 0.3D, veloc.getZ());
        }
        else {
            entity.setVelocity(veloc.getX()/1.5D, veloc.getY(), veloc.getZ()/1.5D);
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EchoGlassBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? AbstractHaloBlockEntity::tick : null;
    }
}
