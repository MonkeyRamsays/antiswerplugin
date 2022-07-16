package me.booby.antiswerplugin;

import me.booby.antiswerplugin.commands.ReloadCommand;
import me.booby.antiswerplugin.commands.SwerCommand;
import me.booby.antiswerplugin.listener.ChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiSwerPlugin extends JavaPlugin {

    private static AntiSwerPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getCommand("swer").setExecutor(new SwerCommand());
        getCommand("swerreload").setExecutor(new ReloadCommand());
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    public static AntiSwerPlugin getInstance() {
        return instance;
    }
}
