package fr.sundaymc.joinsound;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinSoundMain extends JavaPlugin {
    private File Config = new File(getDataFolder(), "config.yml");

    FileConfiguration config = getConfig();

    PluginDescriptionFile file = getDescription();

    public String version = this.file.getVersion();

    public String latestversion;

    public String updateConfig;

    public static String Color(String color) {
        return ChatColor.translateAlternateColorCodes('&', color);
    }

    String prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Plugin-Prefix"));

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"&2Le plugin JoinSound a été activé."));
        createConfig();
        Bukkit.getPluginManager().registerEvents(new Events(this), (Plugin)this);
        getCommand("joinsound").setExecutor(new Commands(this));
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Le plugin JoinSound est désactivé."));
    }
    public void createConfig() {
        if (!this.Config.exists())
            saveResource("config.yml", false);
    }
}
