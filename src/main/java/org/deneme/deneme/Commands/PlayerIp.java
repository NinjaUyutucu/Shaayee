package org.deneme.deneme.Commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.deneme.deneme.Shaayee;

public class PlayerIp implements CommandExecutor {

    private Shaayee plugin;

    public PlayerIp(Shaayee plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Player t = Bukkit.getPlayer(args[1]);
            String p = PlaceholderAPI.setPlaceholders(t, "&7%player_name%");
            String pi = PlaceholderAPI.setPlaceholders(t, "&7%player_ip%");
            String ph = PlaceholderAPI.setPlaceholders(t, "&7%player_health%");
            String pfjd = PlaceholderAPI.setPlaceholders(t, "&7%player_first_join_date%");
            String pp = PlaceholderAPI.setPlaceholders(t, "&7%player_ping%");
            String pg = PlaceholderAPI.setPlaceholders(t, "&7%player_gamemode%");
            String petl = PlaceholderAPI.setPlaceholders(t, "&7%player_exp_to_level%");
            String pfl = PlaceholderAPI.setPlaceholders(t, "&7%player_food_level%");
            String php = PlaceholderAPI.setPlaceholders(t, "&7%player_has_permission_<permission>%");
            String pif = PlaceholderAPI.setPlaceholders(t, "&7%player_is_flying%");
            String pio= PlaceholderAPI.setPlaceholders(t, "&7%player_is_op%");
            String piihn = PlaceholderAPI.setPlaceholders(t, "&7%player_item_in_hand_name%");
            String pt = PlaceholderAPI.setPlaceholders(t, "&7%player_time%");
            String pwt = PlaceholderAPI.setPlaceholders(t, "&7%player_world_type%");
            String px = PlaceholderAPI.setPlaceholders(t, "&7%player_x%");
            String pz = PlaceholderAPI.setPlaceholders(t, "&7%player_z%");
            String PO = this.plugin.getConfig().getString("&4PlayerOffline");
            if (player.hasPermission("permissin.admin")) {
                if (args.length > 1 && args[0].equalsIgnoreCase("all")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        player.sendMessage(PO);
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4TargetName:"+p+" &4TargetIp:"+pi+" &4TargetHealt:"+ph+" &4TargetFirstJoinDate:"+pfjd+" &4TargetPing:"+pp+" &4TargetGameMode:"+pg+" &4TargetLevel:"+petl+" &4TargetFoodLvl:"+pfl+" &4TargetHasPer:"+php+" &4TargetIsFly:"+pif+" &4TargetIsOp:"+pio+" &4TargetItemInHand:"+piihn+" &4TargetTime:"+pt+" &4TargetWorld:"+pwt+" &4TargetX:"+px+" &4TargetZ:"+pz));
                    }
                } else {
                    Player target = Bukkit.getPlayer(label);
                    if (target == null) {
                        player.sendMessage(ChatColor.AQUA + "/playerinfo <all> <oyuncu>");
                    }
                }
            }
        }
        return true;
    }
}
