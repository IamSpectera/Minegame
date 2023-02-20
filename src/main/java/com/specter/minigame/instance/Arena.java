package com.specter.minigame.instance;

import com.specter.minigame.GameState;
import com.specter.minigame.Minigame;
import com.specter.minigame.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Arena {

    private int id ;
    private Location spawn;

    private GameState state;
    private List<UUID> players;
    private Countdown countdown;

    public Arena(Minigame minigame, int id, Location spawn) {
        this.id = id;
        this.spawn = spawn;

        this.state = GameState.RECRUITING;
        this.players = new ArrayList<>();
        this.countdown = new Countdown(minigame, this);
    }
    /* TOOLS */

    public void sendMessage(String message) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }
    public void sendTitle(String title, String subtitle) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendTitle(title, subtitle);
        }
    }

    /* PLAYERS */

    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
        player.teleport(spawn);

    }

    public void removePlayer(Player player) {
        players.remove(player.getUniqueId());
        player.teleport(ConfigManager.getLobbySpawn());

    }
    /* INFO */
    public int getId() { return id; }

    public GameState getState() { return state; }
    public List<UUID> getPlayers() { return players; }

    public void setState(GameState state) { this.state = state; }

}
