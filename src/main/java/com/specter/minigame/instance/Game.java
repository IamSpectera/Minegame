package com.specter.minigame.instance;

import com.specter.minigame.GameState;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Integer> points;
    public Game(Arena arena) {
        this.arena = arena;
        points = new HashMap<>();


    }


    public void start() {
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "Game has started!");
        arena.sendMessage(ChatColor.GREEN + "Break 20 blocks in the fastest time!");

        for (UUID uuid : arena.getPlayers()) {
            points.put(uuid, 0);
        }
    }

    public void addPoints(Player player) {
        int playerPoints = points.get(player.getUniqueId()) + 1;
        if (playerPoints == 20) {
            arena.sendMessage(ChatColor.GOLD + player.getName() + "HAS WON! Thanks for playing!");
            arena.reset(true);
            return;
        }

        player.sendMessage(ChatColor.RED + "+1 POINT!");
        points.replace(player.getUniqueId(), playerPoints);
    }
}
