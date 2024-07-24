package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import com.yungnickyoung.minecraft.yungsmenutweaks.services.Services;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "renderBackground", at = @At("HEAD"), cancellable = true)
    public void yungsmenutweaks_overrideBackground(GuiGraphics guiGraphics, int $$1, int $$2, float $$3, CallbackInfo ci) {
        if (YungsMenuTweaksCommon.CONFIG.enableBackgroundTexture) {
            Services.PLATFORM.renderBackground((Screen) (Object) this, guiGraphics, YungsMenuTweaksCommon.CONFIG.backgroundTexture);
            ci.cancel();
        }
    }
}
