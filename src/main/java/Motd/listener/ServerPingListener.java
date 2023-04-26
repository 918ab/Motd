package Motd.listener;

import Motd.Main;
import Motd.impl.MotdProfileimpl;
import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ServerPingListener implements Listener {
    static final ServerPingListener INSTANCE = new ServerPingListener(Main.getPlugin());
    final Main plugin;
    final List<MotdProfileimpl> MotdList;

    public ServerPingListener(Main plugin) {
        this.plugin = plugin;
        this.MotdList = new ArrayList();
        this.reloadCache();
    }
    public static ServerPingListener getInstance() {
        return INSTANCE;
    }

    public void reloadCache() {
        this.MotdList.clear();

        Iterator var1 = this.plugin.getConfig().getStringList("player-list").iterator();

        while(var1.hasNext()) {
            String str = (String) var1.next();
            this.MotdList.add(new MotdProfileimpl(ChatColor.translateAlternateColorCodes('&', str)));

        }


    }

    @EventHandler
    public void onServerListPing(PaperServerListPingEvent event) {
        String msg = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Motd.1"));
        String msg1 = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Motd.2"));
        event.setMotd(msg+"\n"+msg1);
        String VersionName = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("VersionName"));
        event.setVersion(VersionName);
        Integer MaxPlayers = this.plugin.getConfig().getInt("MaxPlayers");
        event.setMaxPlayers(MaxPlayers);
        boolean HidePlayers = this.plugin.getConfig().getBoolean("HidePlayers");
        event.setHidePlayers(HidePlayers);
        boolean Cancelled = this.plugin.getConfig().getBoolean("Cancelled");
        event.setCancelled(Cancelled);
        boolean playerlistuse = this.plugin.getConfig().getBoolean("player-list-use");
        if(playerlistuse==true) {
            List<PlayerProfile> profiles = event.getPlayerSample();
            profiles.clear();
            profiles.addAll(this.MotdList);
        }



    }
}
