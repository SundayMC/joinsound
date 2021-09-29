package fr.sundaymc.joinsound;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    private JoinSoundMain plugin;

    public Commands(JoinSoundMain plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("joinsound.reload")) {
            sender.sendMessage(JoinSoundMain.Color(this.plugin.getConfig().getString("No-Permission").replace("%prefix%", this.plugin.prefix)));
            return false;
        }
        if (cmd.getName().equalsIgnoreCase("joinsound")) {
            if (args.length == 0 || args.length > 1) {
                for (String Help : this.plugin.getConfig().getStringList("Help-Message"))
                    sender.sendMessage(JoinSoundMain.Color(Help));
                return false;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                this.plugin.reloadConfig();
                sender.sendMessage(JoinSoundMain.Color(this.plugin.getConfig().getString("Reload-Message").replace("%prefix%", this.plugin.prefix)));
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(JoinSoundMain.Color(this.plugin.getConfig().getString("Only-Player").replace("%prefix%", this.plugin.prefix)));
                return false;
            }
        }
        return true;
    }
}
