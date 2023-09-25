package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import com.yungnickyoung.minecraft.yungsmenutweaks.gui.IRightClickable;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.CycleButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractWidget.class)
public abstract class AbstractWidgetMixin implements IRightClickable {
    @Unique private boolean wasRightClicked;

    /**
     * Registers right-clicking cycle buttons as a valid click action.
     */
    @Inject(method = "isValidClickButton", at = @At("HEAD"), cancellable = true)
    public void yungsmenutweaks_allowRightClickCycleButton(int action, CallbackInfoReturnable<Boolean> cir) {
        if (isCycleButton(this) && YungsMenuTweaksCommon.CONFIG.enableRightClickCycleButton) {
            this.setRightClicked(action == 1);
            cir.setReturnValue(action == 0 || action == 1);
        }
    }

    @Unique
    private boolean isCycleButton(Object obj) {
        return obj instanceof CycleButton;
    }

    @Override
    public void setRightClicked(boolean rightClicked) {
        this.wasRightClicked = rightClicked;
    }

    @Override
    public boolean wasRightClicked() {
        return this.wasRightClicked;
    }
}
