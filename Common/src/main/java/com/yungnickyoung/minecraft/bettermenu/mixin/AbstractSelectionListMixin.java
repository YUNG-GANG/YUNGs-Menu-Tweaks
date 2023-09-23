package com.yungnickyoung.minecraft.bettermenu.mixin;

import com.yungnickyoung.minecraft.bettermenu.BetterMenuCommon;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractSelectionList.class)
public class AbstractSelectionListMixin {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blit(Lnet/minecraft/resources/ResourceLocation;IIFFIIII)V"))
    private void bettermenu_changeSelectionListBackground(GuiGraphics instance, ResourceLocation id, int $$1, int $$2, float $$3, float $$4, int $$5, int $$6, int $$7, int $$8) {
        if (BetterMenuCommon.CONFIG.enableBackgroundTexture && id.equals(Screen.BACKGROUND_LOCATION)) {
            instance.blit(BetterMenuCommon.CONFIG.backgroundTexture, $$1, $$2, $$3, $$4, $$5, $$6, $$7, $$8);
        } else {
            instance.blit(id, $$1, $$2, $$3, $$4, $$5, $$6, $$7, $$8);
        }
    }
}
