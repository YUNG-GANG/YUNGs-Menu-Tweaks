package com.yungnickyoung.minecraft.yungsmenutweaks.services;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;

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
    public void renderBackground(Screen screen, GuiGraphicsExtractor guiGraphics, Identifier backgroundLocation, final int mouseX, final int mouseY, final float partialTick) {
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, backgroundLocation, 0, 0, 0, 0, screen.width, screen.height, 32, 32, 0xFF404040);
    }
}
