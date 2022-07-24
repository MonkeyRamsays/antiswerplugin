package me.booby.antiswerplugin.listener;

import me.booby.antiswerplugin.AntiSwerPlugin;
import me.booby.antiswerplugin.util.Color;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.text.MessageFormat;

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

        FileConfiguration config = AntiSwerPlugin.getInstance().getConfig();

        // here we go thru every swer word in the config
        for (String word : config.getStringList("swer-words")) {
            // we see if the message is bad by checking if it contains this bad word
            boolean isBad = message.contains(word.toLowerCase());

            if (isBad) {
                // if the message is bad we cancel event so chat doesn't send
                event.setCancelled(true);
                player.sendMessage(Color.translate(config.getString("messages.do-not-swer")));

                // we go thru every online player
                for (Player staffPlayer : Bukkit.getOnlinePlayers()) {
                    // we check if they don't have this permission
                    if (!staffPlayer.hasPermission("antiswer.see")) {
                        // continue -> continues to the next player without doing anything in this case
                        continue;
                    }
                    // down here we know that the player has the permission
                    staffPlayer.sendMessage(Color.translate(
                            MessageFormat.format(config.getString("messages.alert"), player.getName(), event.getMessage())
                    ));
                    // puugz taught me this i can now write ChatColor.RED
                }
                break;
            }
        }

        event.setFormat(player.getName() + ": " + event.getMessage());
    }
}
