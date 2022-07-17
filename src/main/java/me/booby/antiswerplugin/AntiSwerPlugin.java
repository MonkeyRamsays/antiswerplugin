package me.booby.antiswerplugin;

import me.booby.antiswerplugin.commands.ReloadCommand;
import me.booby.antiswerplugin.commands.SwerCommand;
import me.booby.antiswerplugin.listener.ChatListener;
import me.booby.antiswerplugin.util.Color;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiSwerPlugin extends JavaPlugin {

    private static AntiSwerPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();

        this.getCommand("swer").setExecutor(new SwerCommand());
        this.getCommand("swerreload").setExecutor(new ReloadCommand());
        this.getServer().getPluginManager().registerEvents(new ChatListener(), this);

        this.getLogger().info("Ultimate AntiSwer protection has been enabled!!!!!");
        this.getServer().getConsoleSender().sendMessage(Color.translate(
                "&aUltimate AntiSwer protection has been enabled!!!!!\n" +
                     "&aVersion " + this.getDescription().getVersion()
        ));
    }

    public static AntiSwerPlugin getInstance() {
        return instance;
    }
}
