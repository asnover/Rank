package me.snover.rank.events;

import me.snover.rank.LoggedUsers;
import me.snover.rank.Rank;
import me.snover.rank.RankData;
import me.snover.rank.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class Events implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        User user = new User(RankData.getPlayerRank(player), player);
        LoggedUsers.addUser(user);
    }
}
