package me.snover.rank.commands;

import me.snover.rank.LoggedUsers;
import me.snover.rank.Rank;
import me.snover.rank.RankData;
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
            Player player = Bukkit.getPlayer(args[1]);
            String rankArg = args[2];
            try {
                int rankID = Integer.parseInt(rankArg);
                for(Rank rank : Rank.values()) {
                    if(rank.getRankID() == rankID) {
                        RankData.setPlayerRank(player, rank);
                        commandSender.sendMessage("Player rank set to: " + rank.getDisplayName());
                        return true;
                    }
                }

                commandSender.sendMessage("§4This is not the rank you are looking for!");
            } catch (NumberFormatException e) {
                for (Rank rank : Rank.values()) {
                    if(rank.getName().equalsIgnoreCase(rankArg)) {
                        RankData.setPlayerRank(player, rank);
                        commandSender.sendMessage("Player rank set to: " + rank.getDisplayName());
                        return true;
                    }
                }

                commandSender.sendMessage("§4This is not the rank you are looking for!");
                return true;
            }

            commandSender.sendMessage("/rank set <player> <rank name/rank ID>");
            return true;
        }

        if(args[0] == "status") {
            Player player = Bukkit.getPlayer(args[1]);
            commandSender.sendMessage("Player rank is: " + RankData.getPlayerRank(player).getDisplayName());
            return true;
        }
        return true;
    }
}
