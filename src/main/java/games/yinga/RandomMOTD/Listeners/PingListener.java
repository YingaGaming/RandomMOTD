package games.yinga.RandomMOTD.Listeners;

import java.util.List;
import java.util.Random;

import games.yinga.RandomMOTD.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.event.EventHandler;

public class PingListener implements Listener {

    Random random = new Random();

    @EventHandler
    public void onPing(ProxyPingEvent event) {

        Configuration config = Main.getConfig();

        List<String> motdList = config.getStringList("motd");

        String motd = motdList.get(random.nextInt(motdList.size()));

        ServerPing response = event.getResponse();

        response.setDescriptionComponent(new ComponentBuilder(
                ChatColor.translateAlternateColorCodes('&', motd)).create()[0]);

        event.setResponse(response);

    }

}
