package com.yungnickyoung.minecraft.bettermenu.mixin.compat.modmenu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.terraformersmc.modmenu.gui.widget.DescriptionListWidget;
import com.yungnickyoung.minecraft.bettermenu.BetterMenuCommon;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DescriptionListWidget.class)
public abstract class ModMenuDescriptionListWidgetMixin {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V"))
    private void bettermenu_renderModMenuDescriptionListWidgetBackground(int i, ResourceLocation id) {
        if (BetterMenuCommon.CONFIG.enableBackgroundTexture && id.equals(Screen.BACKGROUND_LOCATION)) {
            RenderSystem.setShaderTexture(0, BetterMenuCommon.CONFIG.backgroundTexture);
        } else {
            RenderSystem.setShaderTexture(0, Screen.BACKGROUND_LOCATION);
        }
    }
}
