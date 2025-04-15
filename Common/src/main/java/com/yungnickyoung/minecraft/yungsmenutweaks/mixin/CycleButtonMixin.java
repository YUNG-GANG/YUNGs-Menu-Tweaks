package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.screens.Screen;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
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
    public void yungsmenutweaks_onPressCycleButton(CallbackInfo ci) {
        boolean isMouseRight = GLFW.glfwGetMouseButton(Minecraft.getInstance().getWindow().getWindow(), InputConstants.MOUSE_BUTTON_RIGHT) == GLFW.GLFW_PRESS;
        if (Screen.hasShiftDown() || (YungsMenuTweaksCommon.CONFIG.enableRightClickCycleButton && isMouseRight)) {
            this.cycleValue(-1);
        } else {
            this.cycleValue(1);
        }
        ci.cancel();
    }
}
