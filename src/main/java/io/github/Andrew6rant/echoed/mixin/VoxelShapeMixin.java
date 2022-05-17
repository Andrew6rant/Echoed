package io.github.Andrew6rant.echoed.mixin;

import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelSet;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VoxelShape.class)
public class VoxelShapeMixin {
    @Mutable
    @Final
    @Shadow
    protected VoxelSet voxels;

    public VoxelShapeMixin(VoxelSet voxels) {
        this.voxels = voxels;
    }

    @Inject(method = "getBoundingBox", at = @At("HEAD"), cancellable = true)
    private void boundBoxIfEmpty(CallbackInfoReturnable<Box> cir) {
        if (this.voxels.isEmpty()) {
            cir.setReturnValue(new Box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
        }
    }
}