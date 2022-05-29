package io.github.Andrew6rant.echoed;

import io.github.Andrew6rant.echoed.client.StatueBlockRenderer;
import io.github.Andrew6rant.echoed.registry.BlockEntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class EchoedClient implements ClientModInitializer {
    public static void registerTranslucent(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
    }
    @Override
    public void onInitializeClient() {
        registerTranslucent(Echoed.ECHO_GLASS);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.PETRIFIED_ALLAY_BLOCK_ENTITY,
                (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new StatueBlockRenderer());
    }
}
