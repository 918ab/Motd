package Motd.Command;

import Motd.Main;
import Motd.listener.ServerPingListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class Command implements CommandExecutor {

    private String pr = "§x§8§A§F§F§0§0M§x§9§8§F§F§4§0o§x§A§7§F§F§8§0t§x§B§5§F§F§C§0d §f● ";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.isOp()){

            Main.getPlugin().reloadConfig();
            for (Player player : Bukkit.getOnlinePlayers()) {
                new ServerPingListener(Main.getPlugin()).updateTabList(player);
            }
            String msg = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Motd.1"));
            String msg1 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Motd.2"));
            String VersionName = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("VersionName"));
            Integer MaxPlayers = Main.getPlugin().getConfig().getInt("MaxPlayers");
            Integer NumPlayers = Main.getPlugin().getConfig().getInt("NumPlayers");
            boolean HidePlayers = Main.getPlugin().getConfig().getBoolean("HidePlayers");
            boolean Cancelled = Main.getPlugin().getConfig().getBoolean("Cancelled");
            boolean playerlistuse = Main.getPlugin().getConfig().getBoolean("player-list-use");
            sender.sendMessage(pr+"리로드 완료");
            sender.sendMessage(pr+"Motd : "+msg+"/"+msg1);
            sender.sendMessage(pr+"VersionName : "+VersionName);
            sender.sendMessage(pr+"MaxPlayers : "+MaxPlayers);
            sender.sendMessage(pr+"HidePlayers : "+HidePlayers);
            sender.sendMessage(pr+"Cancelled : "+Cancelled);
            sender.sendMessage(pr+"Playerlistuse : "+ playerlistuse);
            sender.sendMessage(pr+"NumPlayers : "+ NumPlayers);
            if (ServerPingListener.getInstance().reloadServerIcon()) {
                sender.sendMessage(pr + "server-icon.png 리로드 완료");
            } else {
                sender.sendMessage(pr + "server-icon.png 리로드 실패 ");
            }
        }else{
            sender.sendMessage(pr+"권한이 없습니다");
        }
        return true;
    }
}
