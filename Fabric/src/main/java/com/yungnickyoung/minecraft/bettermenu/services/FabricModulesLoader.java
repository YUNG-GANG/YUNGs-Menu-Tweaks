package com.yungnickyoung.minecraft.bettermenu.services;

import com.yungnickyoung.minecraft.bettermenu.module.*;

public class FabricModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        IModulesLoader.super.loadModules(); // Load common modules
        ConfigModuleFabric.init();
    }
}
