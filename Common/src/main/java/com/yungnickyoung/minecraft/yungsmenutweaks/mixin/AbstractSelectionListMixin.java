package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.input.MouseButtonInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractWidget.class)
public abstract class AbstractSelectionListMixin {
    /**
     * Registers right-clicking all selection entry buttons as a valid click action.
     */
    @Inject(method = "isValidClickButton", at = @At("HEAD"), cancellable = true)
    public void yungsmenutweaks_allowRightClickCycleButton(final MouseButtonInfo buttonInfo, final CallbackInfoReturnable<Boolean> cir) {
        if (YungsMenuTweaksCommon.CONFIG.enableRightClickCycleButton && ((Object) this) instanceof CycleButton) {
            cir.setReturnValue(buttonInfo.button() == InputConstants.MOUSE_BUTTON_LEFT || buttonInfo.button() == InputConstants.MOUSE_BUTTON_RIGHT);
        }
    }
}
