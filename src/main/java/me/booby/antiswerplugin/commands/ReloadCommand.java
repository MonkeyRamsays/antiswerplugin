package me.booby.antiswerplugin.commands;

import me.booby.antiswerplugin.AntiSwerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        AntiSwerPlugin plugin = AntiSwerPlugin.getInstance();

        plugin.reloadConfig();
        sender.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "reloaded the ultimate juicer banger night enderman anger wicked anti swer plugin reloaded " + ChatColor.RED + "bang.");
        // look at this i have made this fucking unreadable

        return false;
    }
}
