package me.snover.rank.commands;

import me.snover.rank.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.logging.Level;

public class RankCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player) {
           Player player = (Player) commandSender;
            User user = LoggedUsers.getUser(player);
            Rank rank = Rank.ADMINISTRATOR;
            if(!rank.playerHasRankMin(user.getRank()) && !player.isOp()) {
                player.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }
        }

        if(args.length < 1) {
            System.out.println(args.length);
            commandSender.sendMessage("/rank <set|status>");
            return true;
        }

        if(args[0].equalsIgnoreCase("set")) {
            if(args.length < 3) {
                commandSender.sendMessage("/rank set <player> <rank name/rank ID>");
                return true;
            }
            Player player = Bukkit.getPlayer(args[1]);
            String rankArg = args[2];
            int rankID;
                try {
                    rankID = Integer.parseInt(rankArg);
                } catch (NumberFormatException e) {
                    rankID = Rank.getRankID(rankArg);
                }
                for(Rank rank : Rank.values()) {
                    if(rank.getRankID() == rankID) {
                        RankData.setPlayerRank(player, rank);
                        commandSender.sendMessage("Player rank set to: " + rank.getDisplayName());
                        return true;
                    } else {
                        commandSender.sendMessage("/rank set <player> <rank name/rank ID>");
                        return true;
                    }
                }
        }

        if(args[0].equalsIgnoreCase("status")) {
            if(args.length < 2) {
                commandSender.sendMessage("/rank status <player>");
                return true;
            }
            Player player = Bukkit.getPlayer(args[1]);
            Rank playerStatus = RankData.getPlayerRank(player);
            if(playerStatus == null) {
                commandSender.sendMessage("§4This is not the player you are looking for!");
                return true;
            }
            commandSender.sendMessage("Player rank is: " + RankData.getPlayerRank(player).getDisplayName());
            return true;
        }
        commandSender.sendMessage("/rank <set|status>");
        return true;
    }
}
