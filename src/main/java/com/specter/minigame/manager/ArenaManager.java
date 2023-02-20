package com.specter.minigame.manager;

import com.specter.minigame.instance.Arena;
import com.specter.minigame.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArenaManager {

    private List<Arena> arenas = new ArrayList<>();

    public ArenaManager(Minigame minigame) {
        FileConfiguration config = minigame.getConfig();
        for (String str : config.getConfigurationSection("arena.").getKeys(false)) {
            arenas.add(new Arena(minigame, Integer.parseInt(str), new Location(
                    Bukkit.getWorld(config.getString("arena." + str + ".world")),
                    config.getDouble("arena." + str + ".x"),
                    config.getDouble("arena." + str + ".y"),
                    config.getDouble("arena." + str + ".z"),
                    (float) config.getDouble("arena." + str + ".yaw"),
                    (float) config.getDouble("arena." + str + ".pitch"))));

        }

    }

    public List<Arena> getArenas() { return arenas; }

    public Arena getArena(Player player) {
        for (Arena arena : arenas) {
            if (arena.getPlayers().contains(player.getUniqueId())) {
                return arena;
            }
        }
        return null;
    }

    public Arena getArena(int id) {
        for (Arena arena : arenas) {
            if (arena.getId() == id) {
                return arena;
            }
        }
        return null;
    }

}
