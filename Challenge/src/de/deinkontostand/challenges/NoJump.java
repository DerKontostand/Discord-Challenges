package de.deinkontostand.challenges;

import com.google.common.collect.Sets;
import de.deinkontostand.commands.TimerScheduler;
import de.deinkontostand.listeners.SettingsListener;
import de.deinkontostand.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.Set;
import java.util.UUID;

import static de.deinkontostand.main.Main.Timer;

public class NoJump implements Listener {

    private Set<UUID> prevPlayersOnGround = Sets.newHashSet();


    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (player.getVelocity().getY() > 0) {
            double jumpVelocity = (double) 0.42F;
            if (player.hasPotionEffect(PotionEffectType.JUMP)) {
                jumpVelocity += (double) ((float) (player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() + 1) * 0.1F);
            }
            if (e.getPlayer().getLocation().getBlock().getType() != Material.LADDER && prevPlayersOnGround.contains(player.getUniqueId())) {
                if (!player.isOnGround() && Double.compare(player.getVelocity().getY(), jumpVelocity) == 0) {
                    if(Timer == true && SettingsListener.booleans.get(0) == true && !(e.getPlayer().getGameMode() == GameMode.SPECTATOR) && !(e.getPlayer().getGameMode() == GameMode.CREATIVE) && !(player.getLocation().getBlock().getType() == Material.WATER)){

                        Bukkit.getOnlinePlayers().forEach(players ->{
                            players.setGameMode(GameMode.SPECTATOR);
                            players.sendMessage("§8[§2NoJump§8] §e" + player.getName() + " §9ist gesprungen!");
                            Main.getPlugin().getRunnable().cancel();
                            Timer = false;

                            new TimerScheduler().runTaskTimer(Main.getPlugin(), 20L, 20L);
                        });
                    }else{

                    }
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
