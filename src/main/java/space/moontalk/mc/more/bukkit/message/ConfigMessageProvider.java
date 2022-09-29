package space.moontalk.mc.more.bukkit.message;

import org.bukkit.configuration.Configuration;

import org.jetbrains.annotations.NotNull;

public interface ConfigMessageProvider {
    @NotNull Configuration getConfig();
    @NotNull String getSectionName();
    @NotNull String getFormattedString(@NotNull String path, @NotNull String ...substitutions);
    @NotNull String getString(@NotNull String path);
}
