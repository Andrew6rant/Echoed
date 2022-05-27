package io.github.Andrew6rant.echoed.client;

import io.github.Andrew6rant.echoed.Echoed;
import io.github.Andrew6rant.echoed.block.PetrifiedAllayBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StatueModel extends AnimatedGeoModel<PetrifiedAllayBlockEntity> {
    @Override
    public Identifier getModelResource(PetrifiedAllayBlockEntity object) {
        return new Identifier(Echoed.ModID, "geo/petrified_allay.geo.json");
    }

    @Override
    public Identifier getTextureResource(PetrifiedAllayBlockEntity object) {
        return new Identifier(Echoed.ModID, "textures/block/petrified_allay.png");
    }

    @Override
    public Identifier getAnimationResource(PetrifiedAllayBlockEntity animatable) {
        return new Identifier(Echoed.ModID, "animations/petrified_allay.animation.json");
    }
}
