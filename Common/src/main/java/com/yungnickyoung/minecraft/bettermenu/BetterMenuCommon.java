package com.yungnickyoung.minecraft.bettermenu;

import com.yungnickyoung.minecraft.bettermenu.module.ConfigModule;
import com.yungnickyoung.minecraft.bettermenu.services.Services;
import com.yungnickyoung.minecraft.yungsapi.api.YungAutoRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BetterMenuCommon {
    public static final String MOD_ID = "bettermenu";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ConfigModule CONFIG = new ConfigModule();

    public static void init() {
        YungAutoRegister.scanPackageForAnnotations("com.yungnickyoung.minecraft.bettermenu.module");
        Services.MODULES.loadModules();
    }
}
