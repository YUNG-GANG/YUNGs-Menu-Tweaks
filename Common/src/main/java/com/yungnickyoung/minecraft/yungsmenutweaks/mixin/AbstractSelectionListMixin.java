package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AbstractSelectionList.class)
public class AbstractSelectionListMixin {
    @ModifyArg(method = "render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blit(Lnet/minecraft/resources/ResourceLocation;IIFFIIII)V"), index = 0)
    public ResourceLocation yungsmenutweaks_changeSelectionListBackground(ResourceLocation original) {
        if (YungsMenuTweaksCommon.CONFIG.enableBackgroundTexture && original.equals(Screen.BACKGROUND_LOCATION)) {
            return YungsMenuTweaksCommon.CONFIG.backgroundTexture;
        }
        return original;
    }
}
