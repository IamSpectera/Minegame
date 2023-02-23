package com.specter.minigame;

import com.specter.minigame.Listener.ConnectListener;
import com.specter.minigame.Listener.GameListener;
import com.specter.minigame.manager.ArenaManager;
import com.specter.minigame.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Minigame extends JavaPlugin {

    private ArenaManager arenaManager;
    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager.setupConfig(this);

       arenaManager = new ArenaManager(this);
       Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);
       Bukkit.getPluginManager().registerEvents(new GameListener(this), this);

    }

    public ArenaManager getArenaManager() { return arenaManager; }
}
