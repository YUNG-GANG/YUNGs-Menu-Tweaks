package com.yungnickyoung.minecraft.bettermenu.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BMConfigForge {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> enableRightClickCycleButton;

    static {
        BUILDER.push("YUNG's Better Menu");

        enableRightClickCycleButton = BUILDER
                .comment(
                        " Allows right clicking to cycle backwards through some buttons.\n" +
                        " Default: true")
                .define("Right Click Reverse Cycle", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}