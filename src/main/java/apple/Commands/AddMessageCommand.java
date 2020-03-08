package apple.Commands;

import apple.AnnouncementsMain;
import apple.Message;
import apple.SendAnnouncement;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AddMessageCommand implements CommandExecutor {
    JavaPlugin plugin;

    public AddMessageCommand(AnnouncementsMain plugin) {
        this.plugin = plugin;
        PluginCommand command = plugin.getCommand("announce_add");
        if (command == null) {
            System.err.println(Message.ANNOUNCEMENTS_TAG + " Could not load command announce_add");
            return;
        }
        command.setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = Bukkit.getPlayer(commandSender.getName());
        if (player == null) {
            return true;
        }
        String message = String.join(" ", args);
        Message.addMessage(message);
        SendAnnouncement.sendAnnouncement(player, Message.message, plugin);
        return false;
    }
}
