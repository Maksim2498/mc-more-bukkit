package space.moontalk.mc.more.bukkit.message;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.Configuration;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

import space.moontalk.placeholders.DefaultSubstituter;
import space.moontalk.placeholders.Substituter;

@Getter
public class DefaultMessageProvider implements ConfigMessageProvider {
    private final @NotNull Substituter               substituor;
    private final @NotNull Configuration             config;
    private final @NotNull String                    sectionName;
    private final @NotNull Map<String, MessageMaker> messageMakers = new HashMap<>();

    public DefaultMessageProvider(@NotNull Configuration config) {
        this(config, "");
    }

    public DefaultMessageProvider(@NotNull Configuration config, @NotNull String sectionName) {
        this(config, sectionName, new DefaultSubstituter());
    }

    public DefaultMessageProvider(
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
        path = String.format("%s.%s", sectionName, path);
        return config.getString(path);
    }
}
