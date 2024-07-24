package com.yungnickyoung.minecraft.yungsmenutweaks.module;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksNeoForge;
import com.yungnickyoung.minecraft.yungsmenutweaks.config.YMTConfigNeoForge;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.LevelEvent;

public class ConfigModuleNeoForge {
    public static void init(ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, YMTConfigNeoForge.SPEC, "yungsmenutweaks-neoforge-1_21.toml");
        NeoForge.EVENT_BUS.addListener(ConfigModuleNeoForge::onWorldLoad);
        YungsMenuTweaksNeoForge.loadingContextEventBus.addListener(ConfigModuleNeoForge::onConfigChange);
    }

    private static void onWorldLoad(LevelEvent.Load event) {
        bakeConfig();
    }

    private static void onConfigChange(ModConfigEvent event) {
        if (event.getConfig().getSpec() == YMTConfigNeoForge.SPEC) {
            bakeConfig();
        }
    }

    private static void bakeConfig() {
        YungsMenuTweaksCommon.CONFIG.enableRightClickCycleButton = YMTConfigNeoForge.enableRightClickCycleButton.get();
        YungsMenuTweaksCommon.CONFIG.enableMouseScrollOnSliders = YMTConfigNeoForge.enableMouseScrollOnSliders.get();
        YungsMenuTweaksCommon.CONFIG.enableBackgroundTexture = YMTConfigNeoForge.enableBackgroundTexture.get();
        ResourceLocation backgroundTexture = ResourceLocation.tryParse(YMTConfigNeoForge.backgroundTexture.get());
        if (backgroundTexture != null) {
            YungsMenuTweaksCommon.CONFIG.backgroundTexture = backgroundTexture;
        } else {
            YungsMenuTweaksCommon.LOGGER.error("Invalid background texture path: {}", YMTConfigNeoForge.backgroundTexture.get());
            YungsMenuTweaksCommon.LOGGER.error("Using default background texture path instead: textures/block/dirt.png");
            YungsMenuTweaksCommon.CONFIG.backgroundTexture = ResourceLocation.withDefaultNamespace("textures/block/dirt.png");
        }
    }
}
