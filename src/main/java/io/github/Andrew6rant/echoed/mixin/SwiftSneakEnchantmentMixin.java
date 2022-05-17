package io.github.Andrew6rant.echoed.mixin;

import net.minecraft.enchantment.SwiftSneakEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SwiftSneakEnchantment.class)
public class SwiftSneakEnchantmentMixin {
    @Inject(method = "getMaxLevel", at = @At("RETURN"), cancellable = true)
    public void getMaxLevel(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(4);
    }
}
