package com.yungnickyoung.minecraft.yungsmenutweaks.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.gui.widget.ScrollPanel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScrollPanel.class)
public abstract class ScrollPanelMixinNeoForge {
    @Redirect(method = "drawBackground", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V"))
    private void yungsmenutweaks_renderModMenuScreenBackground(int i, ResourceLocation id) {
        if (YungsMenuTweaksCommon.CONFIG.enableBackgroundTexture && id.equals(Screen.BACKGROUND_LOCATION)) {
            RenderSystem.setShaderTexture(0, YungsMenuTweaksCommon.CONFIG.backgroundTexture);
        } else {
            RenderSystem.setShaderTexture(0, Screen.BACKGROUND_LOCATION);
        }
    }
}
