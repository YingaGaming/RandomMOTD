package games.yinga.RandomMOTD.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class BaseCommand extends Command {

    public BaseCommand(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new ComponentBuilder(
                    ChatColor.translateAlternateColorCodes('&',
                            "&d&lRandomMOTD\n&e==========\n&breload &a| &6Reload config"))
                    .create());
            return;
        }
        
        switch (args[0].toLowerCase()) {
            case "reload":
                new ReloadCommand().execute(sender, args);
                break;
        
            default:
                sender.sendMessage(new ComponentBuilder(
                        ChatColor.translateAlternateColorCodes('&',
                                "&cUnknown Command!"))
                        .create());
                break;
        }
        
    }
    
}
