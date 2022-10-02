package space.moontalk.mc.more.bukkit;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

import lombok.val;

public interface MoreBukkit {
    // Ticks:

    static final int SECOND_TICKS = 20;
    static final int MINUTE_TICKS = 60 * SECOND_TICKS;
    static final int HOUR_TICKS   = 60 * MINUTE_TICKS;

    static int getCurrentSecond() {
        return Bukkit.getCurrentTick() / SECOND_TICKS;
    }

    static int getCurrentMinute() {
        return Bukkit.getCurrentTick() / MINUTE_TICKS;
    }

    static int getCurrentHour() {
        return Bukkit.getCurrentTick() / HOUR_TICKS;
    }



    // World:

    static @NotNull World getWorld(@NotNull UUID worldUniqueId) {
        val world = Bukkit.getWorld(worldUniqueId);

        if (world == null) {
            val message = String.format("world with uuid %s not found", worldUniqueId.toString());
            throw new IllegalArgumentException(message);
        }

        return world;
    }

    static @NotNull World getWorld(@NotNull String worldName) {
        val world = Bukkit.getWorld(worldName);

        if (world == null) {
            val message = String.format("world with name %s not found");
            throw new IllegalArgumentException(message);
        }

        return world;
    }



    // Unique ID:

    static @NotNull UUID getPlayerUniqueId(@NotNull String playerName) {
        val player = Bukkit.getPlayer(playerName);

        if (player != null) 
            return player.getUniqueId();

        val offlinePlayer = Bukkit.getOfflinePlayer(playerName);

        if (offlinePlayer != null) 
            return offlinePlayer.getUniqueId();

        val message = String.format("not online neither offline player with name %s not found", playerName);
        throw new IllegalArgumentException(message);
    }



    // Either Online Either Offline Player:

    static @NotNull OfflinePlayer getAnyPlayer(@NotNull UUID playerUniqueId) {
        val onlinePlayer = Bukkit.getPlayer(playerUniqueId);

        if (onlinePlayer != null)
            return onlinePlayer;

        val offlinePlayer = Bukkit.getOfflinePlayer(playerUniqueId);

        if (offlinePlayer != null)
            return offlinePlayer;

        val message = String.format("online/offline player with UUID %s not found", playerUniqueId.toString());
        throw new IllegalArgumentException(message);
    }

    static @NotNull OfflinePlayer getAnyPlayer(@NotNull String playerName) {
        val onlinePlayer = Bukkit.getPlayer(playerName);

        if (onlinePlayer != null)
            return onlinePlayer;

        val offlinePlayer = Bukkit.getOfflinePlayer(playerName);

        if (offlinePlayer != null)
            return offlinePlayer;

        val message = String.format("online/offline player %s not found", playerName);
        throw new IllegalArgumentException(message);
    }



    // Offline Player:

    static @NotNull OfflinePlayer getOfflinePlayer(@NotNull UUID playerUniqueId) {
        val player = Bukkit.getOfflinePlayer(playerUniqueId);

        if (player == null) {
            val message = String.format("offline player with uuid %s not found", playerUniqueId.toString());
            throw new IllegalArgumentException(message);
        }

        return player;
    }

    static @NotNull OfflinePlayer getOfflinePlayer(@NotNull String playerName) {
        val player = Bukkit.getOfflinePlayer(playerName);

        if (player == null) {
            val message = String.format("offline player with name %s not found", playerName);
            throw new IllegalArgumentException(message);
        }

        return player;
    }



    // Player:

    static @NotNull Player getPlayer(@NotNull UUID playerUniqueId) {
        val player = Bukkit.getPlayer(playerUniqueId);

        if (player == null) {
            val message = String.format("player with uuid %s not found", playerUniqueId.toString());
            throw new IllegalArgumentException(message);
        }

        return player;
    }

    static @NotNull Player getPlayer(@NotNull String playerName) {
        val player = Bukkit.getPlayer(playerName);

        if (player == null) {
            val message = String.format("player with name %s not found", playerName);
            throw new IllegalArgumentException(message);
        }

        return player;
    }
}
