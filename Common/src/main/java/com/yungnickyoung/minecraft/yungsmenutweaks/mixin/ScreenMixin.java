package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import com.yungnickyoung.minecraft.yungsmenutweaks.services.Services;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "extractBackground", at = @At("HEAD"), cancellable = true)
    public void yungsmenutweaks_overrideBackground(final GuiGraphicsExtractor graphics, final int mouseX, final int mouseY, final float a, final CallbackInfo ci) {
        if (YungsMenuTweaksCommon.CONFIG.enableBackgroundTexture) {
            Services.PLATFORM.renderBackground((Screen) (Object) this, graphics, YungsMenuTweaksCommon.CONFIG.backgroundTexture, mouseX, mouseY, a);
            ci.cancel();
        }
    }
}
