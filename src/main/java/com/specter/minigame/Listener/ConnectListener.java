package com.specter.minigame.Listener;

import com.specter.minigame.Minigame;
import com.specter.minigame.instance.Arena;
import com.specter.minigame.manager.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectListener implements Listener {

    private Minigame minigame;
    public ConnectListener(Minigame minigame) {
        this.minigame = minigame;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        e.getPlayer().teleport(ConfigManager.getLobbySpawn());

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Arena arena = minigame.getArenaManager().getArena(e.getPlayer());
        if (arena != null) {
            arena.removePlayer(e.getPlayer());
        }

    }
}
