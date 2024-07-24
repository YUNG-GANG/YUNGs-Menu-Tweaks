package com.yungnickyoung.minecraft.yungsmenutweaks;

import com.yungnickyoung.minecraft.yungsmenutweaks.module.ConfigModuleNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(YungsMenuTweaksCommon.MOD_ID)
public class YungsMenuTweaksNeoForge {
    public static IEventBus loadingContextEventBus;

    public YungsMenuTweaksNeoForge(IEventBus eventBus, ModContainer container) {
        YungsMenuTweaksNeoForge.loadingContextEventBus = eventBus;

        YungsMenuTweaksCommon.init();
        ConfigModuleNeoForge.init(container);
    }
}