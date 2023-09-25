package com.yungnickyoung.minecraft.yungsmenutweaks;

import com.yungnickyoung.minecraft.yungsmenutweaks.services.Services;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class YungsMenuTweaksFabric implements ClientModInitializer {

    public static boolean isModMenuEnabled;

    @Override
    public void onInitializeClient() {
        YungsMenuTweaksCommon.init();

        // Enable explicit ModMenu compat if ModMenu is loaded and the version is less than 7.1.0.
        boolean isModMenuLoaded = Services.PLATFORM.isModLoaded("modmenu") && Services.PLATFORM.getPlatformName().equals("Fabric");
        if (isModMenuLoaded) {
            String modMenuVersion = FabricLoader.getInstance().getModContainer("modmenu").get().getMetadata().getVersion().getFriendlyString();
            isModMenuEnabled = modMenuVersion.compareTo("7.1.0") < 0;
        }
    }
}
