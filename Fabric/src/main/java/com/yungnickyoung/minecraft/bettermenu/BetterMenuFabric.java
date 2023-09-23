package com.yungnickyoung.minecraft.bettermenu;

import com.yungnickyoung.minecraft.bettermenu.services.Services;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class BetterMenuFabric implements ClientModInitializer {

    public static boolean isModMenuEnabled;

    @Override
    public void onInitializeClient() {
        BetterMenuCommon.init();

        // Enable explicit ModMenu compat if ModMenu is loaded and the version is less than 7.1.0.
        boolean isModMenuLoaded = Services.PLATFORM.isModLoaded("modmenu") && Services.PLATFORM.getPlatformName().equals("Fabric");
        if (isModMenuLoaded) {
            String modMenuVersion = FabricLoader.getInstance().getModContainer("modmenu").get().getMetadata().getVersion().getFriendlyString();
            isModMenuEnabled = modMenuVersion.compareTo("7.1.0") < 0;
        }
    }
}
