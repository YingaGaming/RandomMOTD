package games.yinga.RandomMOTD.Commands;

import java.io.IOException;

import games.yinga.RandomMOTD.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class ReloadCommand {

    public void execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("randommotd.reload")) {
            sender.sendMessage(new ComponentBuilder(
                    ChatColor.translateAlternateColorCodes('&', "&cYou are not allowed to do this!"))
                    .create());
            return;
        }

        try {
            Main.getInstance().loadConfig();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        sender.sendMessage(new ComponentBuilder(
                ChatColor.translateAlternateColorCodes('&', "&aConfig reloaded!"))
                .create());

    }
    
}
