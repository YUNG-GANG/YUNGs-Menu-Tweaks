package com.yungnickyoung.minecraft.yungsmenutweaks;

import net.fabricmc.api.ClientModInitializer;

public class YungsMenuTweaksFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        YungsMenuTweaksCommon.init();
    }
}
