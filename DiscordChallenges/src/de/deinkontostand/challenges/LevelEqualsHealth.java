package de.deinkontostand.challenges;

import de.deinkontostand.discordchallenges.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class LevelEqualsHealth implements Listener {

    @EventHandler
    public void levelGain(PlayerLevelChangeEvent e){
        if(Main.levelequalshealth){

            e.getPlayer().setMaxHealth(e.getPlayer().getLevel());

        }


    }

}
