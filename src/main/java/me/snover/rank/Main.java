package me.snover.rank;

import me.snover.rank.commands.RankCommand;
import me.snover.rank.events.Events;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        this.plugin = this;

        RankData.loadConfigFile();

        this.getCommand("rank").setExecutor(new RankCommand());
        this.getServer().getPluginManager().registerEvents(new Events(), this);
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
