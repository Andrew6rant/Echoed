package io.github.Andrew6rant.echoed.block;

import io.github.Andrew6rant.echoed.Echoed;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class PetrifiedAllayBlockEntity extends BlockEntity implements IAnimatable {
    public PetrifiedAllayBlockEntity(BlockPos pos, BlockState state) {
        super(Echoed.PETRIFIED_ALLAY_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return null;
    }
}
