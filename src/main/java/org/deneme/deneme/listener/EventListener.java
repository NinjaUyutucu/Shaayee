//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.deneme.deneme.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.deneme.deneme.Shaayee;

public class EventListener implements Listener {
    private Shaayee plugin;

    public EventListener(Shaayee plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String pfl = this.plugin.getConfig().getString("PlayerFirstLogin");
        String pl = this.plugin.getConfig().getString("PlayerLogin");
        String plpm = this.plugin.getConfig().getString("PlayerLoginPrivateMessage");
        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.AQUA + player.getName() + ChatColor.GRAY + pl);
        } else {
            e.setJoinMessage(ChatColor.AQUA + player.getName() + ChatColor.GRAY + pfl);
        }

        player.sendMessage(ChatColor.AQUA + plpm);
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e) {
        Player player = e.getPlayer();
        String tp = this.plugin.getConfig().getString("Teleporting");
        player.sendMessage(ChatColor.AQUA + tp);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        String cb = this.plugin.getConfig().getString("CantBreak");
        if (player.hasPermission("permission.admin")) {
            if (player.isOp()) {
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + cb);
            }
        }

    }
}
