//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.deneme.deneme.Commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.deneme.deneme.Shaayee;

public class TestGamemode implements CommandExecutor {
    private Shaayee plugin;

    public TestGamemode(Shaayee plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String prefix = this.plugin.getConfig().getString("Prefix");
            String gm0 = this.plugin.getConfig().getString("gm0-message");
            String gm1 = this.plugin.getConfig().getString("gm1-message");
            String gm2 = this.plugin.getConfig().getString("gm2-message");
            String gm3 = this.plugin.getConfig().getString("gm3-message");
            String PO = this.plugin.getConfig().getString("PlayerOffline");
            String p = PlaceholderAPI.setPlaceholders(player, "%player_name%");
            if (player.hasPermission("permission.admin")) {
                if (args.length == 1 && args[0].equalsIgnoreCase("1")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gm1));
                } else if (args.length > 1 && args[0].equalsIgnoreCase("1")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        player.sendMessage(PO);
                    } else {
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Oyun Modunuz " + p + " Tarafından Yaratıcıya Alındı"));
                        target.setGameMode(GameMode.CREATIVE);
                    }
                } else if (args.length == 1 && args[0].equalsIgnoreCase("0")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gm0));
                } else if (args.length > 1 && args[0].equalsIgnoreCase("0")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        player.sendMessage(PO);
                    } else {
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Oyun Modunuz " + p + " Tarafından Hayatta Kalmaya Alındı"));
                        target.setGameMode(GameMode.SURVIVAL);
                    }
                } else if (args.length == 1 && args[0].equalsIgnoreCase("2")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gm2));
                } else if (args.length > 1 && args[0].equalsIgnoreCase("2")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        player.sendMessage(PO);
                    } else {
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Oyun Modunuz " + p + " Tarafından Maceraya Alındı"));
                        target.setGameMode(GameMode.ADVENTURE);
                    }
                } else if (args.length == 1 && args[0].equalsIgnoreCase("3")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gm3));
                } else if (args.length > 1 && args[0].equalsIgnoreCase("3")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        player.sendMessage(PO);
                    } else {
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Oyun Modunuz " + p + " Tarafından Izleyiciye Alındı"));
                        target.setGameMode(GameMode.SPECTATOR);
                    }
                } else {
                    player.sendMessage(ChatColor.AQUA + "/gm <0/1/2/3> <oyuncu>");
                }
            }
        }

        return true;
    }
}
