package Motd.Command;

import Motd.Main;
import Motd.listener.ServerPingListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class Command implements CommandExecutor {



    public Command(){

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.isOp()){

            Main.getPlugin().reloadConfig();
            ServerPingListener.getInstance().reloadCache();
            String msg = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Motd.1"));
            String msg1 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Motd.2"));
            String VersionName = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("VersionName"));
            Integer MaxPlayers = Main.getPlugin().getConfig().getInt("MaxPlayers");
            boolean HidePlayers = Main.getPlugin().getConfig().getBoolean("HidePlayers");
            boolean Cancelled = Main.getPlugin().getConfig().getBoolean("Cancelled");
            boolean playerlistuse = Main.getPlugin().getConfig().getBoolean("player-list-use");
            sender.sendMessage("§f[§aMotd§f] 리로드 완료");
            sender.sendMessage("§f[§aMotd§f] Motd : "+msg+"/"+msg1);
            sender.sendMessage("§f[§aMotd§f] VersionName : "+VersionName);
            sender.sendMessage("§f[§aMotd§f] MaxPlayers : "+MaxPlayers);
            sender.sendMessage("§f[§aMotd§f] HidePlayers : "+HidePlayers);
            sender.sendMessage("§f[§aMotd§f] Cancelled : "+Cancelled);
            sender.sendMessage("§f[§aMotd§f] Playerlistuse : "+ playerlistuse);
        }else{
            sender.sendMessage("§f[§aMotd§f] 권한이 없습니다");
        }
        return true;
    }
}
