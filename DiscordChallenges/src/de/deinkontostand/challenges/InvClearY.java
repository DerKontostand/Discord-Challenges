package de.deinkontostand.challenges;

import de.deinkontostand.discordchallenges.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class InvClearY implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(Main.invcleary) {

            if (e.getFrom().getBlockY() != e.getTo().getBlockY()) {
                Random random = new Random();

                e.getPlayer().getInventory().getItem(random.nextInt(e.getPlayer().getInventory().getSize())).setType(Material.AIR);

            }

        }

    }

}
