package com.yungnickyoung.minecraft.yungsmenutweaks.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigYungsMenuTweaksFabric {
    @ConfigEntry.Gui.Tooltip
    public boolean enableRightClickCycleButton = true;

    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean enableMouseScrollOnSliders = true;

    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean enableBackgroundTexture = false;

    @ConfigEntry.Gui.Tooltip(count = 2)
    public String backgroundTexture = "minecraft:textures/block/dirt.png";
}
