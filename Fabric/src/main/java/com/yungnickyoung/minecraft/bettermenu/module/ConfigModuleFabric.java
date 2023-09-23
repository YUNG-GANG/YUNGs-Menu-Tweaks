package com.yungnickyoung.minecraft.bettermenu.module;

import com.yungnickyoung.minecraft.bettermenu.BetterMenuCommon;
import com.yungnickyoung.minecraft.bettermenu.config.BMConfigFabric;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;

public class ConfigModuleFabric {
    public static void init() {
        AutoConfig.register(BMConfigFabric.class, Toml4jConfigSerializer::new);
        AutoConfig.getConfigHolder(BMConfigFabric.class).registerSaveListener(ConfigModuleFabric::bakeConfig);
        AutoConfig.getConfigHolder(BMConfigFabric.class).registerLoadListener(ConfigModuleFabric::bakeConfig);
        bakeConfig(AutoConfig.getConfigHolder(BMConfigFabric.class).get());
    }

    private static InteractionResult bakeConfig(ConfigHolder<BMConfigFabric> configHolder, BMConfigFabric configFabric) {
        bakeConfig(configFabric);
        return InteractionResult.SUCCESS;
    }

    private static void bakeConfig(BMConfigFabric configFabric) {
        BetterMenuCommon.CONFIG.enableRightClickCycleButton = configFabric.betterMenu.enableRightClickCycleButton;
        BetterMenuCommon.CONFIG.enableMouseScrollOnSliders = configFabric.betterMenu.enableMouseScrollOnSliders;
        BetterMenuCommon.CONFIG.enableBackgroundTexture = configFabric.betterMenu.enableBackgroundTexture;
        ResourceLocation backgroundTexture = ResourceLocation.tryParse(configFabric.betterMenu.backgroundTexture);
        if (backgroundTexture != null) {
            BetterMenuCommon.CONFIG.backgroundTexture = backgroundTexture;
        } else {
            BetterMenuCommon.LOGGER.error("Invalid background texture path: " + configFabric.betterMenu.backgroundTexture);
            BetterMenuCommon.LOGGER.error("Using default background texture path instead: textures/block/dirt.png");
            BetterMenuCommon.CONFIG.backgroundTexture = new ResourceLocation("textures/block/dirt.png");
        }
    }
}
