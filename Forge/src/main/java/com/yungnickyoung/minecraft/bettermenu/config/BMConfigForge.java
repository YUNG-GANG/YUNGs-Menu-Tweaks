package com.yungnickyoung.minecraft.bettermenu.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BMConfigForge {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> enableRightClickCycleButton;
    public static final ForgeConfigSpec.ConfigValue<Boolean> enableMouseScrollOnSliders;

    static {
        BUILDER.push("YUNG's Better Menu");

        enableRightClickCycleButton = BUILDER
                .comment(
                        " Allows right clicking to cycle backwards through some buttons.\n" +
                        " Default: true")
                .define("Right Click Reverses Cycle Buttons", true);

        enableMouseScrollOnSliders = BUILDER
                .comment(
                        " Allows scrolling the mouse wheel to modify options using a slider\n" +
                        " when hovering over the slider.\n" +
                        " Default: true")
                .define("Mouse Scroll Wheel Affects Sliders", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}