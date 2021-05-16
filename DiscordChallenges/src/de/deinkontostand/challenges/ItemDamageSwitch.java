package de.deinkontostand.challenges;

import de.deinkontostand.discordchallenges.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ItemDamageSwitch implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(Main.itemdamageswitch){
            if(e.getEntity() instanceof Player) {


                ArrayList switchingItem = new ArrayList();

                for (Material mat : Material.values()) {
                    if (!(mat == null)) {
                        switchingItem.add(mat);


                    }


                }

                int emptySlots = 0;

                ItemStack[] storageContents = ((Player) e.getEntity()).getInventory().getStorageContents();

                for (ItemStack item : storageContents) {
                    if (item == null) {
                        emptySlots++;

                    }

                }

                Inventory inventory = ((Player) e.getEntity()).getInventory();

                for (int i = 0; i <= emptySlots; i++) {
                    Random random = new Random();
                    int slot = random.nextInt(inventory.getSize()-1);

                    ItemStack randomItem = inventory.getItem(slot);

                    if (randomItem != null) {
                        i = emptySlots;

                        inventory.getItem(slot).setType((Material) switchingItem.get(random.nextInt(switchingItem.size())));


                    }

                }


            }
        }

    }

}
