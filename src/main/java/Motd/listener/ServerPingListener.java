package Motd.listener;

import Motd.Main;
import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import com.destroystokyo.paper.profile.PlayerProfile;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.CachedServerIcon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ServerPingListener implements Listener {
    static final ServerPingListener INSTANCE = new ServerPingListener(Main.getPlugin());
    final Main plugin;
    private CachedServerIcon serverIcon;
    public ServerPingListener(Main plugin) {
        this.plugin = plugin;
        reloadServerIcon();
    }

    public static ServerPingListener getInstance() {
        return INSTANCE;
    }
    public boolean reloadServerIcon() {
        File iconFile = new File(plugin.getDataFolder(), "server-icon.png");
        if (!iconFile.exists()) {
            return false;
        }
        try {
            this.serverIcon = Bukkit.loadServerIcon(iconFile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    @EventHandler
    public void onServerListPing(PaperServerListPingEvent event) {
        String msg = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Motd.1"));
        String msg1 = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Motd.2"));
        event.setMotd(msg + "\n" + msg1);

        String versionName = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("VersionName"));
        event.setVersion(versionName);

        int maxPlayers = this.plugin.getConfig().getInt("MaxPlayers");
        event.setMaxPlayers(maxPlayers);

        boolean hidePlayers = this.plugin.getConfig().getBoolean("HidePlayers");
        event.setHidePlayers(hidePlayers);

        boolean cancelled = this.plugin.getConfig().getBoolean("Cancelled");
        event.setCancelled(cancelled);

        boolean numPlayersUse = this.plugin.getConfig().getBoolean("NumPlayers-use");
        if (numPlayersUse) {
            int numPlayers = this.plugin.getConfig().getInt("NumPlayers");
            event.setNumPlayers(numPlayers);
        }
        boolean playerListUse = this.plugin.getConfig().getBoolean("player-list-use");
        if (playerListUse) {
            List<String> lines = this.plugin.getConfig().getStringList("player-list");
            event.getListedPlayers().clear();

            for (int i = 0; i < lines.size(); i++) {
                String coloredName = ChatColor.translateAlternateColorCodes('&', lines.get(i));
                event.getListedPlayers().add(i, new PaperServerListPingEvent.ListedPlayerInfo(coloredName, UUID.randomUUID()));
            }
        }
        if (this.serverIcon != null) {
            event.setServerIcon(this.serverIcon);
        }
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        updateTabList(event.getPlayer());
    }

    public void updateTabList(org.bukkit.entity.Player player) {
        List<String> headerLines = plugin.getConfig().getStringList("Tab.header");
        List<String> footerLines = plugin.getConfig().getStringList("Tab.footer");
        Component header = Component.text(headerLines.stream()
                .map(line -> ChatColor.translateAlternateColorCodes('&', line))
                .collect(Collectors.joining("\n")));
        Component footer = Component.text(footerLines.stream()
                .map(line -> ChatColor.translateAlternateColorCodes('&', line))
                .collect(Collectors.joining("\n")));
        Bukkit.broadcastMessage(header.toString());
        player.sendPlayerListHeaderAndFooter(header, footer);
    }

}