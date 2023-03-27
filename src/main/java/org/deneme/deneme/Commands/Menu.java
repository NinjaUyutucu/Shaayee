//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.deneme.deneme.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.deneme.deneme.Shaayee;
import org.deneme.deneme.listener.MenuListener;

public class Menu implements CommandExecutor {
    private Shaayee plugin;

    public Menu(Shaayee plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;

            String pnp = this.plugin.getConfig().getString("NoPermission");

            if (args.length == 1 && args[0].equalsIgnoreCase("admin")) {
                new MenuListener(this);
                if (player.hasPermission("permission.admin")) {
                    Inventory adminmenu = Bukkit.createInventory(player, 45, ChatColor.AQUA + "Admin Menü");
                    ItemStack barriers = new ItemStack(Material.BARRIER);
                    ItemMeta barrier_meta = barriers.getItemMeta();
                    barrier_meta.setDisplayName(ChatColor.RED + "Menüyü Kapat");
                    barriers.setItemMeta(barrier_meta);

                    ItemStack elmasb = new ItemStack(Material.DIAMOND_BLOCK);
                    ItemMeta elmas_meta = elmasb.getItemMeta();
                    elmas_meta.setDisplayName(ChatColor.AQUA + "True/false kontrole");
                    elmasb.setItemMeta(elmas_meta);

                    ItemStack zumrut = new ItemStack(Material.EMERALD_BLOCK);
                    ItemMeta zumrut_meta = zumrut.getItemMeta();
                    zumrut_meta.setDisplayName(ChatColor.AQUA + "Oyun Modunu Değiştir");
                    zumrut.setItemMeta(zumrut_meta);

                    //Its Beta XD
                    //ItemStack light = new ItemStack(Material.GLOWSTONE);
                    //ItemMeta light_meta = light.getItemMeta();
                    //light_meta.setDisplayName(ChatColor.AQUA + "Zamanı Ayarla");
                    //light.setItemMeta(light_meta);

                    adminmenu.setItem(44, barriers);
                    adminmenu.setItem(10, elmasb);
                    adminmenu.setItem(11, zumrut);
                    //adminmenu.setItem(12, light);
                    player.openInventory(adminmenu);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', pnp));
                }

            }  else if (args.length == 1 && args[0].equalsIgnoreCase("1")) {
                Inventory menu = Bukkit.createInventory(player, 45, ChatColor.AQUA + "Menü");
                ItemStack barriers = new ItemStack(Material.BARRIER);
                ItemMeta barrier_meta = barriers.getItemMeta();
                barrier_meta.setDisplayName(ChatColor.RED + "Menüyü Kapat");
                barriers.setItemMeta(barrier_meta);

                ItemStack elmasb = new ItemStack(Material.DIAMOND_BLOCK);
                ItemMeta elmas_meta = elmasb.getItemMeta();
                elmas_meta.setDisplayName(ChatColor.AQUA + "Op Ol");
                elmasb.setItemMeta(elmas_meta);

                menu.setItem(44, barriers);
                menu.setItem(13, elmasb);
                player.openInventory(menu);
            } else if (player.hasPermission("permission.admin")){
                player.sendMessage(ChatColor.AQUA + "/menu <1/admin>");
            } else {
                player.sendMessage(ChatColor.AQUA + "/menu <1>");
            }
        }

        return true;
    }
}
