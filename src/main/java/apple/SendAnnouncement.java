package apple;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class SendAnnouncement {
    public static void sendAnnouncement(Player player, List<String> message, JavaPlugin plugin) {
        for (String msg : message) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                try {
                    player.sendMessage(ChatColor.AQUA + msg);
                } catch (Exception ignored) {
                    System.err.println("[FoundationAnnouncements] Was not able to send a message to player: " + player.getName());
                    // if they log out or something, just print a small err message
                }
            }, 80);
        }

    }
}
