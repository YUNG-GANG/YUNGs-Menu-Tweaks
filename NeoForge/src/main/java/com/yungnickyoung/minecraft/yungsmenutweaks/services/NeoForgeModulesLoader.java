package com.yungnickyoung.minecraft.yungsmenutweaks.services;

import com.yungnickyoung.minecraft.yungsmenutweaks.module.*;

public class NeoForgeModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        IModulesLoader.super.loadModules(); // Load common modules
        ConfigModuleNeoForge.init();
    }
}
