package de.deinkontostand.challenges;

import com.google.common.collect.Sets;
import de.deinkontostand.discordchallenges.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Set;
import java.util.UUID;

public class HigherPerJump implements Listener {


        private Set<UUID> prevPlayersOnGround = Sets.newHashSet();

        int timesJumped = 0;

        @EventHandler
        public void onMove(PlayerMoveEvent e) {
            if(Main.higherperjump) {
                Player player = e.getPlayer();
                if (player.getVelocity().getY() > 0) {
                    double jumpVelocity = (double) 0.42F;
                    if (player.hasPotionEffect(PotionEffectType.JUMP)) {
                        jumpVelocity += (double) ((float) (player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() + 1) * 0.1F);
                    }
                    if (e.getPlayer().getLocation().getBlock().getType() != Material.LADDER && prevPlayersOnGround.contains(player.getUniqueId())) {
                        if (!player.isOnGround() && Double.compare(player.getVelocity().getY(), jumpVelocity) == 0) {
                            //JUMP CHECK

                            if (timesJumped > 0) {

                                if (Integer.class.isInstance(timesJumped / 2)) {
                                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, timesJumped), false);

                                }


                            }


                            timesJumped++;
                            //JUMP CHECK
                        }
                    }
                }
                if (player.isOnGround()) {
                    prevPlayersOnGround.add(player.getUniqueId());
                } else {
                    prevPlayersOnGround.remove(player.getUniqueId());
                }
            }
        }




}
