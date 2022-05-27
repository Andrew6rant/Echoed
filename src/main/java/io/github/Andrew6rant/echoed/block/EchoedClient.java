package io.github.Andrew6rant.echoed.block;

import io.github.Andrew6rant.echoed.Echoed;
import io.github.Andrew6rant.echoed.client.StatueBlockRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class EchoedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(Echoed.PETRIFIED_ALLAY_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new StatueBlockRenderer());
    }
}
