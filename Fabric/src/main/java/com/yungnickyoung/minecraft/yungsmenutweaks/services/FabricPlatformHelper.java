package com.yungnickyoung.minecraft.yungsmenutweaks.services;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class FabricPlatformHelper implements IPlatformHelper {
    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public void renderBackground(Screen screen, GuiGraphics guiGraphics, ResourceLocation backgroundLocation) {
        RenderSystem.enableBlend();
        guiGraphics.blit(RenderType::guiTextured, backgroundLocation, 0, 0, 0, 0, screen.width, screen.height, 32, 32, 0xFF404040);
        RenderSystem.disableBlend();
    }
}
