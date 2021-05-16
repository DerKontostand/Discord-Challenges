package de.deinkontostand.challenges;

import de.deinkontostand.listeners.DeathListener;
import de.deinkontostand.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlockInventory implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(Main.BlockInventory) {
            if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {

                if (!e.getPlayer().getInventory().contains(e.getPlayer().getLocation().getBlock().getType())) {

                    Main.stopChallenge();

                    DeathListener.fakeDeath(e.getPlayer());

                }

            }
        }

    }


}
