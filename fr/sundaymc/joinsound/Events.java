package fr.sundaymc.joinsound;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {
    private JoinSoundMain plugin;

    public Events(JoinSoundMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public boolean onJoin(PlayerJoinEvent p) {
        Player player = p.getPlayer();
        if (player.hasPermission("joinsound.havejoinsound")) {
            if (this.plugin.getConfig().getBoolean("Sound-On-Join"))
                for (Player onlinePlayer : Bukkit.getOnlinePlayers())
                {
                    onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.valueOf(this.plugin.getConfig().getString("Sound-Join")), this.plugin.getConfig().getInt("Volume"), this.plugin.getConfig().getInt("Pitch"));
                }
        }
        return false;

    }
    public boolean onQuit(PlayerQuitEvent p) {
        Player player = p.getPlayer();
        if (player.hasPermission("joinsound.havequitsound")) {
            if (this.plugin.getConfig().getBoolean("Sound-On-Quit"))
                for (Player onlinePlayer : Bukkit.getOnlinePlayers())
                {
                    onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.valueOf(this.plugin.getConfig().getString("Sound-Quit")), this.plugin.getConfig().getInt("Volume"), this.plugin.getConfig().getInt("Pitch"));
                }
        }
        return false;
    }
}
