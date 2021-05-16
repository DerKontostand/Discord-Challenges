package de.deinkontostand.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;


public class onJoin implements Listener {

    public static HashMap<Player, Player> onlinePlayers = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage("§a" + e.getPlayer().getName() + " §7hat den Server §abetreten");
        onlinePlayers.put(e.getPlayer(), e.getPlayer());

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        e.setQuitMessage("§c" + e.getPlayer().getName() + " §7hat den Server §cverlassen");

    }

}
