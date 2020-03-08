package apple;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LoginListener implements Listener {
    JavaPlugin plugin;

    public LoginListener(AnnouncementsMain plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void loginListener(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        SendAnnouncement.sendAnnouncement(player, Message.message, plugin);
    }
}
