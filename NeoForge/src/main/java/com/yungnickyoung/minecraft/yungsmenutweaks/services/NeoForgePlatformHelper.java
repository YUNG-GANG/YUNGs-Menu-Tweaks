package com.yungnickyoung.minecraft.yungsmenutweaks.services;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.common.NeoForge;

public class NeoForgePlatformHelper implements IPlatformHelper {
    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public void renderBackground(Screen screen, GuiGraphicsExtractor guiGraphics, Identifier backgroundLocation, final int mouseX, final int mouseY, final float partialTick) {
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, backgroundLocation, 0, 0, 0, 0, screen.width, screen.height, 32, 32, 0xFF404040);
        NeoForge.EVENT_BUS.post(new ScreenEvent.Render.Background(screen, guiGraphics, mouseX, mouseY, partialTick)); // re-fire NeoForge event since we cancelled before it's thrown
    }
}
