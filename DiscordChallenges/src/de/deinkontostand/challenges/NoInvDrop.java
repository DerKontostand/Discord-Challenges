package de.deinkontostand.challenges;

import de.deinkontostand.discordchallenges.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class NoInvDrop implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if(Main.noinvdrop){

            e.setCancelled(true);


        }


    }


}
