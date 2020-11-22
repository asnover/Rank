package me.snover.rank.commands;

import me.snover.rank.LoggedUsers;
import me.snover.rank.Rank;
import me.snover.rank.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class RankCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player) {
           Player player = (Player) commandSender;
            User user = LoggedUsers.getUser(player);
            Rank rank = Rank.ADMINISTRATOR;
            if(!rank.playerHasRankMin(user.getRank())) {
                player.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }
        }

        if(args[0] == "set") {
            UUID uuid = Bukkit.getPlayer(args[1]).getUniqueId();
            String rankArg = args[2];

        }

        commandSender.sendMessage("/rank set <player> <rank name OR rank ID>");
        return true;
    }
}
