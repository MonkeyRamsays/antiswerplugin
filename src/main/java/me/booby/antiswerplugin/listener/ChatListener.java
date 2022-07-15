package me.booby.antiswerplugin.listener;

import me.booby.antiswerplugin.AntiSwerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void handleChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        // type name   = value;

        // 1 - i x
        // ! - i
        // 4 - a
        // @ - a
        // 3 - e
        // 0 - o

        // "shut the fuck up bitch ass motherfucker dick skessy"
        // 104 58 -> io4 58

        // event.getMessage() -> "m0th3rfuck3r"
        // event.getMessage() -> "d1ck"
        String message = event.getMessage().toLowerCase()
                .replaceAll("1", "i")
                .replaceAll("!", "i")
                .replaceAll("4", "a")
                .replaceAll("@", "a")
                .replaceAll("3", "e")
                .replaceAll("0", "o");
        // after all replacements -> "motherfucker"
        // after all replacements -> "dick"

        // Object + "string whatigbdsrtgsf"
        // Object + Object + "string whatigbdsrtgsf"

        for (String word : AntiSwerPlugin.getInstance().getConfig().getStringList("swer-words")) {
            boolean isBad = message.contains(word.toLowerCase());

            if (isBad) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "do not swer.");
                break;
            }
        }

        event.setFormat(player.getName() + ": " + event.getMessage());
    }
}