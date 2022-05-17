package io.github.Andrew6rant.echoed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class EchoedClient implements ClientModInitializer {
    public static void registerTranslucent(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
    }
    @Override
    public void onInitializeClient() {
        registerTranslucent(Echoed.ECHO_GLASS);
    }
}
