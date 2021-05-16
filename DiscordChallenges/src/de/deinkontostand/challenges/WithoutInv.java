package de.deinkontostand.challenges;

import de.deinkontostand.discordchallenges.Main;
import de.deinkontostand.inventorys.openInventory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class WithoutInv implements Listener {

    @EventHandler
    public void openInv(InventoryOpenEvent e){
        if(Main.withoutinv) {
            if(e.getInventory() != openInventory.inv) {
                e.getPlayer().closeInventory();
            }else{

            }

        }

    }

}
