package com.yungnickyoung.minecraft.yungsmenutweaks.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name="yungsmenutweaks-fabric-1_20_4")
public class YMTConfigFabric implements ConfigData {
    @ConfigEntry.Category("YUNG's Menu Tweaks")
    @ConfigEntry.Gui.TransitiveObject
    public ConfigYungsMenuTweaksFabric yungsMenuTweaks = new ConfigYungsMenuTweaksFabric();
}
