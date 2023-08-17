package io.github.Andrew6rant.echoed.block;

import com.unascribed.lib39.waypoint.api.AbstractHaloBlockEntity;
import com.unascribed.lib39.waypoint.api.HaloBlockEntity;
import io.github.Andrew6rant.echoed.Echoed;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EchoGlassBlockEntity extends AbstractHaloBlockEntity {

    public EchoGlassBlockEntity(BlockPos pos, BlockState state) {
        super(Echoed.ECHO_GLASS_BLOCK_ENTITY, pos, state);
    }

}
