package com.yungnickyoung.minecraft.bettermenu.module;

import com.yungnickyoung.minecraft.bettermenu.BetterMenuCommon;
import com.yungnickyoung.minecraft.bettermenu.config.BMConfigForge;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ConfigModuleForge {
    public static void init() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BMConfigForge.SPEC, "bettermenu-forge-1_20.toml");
        MinecraftForge.EVENT_BUS.addListener(ConfigModuleForge::onWorldLoad);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ConfigModuleForge::onConfigChange);
    }

    private static void onWorldLoad(LevelEvent.Load event) {
        bakeConfig();
    }

    private static void onConfigChange(ModConfigEvent event) {
        if (event.getConfig().getSpec() == BMConfigForge.SPEC) {
            bakeConfig();
        }
    }

    private static void bakeConfig() {
        BetterMenuCommon.CONFIG.enableRightClickCycleButton = BMConfigForge.enableRightClickCycleButton.get();
        BetterMenuCommon.CONFIG.enableMouseScrollOnSliders = BMConfigForge.enableMouseScrollOnSliders.get();
        BetterMenuCommon.CONFIG.enableBackgroundTexture = BMConfigForge.enableBackgroundTexture.get();
        ResourceLocation backgroundTexture = ResourceLocation.tryParse(BMConfigForge.backgroundTexture.get());
        if (backgroundTexture != null) {
            BetterMenuCommon.CONFIG.backgroundTexture = backgroundTexture;
        } else {
            BetterMenuCommon.LOGGER.error("Invalid background texture path: " + BMConfigForge.backgroundTexture.get());
            BetterMenuCommon.LOGGER.error("Using default background texture path instead: textures/block/dirt.png");
            BetterMenuCommon.CONFIG.backgroundTexture = new ResourceLocation("textures/block/dirt.png");
        }
    }
}
