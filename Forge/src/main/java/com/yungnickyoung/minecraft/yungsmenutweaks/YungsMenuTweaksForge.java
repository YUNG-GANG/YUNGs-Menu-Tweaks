package com.yungnickyoung.minecraft.yungsmenutweaks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(YungsMenuTweaksCommon.MOD_ID)
public class YungsMenuTweaksForge {
    public YungsMenuTweaksForge() {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> YungsMenuTweaksCommon::init);
    }
}