package com.yungnickyoung.minecraft.yungsmenutweaks;

import com.yungnickyoung.minecraft.yungsmenutweaks.module.ConfigModule;
import com.yungnickyoung.minecraft.yungsmenutweaks.services.Services;
import com.yungnickyoung.minecraft.yungsapi.api.YungAutoRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YungsMenuTweaksCommon {
    public static final String MOD_ID = "yungsmenutweaks";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ConfigModule CONFIG = new ConfigModule();

    public static void init() {
        YungAutoRegister.scanPackageForAnnotations("com.yungnickyoung.minecraft.yungsmenutweaks.module");
        Services.MODULES.loadModules();
    }
}
