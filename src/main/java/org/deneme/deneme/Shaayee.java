//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.deneme.deneme;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.deneme.deneme.Commands.Discord;
import org.deneme.deneme.Commands.Menu;
import org.deneme.deneme.Commands.PlayerIp;
import org.deneme.deneme.Commands.TestGamemode;
import org.deneme.deneme.listener.EventListener;
import org.deneme.deneme.listener.MenuListener;

public class Shaayee extends JavaPlugin {

    FileConfiguration config;
    File cfile;
    public Shaayee() {
    }

    public void onLoad() {
        System.out.println("[Shaayee] Plugin Başlatılıyor");
    }

    public void onEnable() {
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        cfile = new File(getDataFolder(), "config.yml");

        Bukkit.getPluginManager().registerEvents(new EventListener(this), this);
        Bukkit.getPluginManager().registerEvents(new MenuListener(this), this);
        this.getCommand("gm").setExecutor(new TestGamemode(this));
        this.getCommand("discord").setExecutor(new Discord(this));
        this.getCommand("menu").setExecutor(new Menu(this));
        this.getCommand("playerinfo").setExecutor(new PlayerIp(this));
        System.out.println("Plugin Başarı Ile Başlatıldı Iyi Oyunlar");
    }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("permission.admin")) {
                if (cmd.getName().equalsIgnoreCase("sreload")) {
                    config = YamlConfiguration.loadConfiguration(cfile);
                    sender.sendMessage(ChatColor.GREEN + "Config Başarıyla Yeniden Başlatıldı");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',config.getString("NoPermission")));
            }
        }
        return true;
    }

    public void onDisable() {
        System.out.println("Plugin Kapatıldı...");
    }
}
