package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractSelectionList.class)
public abstract class AbstractSelectionListMixinNeoForge {
    @Inject(method = "mouseScrolled", at = @At("HEAD"), cancellable = true)
    public void yungsmenutweaks_mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY, CallbackInfoReturnable<Boolean> cir) {
        if (YungsMenuTweaksCommon.CONFIG.enableMouseScrollOnSliders && isOptionsList(this)) {
            for (OptionsList.Entry entry : asOptionList(this).children()) {
                for (GuiEventListener child : entry.children()) {
                    if (child instanceof AbstractSliderButton sliderButton) {
                        if (child.isMouseOver(mouseX, mouseY)) {
                            sliderButton.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
                            cir.setReturnValue(true);
                        }
                    }
                }
            }
        }
    }

    @Unique
    private boolean isOptionsList(Object obj) {
        return obj instanceof OptionsList;
    }

    @Unique
    private OptionsList asOptionList(Object obj) {
        return (OptionsList) obj;
    }
}
