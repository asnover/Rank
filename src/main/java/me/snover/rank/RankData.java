package me.snover.rank;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.UUID;

public class RankData {

    public static YamlConfiguration rankFile;

    public static Rank getPlayerRank(Player player) {
        return Rank.DEFAULT;
    }

    public static Rank getPlayerRank(String name) {
        return Rank.DEFAULT;
    }

    public static Rank getPlayerRank(UUID uuid) {
        return Rank.DEFAULT;
    }

    public static void setPlayerRank(UUID uuid) {

    }

    public static void setPlayerRank(Player player) {
        setPlayerRank(player.getUniqueId());
    }

    public static void setPlayerRank(String name) {
        setPlayerRank(Bukkit.getPlayer(name).getUniqueId());
    }
}
