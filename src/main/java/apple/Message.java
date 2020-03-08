package apple;

import apple.finals.YMLNavigate;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Message {
    public static final String ANNOUNCEMENTS_TAG = "[FoundationAnnouncements]";
    public static List<String> message;
    private static JavaPlugin plugin;

    public static void initialize(JavaPlugin pl) {
        plugin = pl;
        update();
    }

    public static void update() {
        File file = new File(plugin.getDataFolder() + File.separator + "announcement" + File.separator + "announcements.yml");
        YamlConfiguration configOrig = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection config = configOrig.getConfigurationSection(YMLNavigate.message);
        if (config == null) {
            System.err.println("[FoundationAnnouncement] There was an error retrieving the announcement section.");
            return;
        }
        message = new ArrayList<>();
        int i = 0;
        while (true) {
            String msg = config.getString(YMLNavigate.line + i++);
            if (msg == null) break;
            message.add(msg);
        }
    }

    public static void write(List<String> newMessage) {
        File file = new File(plugin.getDataFolder() + File.separator + "announcement" + File.separator + "announcements.yml");
        YamlConfiguration configOrig = YamlConfiguration.loadConfiguration(file);
        configOrig.set(YMLNavigate.message, null);
        configOrig.createSection(YMLNavigate.message);
        ConfigurationSection config = configOrig.getConfigurationSection(YMLNavigate.message);
        if (config == null) {
            System.err.println("[FoundationAnnouncement] There was an error retrieving the announcement section.");
            return;
        }
        int i = 0;
        for (String msg : newMessage) {
            config.set(YMLNavigate.line + i++, msg);
        }
        try {
            configOrig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        update();

    }

    public static void addMessage(String msg) {
        message.add(msg);
        write(message);
    }
}
