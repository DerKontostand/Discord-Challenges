package de.deinkontostand.inventorys;

import de.deinkontostand.discordchallenges.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getClickedInventory() == openInventory.inv){

                e.setCancelled(true);

                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9MobDamageSwitch")) {
                    Main.mobdamageswitch = !Main.mobdamageswitch;


                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9ItemDamageSwitch")) {
                    Main.itemdamageswitch = !Main.itemdamageswitch;


                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9WeaknessMobKill")) {

                    Main.weaknessmobkill = !Main.weaknessmobkill;


                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9InvClearY")) {

                    Main.invcleary = !Main.invcleary;


                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9LevelEqualsHealth")) {

                    Main.levelequalshealth = !Main.levelequalshealth;

                    if(e.getWhoClicked() instanceof Player) {

                        for(Player pl : Bukkit.getOnlinePlayers()){

                            pl.setExp(1);
                            pl.setLevel(1);

                            pl.setHealth(20);

                        }



                    }

                    if(Main.levelequalshealth == true){

                        for(Player pl : Bukkit.getOnlinePlayers()){

                            pl.setHealth(20);

                        }




                    }

                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9WithoutInv")) {

                    Main.withoutinv = !Main.withoutinv;


                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9NoInvDrop")) {

                    Main.noinvdrop = !Main.noinvdrop;


                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9EffectPerChunk")) {

                    Main.effectperchunk = !Main.effectperchunk;


                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9HigherPerJump")) {

                    Main.higherperjump = !Main.higherperjump;


                } else {



                }


            openInventory.setItems(e.getWhoClicked());





        }


    }


}
