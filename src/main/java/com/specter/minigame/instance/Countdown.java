package com.specter.minigame.instance;

import com.specter.minigame.GameState;
import com.specter.minigame.Minigame;
import com.specter.minigame.manager.ConfigManager;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private Minigame minigame;
    private Arena arena;

    private int countdownSeconds;
    public Countdown(Minigame minigame, Arena arena) {
        this.minigame = minigame;
        this.arena = arena;
        this.countdownSeconds = ConfigManager.getCountdownSeconds();

    }

    public void start() {
        arena.setState(GameState.COUNTDOWN);
        runTaskTimer(minigame, 0, 20);
    }

    @Override
    public void run() {
        if (countdownSeconds == 0) {
            cancel();
            // arena start
            return;
        }

        if (countdownSeconds <= 10 || countdownSeconds % 15 == 0) {

        }

        countdownSeconds--;
    }
}
