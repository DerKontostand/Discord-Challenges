package de.deinkontostand.commands;

import de.deinkontostand.listeners.SettingsListener;
import de.deinkontostand.main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.Arrays;

public class Settings implements CommandExecutor {


    public static int InvSize = 36;
    public static Inventory inv = Bukkit.createInventory(null, InvSize, "§c§lChallenge-Settings");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player)sender;
            try{
                if(args[0].equalsIgnoreCase("sethp")){
                    if(Integer.parseInt(args[1]) <= 20 && Integer.parseInt(args[1]) >= 1){
                        p.setHealth(Double.parseDouble(args[1]));
                    }else{
                        p.sendMessage("§cDie HP anzahl ist ungültig!");
                    }
                }

            }catch (Exception e){
                for (int i = 0; i < InvSize; i++) {
                    ItemStack glas = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemMeta glasmeta = glas.getItemMeta();
                    glasmeta.setDisplayName("§8 ");
                    glas.setItemMeta(glasmeta);
                    inv.setItem(i, glas);
                }


                ItemStack nojump = new ItemStack(Material.DIAMOND_BOOTS);

                //
                if(SettingsListener.booleans.get(0)) {

                    ItemMeta meta = nojump.getItemMeta();

                    meta.setDisplayName("§2NoJump");
                    meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                    meta.setLore(Arrays.asList("§aAN"));

                    nojump.setItemMeta(meta);
                    inv.setItem(10, nojump);


                }else{

                    ItemMeta meta = nojump.getItemMeta();

                    meta.setDisplayName("§2NoJump");
                    meta.removeEnchant(Enchantment.ARROW_DAMAGE);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                    meta.setLore(Arrays.asList("§cAUS"));

                    nojump.setItemMeta(meta);
                    inv.setItem(10, nojump);

                }
                //

                ItemStack opmobs = new ItemStack(Material.NETHER_STAR);

                //
                if(SettingsListener.booleans.get(1)) {

                    ItemMeta meta = opmobs.getItemMeta();

                    meta.setDisplayName("§9OPMobs");
                    meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                    meta.setLore(Arrays.asList("§aAN"));

                    opmobs.setItemMeta(meta);
                    inv.setItem(12, opmobs);


                }else{

                    ItemMeta meta = opmobs.getItemMeta();

                    meta.setDisplayName("§9OPMobs");
                    meta.removeEnchant(Enchantment.ARROW_DAMAGE);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                    meta.setLore(Arrays.asList("§cAUS"));

                    opmobs.setItemMeta(meta);

                }

                //

                ItemStack blockremover = new ItemStack(Material.GRASS_BLOCK);
                ItemMeta blockmeta = blockremover.getItemMeta();
                blockmeta.setDisplayName("§5BlockRemover");
                //

                if(SettingsListener.booleans.get(2)) {

                    ItemMeta meta = blockremover.getItemMeta();
                    meta.setDisplayName("§5BlockRemover");

                    meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                    meta.setLore(Arrays.asList("§aAN"));

                    blockremover.setItemMeta(meta);


                }else{

                    ItemMeta meta = blockremover.getItemMeta();
                    meta.setDisplayName("§5BlockRemover");

                    meta.removeEnchant(Enchantment.ARROW_DAMAGE);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                    meta.setLore(Arrays.asList("§cAUS"));

                    blockremover.setItemMeta(meta);

                }
                //
                ItemStack onebiome = new ItemStack(Material.GRASS_BLOCK);
                ItemMeta biomemeta = onebiome.getItemMeta();
                biomemeta.setDisplayName("§6OneBiome §7§kI§cNEU§7§kI");
                //

                if(SettingsListener.booleans.get(3)) {

                    ItemMeta meta = onebiome.getItemMeta();
                    meta.setDisplayName("§6OneBiome §7§kI§cNEU§7§kI");

                    meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                    meta.setLore(Arrays.asList("§aAN"));

                    onebiome.setItemMeta(meta);


                }else{

                    ItemMeta meta = onebiome.getItemMeta();
                    meta.setDisplayName("§6OneBiome §7§kI§cNEU§7§kI");

                    meta.removeEnchant(Enchantment.ARROW_DAMAGE);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                    meta.setLore(Arrays.asList("§cAUS"));

                    onebiome.setItemMeta(meta);

                }

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

                inv.setItem(10, nojump);
                inv.setItem(12, blockremover);
                inv.setItem(14, opmobs);
                inv.setItem(16, onebiome);


                if(SettingsListener.einfach) {
                    inv.setItem(14 + 9, einfachStack);
                }else if(SettingsListener.mittel){
                    inv.setItem(14 + 9, mittelStack);
                }else{
                    inv.setItem(14 + 9, schwerStack);
                }




                p.openInventory(inv);

            }
        }
        return false;
    }
}
