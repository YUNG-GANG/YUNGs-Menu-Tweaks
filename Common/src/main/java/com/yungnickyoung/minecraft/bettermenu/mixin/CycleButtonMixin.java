package com.yungnickyoung.minecraft.bettermenu.mixin;

import com.yungnickyoung.minecraft.bettermenu.BetterMenuCommon;
import com.yungnickyoung.minecraft.bettermenu.gui.IRightClickable;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CycleButton.class)
public abstract class CycleButtonMixin {
    @Shadow protected abstract void cycleValue(int $$0);

    /**
     * Allows right-clicking cycle buttons to cycle backwards.
     */
    @Inject(method = "onPress", at = @At("HEAD"), cancellable = true)
    public void betterMenu_onPressCycleButton(CallbackInfo ci) {
        if (Screen.hasShiftDown() || (BetterMenuCommon.CONFIG.enableRightClickCycleButton && wasRightClicked(this))) {
            this.cycleValue(-1);
        } else {
            this.cycleValue(1);
        }
        ci.cancel();
    }

    @Unique
    private boolean wasRightClicked(Object obj) {
        return obj instanceof IRightClickable && ((IRightClickable) obj).wasRightClicked();
    }
}
