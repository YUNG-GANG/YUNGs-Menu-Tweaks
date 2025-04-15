package com.yungnickyoung.minecraft.yungsmenutweaks.services;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
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
        return !FMLLoader.isProduction();
    }

    @Override
    public void renderBackground(Screen screen, GuiGraphics guiGraphics, ResourceLocation backgroundLocation) {
        RenderSystem.enableBlend();
        guiGraphics.blit(RenderType::guiTextured, backgroundLocation, 0, 0, 0, 0, screen.width, screen.height, 32, 32, 0xFF404040);
        RenderSystem.disableBlend();
        NeoForge.EVENT_BUS.post(new ScreenEvent.BackgroundRendered(screen, guiGraphics)); // re-fire NeoForge event since we cancelled before it's thrown
    }
}
