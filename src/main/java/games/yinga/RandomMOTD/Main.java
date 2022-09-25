package games.yinga.RandomMOTD;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import games.yinga.RandomMOTD.Commands.BaseCommand;
import games.yinga.RandomMOTD.Listeners.PingListener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Main extends Plugin {

    private static Configuration config;
    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        try {
            makeConfig();
            loadConfig();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        registerListeners();
        registerCommands();

        this.getProxy().getLogger().info("RandomMOTD Enabled");
    }

    private void makeConfig() throws IOException {
        // Create plugin config folder if it doesn't exist
        if (!getDataFolder().exists()) {
            getLogger().info("Created config folder: " + getDataFolder().mkdir());
        }

        File configFile = new File(getDataFolder(), "config.yml");

        // Copy default config if it doesn't exist
        if (!configFile.exists()) {
            FileOutputStream outputStream = new FileOutputStream(configFile); // Throws IOException
            InputStream in = getResourceAsStream("config.yml"); // This file must exist in the jar resources folder
            in.transferTo(outputStream); // Throws IOException
        }
    }

    public void loadConfig() throws IOException {
        config = ConfigurationProvider.getProvider(YamlConfiguration.class)
                .load(new File(getDataFolder(), "config.yml"));
    }

    public static Configuration getConfig() {
        return config;
    }

    public static Main getInstance() {
        return instance;
    }

    private void registerListeners() {
        this.getProxy().getPluginManager().registerListener(this, new PingListener());
    }

    private void registerCommands() {
        this.getProxy().getPluginManager().registerCommand(this, new BaseCommand("rmotd"));
    }

}
