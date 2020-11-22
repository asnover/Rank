package me.snover.rank;

import me.snover.rank.commands.RankCommand;
import me.snover.rank.events.Events;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        File f = new File("plugins/rank/rank.yml");
        if(!f.exists()) {
            try {
                Files.createDirectory(new File("plugins/rank").toPath());
                Files.createFile(f.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        RankData.rankFile = YamlConfiguration.loadConfiguration(f);

        this.getCommand("rank").setExecutor(new RankCommand());
        this.getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
