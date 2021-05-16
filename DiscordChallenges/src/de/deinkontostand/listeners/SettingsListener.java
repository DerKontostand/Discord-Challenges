package de.deinkontostand.listeners;

import de.deinkontostand.commands.Settings;
import de.deinkontostand.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;

public class SettingsListener implements Listener {

    public static HashMap<Integer, Boolean> booleans = new HashMap<>();

    public static boolean einfach = true;
    public static boolean mittel = false;
    public static boolean schwer = false;

    private static Inventory nojump = Bukkit.createInventory(null, 27, "§2NoJump§7-Settings");
    private static Inventory blockremover = Bukkit.createInventory(null, 27, "§5BlockRemover§7-Settings");
    private static Inventory onebiome = Bukkit.createInventory(null, 81, "§6BlockInventory§7-Settings");
    private static Inventory opmobs = Bukkit.createInventory(null, 27, "§9OPMobs§7-Settings");


    @EventHandler
    public void onInteract(InventoryClickEvent e) {
            Player p = (Player) e.getWhoClicked();

            ItemStack einfachStack = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);

            ItemMeta einfachMeta = einfachStack.getItemMeta();
            einfachMeta.setDisplayName("§aEINFACH");

            einfachStack.setItemMeta(einfachMeta);


            ItemStack mittelStack = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
            ItemMeta mittelMeta = einfachStack.getItemMeta();
            mittelMeta.setDisplayName("§6MITTEL");

            mittelStack.setItemMeta(mittelMeta);


            ItemStack schwerStack = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta schwerMeta = einfachStack.getItemMeta();
            schwerMeta.setDisplayName("§cSCHWER");

            schwerStack.setItemMeta(schwerMeta);


            if(e.getClickedInventory() == Settings.inv) {
                    if (e.getCurrentItem() == null) {


                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2NoJump")) {

                        if(e.getClick() == ClickType.LEFT) {
                            handleItems(0, "§8[§2NoJump§8]", (Player) e.getWhoClicked(), e.getCurrentItem(), 10);
                            e.setCancelled(true);
                        }else if(e.getClick() == ClickType.RIGHT){
                            handleSettings(e.getCurrentItem(), nojump, p);
                        }


                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§8 ")) {
                        e.setCancelled(true);


                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9OPMobs")) {

                        if(e.getClick() == ClickType.LEFT) {
                            handleItems(1, "§8[§9OPMobs§8]", (Player) e.getWhoClicked(), e.getCurrentItem(), 14);
                            e.setCancelled(true);
                        }else if(e.getClick() == ClickType.RIGHT){
                            handleSettings(e.getCurrentItem(), opmobs, p);
                        }

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aEINFACH")) {


                        einfach = false;
                        mittel = true;
                        schwer = false;

                        e.setCancelled(true);


                        Settings.inv.setItem(14 + 9, mittelStack);

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6MITTEL")) {
                        einfach = false;
                        mittel = false;
                        schwer = true;


                        e.setCancelled(true);


                        Settings.inv.setItem(14 + 9, schwerStack);

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cSCHWER")) {
                        einfach = true;
                        mittel = false;
                        schwer = false;


                        e.setCancelled(true);

                        Settings.inv.setItem(14 + 9, einfachStack);

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5BlockRemover")) {

                        if(e.getClick() == ClickType.LEFT) {
                            handleItems(2, "§8[§5BlockRemover§8]", (Player) e.getWhoClicked(), e.getCurrentItem(), 12);
                            e.setCancelled(true);
                        }else if(e.getClick() == ClickType.RIGHT){
                            handleSettings(e.getCurrentItem(), blockremover, p);
                        }

                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6BlockInventory §7§kI§cNEU§7§kI")){

                        if(e.getClick() == ClickType.LEFT) {
                            handleItems(3, "§8[§6BlockInventory§8]", (Player) e.getWhoClicked(), e.getCurrentItem(), 16);
                            e.setCancelled(true);
                        }else if(e.getClick() == ClickType.RIGHT){
                            handleSettings(e.getCurrentItem(), onebiome, p);
                        }


                    }else {
                        e.setCancelled(false);
                    }

            }

    }

    public void handleItems(int i, String s, Player p, ItemStack item, int slot){
        if(p instanceof Player) {
            FileConfiguration config = Main.getPlugin().getConfig();


            if (booleans.size() >= i) {
                if (!booleans.get(i)) {
                    Bukkit.getOnlinePlayers().forEach(player ->{
                        player.sendTitle(s + " §awurde aktiviert!", "§evon " + p.getName(), 20, 20, 0);

                        //


                    });

                    ItemMeta meta = item.getItemMeta();

                    meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                    meta.setLore(Arrays.asList("§aAN"));

                    item.setItemMeta(meta);
                    Settings.inv.setItem(slot, item);

                    booleans.remove(i);
                    booleans.put(i, true);


                } else {
                    Bukkit.getOnlinePlayers().forEach(player ->{
                        player.sendTitle(s + " §cwurde deaktiviert!", "§evon " + p.getName(), 20, 20, 0);
                    });

                    //

                    ItemMeta meta = item.getItemMeta();

                    Settings.inv.setItem(slot, item);

                    meta.removeEnchant(Enchantment.ARROW_DAMAGE);

                    meta.setLore(Arrays.asList("§cAUS"));

                    item.setItemMeta(meta);
                    Settings.inv.setItem(slot, item);

                    booleans.remove(i);
                    booleans.put(i, false);
                }

            }
        }
    }

    public void handleSettings(ItemStack item, Inventory inv, Player p){

        p.openInventory(inv);


    }

    public static Biome choosedBiome;

    public void setItems(){

        ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§8 ");
        item.setItemMeta(itemMeta);



        for (int i = 0; i < nojump.getSize(); i++) {
            if (i > 9 && i < 45 && i % 9 != 0) i += 7;
            nojump.setItem(i, item);
        }

        for (int i = 0; i < blockremover.getSize(); i++) {
            if (i > 9 && i < 45 && i % 9 != 0) i += 7;
            blockremover.setItem(i, item);
        }

        for (int i = 0; i < opmobs.getSize(); i++) {
            if (i > 9 && i < 45 && i % 9 != 0) i += 7;
            opmobs.setItem(i, item);
        }



    }

    @EventHandler
    public static void InventoryClick(InventoryClickEvent e){
        if(e.getClickedInventory() == onebiome){



        }


    }



}
