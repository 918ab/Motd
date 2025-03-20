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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        saveDefaultServerIcon();
    }

    @Override
    public void onDisable() {
    }

    private void saveDefaultServerIcon() {
        File iconFile = new File(getDataFolder(), "server-icon.png");
        if (!iconFile.exists()) {
            try (InputStream in = getResource("server-icon.png"); FileOutputStream out = new FileOutputStream(iconFile)) {
                if (in == null) {
                    return;
                }
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            } catch (IOException e) {
                getLogger().log(Level.SEVERE, "server-icon.png 파일 생성 중 오류", e);
            }
        }
    }
}


