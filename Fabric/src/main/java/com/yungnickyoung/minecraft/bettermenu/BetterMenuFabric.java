package com.yungnickyoung.minecraft.bettermenu;

import net.fabricmc.api.ClientModInitializer;

public class BetterMenuFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BetterMenuCommon.init();
    }
}
