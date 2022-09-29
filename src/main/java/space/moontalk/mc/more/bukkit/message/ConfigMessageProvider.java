package space.moontalk.mc.more.bukkit.message;

import org.bukkit.configuration.Configuration;

import org.jetbrains.annotations.NotNull;

public interface ConfigMessageProvider {
    @NotNull Configuration getConfig();
    @NotNull String getSectionName();
}
