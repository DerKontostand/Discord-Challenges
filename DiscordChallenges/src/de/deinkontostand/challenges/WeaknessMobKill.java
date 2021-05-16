package de.deinkontostand.challenges;

import de.deinkontostand.discordchallenges.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WeaknessMobKill implements Listener {


    @EventHandler
    public void onKill(EntityDeathEvent e){
        if(Main.weaknessmobkill) {
            if (e.getEntity().getKiller() instanceof Player) {
                Player p = e.getEntity().getKiller();

                int amplifier;

                try{
                    amplifier = p.getPotionEffect(PotionEffectType.WEAKNESS).getAmplifier();
                } catch (Exception ex){

                    amplifier = 1;

                }

                p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1000000, amplifier + 1));

            }

        }
    }
}
