package me.booby.antiswerplugin.commands;

import me.booby.antiswerplugin.AntiSwerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SwerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ew fuck off");
            return true;
        }

        Player player = (Player) sender;
        AntiSwerPlugin plugin = AntiSwerPlugin.getInstance();
        String version = plugin.getDescription().getVersion();
        String author = plugin.getDescription().getAuthors().get(0);

        player.sendMessage(ChatColor.AQUA + "ultimate swer plugin made by " + author + " version " + version);

        return false;
    }
}
