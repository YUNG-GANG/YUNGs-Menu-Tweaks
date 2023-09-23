package com.yungnickyoung.minecraft.bettermenu.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.resources.ResourceLocation;

public class ConfigBetterMenuFabric {
    @ConfigEntry.Gui.Tooltip
    public boolean enableRightClickCycleButton = true;

    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean enableMouseScrollOnSliders = true;

    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean enableBackgroundTexture = false;

    @ConfigEntry.Gui.Tooltip(count = 2)
    public String backgroundTexture = "minecraft:textures/block/dirt.png";
}
