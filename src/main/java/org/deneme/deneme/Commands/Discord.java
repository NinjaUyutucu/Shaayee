//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.deneme.deneme.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.deneme.deneme.Shaayee;

public class Discord implements CommandExecutor {
    private Shaayee plugin;

    public Discord(Shaayee plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            String prefix = this.plugin.getConfig().getString("Prefix");
            String dc = this.plugin.getConfig().getString("Discord");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + dc));
        }

        return true;
    }
}
