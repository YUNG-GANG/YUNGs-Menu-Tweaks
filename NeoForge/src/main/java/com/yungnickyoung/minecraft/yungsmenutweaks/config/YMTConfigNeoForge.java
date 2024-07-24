package com.yungnickyoung.minecraft.yungsmenutweaks.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class YMTConfigNeoForge {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<Boolean> enableRightClickCycleButton;
    public static final ModConfigSpec.ConfigValue<Boolean> enableMouseScrollOnSliders;
    public static final ModConfigSpec.ConfigValue<Boolean> enableBackgroundTexture;
    public static final ModConfigSpec.ConfigValue<String> backgroundTexture;

    static {
        BUILDER.push("YUNG's Menu Tweaks");

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

        enableBackgroundTexture = BUILDER
                .comment(
                        " If enabled, a custom background texture will be used in menus where possible.\n" +
                        " The texture used is specified by the Custom Background Texture option below.\n" +
                        " Default: false")
                .define("Enable Custom Background Texture", false);

        backgroundTexture = BUILDER
                .comment(
                        " A texture to use as a custom background, instead of the typical blurred background.\n" +
                        " Only does anything if the Enable Custom Background Texture option is true.\n" +
                        " Default: minecraft:textures/block/dirt.png")
                .define("Custom Background Texture", "minecraft:textures/block/dirt.png");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}