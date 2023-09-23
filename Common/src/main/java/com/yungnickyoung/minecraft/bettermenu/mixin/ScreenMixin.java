package com.yungnickyoung.minecraft.bettermenu.mixin;

import com.yungnickyoung.minecraft.bettermenu.BetterMenuCommon;
import com.yungnickyoung.minecraft.bettermenu.services.Services;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "renderDirtBackground", at = @At("HEAD"), cancellable = true)
    public void betterMenu_overrideDirtBackground(GuiGraphics guiGraphics, CallbackInfo ci) {
        if (BetterMenuCommon.CONFIG.enableBackgroundTexture) {
            Services.PLATFORM.renderBackground((Screen) (Object) this, guiGraphics, BetterMenuCommon.CONFIG.backgroundTexture);
            ci.cancel();
        }
    }
}
