package com.yungnickyoung.minecraft.bettermenu.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigBetterMenuFabric {
    @ConfigEntry.Gui.Tooltip
    public boolean enableRightClickCycleButton = true;

    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean enableMouseScrollOnSliders = true;
}
