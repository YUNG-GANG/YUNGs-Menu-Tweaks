package com.yungnickyoung.minecraft.bettermenu.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name="bettermenu-fabric-1_20")
public class BMConfigFabric implements ConfigData {
    @ConfigEntry.Category("Better Menu")
    @ConfigEntry.Gui.TransitiveObject
    public ConfigBetterMenuFabric betterMenu = new ConfigBetterMenuFabric();
}
