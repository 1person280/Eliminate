package dev.miitong.eliminate.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = "eliminate")
public class EliminateConfig implements ConfigData {

    private static EliminateConfig INSTANCE;

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("general")
    public General general = new General();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("advanced")
    public Advanced advanced = new Advanced();

    public static class General {
        @ConfigEntry.Gui.Tooltip
        public boolean enabled = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 16, max = 256)
        public int cullingDistance = 64;

        @ConfigEntry.Gui.Tooltip
        public boolean debugMode = false;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
        public int updateSpeed = 20;

        @ConfigEntry.Gui.Tooltip
        public boolean syncWithSodium = false;
    }

    public static class Advanced {
        @ConfigEntry.Gui.Tooltip
        public boolean fovCullingEnabled = true;

        @ConfigEntry.Gui.Tooltip
        public boolean aggressiveMountainCulling = true;

        @ConfigEntry.Gui.Tooltip
        public boolean transparencyAwareness = true;

        @ConfigEntry.Gui.Tooltip
        public boolean horizontalCulling = true;

        @ConfigEntry.Gui.Tooltip
        public boolean biomeAwareCulling = true;

        @ConfigEntry.Gui.Tooltip
        public boolean dynamicCullingDistance = false;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 30, max = 240)
        public int targetFps = 60;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 16, max = 128)
        public int minDynamicDistance = 32;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 64, max = 256)
        public int maxDynamicDistance = 128;
    }

    // 便捷访问方法
    public boolean isEnabled() {
        return general.enabled;
    }

    public int getCullingDistance() {
        return general.cullingDistance;
    }

    public boolean isDebugMode() {
        return general.debugMode;
    }

    public int getUpdateSpeed() {
        return general.updateSpeed;
    }

    public boolean isSyncWithSodium() {
        return general.syncWithSodium;
    }

    public boolean isFovCullingEnabled() {
        return advanced.fovCullingEnabled;
    }

    public boolean isAggressiveMountainCulling() {
        return advanced.aggressiveMountainCulling;
    }

    public boolean isTransparencyAwareness() {
        return advanced.transparencyAwareness;
    }

    public boolean isHorizontalCulling() {
        return advanced.horizontalCulling;
    }

    public boolean isBiomeAwareCulling() {
        return advanced.biomeAwareCulling;
    }

    public boolean isDynamicCullingDistance() {
        return advanced.dynamicCullingDistance;
    }

    public int getTargetFps() {
        return advanced.targetFps;
    }

    public int getMinDynamicDistance() {
        return advanced.minDynamicDistance;
    }

    public int getMaxDynamicDistance() {
        return advanced.maxDynamicDistance;
    }

    // 兼容性访问方法（保持与现有代码一致）
    public boolean getEnabled() {
        return general.enabled;
    }

    public int getCullingDistanceValue() {
        return general.cullingDistance;
    }

    public boolean getDebugMode() {
        return general.debugMode;
    }

    public int getUpdateSpeedValue() {
        return general.updateSpeed;
    }

    public boolean getSyncWithSodium() {
        return general.syncWithSodium;
    }

    public boolean getFovCullingEnabled() {
        return advanced.fovCullingEnabled;
    }

    public boolean getAggressiveMountainCulling() {
        return advanced.aggressiveMountainCulling;
    }

    public boolean getTransparencyAwareness() {
        return advanced.transparencyAwareness;
    }

    public boolean getHorizontalCulling() {
        return advanced.horizontalCulling;
    }

    public boolean getBiomeAwareCulling() {
        return advanced.biomeAwareCulling;
    }

    public boolean getDynamicCullingDistance() {
        return advanced.dynamicCullingDistance;
    }

    public int getTargetFpsValue() {
        return advanced.targetFps;
    }

    public int getMinDynamicDistanceValue() {
        return advanced.minDynamicDistance;
    }

    public int getMaxDynamicDistanceValue() {
        return advanced.maxDynamicDistance;
    }

    // 公共访问器（为了与现有代码兼容）
    public boolean enabled = true;
    public int cullingDistance = 64;
    public boolean debugMode = false;
    public int updateSpeed = 20;
    public boolean syncWithSodium = false;
    public boolean fovCullingEnabled = true;
    public boolean aggressiveMountainCulling = true;
    public boolean transparencyAwareness = true;
    public boolean horizontalCulling = true;
    public boolean biomeAwareCulling = true;
    public boolean dynamicCullingDistance = false;
    public int targetFps = 60;
    public int minDynamicDistance = 32;
    public int maxDynamicDistance = 128;

    public static void load() {
        AutoConfig.register(EliminateConfig.class, GsonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(EliminateConfig.class).getConfig();

        // 同步公共字段
        syncPublicFields();
    }

    public static EliminateConfig getInstance() {
        if (INSTANCE == null) {
            load();
        }
        return INSTANCE;
    }

    private static void syncPublicFields() {
        if (INSTANCE == null) return;

        // 同步公共字段
        INSTANCE.enabled = INSTANCE.general.enabled;
        INSTANCE.cullingDistance = INSTANCE.general.cullingDistance;
        INSTANCE.debugMode = INSTANCE.general.debugMode;
        INSTANCE.updateSpeed = INSTANCE.general.updateSpeed;
        INSTANCE.syncWithSodium = INSTANCE.general.syncWithSodium;
        INSTANCE.fovCullingEnabled = INSTANCE.advanced.fovCullingEnabled;
        INSTANCE.aggressiveMountainCulling = INSTANCE.advanced.aggressiveMountainCulling;
        INSTANCE.transparencyAwareness = INSTANCE.advanced.transparencyAwareness;
        INSTANCE.horizontalCulling = INSTANCE.advanced.horizontalCulling;
        INSTANCE.biomeAwareCulling = INSTANCE.advanced.biomeAwareCulling;
        INSTANCE.dynamicCullingDistance = INSTANCE.advanced.dynamicCullingDistance;
        INSTANCE.targetFps = INSTANCE.advanced.targetFps;
        INSTANCE.minDynamicDistance = INSTANCE.advanced.minDynamicDistance;
        INSTANCE.maxDynamicDistance = INSTANCE.advanced.maxDynamicDistance;
    }

    @Override
    public void validatePostLoad() {
        syncPublicFields();
    }
}