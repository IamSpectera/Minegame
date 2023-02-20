package com.specter.minigame;

import com.specter.minigame.manager.ArenaManager;
import com.specter.minigame.manager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Minigame extends JavaPlugin {

    private ArenaManager arenaManager;
    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager.setupConfig(this);

       arenaManager = new ArenaManager(this);

    }

    public ArenaManager getArenaManager() { return arenaManager; }
}
