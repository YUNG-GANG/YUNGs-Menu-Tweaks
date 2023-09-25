package com.yungnickyoung.minecraft.yungsmenutweaks;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class YungsMenuTweaksMixinPluginFabric implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        // Mixins that should only load when ModMenu is loaded.
        if ("com.yungnickyoung.minecraft.bettermenu.mixin.ModMenuDescriptionListWidgetMixin".equals(mixinClassName)) {
            return YungsMenuTweaksFabric.isModMenuEnabled;
        } else if ("com.yungnickyoung.minecraft.bettermenu.mixin.ModMenuModsScreenMixin".equals(mixinClassName)) {
            return YungsMenuTweaksFabric.isModMenuEnabled;
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
