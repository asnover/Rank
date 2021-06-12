package me.snover.rank;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class RankData {

    private static FileConfiguration rankFile;

    public static Rank getPlayerRank(Player player) {
        String uuid = player.getUniqueId().toString();
        int rankID = Rank.DEFAULT.getRankID();
        try {
            rankID = Integer.parseInt(String.valueOf(getRankFile().get(uuid)));
        } catch (NumberFormatException e) {
            Main.getPlugin().getLogger().log(Level.INFO, "Could not parse for player's rank... Setting rank to default");
            setPlayerRank(player, Rank.DEFAULT);
        }
        for(Rank rank : Rank.values()) {
            if(rank.getRankID() == rankID) return rank;
        }
        return null;
    }

    public static void setPlayerRank(Player player, Rank rank) {
        String uuid = player.getUniqueId().toString();
        getRankFile().set(uuid, rank.getRankID());
    }

    public static FileConfiguration getRankFile() {
        return rankFile;
    }

    public static void loadConfigFile() {
        File file = new File(Main.getPlugin().getDataFolder() + "/rank.yml");
        if(!file.exists()) {
            file.mkdirs();
            Main.getPlugin().saveResource("rank.yml", false);
        }
        rankFile = new YamlConfiguration();
        try {
            rankFile.load(file);
        } catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
    }
}
