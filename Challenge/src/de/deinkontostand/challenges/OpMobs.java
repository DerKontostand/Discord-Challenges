package de.deinkontostand.challenges;

import de.deinkontostand.listeners.SettingsListener;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OpMobs implements Listener{

    Location loc;
    Creeper creeper;
    Skeleton skel;
    Zombie zomb;
    Player p;
    public static ArrayList<ItemStack> itemStacks = new ArrayList<>();

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        opitems();

        if(SettingsListener.booleans.get(1)) {
            Entity entity = event.getEntity();
            if (entity instanceof Creeper) {
                creeper = (Creeper) entity;
                creeper.setPowered(true);
            }else if(entity instanceof Skeleton){
                skel = (Skeleton) entity;
                if(SettingsListener.schwer) {
                    ItemStack item = new ItemStack(Material.BOW);
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                    itemMeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);

                    item.setItemMeta(itemMeta);

                    skel.getEquipment().setItem(EquipmentSlot.HAND, item);



                    skel.getEquipment().setItem(EquipmentSlot.HEAD, itemStacks.get(0));
                    skel.getEquipment().setItem(EquipmentSlot.CHEST, itemStacks.get(1));
                    skel.getEquipment().setItem(EquipmentSlot.LEGS, itemStacks.get(2));
                    skel.getEquipment().setItem(EquipmentSlot.FEET, itemStacks.get(3));

                }
            }else if(entity instanceof Zombie){
                zomb = (Zombie) entity;

                if(SettingsListener.schwer){
                    ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);

                    item.setItemMeta(itemMeta);

                    zomb.getEquipment().setItem(EquipmentSlot.HAND, item);



                    zomb.getEquipment().setItem(EquipmentSlot.HEAD, itemStacks.get(0));
                    zomb.getEquipment().setItem(EquipmentSlot.CHEST, itemStacks.get(1));
                    zomb.getEquipment().setItem(EquipmentSlot.LEGS, itemStacks.get(2));
                    zomb.getEquipment().setItem(EquipmentSlot.FEET, itemStacks.get(3));

                }


            }

            if(entity instanceof Player){
                p = (Player) entity;

            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        if(SettingsListener.booleans.get(1)) {
            p = event.getPlayer();

            if (creeper != null) {
                if (event.getPlayer().getLocation().distance(creeper.getLocation()) <= 3 && event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                    creeper.explode();
                }
            }
        }
    }

    public static ArrayList opitems() {
        ItemStack item1 = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta item1Meta = item1.getItemMeta();
        item1Meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        item1.setItemMeta(item1Meta);

        ItemStack item2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta item2Meta = item2.getItemMeta();
        item2Meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        item2.setItemMeta(item2Meta);

        ItemStack item3 = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta item3Meta = item3.getItemMeta();
        item3Meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        item3.setItemMeta(item3Meta);

        ItemStack item4 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta item4Meta = item4.getItemMeta();
        item4Meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        item4.setItemMeta(item4Meta);

        itemStacks.add(item1);
        itemStacks.add(item2);
        itemStacks.add(item3);
        itemStacks.add(item4);

        return itemStacks;
    }



}
