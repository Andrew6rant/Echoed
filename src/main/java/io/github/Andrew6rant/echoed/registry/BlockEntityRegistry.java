package io.github.Andrew6rant.echoed.registry;

import io.github.Andrew6rant.echoed.Echoed;
import io.github.Andrew6rant.echoed.block.PetrifiedAllayBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistry {
    public static final BlockEntityType<PetrifiedAllayBlockEntity> PETRIFIED_ALLAY_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE, Echoed.ModID + ":petrified_allay",
            FabricBlockEntityTypeBuilder.create(PetrifiedAllayBlockEntity::new, Echoed.PETRIFIED_ALLAY).build(null));
}
