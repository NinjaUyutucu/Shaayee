//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.deneme.deneme.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.deneme.deneme.Commands.Menu;
import org.deneme.deneme.Shaayee;

public class MenuListener implements Listener {

    private Shaayee plugin;

    public MenuListener(Shaayee plugin) {
        this.plugin = plugin;
    }

    private Menu p;
    public MenuListener(Menu plugin) {
        this.p = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();

        String prefix = this.plugin.getConfig().getString("Prefix");
        String gm0 = this.plugin.getConfig().getString("gm0-message");
        String gm1 = this.plugin.getConfig().getString("gm1-message");
        String msg = this.plugin.getConfig().getString("test");

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Menü")) {
            e.setCancelled(true);

            if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
                player.closeInventory();
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Op Ol")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Birşey Değişmedi"));
            }
        }
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Admin Menü")) {
            e.setCancelled(true);

            if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
                player.closeInventory();
            }

            if (e.getCurrentItem().getType().equals(Material.DIAMOND_BLOCK)) {
                    if (msg.startsWith("true")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + "Test Şuanda " + msg));
                    } else if (msg.startsWith("false")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + "Test Şuanda " + msg));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + "Test Şuanda true veya false değil "));
                    }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Oyun Modunu Değiştir")) {
                Inventory menu = Bukkit.createInventory(player, 45, ChatColor.AQUA + "Admin Menü");
                ItemStack barriers = new ItemStack(Material.BARRIER);
                ItemMeta barrier_meta = barriers.getItemMeta();
                barrier_meta.setDisplayName(ChatColor.RED + "Menüyü Kapat");
                barriers.setItemMeta(barrier_meta);

                ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
                ItemMeta redstone_meta = redstone.getItemMeta();
                redstone_meta.setDisplayName(ChatColor.AQUA + "Oyun Modunu Hayatta Kalmaya Al");
                redstone.setItemMeta(redstone_meta);

                ItemStack zumrut = new ItemStack(Material.EMERALD_BLOCK);
                ItemMeta zumrut_meta = zumrut.getItemMeta();
                zumrut_meta.setDisplayName(ChatColor.AQUA + "Oyun Modunu Yaratıcıya Al");
                zumrut.setItemMeta(zumrut_meta);

                menu.setItem(44, barriers);
                menu.setItem(14, redstone);
                menu.setItem(12, zumrut);
                player.openInventory(menu);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Oyun Modunu Hayatta Kalmaya Al")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gm0));
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Oyun Modunu Yaratıcıya Al")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gm1));
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Zamanı Ayarla")) {
                Inventory menu = Bukkit.createInventory(player, 45, ChatColor.AQUA + "Admin Menü");
                ItemStack barriers = new ItemStack(Material.BARRIER);
                ItemMeta barrier_meta = barriers.getItemMeta();
                barrier_meta.setDisplayName(ChatColor.RED + "Menüyü Kapat");
                barriers.setItemMeta(barrier_meta);

                ItemStack yt = new ItemStack(Material.YELLOW_TERRACOTTA);
                ItemMeta yt_meta = yt.getItemMeta();
                yt_meta.setDisplayName(ChatColor.AQUA + "Zamanı Sabah Yap");
                yt.setItemMeta(yt_meta);

                ItemStack ot = new ItemStack(Material.ORANGE_TERRACOTTA);
                ItemMeta ot_meta = ot.getItemMeta();
                ot_meta.setDisplayName(ChatColor.AQUA + "Zamanı Öğlen Yap");
                ot.setItemMeta(ot_meta);

                ItemStack rt = new ItemStack(Material.RED_TERRACOTTA);
                ItemMeta rt_meta = rt.getItemMeta();
                rt_meta.setDisplayName(ChatColor.AQUA + "Zamanı Akşam Yap");
                rt.setItemMeta(rt_meta);

                ItemStack bt = new ItemStack(Material.BLACK_CONCRETE);
                ItemMeta bt_meta = bt.getItemMeta();
                bt_meta.setDisplayName(ChatColor.AQUA + "Zamanı Gece Yap");
                bt.setItemMeta(bt_meta);

                menu.setItem(44, barriers);
                menu.setItem(11, yt);
                menu.setItem(12, ot);
                menu.setItem(13, rt);
                menu.setItem(14, bt);
                player.openInventory(menu);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Zamanı Sabah Yap")) {
            }
        }
    }
 }

