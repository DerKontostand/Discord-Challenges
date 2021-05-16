package de.deinkontostand.challenges;

import de.deinkontostand.discordchallenges.Main;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class EffectPerChunk implements Listener {

    public static HashMap<Chunk, PotionEffect> effectHashMap = new HashMap<>();

    @EventHandler
    public void enterNewChunk(PlayerMoveEvent e){

        if(randomEffect != null) {
            if (Main.effectperchunk) {
                e.getPlayer().addPotionEffect(randomEffect);
            }
        }else {

            Random random = new Random();

            Object[] effects = Arrays.stream(PotionEffectType.values()).toArray();
            randomEffect = (PotionEffect) effects[random.nextInt(effects.length)];

            effectHashMap.put(e.getPlayer().getLocation().getChunk(), randomEffect);

            e.getPlayer().addPotionEffect(randomEffect);

        }

    }

    private static PotionEffect randomEffect;

    @EventHandler
    public void confirmEffect(ChunkLoadEvent e){
        if(Main.effectperchunk) {
            Random random = new Random();

            Object[] effects = Arrays.stream(PotionEffectType.values()).toArray();
            randomEffect = (PotionEffect) effects[random.nextInt(effects.length)];

            effectHashMap.put(e.getChunk(), randomEffect);

        }

    }

}
