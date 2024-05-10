package com.yungnickyoung.minecraft.yungsmenutweaks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(YungsMenuTweaksCommon.MOD_ID)
public class YungsMenuTweaksNeoForge {
    public static IEventBus loadingContextEventBus;

    public YungsMenuTweaksNeoForge(IEventBus eventBus) {
        YungsMenuTweaksNeoForge.loadingContextEventBus = eventBus;

        YungsMenuTweaksCommon.init();
    }
}