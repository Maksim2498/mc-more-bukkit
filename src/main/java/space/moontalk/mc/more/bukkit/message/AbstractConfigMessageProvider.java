package space.moontalk.mc.more.bukkit.message;

import org.bukkit.configuration.Configuration;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

import space.moontalk.placeholders.DefaultSubstituter;
import space.moontalk.placeholders.Substituter;

public abstract class AbstractConfigMessageProvider implements ConfigMessageProvider {
    private final @NotNull Substituter substituor;

    @Getter
    private final @NotNull Configuration config;

    @Getter
    private final @NotNull String sectionName;

    public AbstractConfigMessageProvider(@NotNull Configuration config) {
        this(config, "");
    }

    public AbstractConfigMessageProvider(@NotNull Configuration config, @NotNull String sectionName) {
        this(config, sectionName, new DefaultSubstituter());
    }

    public AbstractConfigMessageProvider(
        @NotNull Configuration config, 
        @NotNull String        sectionName,
        @NotNull Substituter   substituor
    ) {
        this.config      = config;
        this.sectionName = sectionName;
        this.substituor  = substituor;
    }

    public @NotNull String getFormattedString(@NotNull String path, @NotNull String ...substitutions) {
        return substituor.substitute(getString(path), substitutions);
    }

    public @NotNull String getString(@NotNull String path) {
        return config.getString(sectionName + path);
    }
}
