package com.yungnickyoung.minecraft.yungsmenutweaks.mixin.compat.modmenu;

import com.terraformersmc.modmenu.gui.ModsScreen;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ModsScreen.class)
public abstract class ModMenuModsScreenMixin {
//    @Redirect(method = "overlayBackground", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V"))
//    private static void yungsmenutweaks_renderModMenuScreenBackground(int i, ResourceLocation id) {
//        if (BetterMenuCommon.CONFIG.enableBackgroundTexture && id.equals(Screen.BACKGROUND_LOCATION)) {
//            RenderSystem.setShaderTexture(0, BetterMenuCommon.CONFIG.backgroundTexture);
//        } else {
//            RenderSystem.setShaderTexture(0, Screen.BACKGROUND_LOCATION);
//        }
//    }
}
