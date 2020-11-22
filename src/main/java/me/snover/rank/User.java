package me.snover.rank;

import org.bukkit.entity.Player;

import java.util.UUID;

public class User {
    private Rank rank;
    private String name;
    private Player player;
    private final UUID playerUUID;

    public User(Rank rank, Player player) {
        this.rank = rank;
        this.name = player.getName();
        this.player = player;
        this.playerUUID = player.getUniqueId();
    }

    public String getName() {
        return this.name;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Player getPlayer() {
        return this.player;
    }

    public UUID getPlayerUUID() {
        return this.playerUUID;
    }
}
