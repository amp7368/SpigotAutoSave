package apple;

import apple.Commands.AddMessageCommand;
import apple.Commands.SetMessageCommand;
import apple.finals.GetAdmins;
import org.bukkit.plugin.java.JavaPlugin;

public class AnnouncementsMain extends JavaPlugin {
    @Override
    public void onEnable() {
        Message.initialize(this);
        GetAdmins.initialize(this);

        new AddMessageCommand(this);
        new SetMessageCommand(this);
        new LoginListener(this);
        System.out.println(Message.ANNOUNCEMENTS_TAG +" enabled");
    }
}
