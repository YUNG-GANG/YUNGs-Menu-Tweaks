package com.yungnickyoung.minecraft.yungsmenutweaks.module;

import com.yungnickyoung.minecraft.yungsmenutweaks.YungsMenuTweaksCommon;
import com.yungnickyoung.minecraft.yungsmenutweaks.config.YMTConfigFabric;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;

public class ConfigModuleFabric {
    public static void init() {
        AutoConfig.register(YMTConfigFabric.class, Toml4jConfigSerializer::new);
        AutoConfig.getConfigHolder(YMTConfigFabric.class).registerSaveListener(ConfigModuleFabric::bakeConfig);
        AutoConfig.getConfigHolder(YMTConfigFabric.class).registerLoadListener(ConfigModuleFabric::bakeConfig);
        bakeConfig(AutoConfig.getConfigHolder(YMTConfigFabric.class).get());
    }

    private static InteractionResult bakeConfig(ConfigHolder<YMTConfigFabric> configHolder, YMTConfigFabric configFabric) {
        bakeConfig(configFabric);
        return InteractionResult.SUCCESS;
    }

    private static void bakeConfig(YMTConfigFabric configFabric) {
        YungsMenuTweaksCommon.CONFIG.enableRightClickCycleButton = configFabric.yungsMenuTweaks.enableRightClickCycleButton;
        YungsMenuTweaksCommon.CONFIG.enableMouseScrollOnSliders = configFabric.yungsMenuTweaks.enableMouseScrollOnSliders;
        YungsMenuTweaksCommon.CONFIG.enableBackgroundTexture = configFabric.yungsMenuTweaks.enableBackgroundTexture;
        ResourceLocation backgroundTexture = ResourceLocation.tryParse(configFabric.yungsMenuTweaks.backgroundTexture);
        if (backgroundTexture != null) {
            YungsMenuTweaksCommon.CONFIG.backgroundTexture = backgroundTexture;
        } else {
            YungsMenuTweaksCommon.LOGGER.error("Invalid background texture path: {}", configFabric.yungsMenuTweaks.backgroundTexture);
            YungsMenuTweaksCommon.LOGGER.error("Using default background texture path instead: textures/block/dirt.png");
            YungsMenuTweaksCommon.CONFIG.backgroundTexture = ResourceLocation.withDefaultNamespace("textures/block/dirt.png");
        }
    }
}
