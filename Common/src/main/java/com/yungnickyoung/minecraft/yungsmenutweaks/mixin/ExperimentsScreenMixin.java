package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.worldselection.ExperimentsScreen;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ExperimentsScreen.class)
public class ExperimentsScreenMixin {
    @ModifyArg(method = "renderBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blit(Lnet/minecraft/resources/ResourceLocation;IIFFIIII)V"), index = 0)
    private ResourceLocation yungsmenutweaks_changeExperimentsScreenBackground(ResourceLocation original) {
        if (YungsMenuTweaksCommon.CONFIG.enableBackgroundTexture && original.equals(Screen.BACKGROUND_LOCATION)) {
            return YungsMenuTweaksCommon.CONFIG.backgroundTexture;
        }
        return original;
    }
}
