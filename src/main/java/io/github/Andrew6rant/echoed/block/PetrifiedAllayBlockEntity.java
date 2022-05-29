package io.github.Andrew6rant.echoed.block;

import io.github.Andrew6rant.echoed.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class PetrifiedAllayBlockEntity extends BlockEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public PetrifiedAllayBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.PETRIFIED_ALLAY_BLOCK_ENTITY, pos, state);
    }

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().transitionLengthTicks = 0;
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.allay.static", false));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(
                new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
