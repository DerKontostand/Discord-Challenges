package de.deinkontostand.challenges;

import de.deinkontostand.discordchallenges.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTransformEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class MobDamageSwitch implements Listener {

    Location loc = null;
    EntityType entityType = null;
    double damage = 0;

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(Main.mobdamageswitch) {
            if (!(e.getEntity() instanceof Player)) {
                if (e.getEntity() instanceof LivingEntity) {
                    if (!(e.getDamage() >= ((LivingEntity) e.getEntity()).getHealth())) {
                        Random random = new Random();


                        ArrayList validMobs = new ArrayList();

                        for (EntityType type : EntityType.values()) {
                            if (type.isAlive() && type != EntityType.ENDER_DRAGON) {
                                validMobs.add(type);

                            }

                        }


                        entityType = (EntityType) validMobs.get(random.nextInt(validMobs.size()));


                        loc = e.getEntity().getLocation();
                        damage = e.getDamage();

                        e.getEntity().remove();
                        loc.getBlock().getWorld().spawnEntity(loc, entityType);


                    }

                }
            }

        }

    }

    @EventHandler
    public void onSummon(EntityTransformEvent e){
        if(loc != null && entityType != null){
            if(e.getEntity().getLocation().distance(loc) <= 1){
                if(e.getEntity().getType() == entityType){
                    if(e.getEntity() instanceof LivingEntity){

                        ((LivingEntity) e.getEntity()).damage(damage);

                    }

                }

            }

        }else {
            Bukkit.broadcast("null", "");
        }


    }

}
