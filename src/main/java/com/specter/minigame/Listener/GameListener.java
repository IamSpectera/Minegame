package com.specter.minigame.Listener;

import com.specter.minigame.GameState;
import com.specter.minigame.Minigame;
import com.specter.minigame.instance.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class GameListener implements Listener {

    private Minigame minigame;
    public GameListener(Minigame minigame) { this.minigame = minigame; }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Arena arena = minigame.getArenaManager().getArena(e.getPlayer());
        if (arena != null && arena.getState().equals(GameState.LIVE)) {
            arena.getGame().addPoints(e.getPlayer());
        }

    }

}

