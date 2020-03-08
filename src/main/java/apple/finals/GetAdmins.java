package apple.finals;

import apple.finals.YMLNavigate;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class GetAdmins {
    private static JavaPlugin plugin;

    public static void initialize(JavaPlugin pl) {
        plugin = pl;
    }

    public static boolean isAdmin(String uuid) {
        File file = new File(plugin.getDataFolder() + File.separator + "announcement" + File.separator + "admins.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection configAdmins = config.getConfigurationSection(YMLNavigate.ADMIN);
        int i = 0;
        if (configAdmins == null) {
            System.err.println("Something went wrong with reading the admins.");
            return false;
        }
        String configAdmin = configAdmins.getString(YMLNavigate.ADMIN + i++);
        while (configAdmin != null) {
            if (configAdmin.equals(uuid)) {
                // open the MainOp inventory
                return true;
            }
            configAdmin = configAdmins.getString(YMLNavigate.ADMIN + i++);
        }
        return false;
    }
}
