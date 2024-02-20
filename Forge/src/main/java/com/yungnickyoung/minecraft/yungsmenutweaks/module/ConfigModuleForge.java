package com.yungnickyoung.minecraft.yungsmenutweaks.module;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import com.yungnickyoung.minecraft.yungsmenutweaks.config.YMTConfigForge;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ConfigModuleForge {
    public static void init() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, YMTConfigForge.SPEC, "yungsmenutweaks-forge-1_20_4.toml");
        MinecraftForge.EVENT_BUS.addListener(ConfigModuleForge::onWorldLoad);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ConfigModuleForge::onConfigChange);
    }

    private static void onWorldLoad(LevelEvent.Load event) {
        bakeConfig();
    }

    private static void onConfigChange(ModConfigEvent event) {
        if (event.getConfig().getSpec() == YMTConfigForge.SPEC) {
            bakeConfig();
        }
    }

    private static void bakeConfig() {
        YungsMenuTweaksCommon.CONFIG.enableRightClickCycleButton = YMTConfigForge.enableRightClickCycleButton.get();
        YungsMenuTweaksCommon.CONFIG.enableMouseScrollOnSliders = YMTConfigForge.enableMouseScrollOnSliders.get();
        YungsMenuTweaksCommon.CONFIG.enableBackgroundTexture = YMTConfigForge.enableBackgroundTexture.get();
        ResourceLocation backgroundTexture = ResourceLocation.tryParse(YMTConfigForge.backgroundTexture.get());
        if (backgroundTexture != null) {
            YungsMenuTweaksCommon.CONFIG.backgroundTexture = backgroundTexture;
        } else {
            YungsMenuTweaksCommon.LOGGER.error("Invalid background texture path: " + YMTConfigForge.backgroundTexture.get());
            YungsMenuTweaksCommon.LOGGER.error("Using default background texture path instead: textures/block/dirt.png");
            YungsMenuTweaksCommon.CONFIG.backgroundTexture = new ResourceLocation("textures/block/dirt.png");
        }
    }
}
