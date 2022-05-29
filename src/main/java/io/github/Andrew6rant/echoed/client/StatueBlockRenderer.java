package io.github.Andrew6rant.echoed.client;

import io.github.Andrew6rant.echoed.block.PetrifiedAllayBlockEntity;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class StatueBlockRenderer extends GeoBlockRenderer<PetrifiedAllayBlockEntity> {
    public StatueBlockRenderer() {
        super(new StatueModel());
    }
}
