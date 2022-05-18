package io.github.Andrew6rant.echoed.block;

import io.github.Andrew6rant.echoed.Echoed;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.AbstractRandom;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EchoGlass extends AbstractGlassBlock {
    public EchoGlass(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return context.isHolding(Echoed.ECHO_GLASS.asItem()) || context.isHolding(Echoed.ECHO_KEY) ? VoxelShapes.fullCube(): VoxelShapes.empty();
    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return context.isHolding(Echoed.ECHO_KEY) ? VoxelShapes.empty(): VoxelShapes.fullCube();
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        Vec3d veloc = entity.getVelocity();
        if (entity.isSneaking()) {
            entity.setVelocity(veloc.getX(), 0.2D, veloc.getZ());
            //entity.slowMovement(state, new Vec3d(0.9D, -1D, 0.9D));
        }
        else {
            entity.setVelocity(veloc.getX()/1.5D, veloc.getY(), veloc.getZ()/1.5D);
            //entity.setVelocity(0.9D, 1D, 0.9D);
            //entity.slowMovement(state, new Vec3d(0.9D, 0D, 0.9D));
        }
    }
}
