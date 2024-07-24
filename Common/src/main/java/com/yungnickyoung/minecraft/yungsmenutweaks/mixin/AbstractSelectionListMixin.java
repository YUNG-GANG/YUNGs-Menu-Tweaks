package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import net.minecraft.client.gui.components.AbstractSelectionList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractSelectionList.class)
public class AbstractSelectionListMixin {
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
