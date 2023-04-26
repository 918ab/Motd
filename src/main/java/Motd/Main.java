package Motd;

import Motd.Command.Command;
import Motd.listener.ServerPingListener;
import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;
import java.util.logging.Level;

public final class Main extends JavaPlugin {
    private static Main plugin;
    public Main() {
    }
    public static Main getPlugin() {
        return plugin;
    }


    @Override
    public void onEnable() {
        plugin = this;
        Command command = new Command();
        getCommand("motdreload").setExecutor(command);
        this.getServer().getPluginManager().registerEvents(ServerPingListener.getInstance(), plugin);
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveDefaultConfig();
        }
    }

    @Override
    public void onDisable() {
    }
}


