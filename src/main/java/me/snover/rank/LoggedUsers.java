package me.snover.rank;

import org.bukkit.entity.Player;
import java.util.HashMap;

public class LoggedUsers {
    private static HashMap <Player, User> users = new HashMap<>();

    public static void addUser(User user) {
        users.put(user.getPlayer(), user);
    }

    public static void removeUser(User user) {
        users.remove(user);
    }

    public static void removeUser(Player player) {
        users.remove(player);
     }

    public static User getUser(Player player) {
        return users.get(player);
    }
}
