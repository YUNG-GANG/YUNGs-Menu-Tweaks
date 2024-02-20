package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractSelectionList.class)
public class AbstractSelectionListMixin {
    @ModifyArg(method = "renderWidget", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blit(Lnet/minecraft/resources/ResourceLocation;IIFFIIII)V"), index = 0)
    public ResourceLocation yungsmenutweaks_changeSelectionListBackground(ResourceLocation original) {
        if (YungsMenuTweaksCommon.CONFIG.enableBackgroundTexture && original.equals(Screen.BACKGROUND_LOCATION)) {
            return YungsMenuTweaksCommon.CONFIG.backgroundTexture;
        }
        return original;
    }

    /**
     * Registers right-clicking all selection entry buttons as a valid click action.
     */
    @Inject(method = "isValidMouseClick", at = @At("HEAD"), cancellable = true)
    public void yungsmenutweaks_allowRightClickCycleButton(int action, CallbackInfoReturnable<Boolean> cir) {
        if (YungsMenuTweaksCommon.CONFIG.enableRightClickCycleButton) {
            cir.setReturnValue(action == 0 || action == 1);
        }
    }
}
