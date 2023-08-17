package io.github.Andrew6rant.echoed.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Mutable
    @Final
    @Shadow
    private final MinecraftClient client;

    @Shadow @Final private static Identifier PUMPKIN_BLUR;

    @Shadow
    private void renderOverlay(DrawContext context, Identifier texture, float opacity) {
    }

    public InGameHudMixin(MinecraftClient client) {
        this.client = client;
    }

    @Inject(method = "render", at = @At(target = "Lnet/minecraft/client/network/ClientPlayerEntity;getFrozenTicks()I", value = "INVOKE"))
    private void insertShimmerRenderer(DrawContext context, float tickDelta, CallbackInfo ci) {
        if (client.player.hasStatusEffect(StatusEffects.SPEED)) {
            float amplifier = client.player.getStatusEffect(StatusEffects.SPEED).getAmplifier();
            renderOverlay(context, PUMPKIN_BLUR, 1/amplifier); // just testing
        }
    }
}
