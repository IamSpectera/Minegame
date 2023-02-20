package com.specter.minigame.instance;

import com.specter.minigame.GameState;
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

    public Arena(int id, Location spawn) {
        this.id = id;
        this.spawn = spawn;

        this.state = GameState.RECRUITING;
        this.players = new ArrayList<>();
    }
    /* TOOLS */

    public void sendMessage(String message) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(message);
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
